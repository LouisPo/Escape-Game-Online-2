package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

public class JoueurHumain extends Joueur {

	private String signeH;
	private String signeH1;
	private String signeH2;
	private String signeH3;
	private String signeH4;
	private String[] signetabH;
	private int[] find;
	private int find1;
	private int find2;
	private int find3;
	private int find4;
	private int compteur;
	private int nbessai = 6;
	private int sizeGame = 4;

	public void trouver() {

		System.out.println("rentrez les indications");
		Scanner sc = new Scanner(System.in);
		signeH = sc.nextLine();
		signeH1 = signeH.substring(0, 1);
		signeH2 = signeH.substring(1, 2);
		signeH3 = signeH.substring(2, 3);
		signeH4 = signeH.substring(3, 4);
		signetabH = new String[4];
		for (int i = 0; i < sizeGame; i++) {
			signetabH[i] = signeH.substring(i, i + 1);
		}

	}

	public void fin_partie() {

	}

	int genererInt(int borneInf, int borneSup) {
		Random random = new Random();
		int nb;
		if ((borneSup - borneInf) > 0) {
			nb = borneInf + random.nextInt(borneSup - borneInf);
		} else {
			nb = borneInf;
		}
		return nb; 
	}

	public void evaluerordi(Mode mode) {
		int[] find = new int[4];

		if (signeH1.equals("=")) {
			find1 = ordi1;
		} else if (signeH1.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi1 + 1;
			mode.getTabborneinf()[0] = borneInfTemp;
			ordi1 = genererInt(mode.getTabborneinf()[0], mode.getTabbornesup()[0]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getTabbornesup()[0] = ordi1 - 1;
			// borneInfTemp=ordi2-1;
			ordi1 = genererInt(mode.getTabborneinf()[0], mode.getTabbornesup()[0]);
		}
		
		
		
		if (signeH2.equals("=")) {
			find2 = ordi2;
		} else if (signeH2.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi2 + 1;
			mode.getTabborneinf()[1]= borneInfTemp;
			ordi2 = genererInt(mode.getTabborneinf()[1], mode.getTabbornesup()[1]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getTabbornesup()[1]= ordi2 - 1;
			ordi2 = genererInt(mode.getTabborneinf()[1], mode.getTabbornesup()[1]);
		}

		if (signeH3.equals("=")) {
			find3 = ordi3;
		} else if (signeH3.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi3 + 1;
			mode.getTabborneinf()[2]= borneInfTemp;
			ordi3 = genererInt(mode.getTabborneinf()[2], mode.getTabbornesup()[2]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getTabbornesup()[2] = ordi3 - 1;
			ordi3 = genererInt(mode.getTabborneinf()[2], mode.getTabbornesup()[2]);
		}
		if (signeH4.equals("=")) {
			find4 = ordi4;
		} else if (signeH4.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi4 + 1;
			mode.getTabborneinf()[3]= borneInfTemp;
			ordi4 = genererInt(mode.getTabborneinf()[3], mode.getTabbornesup()[3]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getTabbornesup()[3] = ordi4 - 1;
			ordi4 = genererInt(mode.getTabborneinf()[3], mode.getTabbornesup()[3]);
		}
		compteur = compteur + 1;
		if (compteur < nbessai) {
			System.out.println("" + ordi1 + "" + ordi2 + "" + ordi3 + "" + ordi4);
		}
	}

	//-- GETTER and SETTER
	/**
	 *  A compléter
	 * @return
	 */
	public String getSigneH() {
		return signeH;
	}
}