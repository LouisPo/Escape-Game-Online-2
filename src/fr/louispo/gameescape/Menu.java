package fr.louispo.gameescape;

import java.util.Scanner;

public class Menu {
	public void Menu() {
		System.out.println("constructeur");
	}

	public void menuGen() {
		System.out.println("choisissez le mode de jeu");
		System.out.println("1 - Challenger");
		System.out.println("2 - Defenseur");
		System.out.println("3 - Duel");
		System.out.println("4 - Quitter");

	}

	public void menuFinal() {
		System.out.println("1 - Rejouez");
		System.out.println("2 - Menu principal");
		System.out.println("3 - Quitter");
		Jeu jeuchoix = new Jeu();
		Mode challeng = new Mode();
		Mode defens=new Mode();
		Scanner sc2 = new Scanner(System.in);
		int choix2 = sc2.nextInt();
		if (choix2 == 1 && jeuchoix.ModedeJeu == 1) {
			challeng.challenger();

		}if (choix2 == 1 && jeuchoix.ModedeJeu == 2) {
			defens.defenseur();

		}if (choix2 == 1 && jeuchoix.ModedeJeu == 3) {
			System.out.println("duel");

		}
		if (choix2 == 2) {
			Jeu game = new Jeu();
			Menu menugen = new Menu();
			menugen.menuGen();
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			game.choice(choix);
		}
		if (choix2 == 3) {
			System.out.println("vous quittez le jeu.");
			System.exit(0);
			

		}
	}
}
