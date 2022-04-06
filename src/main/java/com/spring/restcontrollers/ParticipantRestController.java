package com.spring.restcontrollers;

import java.util.List;
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

import com.spring.entities.Participant;
import com.spring.services.ParticipantService;
import com.spring.services.SortieService;

@RestController
@RequestMapping("api/participant")
public class ParticipantRestController {
	@Autowired
	ParticipantService participantService;
	@Autowired
	SortieService sortieService;
		
	@GetMapping("")
	public Page<Participant> getParticipants(Pageable pageable)
	{
		 return participantService.findAll(pageable);
	}
	@GetMapping("{id}")
	public Optional<Participant> findParticipants(@PathVariable int id)
	{
		 return participantService.findById(id);
	}
	@GetMapping("nometprenom/{nom}/{prenom}")
	public Optional<Participant> findParticipantsByNomEtPrenom(@PathVariable String nom, String prenom)
	{
		 return participantService.findByNomAndPrenom(nom, prenom);
	}
	@GetMapping("nomouprenom/{nom}/{prenom}")
	public List<Participant> findParticipantsByNomOuPrenom(@PathVariable String nom, String prenom)
	{
		 return participantService.findByNomOrPrenom(nom, prenom);
	}
	@GetMapping("email/{email}")
	public List<Participant> findParticipantsByEmail(@PathVariable String email)
	{
		 return participantService.findByEmail(email);
	}
	
	@PostMapping("/{id}")
	public Participant addParticipant(@PathVariable int id, @Valid @RequestBody Participant participant) 
	{
		participant.setSortie(sortieService.findById(id).get());
		return participantService.save(participant);	

	}
	@DeleteMapping("{id}")
	public void deleteParticipant(@PathVariable int id) {
		participantService.deleteById(id);
	}




	}

