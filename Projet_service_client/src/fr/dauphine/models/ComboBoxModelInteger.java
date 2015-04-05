package fr.dauphine.models;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import fr.dauphine.renderers.ListInteger;

public class ComboBoxModelInteger  extends AbstractListModel<Integer> implements ComboBoxModel<Integer>{
	
	private static final long serialVersionUID = 1L;
	private final int[] values;	
	
	private Integer selectedItem;
	
	public ComboBoxModelInteger (ListInteger list){
		values = new int[(list.getEnd()-list.getBegin())/list.getPas()+1];
		for (int i = 0;i<values.length;i++)
			values[i]=list.getBegin()+(i*list.getPas());
			
	}
	@Override
	public Integer getElementAt(int indice) {
		return values[indice];
	}

	@Override
	public int getSize() {
		return values.length;
	}
	
	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object obj) {
		selectedItem = (Integer) obj;	
	}
		

}