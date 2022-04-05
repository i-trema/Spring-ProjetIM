package com.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Recommandation;

public interface RecommandationRepo extends JpaRepository<Recommandation, Integer> {
Page<Recommandation> findAll(Pageable pageable);
}
