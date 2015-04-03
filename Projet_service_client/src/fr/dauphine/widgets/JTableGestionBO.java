package fr.dauphine.widgets;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.sql.Time;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.dauphine.models.TableModelGestionBO;
import fr.dauphine.renderers.ComponentTableCellRenderer; 
import fr.dauphine.renderers.ComponentTableCellEditor; 
import fr.dauphine.renderers.JLabelTableCellRenderer;
import fr.dauphine.renderers.JListTableCellEditor;
import fr.dauphine.renderers.ListGenerique;

public class JTableGestionBO extends JTable {
 
	private static final long serialVersionUID = 9021059135821154367L;
	private final ImageIcon addIcon = new ImageIcon(getClass().getResource("add.png"));
	private final TableModelGestionBO model;
	
	private final ComponentTableCellRenderer ComponentTableCellRenderer = new ComponentTableCellRenderer();
	private final ComponentTableCellEditor ComponentTableCellEditor = new ComponentTableCellEditor();
	private final String nomTable;
	private SelectionListener SelectionListener;

	public JTableGestionBO(String nomTable,SelectionListener SelectionListener){
		this.SelectionListener=SelectionListener;
		this.nomTable = nomTable;
		model = new TableModelGestionBO(SelectionListener!=null);

		setRowHeight(35);
		setModel(model);

		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getModel());
		sorter.setSortable(0, false);
		setRowSorter(sorter);
		addMouseListener(new MouseAdapterJTable());
		getTableHeader().addMouseListener(new MouseAdapterHeader());

		// sorter.setSortKeys(null);

		getColumnModel().getColumn(0).setResizable(false);
		getColumnModel().getColumn(0).setMaxWidth(50);
		JLabel addJLabel = new JLabel(addIcon,JLabel.CENTER);
		addJLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));
		addJLabel.setToolTipText(nomTable+"_ajouter");
		getColumnModel().getColumn(0).setHeaderRenderer(new JLabelTableCellRenderer());
		getColumnModel().getColumn(0).setHeaderValue(addJLabel);

		setDefaultEditor(Integer.class, ComponentTableCellEditor);
		setDefaultRenderer(Integer.class, ComponentTableCellRenderer);
		setDefaultEditor(Timestamp.class, ComponentTableCellEditor);
		setDefaultRenderer(Timestamp.class, ComponentTableCellRenderer);
		setDefaultEditor(Time.class, ComponentTableCellEditor);
		setDefaultRenderer(Time.class, ComponentTableCellRenderer);
		setDefaultEditor(String.class, ComponentTableCellEditor);
		setDefaultRenderer(String.class, ComponentTableCellRenderer);
		setDefaultEditor(Double.class, ComponentTableCellEditor);
		setDefaultRenderer(Double.class, ComponentTableCellRenderer);
		setDefaultEditor(ListGenerique.class, new JListTableCellEditor());
		setDefaultRenderer(ListGenerique.class, ComponentTableCellRenderer);
		setDefaultRenderer(boolean.class, ComponentTableCellRenderer);
		
		getTableHeader().setReorderingAllowed(false); 
		// je veux pouvoir selectionner une cellule a la fois
		// setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		//setCellSelectionEnabled(true);
		this.setVisible(true);
	}

	public class MouseAdapterJTable extends MouseAdapter{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent evt) {
			Point p = evt.getPoint();
			//num de la ligne selectionnee
			int row = rowAtPoint(p);     
			//num de la col selectionnee
			int col = columnAtPoint(p);

			if (col==0){
				if (!isModeSelection())	// Bouton Supprimer
					model.delRow(convertRowIndexToModel(row));
				else {// Bouton Selectionner
					SelectionListener.selectionLigne((Integer) model.getValueAt(convertRowIndexToModel(row), 1));
					((JInternalFrame)getParent().getParent().getParent().getParent().getParent().getParent()).dispose();
				}
			}

		}

	}

	private class MouseAdapterHeader extends MouseAdapter{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent evt) {

			Point p = evt.getPoint();
			int col = columnAtPoint(p);

			if (col==0){
				model.addRow();
				int i = convertRowIndexToView(model.getRowCount()-1);
				changeSelection(i, 2, false, false);
				evt.setSource(((JTableHeader)evt.getSource()).getTable());
				editCellAt(i, 2,evt);
				getEditorComponent().requestFocus();
			}

		}

	}


	public boolean isModeSelection() {
		return SelectionListener!=null;
	}

	public String getNomTable() {
		return nomTable;
	}

}