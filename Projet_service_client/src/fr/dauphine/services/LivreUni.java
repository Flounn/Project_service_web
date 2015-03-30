package fr.dauphine.services;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface LivreUni extends Remote {
	
	public String getAuteur() throws RemoteException;
	public void setAuteur(String auteur) throws RemoteException;
	public String getTitre() throws RemoteException;
	public void setTitre(String titre) throws RemoteException;
	public long getISBN() throws RemoteException;
	public void setISBN(long isbn) throws RemoteException;
	
}