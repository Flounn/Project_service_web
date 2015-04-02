package fr.dauphine.vues;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Accueil extends JFrame {

	private static final long serialVersionUID = -435463672951049291L;
	public MenuAccueil menuAccueil;
	private WindowAdapter evenementFrame;
	private AWTEventListener evenementBoutton;

	public Accueil() {	

		initUI();

	}


	private void initUI() {
		// Gestion des modules de vues
		//AbstractJPanelObserver viewInfosCourse=new InformationsCourse(this);


		pack();
		setMinimumSize(new Dimension(800,600));
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		menuAccueil = new MenuAccueil();
		//listeObserver.add(menuAccueil);
		setJMenuBar(menuAccueil);
		setIconImage(new ImageIcon(getClass().getResource("icone.png")).getImage());
		//JSplitPane spHaut = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, viewInfosCourse, viewInfosVoiture);

		//JSplitPane spBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, circuit, viewClassementCourse);
		//spHaut.setDividerSize(2);
		//spBas.setDividerSize(2);

		//JSplitPane spVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spHaut, spBas);
		//spVertical.setDividerSize(2);
		//add(spVertical);

		addWindowListener(evenementFrame) ;
		Toolkit.getDefaultToolkit().addAWTEventListener(evenementBoutton,AWTEvent.KEY_EVENT_MASK);

		setVisible(true);

	}

}