import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Interface extends JFrame{


	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Interface window = new Interface();
		window.setVisible(true);
		

	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.getContentPane().setLayout(gridBagLayout);

		JLabel lblMode = new JLabel("Mode");
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblMode = new GridBagConstraints();
		gbc_lblMode.insets = new Insets(0, 0, 5, 5);
		gbc_lblMode.gridx = 1;
		gbc_lblMode.gridy = 1;
		this.getContentPane().add(lblMode, gbc_lblMode);

		JLabel lblJeux = new JLabel("Jeux");
		GridBagConstraints gbc_lblJeux = new GridBagConstraints();
		gbc_lblJeux.insets = new Insets(0, 0, 5, 5);
		gbc_lblJeux.gridx = 9;
		gbc_lblJeux.gridy = 1;
		this.getContentPane().add(lblJeux, gbc_lblJeux);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Challenger");
		comboBox.addItem("Défenseur");
		comboBox.addItem("Duel");

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		this.getContentPane().add(comboBox, gbc_comboBox);

		JButton btnNewButton = new JButton("Mastermind");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 9;
		gbc_btnNewButton.gridy = 2;
		this.getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton button = new JButton("+/-");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 9;
		gbc_button.gridy = 3;
		this.getContentPane().add(button, gbc_button);
	}

}
