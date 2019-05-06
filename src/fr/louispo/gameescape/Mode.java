package fr.louispo.gameescape;
import java.util.Scanner;

public class Mode {
	static int compteur=0;
	
public void challenger(){
	int nbessai = 3;
	System.out.println("Escape Game : Bienvenue");
	System.out.println("Jeu en cours : Mode Challenger en "+ nbessai+" coups");
	System.out.println("entrez 4 entier entre 1 et 9");
	System.out.println("Historique de vos coups :");
	Joueur_Ordi Jeu = new Joueur_Ordi();
	Jeu.random();
	compteur = 0;
	for (int i = 0; i < nbessai; i++) {
		compteur = compteur +1;
		//System.out.println("#"+compteur);
		Jeu.inputuser();
			Jeu.evaluer();
			if (i == nbessai - 1 || Jeu.resultat.equals("====")) {
				System.out.println("la combinaison est bonne" + Jeu.ordi1 + Jeu.ordi2 + Jeu.ordi3 + Jeu.ordi4);
				Menu menuchoix =new Menu();
				menuchoix.menuFinal();
			}
			
	}
}

public void defenseur(){
	Joueur_Humain Jeu = new Joueur_Humain();
	Jeu.rand();
	Jeu.codeuser();
	Jeu.trouver();
}

public void duel(){
	System.out.println("duel");

}
}
