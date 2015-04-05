package fr.dauphine.models;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractLivresTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	public abstract Object getValueAt(int rowIndex);
	public void resfreshData(){
		fireTableDataChanged();
	}
	public void delRow(int numRow){};
	public boolean addRow(){
		return false;}

}
