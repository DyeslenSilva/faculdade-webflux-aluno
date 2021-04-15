package es.faculdade.moodle.aluno.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.moodle.aluno.model.Aluno;
import reactor.core.publisher.Mono;

public interface AlunoRepo extends R2dbcRepository<Aluno, Integer> {
	
	public Mono<Aluno> updateAluno(Integer idAluno);
}
