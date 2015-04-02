package fr.dauphine.beans;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.dauphine.interfaces.Livre;


public class LivreService {

	private String titre;
	private String auteur;
	private long numero;
	private String isbn;
	private double prixEuros;
	private Date dateAjout;
	private List<String> commentaires = new ArrayList<String>();
	private List<Integer> notes = new ArrayList<Integer>();
	private boolean disponible=true;
	private long compteurPrets;

	public LivreService(){}

	public LivreService(Livre livre)  {
		try {
			titre=livre.getTitre();
			auteur=livre.getAuteur();
			numero=livre.getNumero();
			isbn=livre.getIsbn();
			prixEuros=livre.getPrixEuros();
			dateAjout=livre.getDateAjout();
			commentaires=Arrays.asList(livre.getCommentaires());
			notes=Arrays.asList(livre.getNotes());
			disponible=livre.isDisponible();
			compteurPrets=livre.getCompteurPrets();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public LivreService(String isbn, String auteur, String titre, double prixEuros, Date dateAjout) {
		super();
		this.isbn = isbn; 
		this.auteur = auteur;
		this.titre = titre;
		this.prixEuros = prixEuros;
		this.dateAjout = dateAjout;
	}


	public String toString() {
		return "Livre [ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}


	public String remoteToString() {
		return "Livre [ID=" + numero + ", ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}


	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreService))
			return false;
		LivreService temp = (LivreService) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre&&temp.numero==numero;
	}


	public boolean remoteEquals(Object obj)  {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreService))
			return false;
		LivreService temp = (LivreService) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre;
	}



	public String getTitre()  {
		return titre;
	}


	public void setTitre(String titre)  {
		this.titre = titre;
	}

	public String getAuteur()  {
		return auteur;
	}

	public void setAuteur(String auteur)  {
		this.auteur = auteur;

	}

	public long getNumero()   {
		return numero;
	}

	public void setNumero(long numero)   {
		this.numero = numero;
	}

	public String getIsbn()  {
		return isbn;
	}

	public void setIsbn(String isbn)  {
		this.isbn=isbn;
	}

	public String[] getCommentaires()   {
		return commentaires.toArray(new String[commentaires.size()]);
	}

	public void addCommentaire(String commentaire)   {
		this.commentaires.add(commentaire);
	}

	public boolean isDisponible()   {
		return disponible;
	}

	public void setDisponible(boolean disponible)   {
		this.disponible = disponible;
	}

	public long getCompteurPrets() {
		return compteurPrets;
	}

	public void setCompteurPrets(long compteurPrets) {
		this.compteurPrets = compteurPrets;
	}

	public double getPrixEuros()  {
		return prixEuros;
	}

	public void setPrixEuros(double prixEuros)  {
		this.prixEuros = prixEuros;
	}

	public Date getDateAjout()  {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout)  {
		this.dateAjout = dateAjout;
	}

	/**
	 * @return the notes
	 */

	public Integer[] getNotes() {
		return notes.toArray(new Integer[notes.size()]);
	}


	/**
	 * @param notes the notes to set
	 */

	public void addNote(int note) {
		notes.add(note);
	}


	public double getMoyenneNotes()  {
		double result =0;
		for (int n : notes)
			result=(result+n)/2;

		return result;
	}


}
