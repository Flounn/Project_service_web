package fr.dauphine.bibliotheque;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;


public class BibliothequeImpl extends UnicastRemoteObject implements Bibliotheque {
	
	private static final long serialVersionUID = 1L;
	private final HashMap<Long, Livre> bibliotheque = new HashMap<Long, Livre>();
	private final HashMap<Long, Personne> annuaire = new HashMap<Long, Personne>();
	private long compteurLivre;
	private long compteurPersonne;

	public BibliothequeImpl(int arg0, RMIClientSocketFactory arg1,
			RMIServerSocketFactory arg2) throws RemoteException {
		super(arg0, arg1, arg2);
		System.out.println("BibliothequeImpl(int arg0, RMIClientSocketFactory arg1,"
				+"RMIServerSocketFactory arg2)");
		try {
			//initBiblio();
			Naming.rebind("rmi://localhost:1099/Bibliotheque", this);
			Naming.rebind("rmi://localhost:1099/ObserverService", ObserverImpl.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BibliothequeImpl(int arg0) throws RemoteException {
		super(arg0);
		System.out.println("BibliothequeImpl(int arg0)");
		try {
			//initBiblio();
			Naming.rebind("rmi://localhost:1099/Bibliotheque", this);
			Naming.rebind("rmi://localhost:1099/ObserverService", ObserverImpl.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BibliothequeImpl() throws RemoteException {
		super();
		System.out.println("BibliothequeImpl()");
		try {
			//initBiblio();
			Naming.rebind("rmi://localhost:1099/Bibliotheque", this);
			Naming.rebind("rmi://localhost:1099/ObserverService", ObserverImpl.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initBiblio() throws RemoteException, ParseException {
		System.out.println("Initialisation de la bibliotheque");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		addLivre("9782203001190", "Herge", "Les Aventures de Tintin", 12.50, sdf.parse("2014-01-01"));
		addLivre("9781233918119", "Herge", "Fred et Mile", 10.25, sdf.parse("2012-05-10"));
		addLivre("9780132165112", "John C.Hull", "Options, Futures and Other Derivatives", 61.00, sdf.parse("2010-02-07"));
		addLivre("9782212140101", "Claude Delannoy", "Programmer en langage C : Cours et exercices corriges", 21.75, sdf.parse("2014-12-10"));
		addLivre("9782744025983", "Patrick Engebretson", "Les bases du hacking", 30.00, sdf.parse("2013-10-22"));
		addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets", 25.00, sdf.parse("2010-02-20"));
		addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets", 25.00, sdf.parse("2014-12-05"));
		addLivre("9782953966367", "Charles Cohle", "Je sais qui vous Etes: Le manuel d'espionnage sur Internet", 42.15, sdf.parse("2014-09-12"));
		addLivre("9782744025976", "David Kennedy", "Metasploit Securite & hacking - Le guide du pentesteur", 15.00, sdf.parse("2009-04-10"));
		addLivre("9782744025365", "Jon Erickson", "Techniques de hacking", 55.25, sdf.parse("2012-05-10"));
		addLivre("9781481930277", "Simon Levesque", "Le petit livre du hacker 2012", 27.25, sdf.parse("2012-11-17"));
		addLivre("9782744025969", "Eric Charton", "Hacker's guide", 30.25, sdf.parse("2013-06-05"));
		addLivre("9782746074026", "Franck EBEL", "Hacking et Forensic - Developpez vos propres outils en Python", 20.00, sdf.parse("2009-01-11"));
		addLivre("9782744025235", "Scott Granneman", "Linux", 75.25, sdf.parse("2014-01-09"));
		addLivre("9782822402804", "Alexandre Gomez Urbina", "Hacking Interdit", 65.15, sdf.parse("2009-08-30"));
		addLivre("9782297040174", "Karyotis Catherine", "L'essentiel de la bourse et des marches de capitaux", 40.25, sdf.parse("2010-03-12"));
		addLivre("9787561536254", "Zhao Sheng Min", "Le trading algorithmique et les opérations d'arbitrage", 45.10, sdf.parse("2014-04-10"));
		addLivre("9782100708581", "Jeremy Morvan", "Marches et instruments financiers", 35.15, sdf.parse("2011-07-15"));
		addLivre("9782100519675", "Walder Masieri", "Aide-memoire Mathematiques financieres", 10.25, sdf.parse("2012-09-23"));


		Personne p = new PersonneImpl(Role.Etudiant,"Tiganu","Eugen", "eugen.tiganu@gmail.com", "eugen");
		addPersonne(p);

		Personne p2 = new PersonneImpl(Role.Etudiant,"Lestic","Florian", "florian.lestic@gmail.com", "florian");			
		addPersonne(p2);

		Personne p3 = new PersonneImpl(Role.Etudiant,"Hollande","Francois", "francois.hollande@gmail.com", "francois");			
		addPersonne(p3);

		Personne p4 = new PersonneImpl(Role.Enseignant,"Herve","Luc", "eugen.tiganu@gmail.com", "luc");	
		addPersonne(p4);
		p4.setEmail("luc.herve@gmail.com");
		addPersonne(p4);

		Livre[] livres = findByTitre("Fred et Mile");
		
		Livre l=livres[0];
		p.addLivre(l);
		p.addLivre((Livre) bibliotheque.values().toArray()[5]);
		p.returnLivre((Livre) bibliotheque.values().toArray()[5]);
		p2.addLivre((Livre) bibliotheque.values().toArray()[12]);
		p2.returnLivre((Livre) bibliotheque.values().toArray()[12]);
		p4.addLivre((Livre) bibliotheque.values().toArray()[10]);
		p4.returnLivre((Livre) bibliotheque.values().toArray()[10]);
		p4.addLivre((Livre) bibliotheque.values().toArray()[9]);
		p4.returnLivre((Livre) bibliotheque.values().toArray()[9]);
		p2.addLivre(l);
		l.addToAttente(p2);
		//l.addToAttente(p3);
		p.returnLivre(l);
		l.addCommentaire("Tres bon livre!");
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
	public Livre[] findByAuteur(String auteur) throws RemoteException {
		ArrayList<Livre> result = new ArrayList<Livre>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getAuteur().equals(auteur))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result.toArray(new Livre[result.size()]):null;
	}

	@Override
	public Livre[] findByTitre(String titre) throws RemoteException {
		ArrayList<Livre> result = new ArrayList<Livre>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getTitre().equals(titre))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result.toArray(new Livre[result.size()]):null;
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
		if (dateAjout==null)
			livre.setDateAjout(Calendar.getInstance().getTime());
		else	
			livre.setDateAjout(dateAjout);
		livre.setNumero(compteurLivre);
		compteurLivre++;
		bibliotheque.put(livre.getNumero(), livre);
		System.out.println(livre.remoteToString() +" vient d'etre ajoute a la base");
		return true;
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

	/**
	 * @return achete les livres passes en parametre
	 */
	public boolean acheter(long[] livres) {
		if (livres==null)
			throw new NullPointerException();
		for (int i=0; i<Arrays.asList(livres).size(); i++){
			Livre l = bibliotheque.get(livres[i]);			
			try {
				if (delLivre(l))
					System.out.println(l +" vient d'etre achete.");
				else
					System.out.println(l +" n'a pu etre achete.");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public LivreService[] getLivresCanSell() {
		ArrayList<LivreService> livres = new ArrayList<LivreService>();
		for (Entry<Long, Livre> e : bibliotheque.entrySet()){
			try {
				if (e.getValue().canSell())
					livres.add(new LivreService(e.getValue()));
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
		return livres.toArray(new LivreService[livres.size()]);
	}

	@Override
	public Livre[] getLivres() throws RemoteException {
		return bibliotheque.values().toArray(new Livre[bibliotheque.size()]);
	}

	@Override
	public Personne getPersonne(String email, String mdp) throws RemoteException {
		for (Entry<Long, Personne> t : annuaire.entrySet()){
			if (t.getValue().getEmail().equals(email)&& t.getValue().getMdp().equals(mdp))
				return t.getValue();
		}
		return null;
	}

}
