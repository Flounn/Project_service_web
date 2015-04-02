package fr.dauphine.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import fr.dauphine.beans.PersonneImpl;
import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;


public class MainClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			//System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
			System.setSecurityManager(new SecurityManager());
				
			Bibliotheque b =  (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
			
			ArrayList<Livre> livres = b.findByTitre("Histoire des codes secrets");
			for(Livre l: livres){
				System.out.println(l.remoteToString());
			}
			System.out.println();
			livres = b.findByAuteur("Herge");
			for(Livre l: livres){
				System.out.println(l.remoteToString());
			}
			
			Personne p = (Personne) new PersonneImpl();
			p.setNom("Tiganu");
			p.setPrenom("Eugen");
			p.setRole(Role.Etudiant);
			p.setEmail("eugen.tiganu@gmail.com");
			p.setMdp("Eugen");
			
			b.addPersonne(p);
			
			Personne p2 = (Personne) new PersonneImpl();
			p2.setNom("Lestic");
			p2.setPrenom("Florian");
			p2.setRole(Role.Etudiant);
			p2.setEmail("florian.lestic@gmail.com");
			p2.setMdp("Florian");
			
			b.addPersonne(p2);
			
			Personne p3 = (Personne) new PersonneImpl();
			p3.setNom("Hollande");
			p3.setPrenom("Francois");
			p3.setRole(Role.Etudiant);
			p3.setEmail("francois.hollande@gmail.com");
			p3.setMdp("Francois");
			
			b.addPersonne(p3);
			
			Personne p4 = (Personne) new PersonneImpl();
			p4.setNom("Eugen");
			p4.setPrenom("Herve");
			p4.setRole(Role.Enseignant);
			p4.setEmail("eugen.tiganu@gmail.com");
			p4.setMdp("Eugen");
			
			b.addPersonne(p4);
			p4.setEmail("eugen.Herve@gmail.com");
			b.addPersonne(p4);
			
			
			livres = b.findByTitre("Fred et Mile");
			Livre l=livres.get(0);
			p.addLivre(l);
			System.out.println(p.getNom() + " " + p.getPrenom() + " vient d'emprunter " 
					+ p.getLivres().get(p.getLivres().size()-1).remoteToString());
			
			p2.addLivre(l);
			l.addToAttente(p2);
			l.addToAttente(p3);
			p.returnLivre(l);
			l.addCommentaire("Tres bon livre!");
			
			for(String c: l.getCommentaires())
				System.out.println(l.remoteToString() + " Commentaire :" + c);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

	}

}
