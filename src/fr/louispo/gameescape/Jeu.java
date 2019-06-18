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
	private static final Logger logger = LogManager.getLogger();
	private static Configuration configuration;
	private static Menu menu;
	private static final String CHEMIN_FICHIER_PROPRIETES = "src/fr/louispo/gameescape/properties/config.properties";

	/**
	 * Le constructeur par d�faut (si on �crivait rien ici, ça fonctionnerait tout de même...
	 */
	public Jeu() {
		
	}

	/**
	 * Lancement de l'application.
	 * @param args Le 1er argument d�fini si l'application d�marre en mode d�veloppement.
	 */
	public static void main(String[] args) {
		logger.info("Constructeur du jeu toto");
		//-- R�cup�ration du paramètre modeDev au lancement de l'application le cas �ch�ant
		boolean modeDeveloppeur = false;

		if (args.length != 0) {
			if ("modeDev".equals(args[0])) {
				System.out.println("Mode d�veloppeur activ� au lancement de l'application !!!");
				modeDeveloppeur = true;
			}
		}

		Properties prop = null;
		try{
			//-- Chargement des propri�t�s depuis le fichier
			prop = Resource.load(CHEMIN_FICHIER_PROPRIETES);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//-- Conversion des propri�t�s dans le bon type de donn�es.
		Integer nombreDigit = Integer.valueOf(prop.getProperty("nombreDigit"));
		Integer nombreEssai = Integer.valueOf(prop.getProperty("nombreEssai"));
		boolean modeDev = prop.getProperty("modeDev").equals("true") ? true : false; //-- Expression ternaire

		//-- Initialisation du bean d�di�e aux propri�t�s à transmettre à toutes les classes qui en ont besoin.
		configuration = new Configuration(nombreDigit, nombreEssai, modeDev);

		//-- Le mode d�veloppeur au lancement de la console l'emporte sur le mode d�veloppeur du fichier properties...
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
				System.out.println("vous quittez le jeu.");
				System.exit(0);
			}
			default: {
				System.out.println("Vous devez choisir une des options du menu !!!");
			}
		}
	}
}
