import java.util.Random;
import java.util.Scanner;

public class Joueur_Ordi extends Joueur{
	Random r;
	int ordi1 ;
	int ordi2 ;
	int ordi3 ;
	int ordi4 ;
	int propoH;
	String propoH1;
	String propoH2;
	String propoH3;
	String propoH4; 
	String resultat;
	

	public void random() {
		r = new Random();
		ordi1 = r.nextInt(9);
		ordi2 = r.nextInt(9);
		ordi3 = r.nextInt(9);
		ordi4 = r.nextInt(9);
		System.out.println("" + ordi1 + ordi2 + ordi3 + ordi4);
	}

	public void inputuser() {
		Scanner sc = new Scanner(System.in);
		propoH = sc.nextInt();
		/*DecimalFormat df = new DecimalFormat("00000");
		System.out.println(df.format(mon_nombre));*/
		propoH1 = Integer.toString(propoH).substring(0, 1);
		propoH2 = Integer.toString(propoH).substring(1, 2);
		propoH3 = Integer.toString(propoH).substring(2, 3);
		propoH4 = Integer.toString(propoH).substring(3, 4);


	}
	
	public void evaluer(){
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

		System.out.println("resultat " + resultat);
		if (resultat.equals("====")) {

		}
		if (!resultat.equals("====")) {
			System.out.println("Mauvaise combinaison");
		}
	}


}
