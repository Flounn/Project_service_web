package fr.dauphine.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.main.ConnexionWebServices;
import fr.dauphine.main.Panier;

public class TableModelLivresVentes extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private List<LivreService> livres;
	private int nbColonnes = 6;
	private int nbLignes;

	public TableModelLivresVentes(){
		firstColIcon = new ImageIcon(getClass().getResource("acheter.png"),"Acheter");
		majLivres();
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return boolean.class;
		case 5 : return Double.class;
		case 6 : return Double.class;
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
		case 4 : return "Disponible";
		case 5 : return "Prix (€)";
		case 6 : return "Prix ("+Panier.getDevise()+")";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return nbLignes;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex){
		case 0:return firstColIcon;
		case 1 : return livres.get(rowIndex).getIsbn();
		case 2 : return livres.get(rowIndex).getTitre();
		case 3 : return livres.get(rowIndex).getAuteur();
		case 4 : return livres.get(rowIndex).isDisponible();
		case 5 : return livres.get(rowIndex).getPrixEuros();
		case 6 : return Panier.getPrixDevise(livres.get(rowIndex).getPrixEuros());
		default: return "";
		}


	}

	@Override
	public Object getValueAt(int rowIndex) {
		return livres.get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public void delRow(int numRow) {
		Panier.addLivres(livres.get(numRow));
		majLivres();
		fireTableRowsDeleted(numRow,numRow);
	}


	private void majLivres(){
		try {
			livres = new ArrayList<LivreService>();
			
			List<LivreService> temp = ConnexionWebServices.getLivresCanSell();
			for (LivreService l : temp){
				if (!Panier.getLivres().contains(l))
					livres.add(l);
			}
			nbLignes=livres.size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
