package fr.dauphine.main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;

public final class Connexion {

	private static Bibliotheque bibliotheque ;
	
	public static final boolean addLivre(){
		return addLivre(null,null,null,0,null);
	}

	public static final boolean addLivre(String isbn, String auteur, String titre, double prixEuro){
		return addLivre(isbn,auteur,titre,prixEuro,null);
	}

	public static final boolean addLivre(String isbn, String auteur, String titre, double prixEuro, Date dateAjout){
		try {
			return getBiblio().addLivre(isbn, auteur, titre, prixEuro, dateAjout);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static final List<Livre> getLivres(){
		try {
			return Arrays.asList(getBiblio().getLivres());
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public static final void delLivre(Livre livre){
		try {
			getBiblio().delLivre(livre);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	private final static Bibliotheque getBiblio(){
		if (bibliotheque==null)
			try {
				System.setProperty("java.security.policy", "sec.policy");
				System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
				//System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
				System.setSecurityManager(new SecurityManager());
				bibliotheque = (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return bibliotheque;
	}


}
