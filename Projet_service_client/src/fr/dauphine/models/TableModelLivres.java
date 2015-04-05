package fr.dauphine.models;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.main.Connexion;
import fr.dauphine.main.Session;

public class TableModelLivres extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private final ImageIcon lastColIcon;
	private List<Livre> livres;
	private int nbColonnes = 5;
	private int nbLignes;
	private Livre livreAdd;

	public TableModelLivres(){
		firstColIcon = new ImageIcon(getClass().getResource("del.png"),"Supprimer");
		lastColIcon = new ImageIcon(getClass().getResource("emprunter.png"),"Emprunter");
		majLivres();
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0 : return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return boolean.class;
		case 5 : return Double.class;
		case 6: return lastColIcon.getClass();
		default: return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return nbColonnes+2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex){
		case 0:return "";
		case 1 : return "ISBN";
		case 2 : return "Titre";
		case 3 : return "Auteur";
		case 4 : return "Disponible";
		case 5 : return "Prix (�)";
		case 6 : return "Emprunter";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return nbLignes;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livre livre = (livreAdd!=null&&rowIndex==nbLignes-1)?livreAdd:livres.get(rowIndex);
		try{
			switch (columnIndex){
			case 0 : return firstColIcon;
			case 1 : return livre.getIsbn();
			case 2 : return livre.getTitre();
			case 3 : return livre.getAuteur();
			case 4 : return livre.isDisponible();
			case 5 : return livre.getPrixEuros();
			case 6 : return lastColIcon;
			default: return "";
			}
		}
		catch (RemoteException e){e.printStackTrace();return "";}
	}

	@Override
	public Object getValueAt(int rowIndex) {
		return livres.get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0 || columnIndex == 4 || columnIndex==6)
			return false;
		else return true;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Livre livre = (livreAdd!=null&&rowIndex==nbLignes-1)?livreAdd:livres.get(rowIndex);
		try{
			switch (columnIndex){
			case 1 : livre.setIsbn((String)aValue);break;
			case 2 : livre.setTitre((String)aValue);break;
			case 3 : livre.setAuteur((String)aValue);break;
			case 5 : livre.setPrixEuros((double)aValue);break;
			}
			if (livreAdd!=null&&rowIndex==nbLignes-1 &&  livreAdd.getIsbn()!=null&&livreAdd.getTitre()!=null
					&&livreAdd.getAuteur()!=null){
				Connexion.addLivre(livreAdd.getIsbn(), livreAdd.getAuteur(), livreAdd.getTitre(), livreAdd.getPrixEuros());
				livreAdd=null;
				majLivres();
				fireTableRowsUpdated(rowIndex, rowIndex);
				return;
			}
		}
		catch (RemoteException e){e.printStackTrace();}

		fireTableCellUpdated(rowIndex, columnIndex);	

	}

	@Override
	public boolean addRow(){
		try {
			if (livreAdd!=null)
				return false;
			//livreAdd=new LivreImpl();
			fireTableRowsInserted(nbLignes, nbLignes++);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void delRow(int numRow){
		if (livreAdd!=null&&numRow==nbLignes-1){
			livreAdd=null;
			nbLignes--;
			return;
		}
		Connexion.delLivre(livres.get(numRow));
		majLivres();
		fireTableRowsDeleted(numRow, numRow);	
	}

	public void emprunter(int numRow){
		Session.emprunter(livres.get(numRow));
		fireTableCellUpdated(numRow, 4);
	}


	private void majLivres(){
		try {
			livres = Connexion.getLivres();
			nbLignes=livres.size();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
