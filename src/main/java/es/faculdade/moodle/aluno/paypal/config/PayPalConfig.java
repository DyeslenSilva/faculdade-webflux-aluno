package es.faculdade.moodle.aluno.paypal.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.core.rest.APIContext;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;
import com.paypal.sdk.exceptions.PayPalException;

import lombok.Getter;

@Configuration
public class PayPalConfig {
	
	@Value("${paypal.aluno.id}")
	private String idAluno;
	
	@Value("${paypal.aluno.secret}")
	private String alunoSecret;
	
	@Value("${paypal.model}")
	@Getter
	private String mode;
	
	@Bean
	public Map<String, String> payPalSdkConfig(){
		Map<String, String> configMapa = new HashMap<>();
		configMapa.put(getMode(),mode);
		return configMapa;
	}
	
	@Bean
	public OAuthTokenCredential oAuthTokenCredential() {
		return new OAuthTokenCredential(idAluno, alunoSecret,payPalSdkConfig());
	}
	
	@Bean
	public APIContext apiContext() throws PayPalRESTException{
		APIContext contex = new APIContext(oAuthTokenCredential().getAccessToken());
		contex.setConfigurationMap(payPalSdkConfig());
		return contex;
	}
	
}
