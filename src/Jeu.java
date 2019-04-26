import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Jeu {
	static int nbessai;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu game = new Jeu();
		nbessai = 3;
		game.menuGen();
	}
	public static void menuGen() {
		System.out.println("choisissez le mode de jeu");
		System.out.println("1 - Challenger");
		System.out.println("2 - Defenseur");
		System.out.println("3 - Duel");
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		choice(choix);
	}

	public static void choice(int choixx) {
		if (choixx == 1) {
			Joueur_Ordi Jeu = new Joueur_Ordi();
			Jeu.random();
			for (int i = 0; i < nbessai; i++) {
				Jeu.inputuser();
				Jeu.evaluer();
				if (i == nbessai - 1 || Jeu.resultat.equals("====")) {
					System.out.println("la combinaison est " + Jeu.ordi1 + Jeu.ordi2 + Jeu.ordi3 + Jeu.ordi4);
					System.out.println("1 - Rejouez");
					System.out.println("2 - Menu principal");
					System.out.println("3 - Quitter");
					Scanner sc2 = new Scanner(System.in);
					int choix2 = sc2.nextInt();
					choice(choix2);
				}
			}
		}
		if (choixx == 2) {
			Jeu.menuGen();
		}
		if (choixx == 3){
			System.exit (0);
		}

	}
}
