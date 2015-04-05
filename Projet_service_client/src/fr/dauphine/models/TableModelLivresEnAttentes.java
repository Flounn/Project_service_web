package fr.dauphine.models;

import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import fr.dauphine.main.Session;
import fr.dauphine.widgets.JInternalFrameGestionBO;

public class TableModelLivresEnAttentes extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private int nbColonnes = 3;

	public TableModelLivresEnAttentes(){
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
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return Session.getLivresEnAttentes().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		try{
			switch (columnIndex){
			case 0:return firstColIcon;
			case 1 : return Session.getLivresEnAttentes().get(rowIndex).getIsbn();
			case 2 : return Session.getLivresEnAttentes().get(rowIndex).getTitre();
			case 3 : return Session.getLivresEnAttentes().get(rowIndex).getAuteur();
			case 4 : return Session.getLivresEnAttentes().get(rowIndex).getPrixEuros();
			default: return "";
			}
		}
		catch (RemoteException e){e.printStackTrace();return "";}
	}

	@Override
	public Object getValueAt(int rowIndex) {
		return Session.getLivresEnAttentes().get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try{
			switch (columnIndex){
			case 1 : Session.getLivresEnAttentes().get(rowIndex).setIsbn((String)aValue);break;
			case 2 : Session.getLivresEnAttentes().get(rowIndex).setTitre((String)aValue);break;
			case 3 : Session.getLivresEnAttentes().get(rowIndex).setAuteur((String)aValue);break;
			case 4 : if (aValue==null)return;Session.addNote(Session.getLivresEnAttentes().get(rowIndex),(Integer)aValue);break;
			case 5 : Session.addCommentaire(Session.getLivresEnAttentes().get(rowIndex),(String)aValue);break;
			case 6 : Session.getLivresEnAttentes().get(rowIndex).setPrixEuros((double)aValue);break;
			}

		}
		catch (RemoteException e){e.printStackTrace();}

		fireTableCellUpdated(rowIndex, columnIndex);	

	}

	@Override
	public boolean addRow(){
		try {
			//fireTableRowsInserted(Session.getLivresEnAttentes().size(), Session.getLivresEnAttentes().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delRow(int numRow){
		Session.delAttente(Session.getLivresEnAttentes().get(numRow));
		fireTableRowsDeleted(numRow, numRow);
	}


}
