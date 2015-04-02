package fr.dauphine.main;

import java.rmi.Naming;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.dauphine.beans.BibliothequeImpl;
import fr.dauphine.beans.PersonneImpl;
import fr.dauphine.interfaces.Bibliotheque;
import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;
import fr.dauphine.interfaces.Personne.Role;


public class MainServer {

	private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		try {
			BibliothequeImpl biblio = new BibliothequeImpl();
			initBiblio(biblio);
			Naming.rebind("rmi://localhost:1099/Bibliotheque", biblio);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
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


			fr.dauphine.interfaces.Personne p = new PersonneImpl(Role.Etudiant,"Tiganu","Eugen", "eugen.tiganu@gmail.com", "eugen");
			b.addPersonne(p);

			Personne p2 = new PersonneImpl(Role.Etudiant,"Lestic","Florian", "florian.lestic@gmail.com", "florian");			
			b.addPersonne(p2);

			Personne p3 = new PersonneImpl(Role.Etudiant,"Hollande","Francois", "francois.hollande@gmail.com", "francois");			
			b.addPersonne(p3);

			Personne p4 = new PersonneImpl(Role.Enseignant,"Herve","Luc", "eugen.tiganu@gmail.com", "luc");	
			b.addPersonne(p4);
			p4.setEmail("luc.herve@gmail.com");
			b.addPersonne(p4);


			Livre[] livres = b.findByTitre("Fred et Mile");
			Livre l=livres[0];
			p.addLivre(l);

			p2.addLivre(l);
			l.addToAttente(p2);
			l.addToAttente(p3);
			p.returnLivre(l);
			l.addCommentaire("Tres bon livre!");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
