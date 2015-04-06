package fr.dauphine.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.rpc.ServiceException;

import fr.dauphine.banque.Banque;
import fr.dauphine.banque.BanqueServiceLocator;
import fr.dauphine.banque.BanqueSoapBindingStub;
import fr.dauphine.bibliotheque.BibliothequeImpl;
import fr.dauphine.bibliotheque.BibliothequeImplServiceLocator;
import fr.dauphine.bibliotheque.BibliothequeImplSoapBindingStub;
import fr.dauphine.bibliotheque.PersonneImpl;
import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;

public class Main {
	private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException, NotBoundException {
		
		Banque banque = new BanqueServiceLocator().getBanque();
		((BanqueSoapBindingStub) banque).setMaintainSession(true);
		initBanque(banque);
		
		BibliothequeImpl bibliotheque = new BibliothequeImplServiceLocator().getBibliothequeImpl();
		((BibliothequeImplSoapBindingStub) bibliotheque).setMaintainSession(true);
		//LivreService livres[] = bibliotheque.getLivresCanSell();

		System.setProperty("java.security.policy", "sec.policy");
		//System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
		System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
		System.setSecurityManager(new SecurityManager());
		String[] l = Naming.list("rmi://localhost:1099");
		for(String s:l) 
			System.out.println(s);
		Bibliotheque b = (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
		initBiblio(b);
		
		}
	private static void initBiblio(Bibliotheque b){
		try{
			b.addLivre("9782203001190", "Herge", "Les Aventures de Tintin", 12.50, sdf.parse("2014-01-01"));
			b.addLivre("9781233918119", "Herge", "Fred et Mile", 10.25, sdf.parse("2012-05-10"));
			b.addLivre("9780132165112", "John C.Hull", "Options, Futures and Other Derivatives", 61.00, sdf.parse("2010-02-07"));
			b.addLivre("9782212140101", "Claude Delannoy", "Programmer en langage C : Cours et exercices corriges", 21.75, sdf.parse("2014-12-10"));
			b.addLivre("9782744025983", "Patrick Engebretson", "Les bases du hacking", 30.00, sdf.parse("2013-10-22"));
			b.addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets", 25.00, sdf.parse("2015-02-20"));
			b.addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets", 25.00, sdf.parse("2014-12-05"));
			b.addLivre("9782953966367", "Charles Cohle", "Je sais qui vous Etes: Le manuel d'espionnage sur Internet", 42.15, sdf.parse("2014-09-12"));
			b.addLivre("9782744025976", "David Kennedy", "Metasploit Securite & hacking - Le guide du pentesteur", 15.00, sdf.parse("2009-04-10"));
			b.addLivre("9782744025365", "Jon Erickson", "Techniques de hacking", 55.25, sdf.parse("2012-05-10"));
			b.addLivre("9781481930277", "Simon Levesque", "Le petit livre du hacker 2013", 27.25, sdf.parse("2013-11-17"));
			b.addLivre("9782744025969", "Eric Charton", "Hacker's guide", 30.25, sdf.parse("2013-06-05"));
			b.addLivre("9782746074026", "Franck EBEL", "Hacking et Forensic - Developpez vos propres outils en Python", 20.00, sdf.parse("2015-01-11"));
			b.addLivre("9782744025235", "Scott Granneman", "Linux", 75.25, sdf.parse("2014-01-09"));
			b.addLivre("9782822402804", "Alexandre Gomez Urbina", "Hacking Interdit", 65.15, sdf.parse("2009-08-30"));
			b.addLivre("9782297040174", "Karyotis Catherine", "L'essentiel de la bourse et des marches de capitaux", 40.25, sdf.parse("2010-03-12"));
			b.addLivre("9787561536254", "Zhao Sheng Min", "Le trading algorithmique et les opérations d'arbitrage", 45.10, sdf.parse("2014-04-10"));
			b.addLivre("9782100708581", "Jeremy Morvan", "Marches et instruments financiers", 35.15, sdf.parse("2011-07-15"));
			b.addLivre("9782100519675", "Walder Masieri", "Aide-memoire Mathematiques financieres", 10.25, sdf.parse("2012-09-23"));


			Personne p = new PersonneImpl(Role.Etudiant,"Tiganu","Eugen", "eugen.tiganu@gmail.com", "eugen");
			b.addPersonne(p);

			Personne p2 = new PersonneImpl(Role.Etudiant,"Lestic","Florian", "florian.lestic@gmail.com", "florian");			
			b.addPersonne(p2);

			Personne p3 = new PersonneImpl(Role.Etudiant,"Hollande","Francois", "francois.hollande@gmail.com", "francois");			
			b.addPersonne(p3);

			Personne p4 = new PersonneImpl(Role.Enseignant,"Herve","Luc", "eugen.tiganu@gmail.com", "luc");	
			b.addPersonne(p4);
			p4.setEmail("luc.herve@gmail.com");
			b.addPersonne(p4);


			Livre l = b.findByTitre("Fred et Mile")[0];
			Livre l2 = b.findByTitre("Programmer en langage C : Cours et exercices corriges")[0];
			Livre l3 = b.findByTitre("Linux")[0];
			Livre l4 = b.findByTitre("Hacking Interdit")[0];
			Livre l5 = b.findByTitre("Les Aventures de Tintin")[0];
			Livre l6 = b.findByTitre("Histoire des codes secrets")[0];
			
			p.addLivre(l);
			p.addLivre(l2);
			p.addLivre(l3);
			p.addLivre(l4);
			p.addLivre(l5);
			p.addLivre(l6);
			
			p.returnLivre(l);
			p.returnLivre(l2);
			p.returnLivre(l3);
			p.returnLivre(l4);
			p.returnLivre(l5);
			p.returnLivre(l6);
			
			p.addLivre(l);
			p.addLivre(l2);
			p.addLivre(l3);			
			p4.addLivre(l4);			
			p4.addLivre(l5);
			p4.addLivre(l6);
			
			l4.addToAttente(p);
			l5.addToAttente(p);
			l6.addToAttente(p);
			
			l.addToAttente(p4);
			l2.addToAttente(p4);
			l3.addToAttente(p4);
			
			l.addToAttente(p2);
			l2.addToAttente(p2);
			l3.addToAttente(p2);
			l4.addToAttente(p2);
			l5.addToAttente(p2);
			l6.addToAttente(p2);
			
			l.addToAttente(p3);
			l2.addToAttente(p3);
			l3.addToAttente(p3);
			l4.addToAttente(p3);
			l5.addToAttente(p3);
			l6.addToAttente(p3);
			
			p.returnLivre(l);
			p.returnLivre(l2);
			
			p4.returnLivre(l4);
			p4.returnLivre(l5);
			
			l.addCommentaire("Tres bon livre!");
			l.addCommentaire("J'adore");
			l.addCommentaire("Génial");
			l2.addCommentaire("N'importe quoi");
			l2.addCommentaire("J'ai vu mieux");
			l3.addCommentaire("Comme ci comme ca");
			l4.addCommentaire("Pas mal");
			l4.addCommentaire("Bien décrit");
			l5.addCommentaire("Intéréssant");
			l5.addCommentaire("Bon auteur");
			l6.addCommentaire("Sympa");
			
			l.addNote(8);
			l.addNote(9);
			l.addNote(10);
			l.addNote(7);
			l2.addNote(5);
			l2.addNote(4);
			l2.addNote(3);
			l2.addNote(6);
			l2.addNote(8);
			l3.addNote(7);
			l3.addNote(6);
			l3.addNote(7);
			l3.addNote(9);
			l4.addNote(7);
			l4.addNote(7);
			l4.addNote(8);
			l5.addNote(8);
			l5.addNote(9);
			l6.addNote(8);
			l6.addNote(8);
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public static void initBanque(Banque banque) throws RemoteException{			
			banque.addCompte("Tiganu", "Eugen", "eugen.tiganu@gmail.com", "eugen", "EUR");
			banque.depot("eugen.tiganu@gmail.com", "eugen", 200);
			banque.retraitEur("eugen.tiganu@gmail.com", "eugen", 100.0);
			System.out.println("Tiganu Eugen a un solde de " + banque.consultSolde("eugen.tiganu@gmail.com", "eugen"));
			
			banque.addCompte("Florian", "Lestic", "florian.lestic@gmail.com", "florian", "EUR");
			banque.depot("florian.lestic@gmail.com", "florian", 90);
			
			banque.addCompte("Nicolas", "Sarkozy", "eugen.tiganu@gmail.com", "nicolas", "USD");
			banque.addCompte("Nicolas", "Sarkozy", "nicolas.sarkozy@gmail.com", "nicolas", "USD");
			banque.depot("nicolas.sarkozy@gmail.com", "nicolas", 200);
			banque.retraitEur("nicolas.sarkozy@gmail.com", "nicolas", 100.0);
			
			banque.addCompte("Francois", "Hollande", "francois.hollande@gmail.com", "eugen", "EUR");
			banque.delCompte("francois.hollande@gmail.com","eugen");
			
		}
}