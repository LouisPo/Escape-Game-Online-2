import java.util.Random;
import java.util.Scanner;

public class Mode {

	public void challenger() {
		Random r = new Random();
		int ordi1 = r.nextInt(9);
		int ordi2 = r.nextInt(9);
		int ordi3 = r.nextInt(9);
		int ordi4 = r.nextInt(9);
		System.out.println(ordi1 + ordi2 + ordi3 + ordi4);

		Scanner sc = new Scanner(System.in);
		int propoH = sc.nextInt();
		String propoH1;
		String propoH2;
		String propoH3;
		String propoH4;
		String resultat = "";

		propoH1 = propoH(0, 1);
		propoH2 = propoH(1, 2);
		propoH3 = propoH(2, 3);
		propoH4 = propoH(3, 4);

		if (ordi1 == Integer.parseInt(propoH1)) {
			resultat = "=";
		} else if (ordi1 > Integer.parseInt(propoH1)) {
			resultat = "+";
		} else {
			resultat = "-";
		}
		if (ordi2 == Integer.parseInt(propoH2)) {
			resultat = resultat + "=";
		} else if (ordi2 > Integer.parseInt(propoH2)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi3 == Integer.parseInt(propoH3)) {
			resultat = resultat + "=";
		} else if (ordi3 > Integer.parseInt(propoH3)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}
		if (ordi4 == Integer.parseInt(propoH4)) {
			resultat = resultat + "=";
		} else if (ordi4 > Integer.parseInt(propoH4)) {
			resultat = resultat + "+";
		} else {
			resultat = resultat + "-";
		}

		System.out.println("resultat" + resultat);
		if (resultat.equals("====")) {
			System.out.println("Vous avez gagné");

		}
		if (!resultat.equals("====")) {
			System.out.println("Vous avez perdu");
		}

	}

	private String propoH(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public void defenseur() {

	}

	public void duel() {

	}

}
