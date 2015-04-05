package fr.dauphine.models;

import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import fr.dauphine.main.Session;
import fr.dauphine.renderers.ListInteger;

public class TableModelLivresEmpruntes extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private int nbColonnes = 5;

	public TableModelLivresEmpruntes(){
		firstColIcon = new ImageIcon(getClass().getResource("retour.png"),"Rendre");
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return ListInteger.class;
		case 5 : return String.class;
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
		case 4 : return "Note";
		case 5 : return "Commentaire";
		case 6 : return "Prix (€)";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return Session.getLivres().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		try{
			switch (columnIndex){
			case 0:return firstColIcon;
			case 1 : return Session.getLivres().get(rowIndex).getIsbn();
			case 2 : return Session.getLivres().get(rowIndex).getTitre();
			case 3 : return Session.getLivres().get(rowIndex).getAuteur();
			case 4 : return new ListInteger(0, 10, 1, Session.getNote(Session.getLivres().get(rowIndex)));
			case 5 : return Session.getCommentaire(Session.getLivres().get(rowIndex));
			case 6 : return Session.getLivres().get(rowIndex).getPrixEuros();
			default: return "";
			}
		}
		catch (RemoteException e){e.printStackTrace();return "";}
	}

	@Override
	public Object getValueAt(int rowIndex) {
		return Session.getLivres().get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 4 || columnIndex == 5)
			return true;
		else return false;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try{
			switch (columnIndex){
			case 1 : Session.getLivres().get(rowIndex).setIsbn((String)aValue);break;
			case 2 : Session.getLivres().get(rowIndex).setTitre((String)aValue);break;
			case 3 : Session.getLivres().get(rowIndex).setAuteur((String)aValue);break;
			case 4 : if (aValue==null)return;Session.addNote(Session.getLivres().get(rowIndex),(Integer)aValue);break;
			case 5 : Session.addCommentaire(Session.getLivres().get(rowIndex),(String)aValue);break;
			case 6 : Session.getLivres().get(rowIndex).setPrixEuros((double)aValue);break;
			}
			
		}
		catch (RemoteException e){e.printStackTrace();}
		
		fireTableCellUpdated(rowIndex, columnIndex);	

	}

	@Override
	public boolean addRow(){
		try {
			fireTableRowsInserted(Session.getLivres().size(), Session.getLivres().size());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void delRow(int numRow){
		Session.returnLivre(Session.getLivres().get(numRow));
		fireTableRowsDeleted(numRow, numRow);	
	}


}
