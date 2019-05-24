package fr.louispo.gameescape;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class Mode {
	static int compteur=0;
	static int essai;
	static int borneinf1;
	static int borneinf2;
	static int borneinf3;
	static int borneinf4;
    static int [] tabborneinf;
    static int [] tabbornesup;

	static int bornesup1;
	static int bornesup2;
	static int bornesup3;
	static int bornesup4;
	
	
public void challenger(){
	int nbessai = 0;
	
	 try{
         // chargement des propriétés
 
		 Properties prop = new Properties();
		 prop.load(ClassLoader.getSystemResourceAsStream("fr/louispo/gameescape/properties/config.properties"));
         nbessai= Integer.parseInt(prop.getProperty("nombreEssai"));
    //     MDev=prop.getProperty("modeDev");
         
      }
      catch(Exception e){
         e.printStackTrace();
      }
	System.out.println("Escape Game : Bienvenue");
	System.out.println("Jeu en cours : Mode Challenger en "+ nbessai+" coups");
	System.out.println("entrez 4 entier entre 1 et 9");
	System.out.println("Historique de vos coups :");
	Joueur_Ordi Jeu = new Joueur_Ordi();
	Jeu.random("challenger");
	compteur = 0;
	for (int i = 0; i < nbessai; i++) {
		compteur = compteur +1;
		Jeu.inputuser();
			Jeu.evaluer();
			if (i == nbessai - 1 || Jeu.resultat.equals("====")) {
				Menu menuchoix =new Menu();
				menuchoix.menuFinal();
			}
			
	}
}

public void defenseur(){
	int nbessai = 0;
	
	 try{
        // chargement des propriétés

		 Properties prop = new Properties();
		 prop.load(ClassLoader.getSystemResourceAsStream("fr/louispo/gameescape/properties/config.properties"));
        nbessai= Integer.parseInt(prop.getProperty("nombreEssai"));
        
     }
     catch(Exception e){
        e.printStackTrace();
     }
    tabborneinf= new int [4];
    tabbornesup= new int [4];
    for (int i = 0; i < 4; i++){
    	tabborneinf[i]=1;tabbornesup[i]=9;
    }
	Joueur_Humain Jeu = new Joueur_Humain();
	System.out.println("rentrez votre combinaison secrete");
		Jeu.inputuser();
		Jeu.random("defenseur");
		for (int i = 0; i < nbessai; i++) {

		Jeu.trouver();
	Jeu.evaluerordi();
	if (i == nbessai - 1 || Jeu.signeH.equals("====")) {
		Menu menuchoix =new Menu();
		menuchoix.menuFinal();
	}
		}
}

public void duel(){
	System.out.println("duel");

}
}
