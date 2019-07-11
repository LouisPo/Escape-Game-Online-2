package fr.louispo.gameescape;

import fr.louispo.gameescape.beans.Configuration;

import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * La classe Jeu.
 */
public class Jeu {
	

	//-- Les attributs de la classe
	private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger();
	

	private static Configuration configuration;
	private static Menu menu;
	private static final String CHEMIN_FICHIER_PROPRIETES = "config.properties";

	/**
	 * Le constructeur par défaut (si on écrivait rien ici, ça fonctionnerait tout de même...
	 */
	public Jeu() {
		
	}

	/**
	 * Lancement de l'application.
	 * @param args Le 1er argument défini si l'application démarre en mode développement.
	 */
	public static void main(String[] args) {
		logger.info("Constructeur du jeu");
		//-- Récupération du paramètre modeDev au lancement de l'application le cas échéant
		boolean modeDeveloppeur = false;

		if (args.length != 0) {
			if ("modeDev".equals(args[0])) {
				System.out.println("Mode développeur activé au lancement de l'application !!!");
				modeDeveloppeur = true;
			}
		}

		Properties prop = null;
		try{
			//-- Chargement des propriétés depuis le fichier
			prop = Resource.load(CHEMIN_FICHIER_PROPRIETES);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//-- Conversion des propriétés dans le bon type de données.
		Integer nombreDigit = Integer.valueOf(prop.getProperty("nombreDigit"));
		Integer nombreEssai = Integer.valueOf(prop.getProperty("nombreEssai"));
		boolean modeDev = prop.getProperty("modeDev").equals("true") ? true : false; //-- Expression ternaire

		//-- Initialisation du bean dédiée aux propriétés à transmettre à toutes les classes qui en ont besoin.
		configuration = new Configuration(nombreDigit, nombreEssai, modeDev);

		//-- Le mode développeur au lancement de la console l'emporte sur le mode développeur du fichier properties...
		if (modeDeveloppeur) {
			configuration.setModeDev(true);
		}


		//-- Initialisation du menu et lancement.
		menu = new Menu(configuration);
		menu.menuGen();

		//-- Initialisation du scanner de console.
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();

		//-- Initialisation du jeu et lancement dans le mode choisi.
		Jeu game = new Jeu();
		game.choice(choix);
	}

	/**
	 *
	 * @param choix
	 */
	public void choice(int choix) {
		switch(choix) {
			case 1: {
				Mode modeChallenger = new Mode(menu, configuration);
				modeChallenger.challenger();
			}
			case 2: {
				Mode modeDefenseur = new Mode(menu, configuration);
				modeDefenseur.defenseur();
			}
			case 3: {
				Mode modeDuel = new Mode(menu, configuration);
				modeDuel.duel();
			}
			case 4: {
				logger.info("fin du jeu");
				System.out.println("vous quittez le jeu.");
				System.exit(0);
			}
			default: {
				System.out.println("Vous devez choisir une des options du menu !!!");
			}
		}
	}
}
