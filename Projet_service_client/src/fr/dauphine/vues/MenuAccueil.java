package fr.dauphine.vues;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.dauphine.main.Session;
import fr.dauphine.widgets.JInternalFrameGestionBO;
import fr.dauphine.widgets.JInternalFrameMonProfil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


public class MenuAccueil extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private ActionListener ActionListenerGestionBO;
	private ActionListener ActionListenerMonProfil;
	private ActionListener actionDeconnection;

	private JMenu menuLivre = new JMenu("Livre");
	private JMenuItem menuVoirLivre = new JMenuItem("Voir Livres");
	private JMenuItem menuMonProfil = new JMenuItem("Mon Profil");
	private JMenu menuProfil = new JMenu("Profil");
	private JMenu menuAide = new JMenu("Aide");
	private final JLabel lbl_personne = new JLabel();

	public MenuAccueil(){
		initUI();
	}


	private void initUI() {
		add(menuLivre);
		add(menuProfil);
		add(menuAide);
		initListeners();
		menuLivre.add(menuVoirLivre);
		menuProfil.add(menuMonProfil);

		menuVoirLivre.setName("Livres");
		menuMonProfil.setName("Profil");

		menuVoirLivre.addActionListener(ActionListenerGestionBO);
		menuMonProfil.addActionListener(ActionListenerMonProfil);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		lbl_personne.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_personne.setText(Session.getIntitule());
		lbl_personne.setVerticalAlignment(JLabel.CENTER);
		
		JButton bt_deco = new JButton("Se deconnecter");
		bt_deco.addActionListener(actionDeconnection);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lbl_personne, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bt_deco)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lbl_personne, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(bt_deco))
		);
		panel.setLayout(gl_panel);
		
	}


	private void initListeners() {

		ActionListenerGestionBO = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JInternalFrame test = new JInternalFrameGestionBO(((JMenuItem)arg0.getSource()).getName());
				getParent().add(test);
				try {
					test.setMaximum(true);
				} catch (PropertyVetoException e) {e.printStackTrace();}

			}
		};
		
		ActionListenerMonProfil = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JInternalFrame test = new JInternalFrameMonProfil();
				getParent().add(test);
				try {
					test.setMaximum(true);
				} catch (PropertyVetoException e) {e.printStackTrace();}

			}
		};
		
		actionDeconnection = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Session.seDeconnecter();
				((Accueil)getParent().getParent().getParent()).seDeconnecter();
			}
		}; 

	}
}