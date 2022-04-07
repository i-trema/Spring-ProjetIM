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

import com.spring.entities.Participant;
import com.spring.entities.Sortie;
import com.spring.services.ParticipantService;
import com.spring.services.SortieService;

@Controller
@RequestMapping("participant")
public class ParticipantSimpleController {
	@Autowired
	ParticipantService participantService;
	@Autowired
	SortieService sortieService;
	
	@GetMapping("")
	public String getParticipants(Model m, Pageable pageable) {
		Participant p = new Participant();
		List<Sortie> sorties = sortieService.findAll();
		m.addAttribute("sorties", sorties);
		m.addAttribute("participants", participantService.findAll(pageable));
		m.addAttribute("participant", p); 
		int idSortie = 0;
		m.addAttribute("idSortie", idSortie);
		return "participant";
	}
	
	@PostMapping("add")
	public String addParticipant(@RequestParam int idSortie, @Valid @RequestBody @ModelAttribute(name = "participant") Participant p, BindingResult result, Model m, Pageable pageable) {
	
		if (result.hasErrors()){
			m.addAttribute("participants", participantService.findAll(pageable));
			List<Sortie> sorties = sortieService.findAll();
			m.addAttribute("sorties", sorties);
			return "participant";
		}
		Sortie sortie=sortieService.findById(idSortie);
		p.setSortie(sortie);
		participantService.save(p);

		return "redirect:/participant";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteParticipant(@PathVariable int id) {
		participantService.deleteById(id);
		return "redirect:/participant";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editParticipant(@PathVariable int id, Model m) {
		Participant p = participantService.findById(id).get();
		String nomSortie = p.getSortie().getTitre();
		List<Sortie> sorties = sortieService.findAll();
		m.addAttribute("participant", p);
		m.addAttribute("sorties", sorties);
		m.addAttribute("nomSortie", nomSortie);
		

		return "participantedit";
	}
	@PostMapping("edit/{id}")
	public String addEditedParticipant(@RequestParam String nomSortie, @PathVariable int id, @Valid Participant p, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("participant", p);
			m.addAttribute("participants", participantService.findAll(pageable));
			List<Sortie> sorties = sortieService.findAll();
			m.addAttribute("sorties", sorties);
			return "participantedit";
		}
		p.setId(id);
		participantService.save(p);	
		return "redirect:/participant";
	}

}
