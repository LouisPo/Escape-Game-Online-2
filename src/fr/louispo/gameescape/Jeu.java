package fr.louispo.gameescape;
import java.awt.event.KeyEvent;
import java.net.SocketTimeoutException;
import java.util.Properties;
import java.util.Scanner;

/**
 * La classe Jeu.
 */
public class Jeu {
	/**
	 * Le nombre d'essai de l'utilsateur.
	 */
	private int nbessai;
public static int ModedeJeu;
static Properties prop;
	/**
	 * Le constructeur.
	 */
	public Jeu() {
		

	}
		
	
	

	public void choice(int choix) {
		ModedeJeu=choix;
		if (choix == 1) {
			Mode Challenger = new Mode();
			Challenger.challenger();


		}
		if (choix == 2) {
			Mode Defenseur = new Mode();
			Defenseur.defenseur();
		}
		if (choix == 3){
		}
		if (choix ==4){
			System.out.println("vous quittez le jeu.");
			System.exit (0);
			


		}

	}
	
	/**
	 * Lancement de l'application.
	 * @param args Le 1er argument défini si l'application démarre en mode développement.
	 */
	public static void main(String[] args) {
		
		int i;

	    for (i=0; i < args.length; i++)
	    {
	    	System.out.println("parametre"+i+ args[i]);
	    }
	   
		
		
		// TODO Auto-generated method stub
		Jeu game = new Jeu();
		 try{
		        // chargement des propriétés

				 Properties prop = new Properties();
				 prop.load(ClassLoader.getSystemResourceAsStream("fr/louispo/gameescape/properties/config.properties"));
				 prop.setProperty("modeDev", args[0]);
		         String recup = prop.getProperty("modeDev");
		         System.out.println("recup"+recup);
		        
		     }
		     catch(Exception e){
		        e.printStackTrace();
		     }
		Menu menugen = new Menu();
		menugen.menuGen();
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		game.choice(choix);
	}
}
