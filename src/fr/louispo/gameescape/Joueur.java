package fr.louispo.gameescape;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
	Random r;
	int ordi1;
	int ordi2;
	int ordi3;
	int ordi4;
	int [] ordi;
	int propoH;
	String propoH1;
	String propoH2;
	String propoH3;
	String propoH4;
	String resultat;
	String MDev;
	
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
		if(mode.equals("defenseur")){
		System.out.println("" + ordi1 + ordi2 + ordi3 + ordi4);
		
		}
		if((mode.equals("challenger"))&& (MDev.equals("true"))){
			System.out.println("" + ordi1 + ordi2 + ordi3 + ordi4);

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
}
