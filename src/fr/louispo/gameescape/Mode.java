package fr.louispo.gameescape;

import fr.louispo.gameescape.beans.Configuration;

/**
 *
 */
public class Mode {

	// -- Les attributs de la classe
	private Configuration configuration = null;
	private Menu menu = null;
	private int compteur = 0;
	private int nbEssai;
	private boolean modeDev;

	private int[] tabborneinf;
	private int[] tabbornesup;

	/**
	 *
	 * @param configuration
	 */
	public Mode(Menu menu, Configuration configuration) {
		this.configuration = configuration;
		this.menu = menu;
		nbEssai = configuration.getNombreEssai();
		modeDev = configuration.getModeDev();
	}

	/**
	 * Gestion du mode Challenger.
	 */
	public void challenger() {

		System.out.println("Escape Game : Bienvenue");
		System.out.println("Jeu en cours : Mode Challenger en " + nbEssai + " coups");
		System.out.println("entrez 4 entier entre 1 et 9");
		System.out.println("Historique de vos coups :");
		JoueurOrdi joueurOrdi = new JoueurOrdi();
		joueurOrdi.random("challenger");
		compteur = 0;
		for (int i = 0; i < nbEssai; i++) {
			System.out.println("Joueur rentrez votre proposition: ");
			compteur = compteur + 1;
			joueurOrdi.inputuser();
			joueurOrdi.evaluer(this);
			if (i == nbEssai - 1 && !(joueurOrdi.getResultat().equals("===="))) {
				System.out.println("Vous avez perdu");
				menu.menuFinal(1);
			} else if (joueurOrdi.getResultat().equals("====")) {
				System.out.println("Vous avez gagné");

				menu.menuFinal(1);

			}
		}
	}

	/**
	 * Gestion du mode Défenseur.
	 */
	public void defenseur() {
		System.out.println("Escape Game : Bienvenue");
		System.out.println("Jeu en cours : Mode Defenseur en " + nbEssai + " coups");
		System.out.println("rentrez les indications pour orientez l'ordinateur, pour cela utilisez +,- ou le =");
		System.out.println("Historique des coups :");
		tabborneinf = new int[4];
		tabbornesup = new int[4];
		for (int i = 0; i < 4; i++) {
			tabborneinf[i] = 1;
			tabbornesup[i] = 9;
		}
		JoueurHumain joueurHumain = new JoueurHumain();
		System.out.println("rentrez votre combinaison secrete");
		joueurHumain.inputuser();
		joueurHumain.random("defenseur");
		for (int i = 0; i < nbEssai; i++) {

			joueurHumain.trouver();
			joueurHumain.evaluerordi(this);
			if (i == nbEssai - 1 && !(joueurHumain.getSigneH().equals("===="))) {
				System.out.println("L'ordinateur à perdu");
				menu.menuFinal(2);
			} else if (joueurHumain.getSigneH().equals("====")) {
				System.out.println("l'ordinateur à gagné");

				menu.menuFinal(2);

			}
		}
	}

	/**
	 * Gestion du mode Duel.
	 */
	public void duel() {
		int i = 0;
		System.out.println("Escape Game : Bienvenue");
		System.out.println("Jeu en cours : Mode Duel en  coups");
		System.out.println("rentrez votre combinaison secrete");
		
		//Combinaison secrete ordi
		JoueurOrdi joueurOrdi = new JoueurOrdi();
		//Combinaison secrete du joueur
		JoueurHumain Joueur = new JoueurHumain();
		Joueur.inputuser();
		
		joueurOrdi.random("duel");
		for (i = 0; i < 4; i++) {
			System.out.println("#" + (i + 1) + " Joueur, rentrez votre proposition");
			Joueur.devine();
			Joueur.randomordi("");
			Joueur.evaluerdevine(this);
			//Joueur.trouver();
			if (i == 4 - 1 || Joueur.getResultat().equals("====")) {
				menu.menuFinal(3);
			}
		}
	}

	// -- GETTER && SETTER

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public int[] getTabborneinf() {
		return tabborneinf;
	}

	public void setTabborneinf(int[] tabborneinf) {
		this.tabborneinf = tabborneinf;
	}

	public int[] getTabbornesup() {
		return tabbornesup;
	}

	public void setTabbornesup(int[] tabbornesup) {
		this.tabbornesup = tabbornesup;
	}
}
