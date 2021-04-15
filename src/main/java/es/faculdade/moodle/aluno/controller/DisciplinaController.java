package es.faculdade.moodle.aluno.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.moodle.aluno.model.Disciplinas;
import es.faculdade.moodle.aluno.repo.DisciplinaRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/disciplinaAlunoAPI")
public class DisciplinaController {

	private DisciplinaRepo disciplinaRepo;
	
	@RequestMapping(path ="/disciplinaCads" , method = RequestMethod.POST)
	public Mono<Disciplinas> cadastroDisciplina(@PathVariable Disciplinas disciplinas){
		return disciplinaRepo.save(disciplinas);
	}
	
	@RequestMapping(path = "/disciplinas" , method = RequestMethod.GET)
	public Flux<Disciplinas> listaAllDisciplinas(){
		return disciplinaRepo.findAll();
	}
	
	@RequestMapping(path = "/disciplina/{idDisciplina}" , method = RequestMethod.GET)
	public Mono<Disciplinas> listaDisciplinasByID(@PathVariable Integer idDisciplina){
		return disciplinaRepo.findById(idDisciplina);
	}
	
	@RequestMapping(path = "upDisciplina/{idDisciplina}" , method = RequestMethod.PUT)
	public Mono<Disciplinas> updateDisciplina(@PathVariable Integer idDisciplina){
		return disciplinaRepo.updateDisciplina(idDisciplina);
	}
	
	@RequestMapping(path = "delDisciplina" , method = RequestMethod.DELETE)
	public Mono<Void> deleteDisciplina(@PathVariable Integer idDisciplina){
		return disciplinaRepo.deleteById(idDisciplina);
	}
	
	
	
}
