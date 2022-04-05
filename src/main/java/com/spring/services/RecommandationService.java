package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Recommandation;
import com.spring.repositories.RecommandationRepo;
@Service
public class RecommandationService implements RecommandationServiceInterface{
@Autowired
RecommandationRepo recommandationRepo;

@Override
public Page<Recommandation> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return recommandationRepo.findAll(pageable);
}

@Override
public Optional<Recommandation> findById(int id) {
	// TODO Auto-generated method stub
	return recommandationRepo.findById(id);
}

@Override
public void deleteById(int id) {
	recommandationRepo.deleteById(id);
	
}

@Override
public Recommandation save(Recommandation recommandation) {
	// TODO Auto-generated method stub
	return recommandationRepo.save(recommandation);
}

@Override
public List<Recommandation> findAll() {
	// TODO Auto-generated method stub
	return recommandationRepo.findAll();
}


}
