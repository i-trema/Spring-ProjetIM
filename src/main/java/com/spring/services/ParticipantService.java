package com.spring.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Participant;
import com.spring.repositories.ParticipantRepo;

@Service
public class ParticipantService implements ParticipantServiceInterface{
@Autowired
ParticipantRepo participantRepo;


	@Override
	public Page<Participant> findAll(Pageable pageable) {
		
		return participantRepo.findAll(pageable);
	}

	@Override
	public List<Participant> findByNom(String nom) {
		// TODO Auto-generated method stub
		return participantRepo.findByNom(nom);
	}

	@Override
	public List<Participant> findByPrenom(String prenom) {
		// TODO Auto-generated method stub
		return participantRepo.findByPrenom(prenom);
	}

	@Override
	public List<Participant> findByEmail(String email) {
		// TODO Auto-generated method stub
		return participantRepo.findByEmail(email);
	}

	@Override
	public Optional<Participant> findByNomAndPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return participantRepo.findByNomAndPrenom(nom, prenom);
	}

	@Override
	public List<Participant> findByNomOrPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return participantRepo.findByNomOrPrenom(nom, prenom);
	}

	@Override
	public Optional<Participant> findById(int id) {
		// TODO Auto-generated method stub
		return participantRepo.findById(id);
	}

	public Participant save(@Valid Participant participant) {
		// TODO Auto-generated method stub
		return participantRepo.save(participant);
	}

	public void deleteById(int id) {
		participantRepo.deleteById(id);
		
	}

	@Override
	public List<Participant> findAll() {
		// TODO Auto-generated method stub
		return participantRepo.findAll();
	}

}
