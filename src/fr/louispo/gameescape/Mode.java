package fr.louispo.gameescape;

import fr.louispo.gameescape.beans.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * La classe Mode.
 */
public class Mode {
     

	// -- Les attributs de la classe
	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger();
	
	/** The Constant CHEMIN_FICHIER_PROPRIETES. */
	private static final String CHEMIN_FICHIER_PROPRIETES = "config.properties";
	
	/** The configuration. */
	private Configuration configuration = null;
	
	/** The menu. */
	private Menu menu = null;
	
	/** The compteur. */
	private int compteur = 0;
	
	/** The nb essai. */
	private int nbEssai;
	
	/** The mode dev. */
	private boolean modeDev;

	/** The tabborneinf. */
	public int[] tabborneinf;
	
	/** The tabbornesup. */
	public int[] tabbornesup;
	
	/** The compareinf. */
	public int[] compareinf;
	
	/** The comparesup. */
	public int[] comparesup;

	/**
	 * Instantiates a new mode.
	 *
	 * @param menu the menu
	 * @param configuration the configuration
	 */
	/**
	 * @param menu
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
	/**
	 * 
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
	/**
	 * 
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
		System.out.println("rentrez votre combinaison secrete de 4 chiffres de 0 à 9");
		while(joueurHumain.inputuser() == 1){
		}
		joueurHumain.random("defenseur");
		for (int i = 0; i < nbEssai; i++) {
			System.out.println("rentrez les indications avec +, - ou =");
			while(joueurHumain.trouver() ==1){
			}
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
	/**
	 * 
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
		System.out.println("rentrez votre combinaison secrete de 4 chiffres de 0 à 9");

		JoueurHumain joueurHumain = new JoueurHumain();
		
		//Combinaison secrete ordi
		JoueurOrdi joueurOrdi = new JoueurOrdi();
		//Combinaison secrete du joueur
		JoueurHumain joueur = new JoueurHumain();
		while(joueurHumain.inputuser() == 1){
		}
		
		joueurOrdi.random("duel");
		joueur.randomordi(this);
		for (i = 0; i < 4; i++) {
			System.out.println("[challenger] Joueur, rentrez votre proposition  de 4 chiffres de 0 à 9");
			//proposition user
			while(joueur.devine()==1){
			}
			joueur.evaluerdevine(this);
			if (joueur.getResultat().equals("====")) {
				System.out.println("Vous avez gagné");
				menu.menuFinal(3);
			}
			
			compteur=compteur +1;
			System.out.println("[défenseur] Proposition de l'ordinateur");
			System.out.println("#" + (getCompteur()) + " " + joueur.ordiprop1 + joueur.ordiprop2 + joueur.ordiprop3 + joueur.ordiprop4);
			while(joueur.trouver()==1){
				
			}
			
	
			
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

	/**
	 * Gets the compteur.
	 *
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}

	/**
	 * Sets the compteur.
	 *
	 * @param compteur the new compteur
	 */
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	/**
	 * Gets the tabborneinf.
	 *
	 * @return the tabborneinf
	 */
	public int[] getTabborneinf() {
		return tabborneinf;
	}

	/**
	 * Sets the tabborneinf.
	 *
	 * @param tabborneinf the new tabborneinf
	 */
	public void setTabborneinf(int[] tabborneinf) {
		this.tabborneinf = tabborneinf;
	}

	/**
	 * Gets the tabbornesup.
	 *
	 * @return the tabbornesup
	 */
	public int[] getTabbornesup() {
		return tabbornesup;
	}

	/**
	 * Sets the tabbornesup.
	 *
	 * @param tabbornesup the new tabbornesup
	 */
	public void setTabbornesup(int[] tabbornesup) {
		this.tabbornesup = tabbornesup;
	}
	
	
	/**
	 * Gets the compareinf.
	 *
	 * @return the compareinf
	 */
	public int[] getcompareinf() {
		return compareinf;
	}

	/**
	 * Sets the compareinf.
	 *
	 * @param compareinf the new compareinf
	 */
	public void setcompareinf(int[] compareinf) {
		this.compareinf = compareinf;
	}

	/**
	 * Gets the comparesup.
	 *
	 * @return the comparesup
	 */
	public int[] getcomparesup() {
		return comparesup;
	}

	/**
	 * Sets the comparesup.
	 *
	 * @param comparesup the new comparesup
	 */
	public void setcomparesup(int[] comparesup) {
		this.comparesup = comparesup;
	}
}
