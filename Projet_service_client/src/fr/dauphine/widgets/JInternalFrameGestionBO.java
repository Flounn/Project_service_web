package fr.dauphine.widgets;

import java.awt.Container;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import fr.dauphine.models.AbstractLivresTableModel;
import fr.dauphine.models.TableModelLivres;
import fr.dauphine.vues.Accueil;
import fr.dauphine.vues.AccueilExterne;


/** 
 * @author Flo
 */

public class JInternalFrameGestionBO extends JInternalFrame{

	private static final long serialVersionUID = -8724192589591662705L;
	private final String nom;
	private SelectionListener selectionListener;
	private SelectionListenerLivre selectionListenerLivre;
	private AbstractLivresTableModel model;

	public JInternalFrameGestionBO(String nomT){
		nom=nomT;	
		initUI();
	}

	public JInternalFrameGestionBO(String nomT,AbstractLivresTableModel model){
		nom=nomT;
		this.model=model;
		initUI();
	}

	public JInternalFrameGestionBO(String nomT,SelectionListener SelectionListener){
		this.selectionListener = SelectionListener;
		nom=nomT;	
		initUI();
	}

	public JInternalFrameGestionBO(String nomT,SelectionListenerLivre SelectionListenerLivre){
		this.selectionListenerLivre = SelectionListenerLivre;
		nom=nomT;	
		initUI();
	}

	private void initUI(){
		setClosable(true);
		setTitle(nom);
		setFrameIcon(null);
		if (selectionListenerLivre!=null)
			add(new JScrollPane(new JTableLivres(nom,model!=null?model:new TableModelLivres(),selectionListenerLivre)));
		else
			add(new JScrollPane(new JTableLivres(nom,model!=null?model:new TableModelLivres(),selectionListener)));

		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent arg0) {
				Container container = getParent().getParent().getParent();
				if (container instanceof Accueil){
					Accueil accueil = (Accueil) container;
					accueil.refreshJTables();
				}
				if (container instanceof AccueilExterne){
					AccueilExterne accueil = (AccueilExterne) container;
					accueil.refreshJTables();
				}
			}
		} ) ;

		setVisible(true);
	}

}