package com.spring.restcontrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Role;

import com.spring.services.AccountServiceImplement;

@RestController
@RequestMapping("api/role")
public class RoleRestController {
	@Autowired
	AccountServiceImplement accountServiceImplement;
		
	@GetMapping("")
	public Page<Role> getRoles(Pageable pageable)
	{
		 return accountServiceImplement.findAllRoles(pageable);
	}
	@GetMapping("{roleName}")
	public Role findRoles(@PathVariable String roleName)
	{
		 return accountServiceImplement.findByRoleName(roleName);
	}
	
	@PostMapping("")
	public Role addRole(@Valid @RequestBody Role role) 
	{
	return accountServiceImplement.saveRole(role);	

	}
	@DeleteMapping("{roleName}")
	public void deleteRole(@PathVariable String roleName) {
		accountServiceImplement.deleteRole(roleName);;
	}




	}



