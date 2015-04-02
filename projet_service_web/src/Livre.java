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
	long getNumero() throws RemoteException;
	void setNumero(long numero) throws RemoteException;
	public String getIsbn() throws RemoteException;
	public void setIsbn(String isbn) throws RemoteException;
	void setAttente(List<Personne> attente) throws RemoteException ;
	List<Personne> getAttente() throws RemoteException ;
	boolean isDisponible() throws RemoteException;
	void addToAttente(Personne p) throws RemoteException;
	void enleveFromAttente(Personne p) throws RemoteException;
	List<String> getCommentaires() throws RemoteException;
	void addCommentaire(String commentaire) throws RemoteException;
	void setDisponible(boolean disponible) throws RemoteException;
	void passerAuSuivant(Personne p) throws RemoteException;

	
	
}
