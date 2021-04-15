package es.faculdade.moodle.aluno.model;

import lombok.Data;

@Data
public class Disciplinas {

	private Integer idDisciplina;
	private String nomeDisciplina;
	private Curso curso;
	
}
