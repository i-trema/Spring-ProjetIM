package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.entities.Admin;
import com.spring.entities.Role;
import com.spring.repositories.AdminRepo;
import com.spring.repositories.RoleRepo;


@Service
@Transactional
public class AccountServiceImplement implements AccountService{
	@Bean
	private BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	};
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	RoleRepo roleRepo;
	
	
	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		String hashPW=getBCPE().encode(admin.getPassword());
		System.out.println(hashPW);
		admin.setPassword(hashPW);
		return adminRepo.save(admin);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToAdmin(String login, String roleName) {
		// TODO Auto-generated method stub
		Role role=roleRepo.findByRoleName(roleName);
		Admin admin=adminRepo.findByLogin(login);
		admin.getRoles().add(role);
	}

	@Override
	public Admin findByLogin(String login) {
		// TODO Auto-generated method stub
		return adminRepo.findByLogin(login);
	}

	@Override
	public Page<Role> findAllRoles(Pageable pageable) {
		// TODO Auto-generated method stub
		return roleRepo.findAll(pageable);
	}

	@Override
	public Page<Admin> findAllAdmins(Pageable pageable) {
		// TODO Auto-generated method stub
		return adminRepo.findAll(pageable);
	}

	@Override
	public void deleteRole(String roleName) {
		roleRepo.deleteById(roleName);
		
	}

	@Override
	public void deleteAdmin(String login) {
		adminRepo.deleteById(login);
		
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepo.findByRoleName(roleName);
	}

	@Override
	public Admin findByNomComplet(String nomComplet) {
		// TODO Auto-generated method stub
		return adminRepo.findByNomComplet(nomComplet);
	}

	public List<Admin> findAllAdminsList() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	

}
