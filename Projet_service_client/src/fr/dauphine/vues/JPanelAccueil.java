package fr.dauphine.vues;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import fr.dauphine.models.TableModelLivresEmpruntes;
import fr.dauphine.widgets.JTableLivres;

public class JPanelAccueil extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelAccueil(){
		initUi();
	}

	private void initUi() {
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);
		JLabel lblNewLabel = new JLabel("Bienvenue dans votre bibliotheque.");
		splitPane.setLeftComponent(lblNewLabel);
		
		//JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(new JTableLivres("Emprunt", new TableModelLivresEmpruntes()));
		
		//splitPane_1.setLeftComponent();
		
	}

}
