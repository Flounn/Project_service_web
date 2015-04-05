package fr.dauphine.vues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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