import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface DicoUni extends Remote {
	 
	public boolean add(String titre, String auteur, long ISBN) throws RemoteException;
	public boolean del(long ISBN) throws RemoteException;
	public LivreUni getLivreByName(String name) throws RemoteException;
	public ArrayList<LivreUni> getLivresByAuteur(String auteur) throws RemoteException;
	
}
