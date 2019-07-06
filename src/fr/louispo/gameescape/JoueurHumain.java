package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
public class JoueurHumain extends Joueur {

	/** The signe H. */
	public String signeH;
	
	/** The signe H 1. */
	public String signeH1;
	
	/** The signe H 2. */
	public String signeH2;
	
	/** The signe H 3. */
	public String signeH3;
	
	/** The signe H 4. */
	public String signeH4;
	
	/** The signetab H. */
	private String[] signetabH;
	
	/** The find. */
	private int[] find;
	
	/** The find 1. */
	private int find1;
	
	/** The find 2. */
	private int find2;
	
	/** The find 3. */
	private int find3;
	
	/** The find 4. */
	private int find4;
	
	/** The finder. */
	private int[] finder;
	
	/** The finder 1. */
	private int finder1;
	
	/** The finder 2. */
	private int finder2;
	
	/** The finder 3. */
	private int finder3;
	
	/** The finder 4. */
	private int finder4;
	
	/** The compteur. */
	private int compteur;
	
	/** The nbessai. */
	private int nbessai = 6;
	
	/** The size game. */
	private int sizeGame = 4;
	
	/** The decompte. */
	int decompte=2;

	/**
	 * Trouver.
	 *
	 * @return the int
	 */
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

	/**
	 * Verifsigne.
	 *
	 * @param s1 the s 1
	 * @param s2 the s 2
	 * @param s3 the s 3
	 * @param s4 the s 4
	 * @return the int
	 */
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
	
	
	/**
	 * Fin partie.
	 */
	public void fin_partie() {

	}

	/**
	 * Generer int.
	 *
	 * @param borneInf the borne inf
	 * @param borneSup the borne sup
	 * @return the int
	 */
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

	/**
	 * Evaluerordi.
	 *
	 * @param mode the mode
	 */
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
	 * Gets the signe H.
	 *
	 * @return the signe H
	 */
	public String getSigneH() {
		return signeH;
	}
	
	
	
	
	/**
	 * Compareordi.
	 *
	 * @param mode the mode
	 */
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