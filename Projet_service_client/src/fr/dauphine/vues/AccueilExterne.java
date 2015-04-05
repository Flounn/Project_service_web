package fr.dauphine.vues;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.dauphine.main.Panier;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class AccueilExterne extends JFrame implements ListenerDevise{

	private static final long serialVersionUID = 1L;
	public MenuAccueil menuAccueil;
	private ActionListener actionListenerAcheter;
	private JLabel lbl_total_euros;
	private JLabel lbl_total_devise;

	public AccueilExterne() {
		initListeners();
		initUI();
	}

	private void initListeners() {
		actionListenerAcheter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panier.valider();
				refreshJTables();
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
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

		lbl_total_euros = new JLabel(Panier.getTotalPanier()+" \u20AC");
		lbl_total_euros.setHorizontalAlignment(SwingConstants.LEFT);


		JPanel panel = new JPanelPanier();

		JLabel lblTotal_1 = new JLabel("Total :");
		lblTotal_1.setHorizontalAlignment(SwingConstants.RIGHT);

		lbl_total_devise = new JLabel();
		changerDevise();
		lbl_total_devise.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(1012)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTotal_1, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lbl_total_euros, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_total_devise, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAcheter)
										.addContainerGap(138, Short.MAX_VALUE))
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTotal)
												.addComponent(lbl_total_euros))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblTotal_1)
														.addComponent(lbl_total_devise)))
														.addComponent(btnAcheter))
														.addGap(12))
				);
		getContentPane().setLayout(groupLayout);

	}

	public void refreshJTables() {
		if (getContentPane().getComponents().length==0)
			return;
		JPanelPanier panel = (JPanelPanier) getContentPane().getComponents()[5];
		panel.refreshJTable();
		changerDevise();
		lbl_total_euros.setText(Panier.getTotalPanier()+" \u20AC");
	}

	@Override
	public void changerDevise() {
		lbl_total_devise.setText(Panier.getPrixDevise(Panier.getTotalPanier())+" ("+Panier.getDevise()+")");
		try{
			JPanelPanier panel = (JPanelPanier) getContentPane().getComponents()[5];
			panel.refreshJTableHeader();
		}
		catch (Exception e){}
	}
}