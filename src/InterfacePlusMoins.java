
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class InterfacePlusMoins {

	public JFrame frame2;
	private JTextField usersaisie1;
	private JTextField usersaisie2;
	private JTextField usersaisie4;
	private JTextField usersaisie3;
	private JTextField usersaisie5;
	private JTextField usersaisie[];

	/**
	 * Launch the application.
	 */

	public InterfacePlusMoins(final DepartPlusMoins mother) {

		final JButton button = new JButton("Action");

		frame2.setTitle("Fille n°");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(170, 150);
		frame2.setLocationByPlatform(true);
	//	frame2.setLocationRelativeTo(mother.getFrame());

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mother.openFrame();
				frame2.dispose();
			}
		});
		frame2.getContentPane().add(button);

		frame2.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePlusMoins window = new InterfacePlusMoins();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacePlusMoins() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame2.
	 */
	public void initialize() {
		System.out.println("jack" + DepartPlusMoins.compteurmere);
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 489, 339);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame2.getContentPane().setLayout(gridBagLayout);

		JLabel lblJeuPlusMoins = new JLabel("Jeu Plus Moins");
		lblJeuPlusMoins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblJeuPlusMoins = new GridBagConstraints();
		gbc_lblJeuPlusMoins.insets = new Insets(0, 0, 5, 5);
		gbc_lblJeuPlusMoins.gridx = 3;
		gbc_lblJeuPlusMoins.gridy = 0;
		frame2.getContentPane().add(lblJeuPlusMoins, gbc_lblJeuPlusMoins);

		JLabel text1 = new JLabel("Essai 1");
		text1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_text1 = new GridBagConstraints();
		gbc_text1.insets = new Insets(0, 0, 5, 5);
		gbc_text1.gridx = 1;
		gbc_text1.gridy = 1;
		frame2.getContentPane().add(text1, gbc_text1);

		JLabel oldresult = new JLabel("");
		oldresult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldresult = new GridBagConstraints();
		gbc_oldresult.insets = new Insets(0, 0, 5, 5);
		gbc_oldresult.gridx = 9;
		gbc_oldresult.gridy = 1;
		frame2.getContentPane().add(oldresult, gbc_oldresult);

		

		JLabel text2 = new JLabel("Essai 2");
		GridBagConstraints gbc_text2 = new GridBagConstraints();
		gbc_text2.insets = new Insets(0, 0, 5, 5);
		gbc_text2.gridx = 1;
		gbc_text2.gridy = 2;
		frame2.getContentPane().add(text2, gbc_text2);

		JLabel oldresult2 = new JLabel("");
		oldresult2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldresult2 = new GridBagConstraints();
		gbc_oldresult2.insets = new Insets(0, 0, 5, 5);
		gbc_oldresult2.gridx = 7;
		gbc_oldresult2.gridy = 2;
		frame2.getContentPane().add(oldresult2, gbc_oldresult2);


		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 14;
		gbc_label_4.gridy = 2;
		frame2.getContentPane().add(label_4, gbc_label_4);

		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 15;
		gbc_label_1.gridy = 2;
		frame2.getContentPane().add(label_1, gbc_label_1);

		JLabel text3 = new JLabel("Essai 3");
		GridBagConstraints gbc_text3 = new GridBagConstraints();
		gbc_text3.insets = new Insets(0, 0, 5, 5);
		gbc_text3.gridx = 1;
		gbc_text3.gridy = 3;
		frame2.getContentPane().add(text3, gbc_text3);



		JLabel oldresult3 = new JLabel("");
		oldresult3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldresult3 = new GridBagConstraints();
		gbc_oldresult3.insets = new Insets(0, 0, 5, 5);
		gbc_oldresult3.gridx = 8;
		gbc_oldresult3.gridy = 3;
		frame2.getContentPane().add(oldresult3, gbc_oldresult3);

		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 11;
		gbc_label_2.gridy = 3;
		frame2.getContentPane().add(label_2, gbc_label_2);


		JLabel oldresult4 = new JLabel("");
		oldresult4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldresult4 = new GridBagConstraints();
		gbc_oldresult4.insets = new Insets(0, 0, 5, 5);
		gbc_oldresult4.gridx = 5;
		gbc_oldresult4.gridy = 5;
		frame2.getContentPane().add(oldresult4, gbc_oldresult4);


		JLabel oldresult5 = new JLabel("");
		oldresult5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldresult5 = new GridBagConstraints();
		gbc_oldresult5.insets = new Insets(0, 0, 5, 5);
		gbc_oldresult5.gridx = 4;
		gbc_oldresult5.gridy = 7;
		frame2.getContentPane().add(oldresult5, gbc_oldresult5);

		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 7;
		frame2.getContentPane().add(label_3, gbc_label_3);


		JLabel text4 = new JLabel("Essai 4");
		text4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_text4 = new GridBagConstraints();
		gbc_text4.insets = new Insets(0, 0, 5, 5);
		gbc_text4.gridx = 1;
		gbc_text4.gridy = 5;
		frame2.getContentPane().add(text4, gbc_text4);

		JLabel text5 = new JLabel("Essai 5");
		text5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_text5 = new GridBagConstraints();
		gbc_text5.insets = new Insets(0, 0, 5, 5);
		gbc_text5.gridx = 1;
		gbc_text5.gridy = 7;
		frame2.getContentPane().add(text5, gbc_text5);

		JLabel repfinal = new JLabel("");
		GridBagConstraints gbc_repfinal = new GridBagConstraints();
		gbc_repfinal.insets = new Insets(0, 0, 0, 5);
		gbc_repfinal.gridx = 3;
		gbc_repfinal.gridy = 9;
		frame2.getContentPane().add(repfinal, gbc_repfinal);
		
		
		usersaisie = new JTextField[Integer.parseInt(DepartPlusMoins.compteurmere)];
		System.out.println("taille ded usersaisie  "+usersaisie.length);
		GridBagConstraints gbc_usersaisie1 = new GridBagConstraints();
		gbc_usersaisie1.insets = new Insets(0, 0, 5, 5);
		gbc_usersaisie1.fill = GridBagConstraints.HORIZONTAL;
		
		for (int i = 0; i < usersaisie.length; i++) {
			System.out.println("i vaut  "+i);
			usersaisie[i] = new JTextField("text"+i);
			usersaisie[i].setPreferredSize(new Dimension(200, 24));
			gbc_usersaisie1.gridx = 3;
			gbc_usersaisie1.gridy = 1;
			gbc_usersaisie1.gridy =i +1;
			frame2.getContentPane().add(usersaisie[i], gbc_usersaisie1);
		}

		frame2.validate();
		frame2.setVisible(true);
		// variable comptant le nombre d'essai

		int compteur = 0;
		JLabel results[] = new JLabel[Integer.parseInt(DepartPlusMoins.compteurmere)];
