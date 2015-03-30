
import java.rmi.*;
import java.util.HashMap;

public interface Bibliotheque extends Remote{
	public boolean add(long isbn, String titre, String auteur) throws RemoteException;
	public boolean del(long isbn) throws RemoteException;
	public HashMap<Long, Livre> findByTitre(String titre) throws RemoteException;
	public HashMap<Long, Livre> findByAuteur(String auteur) throws RemoteException;
	
}