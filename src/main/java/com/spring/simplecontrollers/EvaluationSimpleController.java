package com.spring.simplecontrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entities.Evaluation;
import com.spring.services.EvaluationService;

@Controller
@RequestMapping("evaluation")
public class EvaluationSimpleController {
	@Autowired
	EvaluationService evaluationService;
	
	@GetMapping("")
	public String getEvaluations(Model m, Pageable pageable) {
		Evaluation s = new Evaluation();
		m.addAttribute("evaluations", evaluationService.findAll(pageable));
		m.addAttribute("evaluation", s); 
		
		return "evaluation";
	}
	
	@PostMapping("add")
	public String addEvaluation(@Valid @RequestBody @ModelAttribute(name = "evaluation") Evaluation e, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("evaluations", evaluationService.findAll(pageable));
			return "evaluation";
		}
		evaluationService.save(e);
		return "redirect:/evaluation";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteEvaluation(@PathVariable int id) {
		evaluationService.deleteById(id);
		return "redirect:/evaluation";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editEvaluation(@PathVariable int id, Model m) {
		Evaluation s = evaluationService.findById(id).get();
		m.addAttribute("evaluation", s);
		return "evaluationedit";
	}
	@PostMapping("edit/{id}")
	public String addEditedEvaluation(@PathVariable int id, @Valid Evaluation s, BindingResult result, Model m) {
		if (result.hasErrors()){
			m.addAttribute("evaluation", s);
			return "evaluationedit";
		}
		s.setId(id);
		evaluationService.save(s);	
		return "redirect:/evaluation";
	}

}
