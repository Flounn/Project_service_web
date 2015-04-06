package fr.dauphine.models;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import fr.dauphine.main.CompteBancaire;

public class ComboBoxModelDevise  extends AbstractListModel<String> implements ComboBoxModel<String>{
	
	private static final long serialVersionUID = 1L;
	private String[] values = {"EUR","USD","CHF","JPY","CNY"};	
	
	private String selectedItem = CompteBancaire.isConnected()?CompteBancaire.getCompte().getDevise():"EUR";
	
	public ComboBoxModelDevise(){}
	
	public ComboBoxModelDevise(String selectedItem){
		this.selectedItem = selectedItem;
	}
	
	public String getElementAt(int indice) {
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
		selectedItem = (String) obj;	
	}
		

}