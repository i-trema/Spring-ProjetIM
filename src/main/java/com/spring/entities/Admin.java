package com.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String login;
	private int active;
	@NotBlank
	private String password;
	@NotBlank
	@Size(min = 4, max = 50)
	private String nomComplet;
	@NotBlank
	private String adresse;
	@NotBlank
	private String telephone;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
	
	
	
	
	
	
	public Admin(int active, @NotBlank String password, @NotBlank @Size(min = 4, max = 50) String nomComplet,
			@NotBlank String adresse, @NotBlank String telephone, List<Role> roles) {
		super();
		this.active = active;
		this.password = password;
		this.nomComplet = nomComplet;
		this.adresse = adresse;
		this.telephone = telephone;
		this.roles = roles;
	}
	public Admin(String login, int active, @NotBlank String password,
			@NotBlank @Size(min = 4, max = 50) String nomComplet, @NotBlank String adresse, @NotBlank String telephone,
			List<Role> roles) {
		super();
		this.login = login;
		this.active = active;
		this.password = password;
		this.nomComplet = nomComplet;
		this.adresse = adresse;
		this.telephone = telephone;
		this.roles = roles;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Admin() {
		super();
	}
	public Admin(String login, int active, @NotBlank String password,
			@NotBlank @Size(min = 4, max = 50) String nomComplet, @NotBlank String adresse,
			@NotBlank String telephone) {
		super();
		this.login = login;
		this.active = active;
		this.password = password;
		this.nomComplet = nomComplet;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	
	
}
