package fr.dauphine.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Accueil extends JFrame implements ConnexionOk {

	private static final long serialVersionUID = 1L;
	public MenuAccueil menuAccueil;

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
		//JSplitPane spHaut = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, viewInfosCourse, viewInfosVoiture);

		//JSplitPane spBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, circuit, viewClassementCourse);
		//spHaut.setDividerSize(2);
		//spBas.setDividerSize(2);

		//JSplitPane spVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spHaut, spBas);
		//spVertical.setDividerSize(2);
		//add(spVertical);
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

}