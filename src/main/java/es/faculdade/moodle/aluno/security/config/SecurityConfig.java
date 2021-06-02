package es.faculdade.moodle.aluno.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.faculdade.moodle.aluno.security.model.MyUserDetailsService;
import es.faculdade.moodle.aluno.security.model.Usuario;
import es.faculdade.moodle.aluno.security.url.model.URLBasic;

public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	private Usuario usuario;
	
	private URLBasic urlBasic;
	
	protected void configure(HttpSecurity http)throws Exception {
		http
			.httpBasic()
			.and().authorizeRequests()
			.antMatchers(urlBasic.getMatchersConsole()).permitAll()
			.antMatchers("/").permitAll()
			.antMatchers(urlBasic.getUrl1()).hasRole(usuario.getLogin())
			.antMatchers(urlBasic.getUrl2()).hasRole(usuario.getSenha())
			.and().csrf().disable().headers().frameOptions().disable();
	}
	
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	

}