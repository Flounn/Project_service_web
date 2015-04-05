package fr.dauphine.models;

import java.util.List;

import javax.swing.ImageIcon;

import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.main.Connexion;

public class TableModelLivresVentes extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private List<LivreService> livres;
	private int nbColonnes = 4;
	private int nbLignes;

	public TableModelLivresVentes(){
		firstColIcon = new ImageIcon(getClass().getResource("selectionner.png"),"Selectionner");
		majLivres();
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return boolean.class;
		case 4 : return double.class;
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
		case 4 : return "Prix (€)";
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
		case 1 : return livres.get(rowIndex).getTitre();
		case 2 : return livres.get(rowIndex).getAuteur();
		case 3 : return livres.get(rowIndex).isDisponible();
		case 4 : return livres.get(rowIndex).getPrixEuros();
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


	private void majLivres(){
		try {
			livres = Connexion.getLivresCanSell();
			nbLignes=livres.size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
