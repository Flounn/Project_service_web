package fr.dauphine.vues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Accueil extends JFrame implements ConnexionOk {

	private static final long serialVersionUID = 1L;

	public Accueil() {
		initUI();
	}

	private void initUI() {

		pack();
		setMinimumSize(new Dimension(800,600));
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource("icone.png")).getImage());

		initUISeConnecter();

		setVisible(true);

	}

	private void initUISeConnecter(){
		getContentPane().setLayout(new BorderLayout());
		JPanel pane = new JPanelConnexion(this);
		getContentPane().add(pane, BorderLayout.CENTER);
	}

	private void initUIAccueil(){
		getContentPane().removeAll();
		JPanel pane = new JPanelAccueil();
		getContentPane().add(pane, BorderLayout.CENTER);
		setJMenuBar(new MenuAccueil());
		validate();
	}

	@Override
	public void connexionOk() {
		initUIAccueil();
	}
	
	public void refreshJTables(){
		for (Component c : getContentPane().getComponents()){
			if (c instanceof JPanelAccueil){
				JPanelAccueil jpane = (JPanelAccueil) c;
				jpane.refreshJTable();
			}
		}
	}

}