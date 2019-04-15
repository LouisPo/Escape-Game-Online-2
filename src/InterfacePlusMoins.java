
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;

import org.omg.CORBA.portable.ValueOutputStream;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class InterfacePlusMoins {

	public JFrame frame2;
	private JTextField usersaisie[];
	private JLabel essaiuser[];

	/**
	 * Launch the application.
	 */
	public void keyTyped(KeyEvent k) 
	 { 
		char c = k.getKeyChar();
        //le caractère est numérique
        if (c >= '0' && c <= '9') {
             System.out.println(k);
        } else {
            //suppression du caractère
            k.consume();
        }
	 }
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

		JLabel repfinal = new JLabel("");
		GridBagConstraints gbc_repfinal = new GridBagConstraints();
		gbc_repfinal.insets = new Insets(0, 0, 0, 5);
		gbc_repfinal.gridx = 5;
		gbc_repfinal.gridy = 0;
		frame2.getContentPane().add(repfinal, gbc_repfinal);
		//////////////////////////////////////////////////////////////////////////////////
		//affichage du libelle des essais
		essaiuser = new JLabel[Integer.parseInt(DepartPlusMoins.compteurmere)];
		GridBagConstraints gbc_essaiuser = new GridBagConstraints();
		gbc_essaiuser.insets = new Insets(0, 0, 5, 5);
		gbc_essaiuser.fill = GridBagConstraints.HORIZONTAL;
		int kktemp;
		for (int kk=0;kk<essaiuser.length;kk++){
			kktemp=kk+1;
			 essaiuser[kk] = new JLabel("Essai "+kktemp);
			 gbc_essaiuser.gridx = 1;
			 gbc_essaiuser.gridy = 1;
			 gbc_essaiuser.gridy =kk +1;
				frame2.getContentPane().add(essaiuser[kk], gbc_essaiuser);
		}
		
		///////////////////////////////////////////////////////////////////////////////
		// affichage des zones de saisie
		usersaisie = new JTextField[Integer.parseInt(DepartPlusMoins.compteurmere)];
		System.out.println("taille des usersaisie  "+usersaisie.length);
		GridBagConstraints gbc_usersaisie1 = new GridBagConstraints();
		gbc_usersaisie1.insets = new Insets(0, 0, 5, 5);
		gbc_usersaisie1.fill = GridBagConstraints.HORIZONTAL;


		 
		for (int i = 0; i < usersaisie.length; i++) {
			usersaisie[i] = new JTextField("");
			//usersaisie[i].addKeyListener(keyListener);
			usersaisie[i].setPreferredSize(new Dimension(200, 24));
			gbc_usersaisie1.gridx = 3;
			gbc_usersaisie1.gridy = 1;
			gbc_usersaisie1.gridy =i +1;
			frame2.getContentPane().add(usersaisie[i], gbc_usersaisie1);
		}
		
		
		
/*
		usersaisie[0].addKeyListener(new KeyListener() {
        public void keyPressed(KeyEvent e) {};
        public void keyTyped(KeyEvent e) {
            if(usersaisie[0].getText().equals("A"))
            
            	System.out.println("probleme");
        }public void keyReleased(KeyEvent e) {
            if(usersaisie[0].getText().equals("A"))
            System.out.println("big problem");
        }
    });
		
	*/	
		
		
/////////////////////////////////////////////////////////////////////////////////////////////
		
		frame2.validate();
		frame2.setVisible(true);
		// variable comptant le nombre d'essai

		int compteur = 0;
		JLabel results[] = new JLabel[Integer.parseInt(DepartPlusMoins.compteurmere)];
////////////////////////////////////////////////////////////////////////////////////////////
//affichage resultat exp: +-++
		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.insets = new Insets(0, 0, 5, 0);
		
		for (int i = 0; i < results.length; i++) {
			results[i] = new JLabel("");
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
				recup=usersaisie[compteur-1].getText();
			
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
					results[compteur-1].setText(resultat);

					System.out.println("resultat" + resultat);
					if (resultat.equals("====")) {
						repfinal.setText("Vous avez gagné");

					}
					if (!resultat.equals("====") && (compteur == Integer.parseInt(DepartPlusMoins.compteurmere))) {
						repfinal.setText("Vous avez perdu");

					}
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
