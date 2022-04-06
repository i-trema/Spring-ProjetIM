package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entities.Participant;

public interface ParticipantServiceInterface {
	Page<Participant> findAll(Pageable pageable);
	List<Participant> findAll();
	Optional<Participant> findById(int id);
	List<Participant> findByNom(String nom);
	List<Participant> findByPrenom(String prenom);
	List<Participant> findByEmail(String email);
	Optional<Participant> findByNomAndPrenom(String nom, String prenom);
	List<Participant> findByNomOrPrenom(String nom, String prenom);
	void deleteById(int id);
	Participant save(Participant participant);
	void assignParticipant(int ids, Participant participant);
}
