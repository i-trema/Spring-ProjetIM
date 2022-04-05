package com.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.spring.entities.Sortie;
@TestInstance(value = Lifecycle.PER_CLASS)
public class Test {
	Validation v;
	@BeforeAll
	public void init() {
		v=new Validation();
		
	}
	
	@org.junit.jupiter.api.Test
	public void verifEmpty() {
		assertTrue(v.notNull(null));
	}
	@org.junit.jupiter.api.Test
	public void listNotEmpty() {
		List<Sortie> sorties = new ArrayList<Sortie>();
		assertTrue(v.listNotEmpty(sorties));
	}
	
	@org.junit.jupiter.api.Test
	public void entierConvertible() {
		assertTrue(v.entierConvertible("12.3"));
	}
	@org.junit.jupiter.api.Test
	public void stringNotEmpty() {
		assertTrue(v.stringNotEmpty(""));
	}	
	@org.junit.jupiter.api.Test
	public void doubleConvertible() {
		assertTrue(v.doubleConvertible("chiffre double"));
	}
	@org.junit.jupiter.api.Test
	public void passwordWithoutNom() {
		assertTrue(v.passwordWithoutName("password", "word"));
	}
	@org.junit.jupiter.api.Test
	public void nomCompletAvecUnEspace() {
		assertTrue(v.nomOneSpace("nom complet"));
	}
}
