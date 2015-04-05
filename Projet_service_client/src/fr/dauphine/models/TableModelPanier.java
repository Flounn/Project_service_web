package fr.dauphine.models;

import javax.swing.ImageIcon;

import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.main.ConnexionRmi;
import fr.dauphine.main.Panier;
import fr.dauphine.widgets.SelectionListenerLivre;

public class TableModelPanier extends AbstractLivresTableModel implements SelectionListenerLivre {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private int nbColonnes = 5;

	public TableModelPanier(){
		firstColIcon = new ImageIcon(getClass().getResource("del.png"),"Supprimer");
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return Double.class;
		case 5 : return Double.class;
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
		case 1 : return "ISBN";
		case 2 : return "Titre";
		case 3 : return "Auteur";
		case 4 : return "Prix (€)";
		case 5 : return "Prix ("+Panier.getDevise()+")";
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
		case 1 : return Panier.getLivres().get(rowIndex).getIsbn();
		case 2 : return Panier.getLivres().get(rowIndex).getTitre();
		case 3 : return Panier.getLivres().get(rowIndex).getAuteur();
		case 4 : return Panier.getLivres().get(rowIndex).getPrixEuros();
		case 5 : return Panier.getPrixDevise(Panier.getLivres().get(rowIndex).getPrixEuros());
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
		fireTableRowsInserted(old, ConnexionRmi.getLivres().size());
	}

}
