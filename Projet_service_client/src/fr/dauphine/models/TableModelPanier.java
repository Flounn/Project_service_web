package fr.dauphine.models;

import javax.swing.ImageIcon;

import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.main.Connexion;
import fr.dauphine.main.Panier;
import fr.dauphine.widgets.JTableLivres;
import fr.dauphine.widgets.SelectionListenerLivre;

public class TableModelPanier extends AbstractLivresTableModel implements SelectionListenerLivre {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private int nbColonnes = 4;

	public TableModelPanier(){
		firstColIcon = new ImageIcon(getClass().getResource("del.png"),"Supprimer");
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return boolean.class;
		case 4 : return String.class;
		default: return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return nbColonnes+1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex){
		case 0:return "";
		case 1 : return "Titre";
		case 2 : return "Auteur";
		case 3 : return "Disponible";
		case 4 : return "Prix";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return Panier.getLivres().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex){
		case 0:return firstColIcon;
		case 1 : return Panier.getLivres().get(rowIndex).getTitre();
		case 2 : return Panier.getLivres().get(rowIndex).getAuteur();
		case 3 : return Panier.getLivres().get(rowIndex).isDisponible();
		case 4 : return Panier.getLivres().get(rowIndex).getPrixEuros()+"€";
		default: return "";
		}
	}

	@Override
	public Object getValueAt(int rowIndex) {
		return Panier.getLivres().get(rowIndex);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public boolean addRow(){
		new JTableLivres("Livre",this);
		return false;
	}

	@Override
	public void delRow(int numRow){
		Panier.removeLivres(numRow);
		fireTableRowsDeleted(numRow, numRow);	
	}

	@Override
	public void selectionLigne(LivreService livre) {
		int old = Panier.getLivres().size();
		Panier.addLivres(livre);
		fireTableRowsInserted(old, Connexion.getLivres().size());
		
	}

}
