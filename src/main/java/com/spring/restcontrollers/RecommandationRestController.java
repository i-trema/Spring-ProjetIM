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

import com.spring.entities.Recommandation;
import com.spring.services.RecommandationService;
@RestController
@RequestMapping("api/recommandation")
public class RecommandationRestController {
	@Autowired
	RecommandationService recommandationService;

	@GetMapping("")
	public Page<Recommandation> getRecommandations(Pageable pageable)
	{
		 return recommandationService.findAll(pageable);
	}
	@GetMapping("{id}")
	public Optional<Recommandation> findRecommandations(@PathVariable int id)
	{
		 return recommandationService.findById(id);
	}

	@PostMapping("")
	public Recommandation addRecommandation(@Valid @RequestBody Recommandation recommandation) 
	{
	return recommandationService.save(recommandation);	

	}
	@DeleteMapping("{id}")
	public void deleteRecommandation(@PathVariable int id) {
		recommandationService.deleteById(id);
	}




	}