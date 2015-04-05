package fr.dauphine.main;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;

public final class Session {

	private static Personne personne;

	public final static boolean seConnecter(String email, String mdp){
		personne = Connexion.getPersonne(email, mdp);
		if (personne==null)
			return false;
		return true;
	}

	public final static boolean isConnected(){
		return personne!=null;
	}

	public final static void seDeconnecter(){
		personne=null;
	}

	public final static boolean isEnseignant(){
		if (personne==null)
			return false;
		try {
			return personne.getRole()==Role.Enseignant;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public final static boolean isEtudiant(){
		if (personne==null)
			return false;
		try {
			return personne.getRole()==Role.Etudiant;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public final static boolean returnLivre(Livre livre){
		try {
			personne.returnLivre(livre);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public final static Integer getNote(Livre livre){
		try {
			return personne.getNote(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public final static String getCommentaire(Livre livre){
		try {
			return personne.getCommentaire(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public final static void addNote(Livre livre,Integer note){
		try {
			personne.addNote(livre, note);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public final static void addCommentaire (Livre livre, String commentaire){
		try {
			personne.addCommentaire(livre, commentaire);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public final static List<Livre> getLivres(){
		try {
			return Arrays.asList(personne.getLivres());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<Livre>();
	}
	
	public final static List<Livre> getLivresEnAttentes(){
		try {
			return Arrays.asList(personne.getEnAttente());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<Livre>();
	}
	
	public final static void delAttente(Livre livre){
		try {
			personne.delEnAttente(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public final static void emprunter(Livre livre){
		try {
			personne.addLivre(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
