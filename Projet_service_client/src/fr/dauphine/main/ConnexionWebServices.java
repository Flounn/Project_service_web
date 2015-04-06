package fr.dauphine.main;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import fr.dauphine.banque.Banque;
import fr.dauphine.banque.BanqueServiceLocator;
import fr.dauphine.banque.Compte;
import fr.dauphine.bibliotheque.BibliothequeImpl;
import fr.dauphine.bibliotheque.BibliothequeImplServiceLocator;
import fr.dauphine.bibliotheque.LivreService;

public final class ConnexionWebServices {
	
	private static BibliothequeImpl bibliotheque;
	private static Banque banque;
	
	public static final List<LivreService> getLivresCanSell(){
		try {
			return Arrays.asList(getBibliotheque().getLivresCanSell()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<LivreService>();

	}

	public static final boolean validerPanier(List<LivreService> livres){
		try {
			long[] tab = new long[livres.size()];
			for (int i=0;i<tab.length;i++)
				tab[i]=livres.get(i).getNumero();
			return getBibliotheque().acheter(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static final double getPrixDevise(String codeDevise,double prixEuros){
		try {
			return getBibliotheque().getPrixDevise(codeDevise, prixEuros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * @return the bibliotheque
	 */
	public final static BibliothequeImpl getBibliotheque() {
		while (bibliotheque==null){
			try {
				bibliotheque = new BibliothequeImplServiceLocator().getBibliothequeImpl();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return bibliotheque;
	}

	/**
	 * @return the banque
	 */
	private final static Banque getBanque() {
		while (banque==null){
			try {
				banque = new BanqueServiceLocator().getBanque();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return banque;
	}
	
	public static final Compte getCompteBancaire(String email, String mdp){
		try {
			return getBanque().getCompte(email, mdp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static final int retrait(String email, String mdp, double montant){
		try {
			return getBanque().retraitEur(email, mdp, montant);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static final boolean depot(String email, String mdp, double montant){
		try {
			return getBanque().depot(email, mdp, montant);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static final double getSolde(String email, String mdp){
		try {
			return getBanque().consultSolde(email, mdp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean modifierCompteBancaire(String nom, String prenom,
			String email, String mdp, String devise) {
		try {
			return getBanque().modifierCompte(email, mdp, nom, prenom, devise);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
