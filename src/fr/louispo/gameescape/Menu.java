package fr.louispo.gameescape;


import fr.louispo.gameescape.beans.Configuration;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * La classe Menu.
 */
public class Menu {
	
	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger();
	
	/** The Constant CHEMIN_FICHIER_PROPRIETES. */
	private static final String CHEMIN_FICHIER_PROPRIETES = "src/fr/louispo/gameescape/properties/config.properties";

	/** The configuration. */
	private Configuration configuration = null;

	/**
	 * A compléter.
	 *
	 * @param configuration the configuration
	 */
	/**
	 * @param configuration
	 */
	public Menu(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * A compléter.
	 */
	/**
	 * 
	 */
	public void menuGen() {
		System.out.println("choisissez le mode de jeu");
		System.out.println("1 - Challenger");
		System.out.println("2 - Defenseur");
		System.out.println("3 - Duel");
		System.out.println("4 - Quitter");
	}

	/**
	 * A compléter.
	 *
	 * @param modeDeJeu the mode de jeu
	 */
	/**
	 * @param modeDeJeu
	 */
	public void menuFinal(Integer modeDeJeu) {

		System.out.println("1 - Rejouez");
		System.out.println("2 - Menu principal");
		System.out.println("3 - Quitter");

		Mode modeChallenger = new Mode(this, configuration);
		Mode modeDefenseur = new Mode(this, configuration);
		Mode modeDuel = new Mode(this, configuration);

		Scanner sc2 = new Scanner(System.in);
		int choix2 = sc2.nextInt();

		if (choix2 == 1 && modeDeJeu == 1) {
			modeChallenger.challenger();

		}if (choix2 == 1 && modeDeJeu == 2) {
			modeDefenseur.defenseur();

		}if (choix2 == 1 && modeDeJeu == 3) {
			modeDuel.duel();

		}
		if (choix2 == 2) {
			Jeu game = new Jeu();
			Menu menugen = new Menu(configuration);
			menugen.menuGen();
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			game.choice(choix);
		}
		if (choix2 == 3) {
			logger.info("fin du jeu");
			System.out.println("vous quittez le jeu.");
			System.exit(0);
		}
	}
}
