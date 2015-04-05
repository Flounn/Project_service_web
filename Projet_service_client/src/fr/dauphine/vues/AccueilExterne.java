package fr.dauphine.vues;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.dauphine.main.Panier;
import fr.dauphine.models.TableModelPanier;
import fr.dauphine.widgets.JTableLivres;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AccueilExterne extends JFrame implements ListenerDevise{

	private static final long serialVersionUID = 1L;
	public MenuAccueil menuAccueil;
	private ActionListener actionListenerAcheter;
	private JLabel lbl_total;

	public AccueilExterne() {
		initListeners();
		initUI();
	}

	private void initListeners() {
		actionListenerAcheter = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panier.valider();
			}
		};
		
	}

	private void initUI() {
		pack();
		setMinimumSize(new Dimension(800,600));
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource("icone.png")).getImage());
		setTitle("Bibliotheque");
		setJMenuBar(new MenuAccueilExterne(this));
		setVisible(true);
		
		JButton btnAcheter = new JButton("Acheter");
		btnAcheter.addActionListener(actionListenerAcheter);
		JLabel lblTotal = new JLabel("Total :");
		
		lbl_total = new JLabel();
		changerDevise();
		JPanel panel = new JPanel();
		panel.add(new JTableLivres("Panier",new TableModelPanier()));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(489, Short.MAX_VALUE)
					.addComponent(lblTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_total)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAcheter)
					.addGap(155))
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(lbl_total)
						.addComponent(btnAcheter))
					.addGap(16))
		);
		getContentPane().setLayout(groupLayout);

	}

	public void refreshJTables() {
		//TODO
		
	}

	@Override
	public void changerDevise() {
		lbl_total.setText(Panier.getTotalPanier()+" ("+Panier.getDevise()+")");
	}
}