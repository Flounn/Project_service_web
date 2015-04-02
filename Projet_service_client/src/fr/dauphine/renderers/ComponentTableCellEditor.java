package fr.dauphine.renderers;

import java.awt.Component;
import java.awt.Point;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

public class ComponentTableCellEditor implements TableCellEditor{
	private JTextField component;
	private JTable table;
	private int column;
	private int row;
	
	@Override
	public Object getCellEditorValue() {
		if (component.getText().isEmpty())
			return null;
		try{
		switch (table.getModel().getColumnClass(column).getName()){
			case Classe.Integer:
				return Integer.valueOf(component.getText());
			case Classe.Double:
				return Double.valueOf(component.getText());
			case Classe.Timestamp:
				return new Timestamp(new SimpleDateFormat().parse(component.getText()).getTime()); 
			case Classe.Time:	
				return Time.valueOf(component.getText());
			case Classe.String:
				return component.getText();
			default : return null;
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

		component = new JTextField();
		component.setBorder(null);
		component.setHorizontalAlignment(JTextField.CENTER);

		if (value!=null){
			String className = value.getClass().getName();
			switch (className){
			case Classe.Integer:
				component.setText(((Integer)value).toString());break;
			case Classe.Double:
				component.setText(((Double)value).toString());break;	
			case Classe.Timestamp:
				Date d = new Date();
				d.setTime(((Timestamp)value).getTime());
				component.setText(new SimpleDateFormat().format(d));break;
			case Classe.Time:	
				component.setText(((Time)value).toString());break;
			case Classe.String:
				component.setText((String)value);break;
				
			}
			
		}
					
		return component;
	}


}