////////////////////////////////////////////////////////////////////////////////////////////

		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.insets = new Insets(0, 0, 5, 0);
		
		for (int i = 0; i < results.length; i++) {
			results[i] = new JLabel("results" + i);
			results[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
			gbc_result.gridx = 15;
			gbc_result.gridy = 1;
			gbc_result.gridy =i +1;
			frame2.getContentPane().add(results[i], gbc_result);
		}
		/////////////////////////////////////////////////////////////////////////////////////
	
		// creation nombre aléatoire à 4 chiffres
		Random r = new Random();
		int ordi1 = r.nextInt(9);
		int ordi2 = r.nextInt(9);
		int ordi3 = r.nextInt(9);
		int ordi4 = r.nextInt(9);
		System.out.println("nombre aleatoire " + ordi1 + "" + ordi2 + "" + ordi3 + "" + ordi4);

		System.out.println("ttt" + frame2.getContentPane());

		JButton btnJouez = new JButton("Jouez");
		btnJouez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJouez.addActionListener(new ActionListener() {
			int compteur = 0;

			public void actionPerformed(ActionEvent arg0) {

				compteur = compteur + 1;

				String recup = "";

				if (compteur == 1) {
					recup = usersaisie[0].getText();
				}
				if (compteur == 2) {
					recup = usersaisie[1].getText();
				}
				if (compteur == 3) {
					recup = usersaisie[2].getText();
				}
				if (compteur == 4) {
					recup = usersaisie[3].getText();
				}
				if (compteur == 5) {
					recup = usersaisie[4].getText();
				}
	
				System.out.println("recup vaut "+recup+"fin");
				String essai1;
				String essai2;
				String essai3;
				String essai4;

				essai1 = recup.substring(0, 1);
				essai2 = recup.substring(1, 2);
				essai3 = recup.substring(2, 3);
				essai4 = recup.substring(3, 4);

				String resultat = "";

				if (compteur == 10) {
					btnJouez.setVisible(false);

				} else {

					if (ordi1 == Integer.parseInt(essai1)) {
						resultat = "=";
					} else if (ordi1 > Integer.parseInt(essai1)) {
						resultat = "+";
					} else {
						resultat = "-";
					}
					if (ordi2 == Integer.parseInt(essai2)) {
						resultat = resultat + "=";
					} else if (ordi2 > Integer.parseInt(essai2)) {
						resultat = resultat + "+";
					} else {
						resultat = resultat + "-";
					}
					if (ordi3 == Integer.parseInt(essai3)) {
						resultat = resultat + "=";
					} else if (ordi3 > Integer.parseInt(essai3)) {
						resultat = resultat + "+";
					} else {
						resultat = resultat + "-";
					}
					if (ordi4 == Integer.parseInt(essai4)) {
						resultat = resultat + "=";
					} else if (ordi4 > Integer.parseInt(essai4)) {
						resultat = resultat + "+";
					} else {
						resultat = resultat + "-";
					}

					if (compteur == 1) {
						//usersaisie1.setEditable(false);
						results[0].setText(resultat);
						oldresult.setText(essai1 + essai2 + essai3 + essai4);
					}
					if (compteur == 2) {
						//usersaisie1.setEditable(false);
						//usersaisie2.setEditable(false);
						results[1].setText(resultat);
						oldresult2.setText(recup.substring(0, 1) + recup.substring(1, 2) + recup.substring(2, 3)
								+ recup.substring(3, 4));
					}
					if (compteur == 3) {
						//usersaisie1.setEditable(false);
						//usersaisie2.setEditable(false);
						//usersaisie3.setEditable(false);
						results[2].setText(resultat);
						oldresult3.setText(recup.substring(0, 1) + recup.substring(1, 2) + recup.substring(2, 3)
								+ recup.substring(3, 4));
					}
					if (compteur == 4) {
						//usersaisie1.setEditable(false);
						//usersaisie2.setEditable(false);
						//usersaisie3.setEditable(false);
						//usersaisie4.setEditable(false);
						results[3].setText(resultat);
						oldresult4.setText(recup.substring(0, 1) + recup.substring(1, 2) + recup.substring(2, 3)
								+ recup.substring(3, 4));
					}
					if (compteur == 5) {
						//usersaisie1.setEditable(false);
						//usersaisie2.setEditable(false);
						//usersaisie3.setEditable(false);
						//usersaisie4.setEditable(false);
						//usersaisie5.setEditable(false);
						results[4].setText(resultat);
						oldresult5.setText(recup.substring(0, 1) + recup.substring(1, 2) + recup.substring(2, 3)
								+ recup.substring(3, 4));
					}
					System.out.println("resultat" + resultat);
					if (resultat.equals("====")) {
						repfinal.setText("Vous avez gagné");

					}
					if (!resultat.equals("====") && (compteur == Integer.parseInt(DepartPlusMoins.compteurmere))) {
						repfinal.setText("Vous avez perdu");

					}
					//usersaisie1.setText("");
					System.out.println(compteur);
				}
			}

		});

		GridBagConstraints gbc_btnJouez = new GridBagConstraints();
		gbc_btnJouez.gridx = 15;
		gbc_btnJouez.gridy = 9;
		frame2.getContentPane().add(btnJouez, gbc_btnJouez);
	}

}
