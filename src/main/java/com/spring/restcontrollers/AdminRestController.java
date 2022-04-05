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

import com.spring.entities.Admin;

import com.spring.services.AccountServiceImplement;

@RestController
@RequestMapping("api/admin")
public class AdminRestController {
	@Autowired
	AccountServiceImplement accountServiceImplement;
		
	@GetMapping("")
	public Page<Admin> getAdmins(Pageable pageable)
	{
		 return accountServiceImplement.findAllAdmins(pageable);
	}
	@GetMapping("{login}")
	public Admin findAdmins(@PathVariable String login)
	{
		 return accountServiceImplement.findByLogin(login);
	}
	
	@PostMapping("")
	public Admin addAdmin(@Valid @RequestBody Admin admin) 
	{
	return accountServiceImplement.saveAdmin(admin);	

	}
	@DeleteMapping("{id}")
	public void deleteAdmin(@PathVariable String login) {
		accountServiceImplement.deleteAdmin(login);;
	}




	}



