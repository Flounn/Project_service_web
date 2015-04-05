package fr.dauphine.renderers;

import java.awt.Component;
import java.awt.Point;
import java.util.EventObject;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

import fr.dauphine.models.ComboBoxModelInteger;


public class JListTableCellEditor implements TableCellEditor{
	private JComboBox<?> component;
	private JTable table;
	private String className;
	private int row;
	private int column;

	@Override
	public Object getCellEditorValue() {

		try{
			switch (className){
			case Classe.ListGenerique:
				if (component.getSelectedItem()==null)
					return null;
				return ((Generique)component.getSelectedItem()).getId();
			default : return component.getSelectedItem();

			}
		}
		catch (Exception e){return null;}

	}

	@Override
	public void addCellEditorListener(CellEditorListener arg0) {
	}

	@Override
	public void cancelCellEditing() {	
	}

	@Override
	public boolean isCellEditable(EventObject evt) {	
		if (evt!=null)
			table = (JTable) evt.getSource();
		Point p = ((JTable)evt.getSource()).getMousePosition();
		if (p !=null){
			row = table.rowAtPoint(p);
			column = table.columnAtPoint(p);
		}
		else {
			row = table.getSelectedRow();
			column = table.getSelectedColumn();
		}
		return table.isCellEditable(row,column);
	}

	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {	
	}

	@Override
	public boolean shouldSelectCell(EventObject evt) {
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		table.editingStopped(new ChangeEvent(table));
		return true;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean selected, int row, int column) {

		if (value!=null){
			className = value.getClass().getName();
			switch (className){
			case Classe.ListGenerique:
				ListGenerique values = (ListGenerique) value;break;
				//if (values.getNbLigne()>0){
				//component = new JComboBox<Generique>(new ComboBoxModelDevise(values.getResultSet(),true,values.getIndiceSelection()));
				//component.setSelectedIndex(values.getIndiceSelection());
				//}
			case Classe.ListInteger:
				component=new JComboBox<Integer>(new ComboBoxModelInteger((ListInteger) value));
				component.setSelectedItem(((ListInteger) value).getValueSelected());

			}

		}

		return component;
	}


}