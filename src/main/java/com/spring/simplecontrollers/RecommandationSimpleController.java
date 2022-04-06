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

import com.spring.entities.Recommandation;
import com.spring.services.RecommandationService;

@Controller
@RequestMapping("recommandation")
public class RecommandationSimpleController {
	@Autowired
	RecommandationService recommandationService;
	
	@GetMapping("")
	public String getRecommandations(Model m, Pageable pageable) {
		Recommandation s = new Recommandation();
		m.addAttribute("recommandations", recommandationService.findAll(pageable));
		m.addAttribute("recommandation", s); 
		
		return "recommandation";
	}
	
	@PostMapping("add")
	public String addRecommandation(@Valid @RequestBody @ModelAttribute(name = "recommandation") Recommandation r, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("recommandations", recommandationService.findAll(pageable));
			return "recommandation";
		}
		recommandationService.save(r);
		return "redirect:/recommandation";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteRecommandation(@PathVariable int id) {
		recommandationService.deleteById(id);
		return "redirect:/recommandation";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editRecommandation(@PathVariable int id, Model m) {
		Recommandation r = recommandationService.findById(id).get();
		m.addAttribute("recommandation", r);
		return "recommandationedit";
	}
	@PostMapping("edit/{id}")
	public String addEditedRecommandation(@PathVariable int id, @Valid Recommandation r, BindingResult result, Model m) {
		if (result.hasErrors()){
			m.addAttribute("recommandation", r);
			return "recommandationedit";
		}
		r.setId(id);
		recommandationService.save(r);	
		return "redirect:/recommandation";
	}

}
