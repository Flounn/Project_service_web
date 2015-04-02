package fr.dauphine.widgets;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.main.Connexion;
import fr.dauphine.main.IHM;

public class TableModelGestionBO extends AbstractTableModel implements SelectionListener{

	private static final long serialVersionUID = 1473936947799958151L;
	private final ImageIcon firstColIcon;
	private List<Livre> livres;
	private int nbColonnes = 3;
	private int nbLignes;
	//private String[] nomColonnesDatabase;
	//private String[] classNameColonnesDatabase;
	//private String[] nomColonnesAffichees;

	public TableModelGestionBO(boolean selection){
		firstColIcon = new ImageIcon(getClass().getResource(selection?"selectionner.png":"del.png"),selection?"Selectionner":"Supprimer");
		majLivres();

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		return String.class;
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
		case 3 : return "Disponibilite";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return nbLignes;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try{
			switch (columnIndex){
			case 0:return firstColIcon;
			case 1 : return livres.get(rowIndex).getTitre();
			case 2 : return livres.get(rowIndex).getAuteur();
			case 3 : return livres.get(rowIndex).isDisponible();
			default: return "";
			}
		}
		catch (RemoteException e){e.printStackTrace();return "";}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0 || columnIndex == 3)
			return false;
		else return true;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		try{
			switch (columnIndex){
			case 1 : livres.get(rowIndex).setTitre((String)aValue);break;
			case 2 : livres.get(rowIndex).setAuteur((String)aValue);break;
			}
		}
		catch (RemoteException e){e.printStackTrace();}
		fireTableCellUpdated(rowIndex, columnIndex);	

	}

	public void addRow(){
		try {
			new IHM(this);
			majLivres();
			fireTableRowsInserted(nbLignes, nbLignes++);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delRow(int numRow){
		Connexion.delLivre(livres.get(numRow));
		majLivres();
		fireTableRowsDeleted(numRow, numRow);	
	}


	private void majLivres(){
		try {
			livres = Connexion.getLivres();
			nbLignes=livres.size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void selectionLigne(Integer id) {
		majLivres();
		
	}



}
