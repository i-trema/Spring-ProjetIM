package com.spring.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Admin;
import com.spring.entities.Sortie;
import com.spring.repositories.AdminRepo;
import com.spring.repositories.SortieRepo;
@Service
public class SortieService implements SortieServiceInterface{
@Autowired
SortieRepo sortieRepo;
@Autowired
AdminRepo adminRepo;

	@Override
	public Page<Sortie> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sortieRepo.findAll(pageable);
	}

	@Override
	public List<Sortie> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return sortieRepo.findByTitre(titre);
	}

	@Override
	public List<Sortie> findByDestination(String destination) {
		// TODO Auto-generated method stub
		return sortieRepo.findByDestination(destination);
	}

	@Override
	public List<Sortie> findByDepart(String depart) {
		// TODO Auto-generated method stub
		return sortieRepo.findByDepart(depart);
	}

	@Override
	public List<Sortie> findByRetour(String retour) {
		// TODO Auto-generated method stub
		return sortieRepo.findByRetour(retour);
	}

	@Override
	public List<Sortie> findByAdmin(String responsable) {
		// TODO Auto-generated method stub
		return sortieRepo.findByAdmin(responsable);
	}

	@Override
	public List<Sortie> findByDescriptionContaining(String description) {
		// TODO Auto-generated method stub
		return sortieRepo.findByDescriptionContaining(description);
	}

	public Sortie save(@Valid Sortie sortie) {
		return sortieRepo.save(sortie);
	}

	public void deleteById(int id) {
		sortieRepo.deleteById(id);
		
	}

	public Optional<Sortie> findById(int id) {
		// TODO Auto-generated method stub
		return sortieRepo.findById(id);
	}

	@Override
	public List<Sortie> findAll() {
		// TODO Auto-generated method stub
		return sortieRepo.findAll();
	}

	@Override
	public void assignResponsable(String nomComplet, Sortie sortie) {
		Admin admin=adminRepo.findByNomComplet(nomComplet);
		sortie.setAdmin(admin);	
		save(sortie);
	}

}
