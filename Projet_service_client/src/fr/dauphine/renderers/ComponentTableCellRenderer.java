package fr.dauphine.renderers;

import java.awt.Component;
import java.sql.Time;
import java.sql.Timestamp;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class ComponentTableCellRenderer implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {

		JLabel component = new JLabel();
		component.setHorizontalAlignment(JLabel.CENTER);
		component.setBorder(null);

		if (value != null){
			switch (value.getClass().getName()){
			case Classe.Integer:
				component.setText(((Integer)value).toString());break;
			case Classe.Double:
				component.setText(((Double)value).toString());break;
			case Classe.Timestamp:
				component.setText(((Timestamp)value).toLocaleString());
				component.setToolTipText(((Timestamp)value).toLocaleString());
				break;
			case Classe.Time:	
				Time t = (Time)value;
				component.setText(t.getHours()+"h"+(t.getMinutes()<10?"0"+t.getMinutes():t.getMinutes())+(t.getSeconds()!=0?"m"+t.getSeconds()+"s":""));
				component.setToolTipText(t.toString());
				break;
			case Classe.String:
				component.setText((String)value);
				component.setToolTipText((String)value);
				break;
			case Classe.ListGenerique:
				ListGenerique values = (ListGenerique) value;
				String libelle = values.getLibelleSelection(); 
				component.setText(libelle);
				component.setToolTipText(libelle);
				break;
			case Classe.Long:
				Long te = (Long)value;
				component.setText(te.toString());
				component.setToolTipText(te.toString());
				break;
			case Classe.Boolean:
				String val = (Boolean)value==true?"Oui":"Non";
				component.setText(val);
				component.setToolTipText(val);
				break;
			}

		}
		//if 	(isSelected)
		//	component.setBackground(Color.MAGENTA);

		return component;
	}


}