package com.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entities.Admin;
import com.spring.entities.Role;

public interface AccountService {
 public Admin saveAdmin(Admin admin);
 public Role saveRole(Role role);
 public void addRoleToAdmin(String login, String roleName);
 public Admin findByLogin(String login);
 public Admin findByNomComplet(String nomComplet);
 public Role findByRoleName(String roleName);
 public Page<Role> findAllRoles(Pageable pageable);
 public Page<Admin> findAllAdmins(Pageable pageable);
 public void deleteRole(String roleName);
 public void deleteAdmin(String login);
 
}
