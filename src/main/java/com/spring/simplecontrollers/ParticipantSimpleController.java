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

import com.spring.entities.Participant;
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
		m.addAttribute("participants", participantService.findAll(pageable));
		m.addAttribute("participant", p); 
		
		return "participant";
	}
	
	@PostMapping("add/{ids}")
	public String addParticipant(@PathVariable int ids, @Valid @RequestBody @ModelAttribute(name = "participant") Participant p, BindingResult result, Model m, Pageable pageable) {
		if (result.hasErrors()){
			m.addAttribute("participants", participantService.findAll(pageable));

			return "participant";
		}
		
		participantService.save(p);
		p.setSortie(sortieService.findById(ids));
		
		return "redirect:/participant";
	}		
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteParticipant(@PathVariable int id) {
		participantService.deleteById(id);
		return "redirect:/participant";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editParticipant(@PathVariable int id, Model m) {
		Participant s = participantService.findById(id).get();
		m.addAttribute("participant", s);
		return "participantedit";
	}
	@PostMapping("edit/{id}")
	public String addEditedParticipant(@PathVariable int id, @Valid Participant s, BindingResult result, Model m) {
		if (result.hasErrors()){
			m.addAttribute("participant", s);
			return "participantedit";
		}
		s.setId(id);
		participantService.save(s);	
		return "redirect:/participant";
	}

}
