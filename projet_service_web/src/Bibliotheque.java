
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Bibliotheque extends Remote{
	public boolean addLivre(String isbn, String titre, String auteur) throws RemoteException;
	public boolean delLivre(Livre livre) throws RemoteException;
	public ArrayList<Livre> findByTitre(String titre) throws RemoteException;
	public ArrayList<Livre> findByAuteur(String auteur) throws RemoteException;
	boolean addPersonne(Personne personne) throws RemoteException;
	boolean delPersonne(Personne personne) throws RemoteException;
	Personne findByEmail(String email) throws RemoteException;
	
}