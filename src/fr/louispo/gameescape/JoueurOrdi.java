package fr.louispo.gameescape;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


import org.apache.commons.lang3.StringUtils;
// TODO: Auto-generated Javadoc
/**
 * La classe JoueurOrdi.
 */
public class JoueurOrdi extends Joueur {

	/** The propo H. */
	public int propoH;
	
	/** The propo H 1. */
	public String propoH1;
	
	/** The propo H 2. */
	public String propoH2;
	
	/** The propo H 3. */
	public String propoH3;
	
	/** The propo H 4. */
	public String propoH4;
	
	/** The resultat. */
	public String resultat;
	
	/** The nb digit. */
	public String nbDigit;
	
	/* (non-Javadoc)
	 * @see fr.louispo.gameescape.Joueur#inputuser()
	 */
	public int inputuser() {
		
		try{
	         // chargement des propriétés
	 
			Properties prop = null;
			 prop= Resource.load("config.properties");
			 nbDigit= (prop.getProperty("nombreDigit"));
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
		String propoHessai;
		Scanner sc = new Scanner(System.in);
		propoHessai = sc.nextLine();
		if (((StringUtils.isNumeric(propoHessai)))){
		    propoH = Integer.parseInt(propoHessai);
	    }
		if ((!(StringUtils.isNumeric(propoHessai)))  || (Integer.toString(propoH).length()!=4)) {
		//probleme de saisie
			System.out.println("rentrez un nombre comprenant "+ 4+" chiffres ");
			return 1;

		}
		else{
			//saisie correcte
			//propoH = Integer.parseInt(propoHessai);
			//StringUtils.is(Integer.toString(propoH));
			propoH1 = Integer.toString(propoH).substring(0, 1);
			propoH2 = Integer.toString(propoH).substring(1, 2);
			propoH3 = Integer.toString(propoH).substring(2, 3);
			propoH4 = Integer.toString(propoH).substring(3, 4);			
			
			return 0;	
		}
	}
	

	/**
	 * Evaluer.
	 *
	 * @param mode the mode
	 */
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

	/* (non-Javadoc)
	 * @see fr.louispo.gameescape.Joueur#getResultat()
	 */
	public String getResultat() {
		return resultat;
	}
}
