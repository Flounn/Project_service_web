package fr.dauphine.vues;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import fr.dauphine.models.AbstractLivresTableModel;
import fr.dauphine.models.TableModelLivresEmpruntes;
import fr.dauphine.models.TableModelLivresEnAttentes;
import fr.dauphine.widgets.JTableLivres;

public class JPanelAccueil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTableLivres livresEmpruntes;
	private JTableLivres livresEnAttente;

	public JPanelAccueil(){
		initUi();
	}

	private void initUi() {
		
		setLayout(new BorderLayout());
		livresEmpruntes = new JTableLivres("Emprunt", new TableModelLivresEmpruntes());
		livresEnAttente = new JTableLivres("Emprunt en attente", new TableModelLivresEnAttentes());
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(livresEmpruntes),new JScrollPane(livresEnAttente));
		splitPane.setResizeWeight(0.5d);
		add(splitPane);
		//splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		//add(splitPane);
		//JLabel lblNewLabel = new JLabel("Bienvenue dans votre bibliotheque.");
		//splitPane.setLeftComponent(lblNewLabel);
		
		//JSplitPane splitPane_1 = new JSplitPane();
		//splitPane.setRightComponent();
		
		//splitPane_1.setLeftComponent();
		
	}
	
	public void refreshJTable(){
		((AbstractLivresTableModel)livresEmpruntes.getModel()).resfreshData();
		((AbstractLivresTableModel)livresEnAttente.getModel()).resfreshData();
	}

}
