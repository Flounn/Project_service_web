package fr.dauphine.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface Bibliotheque extends Remote{

	boolean addLivre(String isbn, String auteur, String titre, 
			double prixEuros, Date dateAjout) throws RemoteException;
	boolean delLivre(Livre livre) throws RemoteException;
	Livre[] findByTitre(String titre) throws RemoteException;
	Livre[] findByAuteur(String auteur) throws RemoteException;
	boolean addPersonne(Personne personne) throws RemoteException;
	boolean delPersonne(Personne personne) throws RemoteException;
	Personne findByEmail(String email) throws RemoteException;
	Livre[] getLivres() throws RemoteException;
	Personne getPersonne(String email, String mdp) throws RemoteException;
}
