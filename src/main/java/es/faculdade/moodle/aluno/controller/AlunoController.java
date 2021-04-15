package es.faculdade.moodle.aluno.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.moodle.aluno.model.Aluno;
import es.faculdade.moodle.aluno.repo.AlunoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apiAluno")
public class AlunoController {

	private AlunoRepo alunoRepo;
	
	@RequestMapping(path = "/alunoCadastro" , method = RequestMethod.POST)
	public Mono<Aluno> cadastroAluno(@RequestBody Aluno aluno){
		return alunoRepo.save(aluno);
	}
	
	@RequestMapping(path = "/aluno/{idAluno}" , method = RequestMethod.PUT)
	public Mono<Aluno> updateAluno(@RequestBody Integer idAluno){
		return alunoRepo.updateAluno(idAluno);
	}
	
	@RequestMapping(path = "/aluno/{idAluno}" , method = RequestMethod.DELETE)
	public Mono<Void> deleteAluno(@RequestBody Integer idAluno){
		return alunoRepo.deleteById(idAluno);
	}
	
	
	
}
