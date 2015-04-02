package fr.dauphine.vues;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.dauphine.widgets.JInternalFrameGestionBO;


public class MenuAccueil extends JMenuBar {

	private static final long serialVersionUID = 6858134594401444641L;

	private ActionListener ActionListenerGestionBO;

	private JMenu menuLivre = new JMenu("Livre");
	private JMenuItem menuVoirLivre = new JMenuItem("Voir Livres");
	private JMenuItem menuMonProfil = new JMenuItem("Mon Profil");
	private JMenu menuProfil = new JMenu("Profil");
	private JMenu menuAide = new JMenu("Aide");

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
		menuMonProfil.addActionListener(ActionListenerGestionBO);
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

	}









}