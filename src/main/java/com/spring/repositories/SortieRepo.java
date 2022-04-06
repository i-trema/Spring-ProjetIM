package com.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Sortie;

public interface SortieRepo extends JpaRepository<Sortie, Integer> {
Page<Sortie> findAll(Pageable pageable);
List<Sortie> findByTitre(String titre);
List<Sortie> findByDestination(String destination);
List<Sortie> findByDepart(String depart);
List<Sortie> findByRetour(String retour);
List<Sortie> findByAdmin(String responsable);
List<Sortie> findByDescriptionContaining(String description);
Sortie findById(int id);

}
