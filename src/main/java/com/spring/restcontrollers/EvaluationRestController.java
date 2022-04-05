package com.spring.restcontrollers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Evaluation;
import com.spring.services.EvaluationService;

@RestController
@RequestMapping("api/evaluation")
public class EvaluationRestController {
@Autowired
EvaluationService evaluationService;

@GetMapping("")
public Page<Evaluation> getEvaluations(Pageable pageable)
{
	 return evaluationService.findAll(pageable);
}
@GetMapping("{id}")
public Optional<Evaluation> findEvaluations(@PathVariable int id)
{
	 return evaluationService.findById(id);
}

@PostMapping("")
public Evaluation addEvaluation(@Valid @RequestBody Evaluation evaluation) 
{
return evaluationService.save(evaluation);	

}
@DeleteMapping("{id}")
public void deleteEvaluation(@PathVariable int id) {
	evaluationService.deleteById(id);
}




}