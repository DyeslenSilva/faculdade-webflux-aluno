package es.faculdade.moodle.aluno.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.moodle.aluno.model.Disciplinas;
import reactor.core.publisher.Mono;

public interface DisciplinaRepo extends R2dbcRepository<Disciplinas, Integer>{

	public Mono<Disciplinas> updateDisciplina(Integer idDisciplina);
}
