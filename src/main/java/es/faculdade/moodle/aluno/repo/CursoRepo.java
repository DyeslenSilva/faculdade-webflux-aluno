package es.faculdade.moodle.aluno.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.moodle.aluno.model.Curso;
import reactor.core.publisher.Mono;

public interface CursoRepo extends R2dbcRepository<Curso, Integer>{

	public Mono<Curso> updateCurso(Integer idCurso);
}
