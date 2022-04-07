package com.spring.simplecontrollers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entities.Admin;
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
		List<Admin> admins=accountServiceImplement.findAllAdminsList();
		m.addAttribute("admins", admins);
		m.addAttribute("sorties", sortieService.findAll(pageable));
		m.addAttribute("sortie", s); 
		String nomAdmin = "";
		m.addAttribute("nomAdmin", nomAdmin);
		return "sortie";
	}
	
	@PostMapping("add")
	public String addSortie(@RequestParam String nomAdmin, @Valid @RequestBody @ModelAttribute(name = "sortie") Sortie s, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("sorties", sortieService.findAll(pageable));
			List<Admin> admins=accountServiceImplement.findAllAdminsList();
			m.addAttribute("admins", admins);
			
			
			System.out.println("erreur");
			return "sortie";
		}
		
		Admin admin=accountServiceImplement.findByNomComplet(nomAdmin);
		s.setAdmin(admin);
		sortieService.save(s);
		
		System.out.println("OK");
		return "redirect:/sortie";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteSortie(@PathVariable int id) {
		sortieService.deleteById(id);
		return "redirect:/sortie";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editSortie(@PathVariable int id, Model m) {
		Sortie s = sortieService.findById(id);
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
