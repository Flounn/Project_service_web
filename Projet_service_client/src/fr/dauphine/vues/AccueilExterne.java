package fr.dauphine.vues;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import fr.dauphine.interfaces.Livre;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AccueilExterne extends JFrame{
	
	private JTabl

	private static final long serialVersionUID = 1L;
	public MenuAccueil menuAccueil;
	
	private final ArrayList<Livre> livres = new ArrayList<Livre>();

	public AccueilExterne() {
		
		JButton btnAcheter = new JButton("Acheter");
		
		JLabel lblTotal = new JLabel("Total :");
		
		JLabel lbl_total = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.add(new JT);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addComponent(lblTotal)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_total))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnAcheter)))
					.addGap(177))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(lbl_total)
						.addComponent(btnAcheter))
					.addGap(45))
		);
		getContentPane().setLayout(groupLayout);
		initUI();
	}

	private void initUI() {

	}
}