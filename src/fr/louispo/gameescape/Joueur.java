package fr.louispo.gameescape;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
// TODO: Auto-generated Javadoc
/**
 *
 */
public class Joueur {
	
	/** The r. */
	Random r;
	
	/** The ordi 1. */
	static int ordi1;
	
	/** The ordi 2. */
	static int ordi2;
	
	/** The ordi 3. */
	static int ordi3;
	
	/** The ordi 4. */
	static int ordi4;
	
	/** The ordi. */
	static int [] ordi;
	
	/** The ordiprop 1. */
	static int ordiprop1;
	
	/** The ordiprop 2. */
	static int ordiprop2;
	
	/** The ordiprop 3. */
	static int ordiprop3;
	
	/** The ordiprop 4. */
	static int ordiprop4;
	
	/** The ordiprop. */
	static int [] ordiprop;
	
	/** The propo H. */
	int propoH;
	
	/** The propo H 1. */
	String propoH1;
	
	/** The propo H 2. */
	String propoH2;
	
	/** The propo H 3. */
	String propoH3;
	
	/** The propo H 4. */
	String propoH4;
	
	/** The resultat. */
	String resultat;
	
	/** The M dev. */
	String MDev;
	
	/** The devine. */
	static int devine;
	
	/** The devine 1. */
	static String devine1;
	
	/** The devine 2. */
	static String devine2;
	
	/** The devine 3. */
	static String devine3;
	
	/** The devine 4. */
	static String devine4;
	
	/** The nb digit. */
	public String nbDigit;
	
	/**
	 * Random.
	 *
	 * @param mode the mode
	 */
	public void random(String mode) {
		try{
	         // chargement des propriétés
	 
			Properties prop = null;
			 prop= Resource.load("config.properties");
			 MDev= (prop.getProperty("modeDev"));
			 nbDigit= (prop.getProperty("nombreDigit"));
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
		r = new Random();
		ordi1 = r.nextInt(9);
		ordi2 = r.nextInt(9);
		ordi3 = r.nextInt(9);
		ordi4 = r.nextInt(9);
		ordi =new int [4];
		if (ordi1 == 0) {ordi1 = ordi1 + 1;}if (ordi2 == 0) {ordi2 = ordi2 + 1;}
		if (ordi3 == 0) {ordi3 = ordi3 + 1;}if (ordi4 == 0) {ordi4 = ordi4 + 1;}
		if(mode.equals("defenseur")){
		System.out.println("Proposition de l'ordinateur");
		System.out.println("#1 " + ordi1 + ordi2 + ordi3 + ordi4);
		
		}
		
		if( (MDev.equals("true"))){
			System.out.println("ModeDev " + ordi1 + ordi2 + ordi3 + ordi4);

		}
		
	}
	
	
	/**
	 * Randomordi.
	 *
	 * @param mode the mode
	 */
	public void randomordi(Mode mode) {
		r = new Random();
		ordiprop1 = r.nextInt(9);
		ordiprop2 = r.nextInt(9);
		ordiprop3 = r.nextInt(9);
		ordiprop4 = r.nextInt(9);
		ordiprop =new int [4];
		if (ordiprop1 == 0) {ordiprop1 = ordiprop1 + 1;}if (ordiprop2 == 0) {ordiprop2 = ordiprop2 + 1;}
		if (ordiprop3 == 0) {ordiprop3 = ordiprop3 + 1;}if (ordiprop4 == 0) {ordiprop4 = ordiprop4 + 1;}

		
		
	}
	
	/**
	 * Inputuser.
	 *
	 * @return the int
	 */
	public int inputuser() {
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
	 * Devine.
	 *
	 * @return the int
	 */
	public int devine() {
		String devineH;
		Scanner sc = new Scanner(System.in);
		devineH = sc.nextLine();
		if (((StringUtils.isNumeric(devineH)))){
			devine = Integer.parseInt(devineH);
	    }
		
		if ((!(StringUtils.isNumeric(devineH)))  || (Integer.toString(devine).length()>4)  ||  (Integer.toString(devine).length()<4)) {
		//probleme de saisie
			System.out.println("rentrez un nombre comprenant "+ 4+" chiffres ");
			return 1;

		}
		else{
			//saisie correcte
			//propoH = Integer.parseInt(propoHessai);
			//StringUtils.is(Integer.toString(propoH));
			devine1 = Integer.toString(devine).substring(0, 1);
			devine2 = Integer.toString(devine).substring(1, 2);
			devine3 = Integer.toString(devine).substring(2, 3);
			devine4 = Integer.toString(devine).substring(3, 4);			
			
			return 0;	
		}
	}	
	
	/**
	 * Evaluerdevine.
	 *
	 * @param mode the mode
	 */
	public void evaluerdevine(Mode mode) {

		if (ordi1 == Integer.parseInt(devine1)) {
			resultat = "=";
		} else if (ordi1 > Integer.parseInt(devine1)) {
			resultat = "+";
		} else {
			resultat = "-";
		}
		if (ordi2 == Integer.parseInt(devine2)) {
			resultat = resultat + "=";
		} else if (ordi2 > Integer.parseInt(devine2)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi3 == Integer.parseInt(devine3)) {
			resultat = resultat + "=";
		} else if (ordi3 > Integer.parseInt(devine3)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi4 == Integer.parseInt(devine4)) {
			resultat = resultat + "=";
		} else if (ordi4 > Integer.parseInt(devine4)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}

		System.out.println("#" + (mode.getCompteur()+1) + " " + devine + " " + resultat);
	}
	
	/**
	 * Gets the resultat.
	 *
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}
}
