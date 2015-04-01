import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Personne extends Remote{

	String getNom() throws RemoteException;
	void setNom(String nom) throws RemoteException;
	String getPrenom() throws RemoteException;
	void setPrenom(String prenom) throws RemoteException;
	long getId() throws RemoteException;
	void setId(long id) throws RemoteException;
	String getRole() throws RemoteException;
	void setRole(String role) throws RemoteException;
	List<LivreImpl> getLivres() throws RemoteException;
	//void addLivre(LivreImpl livre) throws RemoteException;
	//void returnLivre(LivreImpl livre) throws RemoteException;
	//void notification(LivreImpl livre) throws RemoteException;
	
}
