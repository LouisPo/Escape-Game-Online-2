package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

public class Joueur_Humain extends Joueur {
	String signeH;
	String signeH1;
	String signeH2;
	String signeH3;
	String signeH4;
	String[] signetabH;
	int[] find;
	int find1;
	int find2;
	int find3;
	int find4;
	int compteur;
	int nbessai = 6;
	int sizeGame = 4;

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

	public void evaluerordi() {
		int[] find = new int[4];
		Mode tempmode = new Mode();

		if (signeH1.equals("=")) {
			find1 = ordi1;
		} else if (signeH1.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi1 + 1;
			Mode.tabborneinf[0] = borneInfTemp;
			ordi1 = genererInt(Mode.tabborneinf[0], Mode.tabbornesup[0]);
		} else {
			// random inferieur
			int borneInfTemp;
			Mode.tabbornesup[0] = ordi1 - 1;
			// borneInfTemp=ordi2-1;
			ordi1 = genererInt(Mode.tabborneinf[0], Mode.tabbornesup[0]);
		}
		
		
		
		if (signeH2.equals("=")) {
			find2 = ordi2;
		} else if (signeH2.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi2 + 1;
			Mode.tabborneinf[1]= borneInfTemp;
			ordi2 = genererInt(Mode.tabborneinf[1], Mode.tabbornesup[1]);
		} else {
			// random inferieur
			int borneInfTemp;
			Mode.tabbornesup[1]= ordi2 - 1;
			ordi2 = genererInt(Mode.tabborneinf[1], Mode.tabbornesup[1]);
		}

		if (signeH3.equals("=")) {
			find3 = ordi3;
		} else if (signeH3.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi3 + 1;
			Mode.tabborneinf[2]= borneInfTemp;
			ordi3 = genererInt(Mode.tabborneinf[2], Mode.tabbornesup[2]);
		} else {
			// random inferieur
			int borneInfTemp;
			Mode.tabbornesup[2] = ordi3 - 1;
			ordi3 = genererInt(Mode.tabborneinf[2], Mode.tabbornesup[2]);
		}
		if (signeH4.equals("=")) {
			find4 = ordi4;
		} else if (signeH4.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordi4 + 1;
			Mode.tabborneinf[3]= borneInfTemp;
			ordi4 = genererInt(Mode.tabborneinf[3], Mode.tabbornesup[3]);
		} else {
			// random inferieur
			int borneInfTemp;
			Mode.tabbornesup[3] = ordi4 - 1;
			ordi4 = genererInt(Mode.tabborneinf[3], Mode.tabbornesup[3]);
		}
		compteur = compteur + 1;
		if (compteur < nbessai) {
			System.out.println("" + ordi1 + "" + ordi2 + "" + ordi3 + "" + ordi4);
		}

	}
}