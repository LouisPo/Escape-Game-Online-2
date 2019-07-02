package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

public class JoueurHumain extends Joueur {

	public String signeH;
	public String signeH1;
	public String signeH2;
	public String signeH3;
	public String signeH4;
	private String[] signetabH;
	private int[] find;
	private int find1;
	private int find2;
	private int find3;
	private int find4;
	
	private int[] finder;
	private int finder1;
	private int finder2;
	private int finder3;
	private int finder4;
	private int compteur;
	private int nbessai = 6;
	private int sizeGame = 4;
	int decompte=2;

	public int trouver() {

		
		Scanner sc = new Scanner(System.in);
		signeH = sc.nextLine();
		if(signeH.length()!=4){
			System.out.println("rentrez 4 indications avec uniquement +, - ou =");
			return 1;
		
		}
		else{
			signeH1 = signeH.substring(0, 1);
			signeH2 = signeH.substring(1, 2);
			signeH3 = signeH.substring(2, 3);
			signeH4 = signeH.substring(3, 4);
			
			signetabH = new String[4];
			for (int i = 0; i < sizeGame; i++) {
				signetabH[i] = signeH.substring(i, i + 1);
			}
			
			
			return verifsigne(signeH1,signeH2,signeH3,signeH4);
		}
	}

	public int verifsigne(String s1,String s2,String s3,String s4){
		int retour=0;
		if(!((s1.equals("+"))||(s1.equals("-"))||(s1.equals("=")))){
			retour=1;
		}
		if(!((s2.equals("+"))||(s2.equals("-"))||(s2.equals("=")))){
			retour=1;
		}
		if(!((s3.equals("+"))||(s3.equals("-"))||(s3.equals("=")))){
			retour=1;
		}
		if(!((s4.equals("+"))||(s4.equals("-"))||(s4.equals("=")))){
			retour=1;	
		}
		if(retour==1){
			System.out.println("rentrez 4 indications avec uniquement +, - ou =");	
		}
		return retour;
		
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
		
			if ((compteur < nbessai) && (!(signeH.equals("===="))) && (!(mode.equals("duel")))) {
				System.out.println("Proposition de l'ordinateur");
				System.out.println("#"+decompte +" "+ ordi1 + "" + ordi2 + "" + ordi3 + "" + ordi4);
				decompte=decompte+1;
			
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
	
	
	
	
	public void compareordi(Mode mode) {
		int[] finder = new int[4];

		if (signeH1.equals("=")) {
			finder1 = ordiprop1;
		} else if (signeH1.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordiprop1 + 1;
			mode.getcompareinf()[0] = borneInfTemp;
			ordiprop1 = genererInt(mode.getcompareinf()[0], mode.getcomparesup()[0]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getcomparesup()[0] = ordiprop1 - 1;
			// borneInfTemp=ordiprop2-1;
			ordiprop1 = genererInt(mode.getcompareinf()[0], mode.getcomparesup()[0]);
		}
		
		
		
		if (signeH2.equals("=")) {
			finder2 = ordiprop2;
		} else if (signeH2.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordiprop2 + 1;
			mode.getcompareinf()[1]= borneInfTemp;
			ordiprop2 = genererInt(mode.getcompareinf()[1], mode.getcomparesup()[1]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getcomparesup()[1]= ordiprop2 - 1;
			ordiprop2 = genererInt(mode.getcompareinf()[1], mode.getcomparesup()[1]);
		}

		if (signeH3.equals("=")) {
			finder3 = ordiprop3;
		} else if (signeH3.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordiprop3 + 1;
			mode.getcompareinf()[2]= borneInfTemp;
			ordiprop3 = genererInt(mode.getcompareinf()[2], mode.getcomparesup()[2]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getcomparesup()[2] = ordiprop3 - 1;
			ordiprop3 = genererInt(mode.getcompareinf()[2], mode.getcomparesup()[2]);
		}
		if (signeH4.equals("=")) {
			finder4 = ordiprop4;
		} else if (signeH4.equals("+")) {
			// random superieur
			int borneInfTemp;
			borneInfTemp = ordiprop4 + 1;
			mode.getcompareinf()[3]= borneInfTemp;
			ordiprop4 = genererInt(mode.getcompareinf()[3], mode.getcomparesup()[3]);
		} else {
			// random inferieur
			int borneInfTemp;
			mode.getcomparesup()[3] = ordiprop4 - 1;
			ordiprop4 = genererInt(mode.getcompareinf()[3], mode.getcomparesup()[3]);
			
		}
	}
}