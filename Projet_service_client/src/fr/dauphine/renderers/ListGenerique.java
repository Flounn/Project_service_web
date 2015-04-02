package fr.dauphine.renderers;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ListGenerique {

	private ResultSet resultSet;
	private Integer idSelection;
	private String libelleSelection;
	private int indiceSelection;
	private int nbLigne;

	public ListGenerique(ResultSet rs,Integer idSelection) {
		this.idSelection = idSelection;
		resultSet = rs;
		try {
			if(resultSet.last())
				nbLigne=resultSet.getRow();

		} catch (SQLException e) {e.printStackTrace();}
	}

	public Integer getIdSelection() {
		return idSelection;
	}


	public String getLibelleSelection() {
		if (idSelection == null)
			return null;
		int i =0;
		try {
			resultSet.beforeFirst();
			while (resultSet.next()){
				if (idSelection == (Integer)resultSet.getObject(1)){
					libelleSelection = resultSet.getString(2);
					indiceSelection = i;
					break;
				}
				i++;
			}
			resultSet.first();
		} catch (SQLException e) {e.printStackTrace();}
		return libelleSelection;
	}

	public int getIndiceSelection() {
		return indiceSelection;
	}

	public int getNbLigne() {
		return nbLigne;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}


}