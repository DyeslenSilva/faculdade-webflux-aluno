package es.faculdade.moodle.aluno.model;

import lombok.Data;

@Data
public class Aluno {

	private Integer raAluno;
	private String nomeAluno;
	private String cpf;
	private String endereco;
	private String email;
	private String celularWhatsapp;
	private Disciplinas discplinas;
	private Curso curso;
	private Float notas;
	private Integer faltas;
}
