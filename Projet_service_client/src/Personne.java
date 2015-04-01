import java.rmi.RemoteException;
import java.util.List;


public interface Personne {

	String getNom() throws RemoteException;
	void setNom(String nom) throws RemoteException;
	String getPrenom() throws RemoteException;
	void setPrenom(String prenom) throws RemoteException;
	long getId() throws RemoteException;
	void setId(long id) throws RemoteException;
	String getRole() throws RemoteException;
	void setRole(String role) throws RemoteException;
	List<Livre> getLivres() throws RemoteException;
	void addLivre(Livre livre) throws RemoteException;
	void returnLivre(Livre livre) throws RemoteException;
	
}
