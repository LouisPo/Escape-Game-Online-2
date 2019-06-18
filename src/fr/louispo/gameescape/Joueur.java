package fr.louispo.gameescape;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
	Random r;
	static int ordi1;
	static int ordi2;
	static int ordi3;
	static int ordi4;
	static int [] ordi;
	int ordiprop1;
	int ordiprop2;
	int ordiprop3;
	int ordiprop4;
	int [] ordiprop;
	int propoH;
	String propoH1;
	String propoH2;
	String propoH3;
	String propoH4;
	String resultat;
	String MDev;
	static int devine;
	static String devine1;
	static String devine2;
	static String devine3;
	static String devine4;
	
	public void random(String mode) {
		try{
	         // chargement des propriétés
	 
			Properties prop = new Properties();
			 prop.load(ClassLoader.getSystemResourceAsStream("fr/louispo/gameescape/properties/config.properties"));
			 MDev= (prop.getProperty("modeDev"));
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
		if(mode.equals("defenseur")||mode.equals("duel")){
		System.out.println("Proposition de l'ordinateur");
		System.out.println("#1 " + ordi1 + ordi2 + ordi3 + ordi4);
		
		}
		if((mode.equals("challenger"))&& (MDev.equals("true"))){
			System.out.println("ModeDev " + ordi1 + ordi2 + ordi3 + ordi4);

		}
		if( (MDev.equals("true"))){
			System.out.println("ModeDev " + ordi1 + ordi2 + ordi3 + ordi4);

		}
		
	}
	
	
	public void randomordi(String mode) {
		
		r = new Random();
		ordiprop1 = r.nextInt(9);
		ordiprop2 = r.nextInt(9);
		ordiprop3 = r.nextInt(9);
		ordiprop4 = r.nextInt(9);
		ordiprop =new int [4];
		if (ordiprop1 == 0) {ordiprop1 = ordiprop1 + 1;}if (ordiprop2 == 0) {ordiprop2 = ordiprop2 + 1;}
		if (ordiprop3 == 0) {ordiprop3 = ordiprop3 + 1;}if (ordiprop4 == 0) {ordiprop4 = ordiprop4 + 1;}
		if(mode.equals("duel")){
		System.out.println("Proposition de l'ordinateur");
		System.out.println("#1 " + ordiprop1 + ordiprop2 + ordiprop3 + ordiprop4);
		
		}
		
	}
	
	public void inputuser() {
		Scanner sc = new Scanner(System.in);
		propoH = sc.nextInt();
		propoH1 = Integer.toString(propoH).substring(0, 1);
		propoH2 = Integer.toString(propoH).substring(1, 2);
		propoH3 = Integer.toString(propoH).substring(2, 3);
		propoH4 = Integer.toString(propoH).substring(3, 4);

	}
	
	public void devine(){
		Scanner sc = new Scanner(System.in);
		devine = sc.nextInt();
		devine1 = Integer.toString(devine).substring(0, 1);
		devine2 = Integer.toString(devine).substring(1, 2);
		devine3 = Integer.toString(devine).substring(2, 3);
		devine4 = Integer.toString(devine).substring(3, 4);
		//System.out.println(devine);
		System.out.println("interieur devine " + devine1 + devine2 + devine3 + devine4);

	}
	
	public void evaluerdevine(Mode mode) {
		System.out.println("essai joueurevaluerordi " + ordi1 + ordi2 + ordi3 + ordi4);
		System.out.println("joueur evaluerdevine " + devine1 + devine2 + devine3 + devine4);

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

		System.out.println("#" + mode.getCompteur() + " " + devine + " " + resultat);
	}
	public String getResultat() {
		return resultat;
	}
}
