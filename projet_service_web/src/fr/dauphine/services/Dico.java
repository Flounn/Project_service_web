package fr.dauphine.services;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface Dico extends Remote {

	public boolean add(Livre livre) throws RemoteException;
	public boolean del(long ISBN) throws RemoteException;
	public Livre getLivreByName(String name) throws RemoteException;
	public ArrayList<Livre> getLivresByAuteur(String auteur) throws RemoteException;
	
}
