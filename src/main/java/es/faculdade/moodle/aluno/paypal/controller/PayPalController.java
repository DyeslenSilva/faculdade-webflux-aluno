package es.faculdade.moodle.aluno.paypal.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.core.rest.PayPalRESTException;

import es.faculdade.moodle.aluno.paypal.enumeration.MetodoDePagamento;
import es.faculdade.moodle.aluno.paypal.enumeration.Moeda;
import es.faculdade.moodle.aluno.paypal.enumeration.UrlEnum;
import es.faculdade.moodle.aluno.paypal.model.PagamentoIntent;
import es.faculdade.moodle.aluno.paypal.model.Pagamentos;
import es.faculdade.moodle.aluno.paypal.service.PayPalService;
import es.faculdade.moodle.aluno.util.URLUtils;

@RestController
@RequestMapping("/payAlunoAPI")
public class PayPalController {
	
	public static final String PAYPAL_SUCCESS_URL = "";
	public static final String PAYPAL_CANCEL_URL = "";
	
	private Logger log = (Logger) LogFactory.getLog(getClass());
	
	
	@Autowired
	private PayPalService payPalService;
	
	private Pagamentos pagamentos;
	
	public String pay(HttpServletRequest req) throws PayPalRESTException{
		String cancelURL = URLUtils.getBaseUrl(req) + "/" + UrlEnum.cancelUrl;
		String success = URLUtils.getBaseUrl(req) + "/" + UrlEnum.successURL;
		
		Payment payment = payPalService.createPaymet(pagamentos.getValor(), 
				Moeda.R$,  MetodoDePagamento.paypal, 
				PagamentoIntent.sale, 
				pagamentos.getDescricao(), 
				UrlEnum.successURL,
				UrlEnum.cancelUrl);
		for(Links links : payment.getLinks()) {
			if(links.getRel().equals(URLUtils.getBaseUrl(req))) {
				return "redirect:" + links.getHref();
			}
		}
		
		return "redirect:/";
	}
	
	
	
	
}
