package fr.louispo.gameescape;

import java.util.Random;
import java.util.Scanner;

public class Joueur_Humain extends Joueur {
	Random rand;
	int propoOrdi1;
	int propoOrdi2;
	int propoOrdi3;
	int propoOrdi4;
	int codeH;
	String codeH1;
	String codeH2;
	String codeH3;
	String codeH4;

	
	public void rand() {
		rand = new Random();
		propoOrdi1 = rand.nextInt(9);
		propoOrdi2 = rand.nextInt(9);
		propoOrdi3 = rand.nextInt(9);
		propoOrdi4 = rand.nextInt(9);
		
	}
	public void codeuser() {
		System.out.println("rentrez votre combinaison secrete");
		Scanner sc = new Scanner(System.in);
		codeH = sc.nextInt();
		codeH1 = Integer.toString(codeH).substring(0, 1);
		codeH2 = Integer.toString(codeH).substring(1, 2);
		codeH3 = Integer.toString(codeH).substring(2, 3);
		codeH4 = Integer.toString(codeH).substring(3, 4);

	}
	public void trouver(){
		System.out.println("" + propoOrdi1 + propoOrdi2 + propoOrdi3 + propoOrdi4);
		
	}

	public void fin_partie() {

	}
}