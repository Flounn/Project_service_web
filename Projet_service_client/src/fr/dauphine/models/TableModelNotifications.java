package fr.dauphine.models;

import javax.swing.ImageIcon;

import fr.dauphine.main.Session;

public class TableModelNotifications extends AbstractLivresTableModel {

	private static final long serialVersionUID = 1L;
	private final ImageIcon firstColIcon;
	private int nbColonnes = 1;

	public TableModelNotifications(){
		firstColIcon = new ImageIcon(getClass().getResource("del.png"),"Supprimer");
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return firstColIcon.getClass();
		case 1 : return String.class;
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
		case 0 : return "";
		case 1 : return "Notification";
		default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return Session.getNotifications().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
		case 0:return firstColIcon;
		case 1 : return Session.getNotification(rowIndex);
		default: return "";
		}

	}

	@Override
	public Object getValueAt(int rowIndex) {
		return Session.getNotification(rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void delRow(int numRow){
		Session.delNotification(numRow);
		fireTableRowsDeleted(numRow, numRow);	
	}


}
