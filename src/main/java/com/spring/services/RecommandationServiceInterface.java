package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entities.Recommandation;


public interface RecommandationServiceInterface {
	Page<Recommandation> findAll(Pageable pageable);
	List<Recommandation> findAll();
	
	Optional<Recommandation> findById(int id);
	void deleteById(int id);
	Recommandation save(Recommandation recommandation);
}