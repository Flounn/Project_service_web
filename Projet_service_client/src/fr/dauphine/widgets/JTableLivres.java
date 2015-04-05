package fr.dauphine.widgets;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.beans.PropertyVetoException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.models.AbstractLivresTableModel;
import fr.dauphine.models.TableModelLivres;
import fr.dauphine.models.TableModelLivresEmpruntes;
import fr.dauphine.models.TableModelLivresEnAttentes;
import fr.dauphine.renderers.ComponentTableCellRenderer; 
import fr.dauphine.renderers.ComponentTableCellEditor; 
import fr.dauphine.renderers.JLabelTableCellRenderer;
import fr.dauphine.renderers.JListTableCellEditor;
import fr.dauphine.renderers.ListGenerique;
import fr.dauphine.renderers.ListInteger;

public class JTableLivres extends JTable {

	private static final long serialVersionUID = 9021059135821154367L;
	private final ImageIcon addIcon = new ImageIcon(getClass().getResource("add.png"));
	private final AbstractLivresTableModel model;

	private final ComponentTableCellRenderer ComponentTableCellRenderer = new ComponentTableCellRenderer();
	private final ComponentTableCellEditor ComponentTableCellEditor = new ComponentTableCellEditor();
	private final String nomTable;
	private SelectionListener selectionListener;
	private SelectionListenerLivre selectionListenerLivre;

	public JTableLivres(String nomTable, AbstractLivresTableModel model){
		this.nomTable = nomTable;
		this.model = model;
		initUi();
	}

	public JTableLivres(String nomTable,AbstractLivresTableModel model, SelectionListenerLivre SelectionListenerLivre){
		this.nomTable = nomTable;
		this.model = model;
		this.selectionListenerLivre=SelectionListenerLivre;
		initUi();
	}

	public JTableLivres(String nomTable,AbstractLivresTableModel model,SelectionListener SelectionListener){
		this.nomTable = nomTable;
		this.model = model;
		selectionListener=SelectionListener;
		initUi();
	}

	private void initUi(){
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
		addJLabel.setToolTipText("Ajouter "+nomTable);
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
		setDefaultEditor(ListInteger.class, new JListTableCellEditor());
		setDefaultRenderer(ListInteger.class, ComponentTableCellRenderer);
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
					if (selectionListener!=null)
						selectionListener.selectionLigne((long) model.getValueAt(convertRowIndexToModel(row), 1));
					else
						selectionListenerLivre.selectionLigne((LivreService) model.getValueAt(convertRowIndexToModel(row)));
					((JInternalFrame)getParent().getParent().getParent().getParent().getParent().getParent()).dispose();
				}
			}
			else if (col==6){//Emprunter
				((TableModelLivres)model).emprunter(convertRowIndexToModel(row));
			}

		}

	}

	private class MouseAdapterHeader extends MouseAdapter{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent evt) {

			Point p = evt.getPoint();
			int col = columnAtPoint(p);

			if (col==0){
				if (model instanceof TableModelLivresEnAttentes || model instanceof TableModelLivresEmpruntes){
					JInternalFrame test = new JInternalFrameGestionBO("Emprunt");
					getParent().getParent().getParent().getParent().getParent().getParent().add(test);
					try {
						test.setMaximum(true);
					} catch (PropertyVetoException e) {e.printStackTrace();}
					return;
				}
					
				
				if (model.addRow()){
					int i = convertRowIndexToView(model.getRowCount()-1);
					changeSelection(i, 1, false, false);
					evt.setSource(((JTableHeader)evt.getSource()).getTable());
					editCellAt(i, 1,evt);
					getEditorComponent().requestFocus();
				}
			}

		}

	}


	public boolean isModeSelection() {
		return selectionListener!=null||selectionListenerLivre!=null;
	}

	public String getNomTable() {
		return nomTable;
	}

}