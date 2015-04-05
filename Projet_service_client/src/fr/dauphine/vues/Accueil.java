package fr.dauphine.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.dauphine.main.Session;

public class Accueil extends JFrame implements ConnexionOk {

	private static final long serialVersionUID = 1L;
	private WindowAdapter evenementFrame;

	public Accueil() {
		initListener();
		initUI();
	}

	private void initUI() {
		pack();
		setMinimumSize(new Dimension(800,600));
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource("icone.png")).getImage());
		addWindowListener(evenementFrame);
		setTitle("Bibliotheque");
		initUISeConnecter();
		setVisible(true);
	}

	private void initListener(){
		evenementFrame = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{		
				if (Session.isConnected())
					Session.seDeconnecter();
			}

		};
	}

	private void initUISeConnecter(){
		getContentPane().setLayout(new BorderLayout());
		JPanel pane = new JPanelConnexion(this);
		getContentPane().add(pane, BorderLayout.CENTER);
	}

	private void initUIAccueil(){
		getContentPane().removeAll();
		setJMenuBar(new MenuAccueil());

		setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JPanelLivresEmpruntes(),new JPanelLivresEnAttentes());
		splitPane.setResizeWeight(0.5d);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		validate();
	}

	@Override
	public void connexionOk() {
		initUIAccueil();
	}

	public void refreshJTables(){
		if (getContentPane().getComponents().length==0)
			return;
		JSplitPane splitPane = (JSplitPane)getContentPane().getComponents()[0];
		((JPanelLivresEmpruntes)splitPane.getLeftComponent()).refreshJTable();
		((JPanelLivresEnAttentes)splitPane.getRightComponent()).refreshJTable();
	}

}