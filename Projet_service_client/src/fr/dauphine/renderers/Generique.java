package fr.dauphine.renderers;

public class Generique {

	private Integer id;
	private String libelle;

	public Generique (Integer i,String lib){
		id=i;
		libelle=lib!=null?lib:"";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle!=null?libelle:"";
	}

	@Override
	public String toString() {
		return libelle;
	}


	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null)
			return false;
		if (arg0.getClass()!=this.getClass())
			return false;
		if (((Generique)arg0).getId() != id || ((Generique)arg0).getLibelle() != libelle)
			return false;
		return true;
	}

}