package fr.dauphine.main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Observer;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;

public final class Session {

	private static Personne personne;

	private static ObservableImpl observableImpl ;

	public final static boolean seConnecter(String email, String mdp){
		personne=Connexion.getPersonne(email, mdp);
		if (getPersonne()==null)
			return false;
		try {
			Observer obs = (Observer) Naming.lookup("rmi://localhost:1099/ObserverService");
			obs.registry(getInstanceObservable());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return true;
	}

	private static ObservableImpl getInstanceObservable(){
		while (observableImpl==null){
			try {
				observableImpl = new ObservableImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return observableImpl;
	}

	public final static boolean isConnected(){
		return getPersonne()!=null;
	}

	public final static void seDeconnecter(){
		try {
			Observer obs = (Observer) Naming.lookup("rmi://localhost:1099/ObserverService");
			obs.unregistry(getInstanceObservable());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		personne=null;
	}

	public final static boolean isEnseignant(){
		if (getPersonne()==null)
			return false;
		try {
			return getPersonne().getRole()==Role.Enseignant;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public final static boolean isEtudiant(){
		if (getPersonne()==null)
			return false;
		try {
			return getPersonne().getRole()==Role.Etudiant;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public final static boolean returnLivre(Livre livre){
		try {
			getPersonne().returnLivre(livre);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public final static Integer getNote(Livre livre){
		try {
			return getPersonne().getNote(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final static String getCommentaire(Livre livre){
		try {
			return getPersonne().getCommentaire(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final static void addNote(Livre livre,Integer note){
		try {
			getPersonne().addNote(livre, note);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public final static void addCommentaire (Livre livre, String commentaire){
		try {
			getPersonne().addCommentaire(livre, commentaire);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public final static List<Livre> getLivres(){
		try {
			return Arrays.asList(getPersonne().getLivres());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<Livre>();
	}

	public final static List<Livre> getLivresEnAttentes(){
		try {
			return Arrays.asList(getPersonne().getEnAttente());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<Livre>();
	}

	public final static List<String> getNotifications(){
		try {
			return Arrays.asList(getPersonne().getNotifications());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	public final static String getLastNotification(){

		try {
			return getNotification(personne.getNotifications().length-1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public final static String getNotification(int index){
		try {
			return personne.getNotifications()[index];
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public final static void delNotification(int index){
		try {
			personne.delNotification(index);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public final static void delAttente(Livre livre){
		try {
			getPersonne().delEnAttente(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public final static void emprunter(Livre livre){
		try {
			getPersonne().addLivre(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the personne
	 */
	public final static Personne getPersonne() {
		return personne;
	}

	public final static String getIntitule(){
		try {
			return personne.getPrenom()+" "+personne.getNom()+ " : "+(personne.getRole()==Role.Etudiant?"Etudiant":"Enseignant");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public final static void modifierProfil(String nom, String prenom, String email, String mdp){
		try {
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setEmail(email);
			personne.setMdp(mdp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
