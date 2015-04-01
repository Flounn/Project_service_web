
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Bibliotheque extends Remote{
	public boolean add(long isbn, String titre, String auteur) throws RemoteException;
	public boolean del(long isbn) throws RemoteException;
	public ArrayList<LivreImpl> findByTitre(String titre) throws RemoteException;
	public ArrayList<LivreImpl> findByAuteur(String auteur) throws RemoteException;
	
}