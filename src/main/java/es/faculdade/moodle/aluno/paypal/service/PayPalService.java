package es.faculdade.moodle.aluno.paypal.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.core.rest.APIContext;
import com.paypal.core.rest.PayPalRESTException;

import es.faculdade.moodle.aluno.paypal.enumeration.MetodoDePagamento;
import es.faculdade.moodle.aluno.paypal.enumeration.Moeda;
import es.faculdade.moodle.aluno.paypal.enumeration.UrlEnum;
import es.faculdade.moodle.aluno.paypal.model.PagamentoIntent;

@Service
public class PayPalService {

	@Autowired
	private String apiContext;
	
	public Payment createPaymet(Double total,
			String currency,String method,
			String intent,String description,
			String cancelURL,String succesUrl) throws PayPalRESTException, com.paypal.base.rest.PayPalRESTException {
		
		
		Amount amount = new Amount();
		amount.setCurrency(currency);
		total  = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
		amount.setTotal(String.format("%.2f", total));
		
		Transaction transaction = new Transaction();
		transaction.setDescription(description);
		transaction.setAmount(amount);
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		
		Payer payer = new Payer();
		payer.setPaymentMethod(method.toString());
		
		Payment payment = new Payment();
		payment.setIntent(intent.toString());
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelURL);
		redirectUrls.setReturnUrl(succesUrl);
		
		payment.setRedirectUrls(redirectUrls);
		
		return payment.create(apiContext);
	}
	
	public Payment executePayment(String idPayment, String idPayer) throws com.paypal.base.rest.PayPalRESTException {
		Payment payment= new Payment();
		payment.setId(idPayment);
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(idPayer);
		return payment.execute(apiContext, paymentExecution);
	}

	public Payment createPaymet(double valor, Moeda r$, MetodoDePagamento paypal, PagamentoIntent sale,
			String descricao, UrlEnum successurl, UrlEnum cancelurl) {
		// TODO Auto-generated method stub
		return null;
	}
}
