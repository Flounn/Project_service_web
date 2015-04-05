package fr.dauphine.bibliotheque;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;


public class LivreImpl extends UnicastRemoteObject implements Livre {

	private static final long serialVersionUID = 1L;
	private String titre;
	private String auteur;
	private long numero;
	private String isbn;
	private double prixEuros;
	private Date dateAjout;
	private List<String> commentaires = new ArrayList<String>();
	private List<Integer> notes = new ArrayList<Integer>();
	private boolean disponible=true;
	private long compteurPrets=0;


	/**
	 * Liste de personnes en attente du livre
	 */
	private List<Personne> attente = new ArrayList<Personne>();

	public LivreImpl() throws RemoteException {
		super();
	}

	public LivreImpl(String isbn, String auteur, String titre, double prixEuros, Date dateAjout) throws RemoteException {
		super();
		this.isbn = isbn; 
		this.auteur = auteur;
		this.titre = titre;
		this.prixEuros = prixEuros;
		this.dateAjout = dateAjout;
	}

	@Override
	public Personne[] getAttente() throws RemoteException {
		return attente.toArray(new Personne[attente.size()]);
	}

	/**
	 * Rajoute une personne à la liste d'attente
	 * @param personne
	 * @throws RemoteException
	 */
	@Override
	public void addToAttente(Personne p) throws RemoteException {
		if(!attente.contains(p)){
			System.out.println(p.remoteToString() 
					+ " a ete mis en attente pour " + this.remoteToString());
			this.attente.add(p);
			p.addEnAttente(this);
		}		
	}
	/**
	 * Enleve une personne de la liste d'attente. Notifie la 
	 * personne suivante de la liste d'attente qu'on lui prête le livre
	 * @param personne
	 * @throws RemoteException
	 */
	@Override
	public synchronized void enleveFromAttente(Personne p) throws RemoteException {
		if(attente.contains(p)){
			this.attente.remove(p);
			p.delEnAttente(this);
		}
	}
	@Override
	public synchronized void passerAuSuivant() throws RemoteException {
		if (attente.isEmpty())
			disponible=true;
		else{
			Personne p = attente.get(0);
			attente.remove(p);
			p.delEnAttente(this);
			disponible=true;
			p.addLivre(this);
			p.notification(this);
		}
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
		if (!(obj instanceof LivreImpl))
			return false;
		LivreImpl temp = (LivreImpl) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre&&temp.numero==numero;
	}
	@Override
	public boolean remoteEquals(Object obj) throws RemoteException {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreImpl))
			return false;
		LivreImpl temp = (LivreImpl) obj;
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
	public Double getMoyenneNotes() throws RemoteException {
		if (notes==null||notes.isEmpty())
			return null;
		double result = notes.get(0);
		for (int n : notes)
			result=(result+n)/2;
		return result;
	}

	@Override
	public boolean canSell() throws RemoteException{
		long diff = Calendar.getInstance().getTimeInMillis()-dateAjout.getTime();
		long twoyears = 2*365*24*3600*1000L;
		if (compteurPrets>=1&&diff>twoyears/*&&isDisponible()*/)
			return true;
		return false;
	}

	@Override
	public void setDisponible(boolean disponible) throws RemoteException {
		this.disponible=disponible;		
	}


}
