package fr.dauphine.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Personne extends Remote {

	public enum Role {Enseignant,Etudiant}

	String getNom() throws RemoteException;
	void setNom(String nom) throws RemoteException;
	String getPrenom() throws RemoteException;
	void setPrenom(String prenom) throws RemoteException;
	long getId() throws RemoteException;
	void setId(long id) throws RemoteException;
	Role getRole() throws RemoteException;
	void setRole(Role role) throws RemoteException;
	Livre[] getLivres() throws RemoteException;
	void addLivre(Livre livre) throws RemoteException;
	void returnLivre(Livre livre) throws RemoteException;
	void notification(Livre livre) throws RemoteException;
	void newNotification()throws RemoteException;
	String getEmail() throws RemoteException;
	void setEmail(String email) throws RemoteException;
	String getMdp() throws RemoteException;
	void setMdp(String mdp) throws RemoteException;
	String remoteToString() throws RemoteException;
	boolean remoteEquals(Object obj) throws RemoteException;
	String[] getNotifications() throws RemoteException;
	void addNotification(String notification) throws RemoteException;
	void delNotification(int i) throws RemoteException;
	void delAllNotifications() throws RemoteException;
	Livre[] getEnAttente() throws RemoteException;
	void addEnAttente(Livre l) throws RemoteException;
	void delEnAttente(Livre l) throws RemoteException;
	void delAllEnAttente() throws RemoteException;

	void addNote(Livre livre,int note) throws RemoteException;
	void addCommentaire(Livre livre,String commentaire) throws RemoteException;
	void addNoteAndCommentaire(Livre livre,int note, String commentaire) throws RemoteException;
	Integer getNote(Livre livre) throws RemoteException;
	String getCommentaire(Livre livre) throws RemoteException;
	void notification(String message) throws RemoteException;
}
