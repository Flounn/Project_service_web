package fr.dauphine.main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.dauphine.bibliotheque.BibliothequeImpl;
import fr.dauphine.bibliotheque.BibliothequeImplServiceLocator;
import fr.dauphine.bibliotheque.LivreService;
import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;

public final class Connexion {

	private static Bibliotheque bibliotheque ;

	static{
		System.setProperty("java.security.policy", "sec.policy");
		System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
		//System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
		System.setSecurityManager(new SecurityManager());
	}

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

	public static final List<LivreService> getLivresCanSell(){

		try {
			BibliothequeImpl b = new BibliothequeImplServiceLocator().getBibliothequeImpl();
			return Arrays.asList(b.getLivresCanSell()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<LivreService>();

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
				bibliotheque = (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return bibliotheque;
	}

	public final static Personne getPersonne(String email, String mdp){
		try {
			return getBiblio().getPersonne(email, mdp);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
