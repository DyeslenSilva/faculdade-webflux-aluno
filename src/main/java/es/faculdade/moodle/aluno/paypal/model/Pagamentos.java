package es.faculdade.moodle.aluno.paypal.model;

import es.faculdade.moodle.aluno.paypal.enumeration.Moeda;
import lombok.Data;

@Data
public class Pagamentos {

	private double valor;
	private Moeda moeda;
	private String descricao;
}
