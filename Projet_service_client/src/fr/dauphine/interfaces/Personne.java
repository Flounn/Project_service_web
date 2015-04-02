package fr.dauphine.interfaces;
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
	List<Livre> getLivres() throws RemoteException;
	void addLivre(Livre livre) throws RemoteException;
	void returnLivre(Livre livre) throws RemoteException;
	void notification(Livre livre) throws RemoteException;
	String getEmail() throws RemoteException;
	void setEmail(String email) throws RemoteException;
	String getMdp() throws RemoteException;
	void setMdp(String mdp) throws RemoteException;
	String remoteToString() throws RemoteException;
	boolean remoteEquals(Object obj) throws RemoteException;
	List<String> getNotifications() throws RemoteException;
	void addNotification(String notification) throws RemoteException;
	void delNotification(int i) throws RemoteException;
	void delAllNotifications() throws RemoteException;
	List<Livre> getEnAttente() throws RemoteException;
	void addEnAttente(Livre l) throws RemoteException;
	void delEnAttente(Livre l) throws RemoteException;
	void delAllEnAttente() throws RemoteException;
	
}
