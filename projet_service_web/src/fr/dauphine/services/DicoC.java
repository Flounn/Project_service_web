package fr.dauphine.services;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;


public class DicoC extends UnicastRemoteObject implements Dico {

	public DicoC() throws RemoteException {
		super();
		 livres = new HashMap<Long,Livre>();
	}

	private HashMap<Long, Livre> livres ;
	
	@Override
	public boolean add(Livre livre) throws RemoteException {
		return livres.put(livre.getISBN(), livre) != null;
	} 

	@Override
	public boolean del(long ISBN) throws RemoteException {
		return livres.remove(ISBN) != null;
	}

	@Override
	public ArrayList<Livre> getLivresByAuteur(String auteur) throws RemoteException {
		ArrayList<Livre> result = new ArrayList<Livre>();
		for (long key : livres.keySet()){
			if (livres.get(key).getAuteur().equals(auteur))
				result.add(livres.get(key));
		}
		return result.size()>0?result:null;
	}

	@Override
	public Livre getLivreByName(String name) throws RemoteException {
		for (long key : livres.keySet()){
			if (livres.get(key).getTitre().equals(name))
				return livres.get(key);
		}
		return null;
	}

}
