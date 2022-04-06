package com.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Participant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Size(min = 4, max = 50)
	private String nom;
	@NotBlank
	@Size(min = 4, max = 50)
	private String prenom;
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String telephone;
	@NotNull
	private int age;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sortie", referencedColumnName = "id")
	private Sortie sortie;
	
	
	
	
	public Participant(@NotBlank @Size(min = 4, max = 50) String nom, @NotBlank @Size(min = 4, max = 50) String prenom,
			@Email String email, @NotBlank String telephone, @NotNull int age, Sortie sortie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.sortie = sortie;
	}
	public Participant(int id, @NotBlank @Size(min = 4, max = 50) String nom,
			@NotBlank @Size(min = 4, max = 50) String prenom, @Email String email, @NotBlank String telephone,
			@NotNull int age, Sortie sortie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.sortie = sortie;
	}
	public Sortie getSortie() {
		return sortie;
	}
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
	public Participant() {
		super();
	}
	public Participant(@NotBlank String nom, @NotBlank String prenom, @Email String email, @NotBlank String telephone,
			@NotNull int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
	}
	public Participant(int id, @NotBlank String nom, @NotBlank String prenom, @Email String email,
			@NotBlank String telephone, @NotNull int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
