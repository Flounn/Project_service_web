package fr.dauphine.widgets;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;


/** 
 * @author Flo
 */

public class JInternalFrameGestionBO extends JInternalFrame{

	private static final long serialVersionUID = -8724192589591662705L;
	private final String nom;
	private SelectionListener SelectionListener;
	
	public JInternalFrameGestionBO(String nomT){
		nom=nomT;	
		initUI();
	}
	
	public JInternalFrameGestionBO(String nomT,SelectionListener SelectionListener){
		this.SelectionListener = SelectionListener;
		nom=nomT;	
		initUI();
	}
		
	private void initUI(){
		setClosable(true);
		setTitle(nom);
		setFrameIcon(null);
			
		add(new JScrollPane(new JTableGestionBO(nom,SelectionListener)));
		
		/*addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent arg0) {	
				if (nom == Database.EvenementSportif.TABLE_NAME)
					((Accueil)getParent().getParent().getParent()).JInternalFrameEvenementSportifClose();
				else if (nom == Database.Course.TABLE_NAME)
					((Accueil)getParent().getParent().getParent()).JInternalCourseClose();
				else if (nom == Database.ConditionTours.TABLE_NAME)
					((Accueil)getParent().getParent().getParent()).JInternalConditionToursClose();
			}
          } ) ;*/
		setVisible(true);
	}
	
}