import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Livre extends Remote{
	String remoteToString() throws RemoteException;
	boolean remoteEquals(Object obj) throws RemoteException;
	public String getTitre() throws RemoteException;
	public void setTitre(String titre) throws RemoteException;
	public String getAuteur() throws RemoteException;
	public void setAuteur(String auteur) throws RemoteException;
	public long getIsbn() throws RemoteException;
	public void setIsbn(long isbn) throws RemoteException;
	void setAttente(List<PersonneImpl> attente) throws RemoteException ;
	List<PersonneImpl> getAttente() throws RemoteException ;
	boolean isDisponible() throws RemoteException;
	//void addToAttente(PersonneImpl p) throws RemoteException;
	//void enleveFromAttente(PersonneImpl p) throws RemoteException;
	
	
}
