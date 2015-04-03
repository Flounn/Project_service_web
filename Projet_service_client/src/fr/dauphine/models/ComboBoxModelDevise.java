package fr.dauphine.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import fr.dauphine.renderers.Generique;

public class ComboBoxModelDevise  extends AbstractListModel<Generique> implements ComboBoxModel<Generique>{
	
	private static final long serialVersionUID = -3908233092221170412L;
	private int nbLignes;
	private String[] values = {"EUR",};	
	
	public void setValuesObjects(Object[] valuesObjects) {
		this.valuesObjects = valuesObjects;
	}

	private Generique selectedItem;
	private Class<?>[] classParams;
	
	public ComboBoxModelDevise (S nomRequete) throws Exception{
		initResultSet();
		init();	
	}
	
	public ComboBoxModelDevise (String nomRequete,Class<?>[] classParams, Object[] valuesRequetes) throws Exception{
		this.nomRequete=nomRequete;
		this.valuesObjects = valuesRequetes;
		this.classParams = classParams;
		//classParams = new Class<?>[valuesRequetes.length]; 
//		for (int i = 0;i<valuesRequetes.length;i++)
//			classParams[i]=valuesRequetes[i].getClass();
		
		initResultSet();
		init();	
	}
	
	public ComboBoxModelDevise (String nomRequete,Class<?>[] classParams, boolean valeurNullFirst,Object[] valuesRequetes) throws Exception{
		this.nomRequete=nomRequete;
		this.valeurNullFirst=valeurNullFirst;
		this.valuesObjects = valuesRequetes;
		this.classParams = classParams;
		initResultSet();
		init();
		selectedItem=nbLignes>0?getElementAt(0):null;
	}
	
	public ComboBoxModelDevise (String nomRequete, Class<?>[] classParams,boolean valeurNullFirst,int positionSelected,Object[] valuesRequetes) throws Exception{
		this.nomRequete=nomRequete;
		this.valeurNullFirst=valeurNullFirst;
		this.valuesObjects = valuesRequetes;
		this.classParams = classParams;
		init();
		selectedItem = getElementAt(valeurNullFirst?positionSelected+1:positionSelected);
	}
	
	public ComboBoxModelDevise (ResultSet resultSet, boolean valeurNullFirst,int positionSelected) {
		this.valeurNullFirst=valeurNullFirst;
		nomRequete=null;
		rs=resultSet;
		init();
		selectedItem = getElementAt(positionSelected);
	}
		
	private void init() {
		if (rs == null)
			return;
		try {
			if (rs.last())
				nbLignes = rs.getRow();
			else 
				nbLignes = 0;
			rs.first();
			if (nbLignes>0){
				if (selectedItem==null||(selectedItem!=null&&!containGenerique(selectedItem.getId())))
					selectedItem = new Generique(rs.getInt(1),rs.getString(2));
			}
			else selectedItem = null;
					
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	private void initResultSet() throws Exception {
		if (valuesObjects == null && classParams != null)
			return;
		
		//rs = (ResultSet) ParamsApplication.getRequetesClass().getMethod(nomRequete,classParams).invoke(ParamsApplication.getRequetesClass().newInstance(),valuesObjects);
	}

	
	public Generique getElementAt(int indice) {
		if (valeurNullFirst && indice == 0)
			return null;
		toPosition(valeurNullFirst?indice:indice+1);
		try {
			return new Generique(rs.getInt(1),rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getSize() {
		return valeurNullFirst&&nbLignes>0?nbLignes+1:nbLignes;
	}
	
	private void toPosition (int row){
		if (row > nbLignes || row <0)
			return;
		try {
			if (row>rs.getRow())
				do{
					rs.next();
				}while(row>rs.getRow());
			else if (row<rs.getRow())
				do{
					rs.previous();
				}while(row<rs.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object obj) {
		selectedItem = (Generique) obj;	
	}
	
	public Generique getElementAt(Integer id) {
		try {
			rs.beforeFirst();
			while (rs.next()){
				Integer i = (Integer) rs.getObject(1);
				if (i == id){
					return new Generique(i,rs.getString(2));
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
		

}