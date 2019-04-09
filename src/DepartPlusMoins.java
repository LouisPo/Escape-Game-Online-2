
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JPanel;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DepartPlusMoins extends JFrame {

	// public JFrame frame;
	static String compteurmere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartPlusMoins window = new DepartPlusMoins();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		DepartPlusMoins window = new DepartPlusMoins();
		window.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public DepartPlusMoins() {
		initialize();
	}

	public void openFrame() {
		InterfacePlusMoins child = new InterfacePlusMoins(this);
	}

	public Component getFrame() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.getContentPane().setLayout(gridBagLayout);

		JLabel lblNombreEssais = new JLabel("Nombre essais");
		GridBagConstraints gbc_lblNombreEssais = new GridBagConstraints();
		gbc_lblNombreEssais.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEssais.gridx = 2;
		gbc_lblNombreEssais.gridy = 1;
		this.getContentPane().add(lblNombreEssais, gbc_lblNombreEssais);

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		// augmenter le nombre d'essai de 5 , 10 , 15 , 20 et 25
		// creer parametre selection nombre à rentrer entre 4 et 10
		comboBox.addItem(0);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		/*
		 * comboBox.addItem(6); comboBox.addItem(7); comboBox.addItem(8);
		 * comboBox.addItem(9); comboBox.addItem(10);
		 */
		this.getContentPane().add(comboBox, gbc_comboBox);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.blue);
		panel2.setOpaque(true);
		JButton logout = new JButton("Logout");

		JButton ok = new JButton("ok");
		GridBagConstraints gbc_ok = new GridBagConstraints();
		gbc_ok.gridx = 4;
		gbc_ok.gridy = 7;
		this.getContentPane().add(ok, gbc_ok);

		ok.addActionListener(new ActionListener() {
			int compteur = 0;

			public void actionPerformed(ActionEvent arg0) {
				DepartPlusMoins.compteurmere = Integer.toString(comboBox.getSelectedIndex());
				InterfacePlusMoins child = new InterfacePlusMoins();
			//	closeFrame();
				// this.setContentPane(panel2);
			}
		});
	}
	private void closeFrame(){
		this.setVisible(false);	
	}
}
