package fr.dauphine.vues;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import fr.dauphine.models.TableModelLivresEmpruntes;
import fr.dauphine.widgets.JTableLivres;

public class JPanelAccueil extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelAccueil(){
		initUi();
	}

	private void initUi() {
		
		setLayout(new BorderLayout());
		add(new JScrollPane(new JTableLivres("Emprunt", new TableModelLivresEmpruntes())));
		
		//JSplitPane splitPane = new JSplitPane();
		//splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		//add(splitPane);
		//JLabel lblNewLabel = new JLabel("Bienvenue dans votre bibliotheque.");
		//splitPane.setLeftComponent(lblNewLabel);
		
		//JSplitPane splitPane_1 = new JSplitPane();
		//splitPane.setRightComponent();
		
		//splitPane_1.setLeftComponent();
		
	}

}
