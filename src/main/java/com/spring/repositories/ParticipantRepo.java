package com.spring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Participant;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {
Page<Participant> findAll(Pageable pageable);
List<Participant> findByNom(String nom);
List<Participant> findByPrenom(String prenom);
List<Participant> findByEmail(String email);
Optional<Participant> findByNomAndPrenom(String nom, String prenom);
List<Participant> findByNomOrPrenom(String nom, String prenom);

}
