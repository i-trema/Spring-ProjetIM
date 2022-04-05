package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.calcul.Calcul;
import com.spring.entities.Admin;
import com.spring.entities.Evaluation;
import com.spring.entities.Participant;
import com.spring.entities.Recommandation;
import com.spring.entities.Role;
import com.spring.entities.Sortie;

import com.spring.services.AccountServiceImplement;
import com.spring.services.EvaluationService;
import com.spring.services.ParticipantService;
import com.spring.services.RecommandationService;
import com.spring.services.SortieService;

@SpringBootApplication
public class J1ProjetPersoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(J1ProjetPersoApplication.class, args);
	}
	@Autowired
	SortieService sortieService;
	@Autowired
	RecommandationService recommandationService;
	@Autowired
	ParticipantService participantService;
	@Autowired
	EvaluationService evaluationService;
	@Autowired
	AccountServiceImplement accountServiceImplement;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
//		Role role1 = accountServiceImplement.saveRole(new Role("guide"));
//		Role role2 = accountServiceImplement.saveRole(new Role("organisateur"));
//		
//		Admin guide1 = accountServiceImplement.saveAdmin(new Admin("guide1", 1, "1234", "guide 1", "adresse 1", "12121", null));
//		Admin organisateur1 = accountServiceImplement.saveAdmin(new Admin("organisateur1", 1, "1234", "orga 1", "adresse 2", "5555521", null));
//		accountServiceImplement.addRoleToAdmin("guide1", "guide");
//		accountServiceImplement.addRoleToAdmin("organisateur1", "organisateur");
//		Admin guide2 = accountServiceImplement.saveAdmin(new Admin("guide2", 1, "1234", "guide 2", "adresse 3", "199991", null));
//		accountServiceImplement.addRoleToAdmin("guide2", "guide");
		
//		Sortie s1 = sortieService.save(new Sortie("randonnée", "Forêt de Fontainebleau", "10h", "19h30", guide1, 150, "randonnée en forêt de Fontainebleau"));
//		Sortie s2 = sortieService.save(new Sortie("randonnée2", "Forêt de Sénart", "10h", "19h30", organisateur1, 100, "randonnée en forêt de Sénart"));
//		Recommandation r1 = recommandationService.save(new Recommandation("reco 1", "1ère recommandation", "12/03/2022"));
//		Recommandation r2 = recommandationService.save(new Recommandation("reco 2", "2ème recommandation", "01/03/2022"));
//		Evaluation e1 = evaluationService.save(new Evaluation("évaluation 1", 3, "bien", null));
//		Evaluation e2 = evaluationService.save(new Evaluation("évaluation 2", 5, "très bien", "nom 1"));
//		
//		Participant p1 = participantService.save(new Participant("nom1", "prénom1", "email@fr.fr", "121232131", 30));
//		Participant p2 = participantService.save(new Participant("nom2", "prénom2", "email2@fr.fr", "222131", 50));
	
		Calcul c = new Calcul();
		System.out.println("Moyenne des prix des sorties : " + c.moyennePrix(sortieService.findAll()) + '\n');	
		System.out.println("Total des participants : " + c.totalParticipants(participantService.findAll()) + '\n');
		System.out.println("Moyenne des évaluations : " + c.moyenneEvaluations(evaluationService.findAll()) + '\n');
		System.out.println("Total des recommandations : " + c.totalRecommandations(recommandationService.findAll()) + '\n');
	}

}
