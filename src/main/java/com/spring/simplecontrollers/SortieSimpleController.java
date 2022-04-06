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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entities.Sortie;
import com.spring.services.AccountServiceImplement;
import com.spring.services.SortieService;

@Controller
@RequestMapping("sortie")
public class SortieSimpleController {
	@Autowired
	SortieService sortieService;
	@Autowired
	AccountServiceImplement accountServiceImplement;
	
	@GetMapping("")
	public String getSorties(Model m, Pageable pageable) {
		Sortie s = new Sortie();
		m.addAttribute("sorties", sortieService.findAll(pageable));
		
		
		m.addAttribute("sortie", s);
		
//		if (s.getAdmin()!=null) {
//			m.addAttribute("responsable", s.getAdmin().getNomComplet());
//		}else {
//			m.addAttribute("responsable", "null");
//		} 
		
		return "sortie";
	}
	
	@PostMapping("add")
	public String addSortie(@Valid @ModelAttribute(name = "sortie") Sortie s, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("sorties", sortieService.findAll(pageable));
			return "sortie";
		}
//		s.setAdmin(accountServiceImplement.findByNomComplet(nomComplet));
		sortieService.save(s);	
		return "redirect:/sortie";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteSortie(@PathVariable int id) {
		sortieService.deleteById(id);
		return "redirect:/sortie";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editSortie(@PathVariable int id, Model m) {
		Sortie s = sortieService.findById(id).get();
		m.addAttribute("sortie", s);
		return "sortieedit";
	}
	@PostMapping("edit/{id}")
	public String addEditedSortie(@PathVariable int id, @Valid Sortie s, BindingResult result, Model m) {
		if (result.hasErrors()){
			m.addAttribute("sortie", s);
			return "sortieedit";
		}
		s.setId(id);
		sortieService.save(s);	
		return "redirect:/sortie";
	}

}
