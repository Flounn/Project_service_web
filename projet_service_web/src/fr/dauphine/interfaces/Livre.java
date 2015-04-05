package fr.dauphine.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface Livre extends Remote{

	String remoteToString() throws RemoteException;
	boolean remoteEquals(Object obj) throws RemoteException;
	String getTitre() throws RemoteException;
	void setTitre(String titre) throws RemoteException;
	String getAuteur() throws RemoteException;
	void setAuteur(String auteur) throws RemoteException;
	long getNumero() throws RemoteException;
	void setNumero(long numero) throws RemoteException;
	String getIsbn() throws RemoteException;
	void setIsbn(String isbn) throws RemoteException;
	Personne[] getAttente() throws RemoteException ;
	boolean isDisponible() throws RemoteException;
	void setDisponible(boolean disponible) throws RemoteException;
	void addToAttente(Personne p) throws RemoteException;
	void enleveFromAttente(Personne p) throws RemoteException;
	String[] getCommentaires() throws RemoteException;
	void addCommentaire(String commentaire) throws RemoteException;
	void passerAuSuivant() throws RemoteException;
	long getCompteurPrets() throws RemoteException;
	void setCompteurPrets(long compteurPrets) throws RemoteException;
	double getPrixEuros() throws RemoteException;
	void setPrixEuros(double prixEuros) throws RemoteException;
	Date getDateAjout() throws RemoteException;
	void setDateAjout(Date dateAjout) throws RemoteException;
	void addNote(int note) throws RemoteException;
	Integer[] getNotes() throws RemoteException;
	double getMoyenneNotes() throws RemoteException;
	boolean canSell() throws RemoteException;

}
