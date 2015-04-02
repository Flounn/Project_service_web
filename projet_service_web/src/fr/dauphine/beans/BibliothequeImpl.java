package fr.dauphine.beans;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;


public class BibliothequeImpl extends UnicastRemoteObject implements
		Bibliotheque {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HashMap<Long, LivreImpl> bibliotheque = new HashMap<Long, LivreImpl>();
	private final HashMap<Long, Personne> annuaire = new HashMap<Long, Personne>();
	private long compteurLivre=0;
	private long compteurPersonne=0;

	public BibliothequeImpl() throws RemoteException {
		super();		
	}

	public long getCompteurLivre() {
		return compteurLivre;
	}

	public long getCompteurPersonne() {
		return compteurPersonne;
	}
	/**
	 * Supprime le livre de la base
	 */
	@Override
	public boolean delLivre(Livre livre) throws RemoteException {
		if(bibliotheque.containsKey(livre.getNumero())){
			System.out.println(livre.remoteToString() +" vient d'etre supprime de la base");
			return bibliotheque.remove(livre.getNumero()) != null;
		}
		return false;
	}

	@Override
	public ArrayList<Livre> findByAuteur(String auteur) throws RemoteException {
		ArrayList<Livre> result = new ArrayList<Livre>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getAuteur().equals(auteur))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result:null;
	}

	@Override
	public ArrayList<Livre> findByTitre(String titre) throws RemoteException {
		ArrayList<Livre> result = new ArrayList<Livre>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getTitre().equals(titre))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result:null;
	}
	/**
	 * Ajoute un livre a la base
	 */
	@Override
	public boolean addLivre(String isbn, String auteur, String titre, double prixEuros, Date dateAjout) throws RemoteException {
		LivreImpl livre = new LivreImpl();
		livre.setAuteur(auteur);
		livre.setIsbn(isbn);
		livre.setTitre(titre);
		livre.setPrixEuros(prixEuros);
		livre.setDateAjout(dateAjout);
		livre.setNumero(compteurLivre);
		compteurLivre++;
		System.out.println(livre.remoteToString() +" vient d'etre ajoute a la base");
		return bibliotheque.put(livre.getNumero(), livre) != null;
	}
	/**
	 * Ajoute une personne a la base
	 */
	@Override
	public boolean addPersonne(Personne personne) throws RemoteException {
		if(findByEmail(personne.getEmail())==null){
			personne.setId(compteurPersonne);
			compteurPersonne++;
			System.out.println(personne.remoteToString() +" vient d'etre ajoute a la base");
			return annuaire.put(personne.getId(), personne) != null;
		}
		System.out.println("Une personne avec le mail: " + personne.getEmail() 
				+ " existe deja dans la base");
		return false;
	}
	/**
	 * Supprime une personne de la base
	 */
	@Override
	public boolean delPersonne(Personne personne) throws RemoteException {
		if(annuaire.containsKey(personne.getId())){
			System.out.println(personne.remoteToString() +" vient d'etre supprime de la base");
		}
			return bibliotheque.remove(personne.getId()) != null;
		
	}
	/**
	 * @return Trouve une personne par son email
	 */
	@Override
	public Personne findByEmail(String email) throws RemoteException {
		for (long key : annuaire.keySet()){
			if (annuaire.get(key).getEmail().equals(email))
				return annuaire.get(key);
		}
		return null;
	}
}
