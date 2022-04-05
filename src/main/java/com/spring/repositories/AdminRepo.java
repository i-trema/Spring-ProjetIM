package com.spring.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {
Admin findByLogin(String login);
List<Admin> findByNomComplet(String nomComplet);

}
