package com.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Sortie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String titre;
	@NotBlank
	private String destination;
	@NotBlank
	private String depart;
	@NotBlank
	private String retour;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "responsable", referencedColumnName = "nomComplet")
	private Admin admin;
	@NotNull
	@Min(value = 100)
	private double prix;
	
	@Column(length = 200)
	@NotBlank
	private String description;
	
	
	
	
	public Sortie(int id, @NotBlank String titre, @NotBlank String destination, @NotBlank String depart,
			@NotBlank String retour, Admin admin, @NotNull @Min(100) double prix, @NotBlank String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.destination = destination;
		this.depart = depart;
		this.retour = retour;
		this.admin = admin;
		this.prix = prix;
		this.description = description;
	}
	
	
	public Sortie(@NotBlank String titre, @NotBlank String destination, @NotBlank String depart,
			@NotBlank String retour, Admin admin, @NotNull @Min(100) double prix, @NotBlank String description) {
		super();
		this.titre = titre;
		this.destination = destination;
		this.depart = depart;
		this.retour = retour;
		this.admin = admin;
		this.prix = prix;
		this.description = description;
	}


	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Sortie() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getRetour() {
		return retour;
	}
	public void setRetour(String retour) {
		this.retour = retour;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
