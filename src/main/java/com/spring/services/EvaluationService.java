package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Evaluation;
import com.spring.repositories.EvaluationRepo;
@Service
public class EvaluationService implements EvaluationServiceInterface{
@Autowired
EvaluationRepo evaluationRepo;
	@Override
	public Page<Evaluation> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return evaluationRepo.findAll(pageable);
	}

	@Override
	public Optional<Evaluation> findById(int id) {
		// TODO Auto-generated method stub
		return evaluationRepo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		evaluationRepo.deleteById(id);
	}

	@Override
	public Evaluation save(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return evaluationRepo.save(evaluation);
	}

	@Override
	public List<Evaluation> findAll() {
		// TODO Auto-generated method stub
		return evaluationRepo.findAll();
	}

}
