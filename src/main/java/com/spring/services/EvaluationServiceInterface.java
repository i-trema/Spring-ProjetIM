package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entities.Evaluation;

public interface EvaluationServiceInterface {
	Page<Evaluation> findAll(Pageable pageable);
	List<Evaluation> findAll();
	Optional<Evaluation> findById(int id);
	void deleteById(int id);
	Evaluation save(Evaluation evaluation);
}

