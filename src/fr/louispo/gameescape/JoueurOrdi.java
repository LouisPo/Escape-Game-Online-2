package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

public class JoueurOrdi extends Joueur {

	private int propoH;
	private String propoH1;
	private String propoH2;
	private String propoH3;
	private String propoH4;
	private String resultat;

	public void evaluer(Mode mode) {
		if (ordi1 == Integer.parseInt(propoH1)) {
			resultat = "=";
		} else if (ordi1 > Integer.parseInt(propoH1)) {
			resultat = "+";
		} else {
			resultat = "-";
		}
		if (ordi2 == Integer.parseInt(propoH2)) {
			resultat = resultat + "=";
		} else if (ordi2 > Integer.parseInt(propoH2)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi3 == Integer.parseInt(propoH3)) {
			resultat = resultat + "=";
		} else if (ordi3 > Integer.parseInt(propoH3)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi4 == Integer.parseInt(propoH4)) {
			resultat = resultat + "=";
		} else if (ordi4 > Integer.parseInt(propoH4)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}

		System.out.println("#" + mode.getCompteur() + " " + propoH + " " + resultat);
	}

	//-- GETTER and SETTER

	public String getResultat() {
		return resultat;
	}
}
