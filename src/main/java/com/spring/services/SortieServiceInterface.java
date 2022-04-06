package com.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entities.Sortie;


public interface SortieServiceInterface {
	Page<Sortie> findAll(Pageable pageable);
	List<Sortie> findAll();
	List<Sortie> findByTitre(String titre);
	List<Sortie> findByDestination(String destination);
	List<Sortie> findByDepart(String depart);
	List<Sortie> findByRetour(String retour);
	List<Sortie> findByAdmin(String responsable);
	List<Sortie> findByDescriptionContaining(String description);
	Sortie save(Sortie sortie);
	void assignResponsable(String nomComplet, Sortie sortie);
	void deleteById(int id);
	
}
