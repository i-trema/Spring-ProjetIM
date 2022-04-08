package com.spring.simplecontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entities.Admin;
import com.spring.entities.Role;
import com.spring.services.AccountServiceImplement;

@Controller
@RequestMapping("admin")
public class AdminSimpleController {
	@Autowired
	AccountServiceImplement accountServiceImplement;
	
	
	@GetMapping("")
	public String getAdmins(Model m, Pageable pageable) {
		
		Admin a = new Admin();
		List<Admin> admins = accountServiceImplement.findAllAdmins();
		m.addAttribute("admins", admins);
		m.addAttribute("admin", a); 
		List<Role> roles = accountServiceImplement.findAllRoles();
		m.addAttribute("roles", roles);
		String adminrole = a.getRolesListe();
		
		m.addAttribute("adminrole", adminrole);
		
		
		return "admin";
	}
	
	@PostMapping("add")
	public String addAdmin(@RequestParam String adminrole, @Valid @RequestBody @ModelAttribute(name = "admin") Admin a, BindingResult result, Model m, Pageable pageable) {
//		if (result.hasErrors()){
//			
//			
//			
//			return "admin";
//		}
		
		
		Role role=accountServiceImplement.findByRoleName(adminrole);
		
		accountServiceImplement.saveAdmin(a);
		accountServiceImplement.addRoleToAdmin(a.getLogin(), adminrole);
		a.setRolesListe(adminrole);
		
		System.out.println("OK");
		return "redirect:/admin";
	}		
	
	@RequestMapping(value = "delete/{login}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteAdmin(@PathVariable String login) {
		accountServiceImplement.deleteById(login);
		return "redirect:/admin";
	}
//	
//	@GetMapping(value = "edit/{idEdit}")
//	public String editAdmin(@PathVariable int idEdit, Model m2) {
//		Admin adminedit = accountServiceImplement.findById(idEdit);
//		System.out.println(adminedit.getAdmin().getNomComplet());
//		String nomDuResponsable = adminedit.getAdmin().getNomComplet();
//		List<Admin> admins=accountServiceImplement.findAllAdminsList();
//		m2.addAttribute("admin", adminedit);
//		m2.addAttribute("admins", admins);		
//		m2.addAttribute("nomduresponsable", nomDuResponsable);
//				
//		return "adminedit";
//	}
//	@PostMapping("edit/{id}")
//	public String addEditedAdmin(@RequestParam String nomAdmin, @PathVariable int id, @Valid Admin s, BindingResult result, Model m2, Pageable pageable) {
//		if (result.hasErrors()){
//			m2.addAttribute("admin", s);
//			m2.addAttribute("admins", accountServiceImplement.findAllAdmins(pageable));
//			List<Admin> admins=accountServiceImplement.findAllAdminsList();
//			m2.addAttribute("admins", admins);
//			return "adminedit";
//		}
//		s.setId(id);
//		Admin admin=accountServiceImplement.findByNomComplet(nomAdmin);
//		s.setAdmin(admin);
//		accountServiceImplement.save(s);	
//		return "redirect:/admin";
//	}

}


