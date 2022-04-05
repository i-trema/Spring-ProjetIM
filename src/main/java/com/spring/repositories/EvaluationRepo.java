package com.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entities.Evaluation;

public interface EvaluationRepo extends JpaRepository<Evaluation, Integer> {
	@Query("SELECT e FROM Evaluation e ORDER BY note DESC")
	List<Evaluation> readAllOrderByNoteDesc();
}
