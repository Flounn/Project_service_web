package fr.dauphine.beans;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LivreService implements Livre {

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

	private List<Personne> attente = new ArrayList<Personne>();


	public LivreService(){}
	
	public LivreService(Livre livre) throws RemoteException {
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
		attente=Arrays.asList(livre.getAttente());
	}

	public LivreService(String isbn, String auteur, String titre, double prixEuros, Date dateAjout) throws RemoteException {
		super();
		this.isbn = isbn; 
		this.auteur = auteur;
		this.titre = titre;
		this.prixEuros = prixEuros;
		this.dateAjout = dateAjout;
	}


	public Personne[] getAttente() throws RemoteException {
		return attente.toArray(new Personne[attente.size()]);
	}

	@Override
	public String toString() {
		return "Livre [ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}

	@Override
	public String remoteToString() throws RemoteException{
		return "Livre [ID=" + numero + ", ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreService))
			return false;
		LivreService temp = (LivreService) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre&&temp.numero==numero;
	}

	@Override
	public boolean remoteEquals(Object obj) throws RemoteException {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreService))
			return false;
		LivreService temp = (LivreService) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre;
	}


	@Override
	public String getTitre() throws RemoteException {
		return titre;
	}

	@Override
	public void setTitre(String titre) throws RemoteException {
		this.titre = titre;
	}
	@Override
	public String getAuteur() throws RemoteException {
		return auteur;
	}
	@Override
	public void setAuteur(String auteur) throws RemoteException {
		this.auteur = auteur;

	}
	@Override
	public long getNumero() throws RemoteException  {
		return numero;
	}
	@Override
	public void setNumero(long numero) throws RemoteException  {
		this.numero = numero;
	}
	@Override
	public String getIsbn() throws RemoteException {
		return isbn;
	}
	@Override
	public void setIsbn(String isbn) throws RemoteException {
		this.isbn=isbn;
	}
	@Override
	public String[] getCommentaires() throws RemoteException  {
		return commentaires.toArray(new String[commentaires.size()]);
	}
	@Override
	public void addCommentaire(String commentaire) throws RemoteException  {
		this.commentaires.add(commentaire);
	}
	@Override
	public boolean isDisponible() throws RemoteException  {
		return disponible;
	}
	@Override
	public void setDisponible(boolean disponible) throws RemoteException  {
		this.disponible = disponible;
	}
	@Override
	public long getCompteurPrets() throws RemoteException{
		return compteurPrets;
	}
	@Override
	public void setCompteurPrets(long compteurPrets) throws RemoteException{
		this.compteurPrets = compteurPrets;
	}
	@Override
	public double getPrixEuros() throws RemoteException {
		return prixEuros;
	}
	@Override
	public void setPrixEuros(double prixEuros) throws RemoteException {
		this.prixEuros = prixEuros;
	}
	@Override
	public Date getDateAjout() throws RemoteException {
		return dateAjout;
	}
	@Override
	public void setDateAjout(Date dateAjout) throws RemoteException {
		this.dateAjout = dateAjout;
	}

	/**
	 * @return the notes
	 */
	@Override
	public Integer[] getNotes() throws RemoteException{
		return notes.toArray(new Integer[notes.size()]);
	}


	/**
	 * @param notes the notes to set
	 */
	@Override
	public void addNote(int note) throws RemoteException{
		notes.add(note);
	}

	@Override
	public double getMoyenneNotes() throws RemoteException {
		double result =0;
		for (int n : notes)
			result=(result+n)/2;

		return result;
	}
	@Override
	public boolean canSell() throws RemoteException{
		long diff = Calendar.getInstance().getTimeInMillis()-dateAjout.getTime();
		long twoyears = 2*365*24*3600*1000;
		if (compteurPrets>1&&diff>twoyears/*&&isDisponible()*/)
			return true;
		return false;
	}


	@Override
	public void addToAttente(Personne p) throws RemoteException {

	}


	@Override
	public void enleveFromAttente(Personne p) throws RemoteException {

	}


	@Override
	public void passerAuSuivant(Personne p) throws RemoteException {

	}


}
