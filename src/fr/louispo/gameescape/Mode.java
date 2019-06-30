package fr.louispo.gameescape;

import fr.louispo.gameescape.beans.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class Mode {


	// -- Les attributs de la classe
	private static final Logger logger = LogManager.getLogger();
	private static final String CHEMIN_FICHIER_PROPRIETES = "fr/louispo/gameescape/properties/config.properties";
	private Configuration configuration = null;
	private Menu menu = null;
	private int compteur = 0;
	private int nbEssai;
	private boolean modeDev;

	public int[] tabborneinf;
	public int[] tabbornesup;
	public int[] compareinf;
	public int[] comparesup;

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
		logger.info("Selection du mode challenger");
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
			while(joueurOrdi.inputuser() == 1){
				joueurOrdi.inputuser();
			}
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
		logger.info("Selection du mode Defenseur");
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
		while(joueurHumain.inputuser() == 1){
			joueurHumain.inputuser();
		}
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
		logger.info("Selection du mode Duel");
		int i = 0;
		System.out.println("Escape Game : Bienvenue");
		compareinf = new int[4];
		comparesup = new int[4];
		for (int kkk = 0; kkk < 4; kkk++) {
			compareinf[kkk] = 1;
			comparesup[kkk] = 9;
		}
		System.out.println("Jeu en cours : Mode Duel en "+ nbEssai +" coups");
		System.out.println("rentrez votre combinaison secrete");

		JoueurHumain joueurHumain = new JoueurHumain();
		
		//Combinaison secrete ordi
		JoueurOrdi joueurOrdi = new JoueurOrdi();
		//Combinaison secrete du joueur
		JoueurHumain joueur = new JoueurHumain();
		while(joueurHumain.inputuser() == 1){
			joueurHumain.inputuser();
		}
		
		joueurOrdi.random("duel");
		joueur.randomordi(this);
		for (i = 0; i < 4; i++) {
			System.out.println("[challenger] Joueur, rentrez votre proposition");
			//proposition user
			while(joueur.devine()==1){
				joueur.devine();
			}
			joueur.evaluerdevine(this);
			if (joueur.getResultat().equals("====")) {
				System.out.println("Vous avez gagné");
				menu.menuFinal(3);
			}
			
			compteur=compteur +1;
			System.out.println("[défenseur] Proposition de l'ordinateur");
			System.out.println("#" + (getCompteur()) + " " + joueur.ordiprop1 + joueur.ordiprop2 + joueur.ordiprop3 + joueur.ordiprop4);
			joueur.trouver(); 
			
	
			
			joueur.compareordi(this);
			if(joueur.getSigneH().equals("====")){
				System.out.println("l'ordinateur à gagné");
			
				menu.menuFinal(3);
			}else if (i == 4 - 1) {
				System.out.println("aucun gagnant");
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
	
	
	public int[] getcompareinf() {
		return compareinf;
	}

	public void setcompareinf(int[] compareinf) {
		this.compareinf = compareinf;
	}

	public int[] getcomparesup() {
		return comparesup;
	}

	public void setcomparesup(int[] comparesup) {
		this.comparesup = comparesup;
	}
}
