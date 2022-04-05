package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

	Role findByRoleName(String roleName);

}
