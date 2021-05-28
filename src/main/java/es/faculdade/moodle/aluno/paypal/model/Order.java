package es.faculdade.moodle.aluno.paypal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Order {

	private double valorBoleto;
	private String moeda;
	private String metodo;
	private String objetivo;
	private String descricao;
}
