package es.faculdade.moodle.aluno.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.moodle.aluno.model.Curso;
import es.faculdade.moodle.aluno.repo.CursoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cursoAPIaluno")
public class CursoController {

	private CursoRepo cursoRepo;
	
	@RequestMapping(path="/cursoCad" , method = RequestMethod.POST)
	public Mono<Curso> cadastroCurso(@PathVariable Curso curso){
		return cursoRepo.save(curso);
	}
	
	@RequestMapping(path="/listCurso" , method = RequestMethod.GET)
	public Flux<Curso> listCursos(){
		return cursoRepo.findAll();
	}
	
	@RequestMapping(path = "/listaCurso/{idCurso}" , method =  RequestMethod.GET)
	public Mono<Curso> listCursoPorID(@PathVariable Integer idCurso){
		return cursoRepo.findById(idCurso);
	}
	
	@RequestMapping(path = "/atualizaCurso/{idCurso}" , method = RequestMethod.PUT)
	public Mono<Curso> updateCurso(@PathVariable Integer idCurso){
		return cursoRepo.updateCurso(idCurso);
	}
	
	@RequestMapping(path ="/deleteCurso/{idCurso}" , method = RequestMethod.DELETE)
	public Mono<Void> deleteCurso(@PathVariable Integer idCurso){
		return cursoRepo.deleteById(idCurso);
	}
}
