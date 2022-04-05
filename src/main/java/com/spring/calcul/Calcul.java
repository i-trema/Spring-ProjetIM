package com.spring.calcul;

import java.util.List;

import com.spring.entities.Evaluation;
import com.spring.entities.Participant;
import com.spring.entities.Recommandation;
import com.spring.entities.Sortie;

public class Calcul {

public double moyennePrix(List<Sortie> sorties) {
	double moyennePrix = 0;
	double sommePrix = 0;
	for (Sortie sortie : sorties) {
		sommePrix += sortie.getPrix();
	}
	moyennePrix = sommePrix/(sorties.size());
	return moyennePrix;
}
public int totalParticipants(List<Participant> participants) {
	return participants.size();
}
public double moyenneEvaluations(List<Evaluation> evaluations) {
	int moyenneEval = 0;
	int sommeEval = 0;
	for (Evaluation evaluation : evaluations) {
		sommeEval += evaluation.getNote();
	}
	moyenneEval = sommeEval/(evaluations.size());
	return moyenneEval;
}
public int totalRecommandations(List<Recommandation> recommandations) {
	return recommandations.size();
}

}
