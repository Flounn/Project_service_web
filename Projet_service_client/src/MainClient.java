import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class MainClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			//System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
			System.setSecurityManager(new SecurityManager());
				
			Bibliotheque b =  (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			
			
			b.addLivre("9782203001190", "Herge", "Les Aventures de Tintin");
			b.addLivre("9781233918119", "Herge", "Fred et Mile");
			b.addLivre("9780132165112", "John C.Hull", "Options, Futures and Other Derivatives");
			b.addLivre("9782212140101", "Claude Delannoy", "Programmer en langage C : Cours et exercices corriges");
			b.addLivre("9782744025983", "Patrick Engebretson", "Les bases du hacking");
			b.addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets");
			b.addLivre("9782253150978", "Simon Singh", "Histoire des codes secrets");
			b.addLivre("9782953966367", "Charles Cohle", "Je sais qui vous Etes: Le manuel d'espionnage sur Internet");
			b.addLivre("9782744025976", "David Kennedy", "Metasploit Securite & hacking - Le guide du pentesteur");
			b.addLivre("9782744025365", "Jon Erickson", "Techniques de hacking");
			b.addLivre("9781481930277", "Simon Levesque", "Le petit livre du hacker 2013");
			b.addLivre("9782744025969", "Eric Charton", "Hacker's guide");
			b.addLivre("9782746074026", "Franck EBEL", "Hacking et Forensic - Developpez vos propres outils en Python");
			b.addLivre("9782744025235", "Scott Granneman", "Linux");
			b.addLivre("9782822402804", "Alexandre Gomez Urbina", "Hacking Interdit");
			b.addLivre("9782297040174", "Karyotis Catherine", "L'essentiel de la bourse et des marches de capitaux");
			b.addLivre("9787561536254", "Zhao Sheng Min", "Le trading algorithmique et les opérations d'arbitrage");
			b.addLivre("9782100708581", "Jeremy Morvan", "Marches et instruments financiers");
			b.addLivre("9782100519675", "Walder Masieri", "Aide-memoire Mathematiques financieres");
			
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
			p.setRole("Etudiant");
			p.setEmail("eugen.tiganu@gmail.com");
			p.setMdp("Eugen");
			
			b.addPersonne(p);
			
			Personne p2 = (Personne) new PersonneImpl();
			p2.setNom("Lestic");
			p2.setPrenom("Florian");
			p2.setRole("Etudiant");
			p2.setEmail("florian.lestic@gmail.com");
			p2.setMdp("Florian");
			
			b.addPersonne(p2);
			
			Personne p3 = (Personne) new PersonneImpl();
			p3.setNom("Hollande");
			p3.setPrenom("Francois");
			p3.setRole("Etudiant");
			p3.setEmail("francois.hollande@gmail.com");
			p3.setMdp("Francois");
			
			b.addPersonne(p3);
			
			Personne p4 = (Personne) new PersonneImpl();
			p4.setNom("Eugen");
			p4.setPrenom("Herve");
			p4.setRole("Enseignant");
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
		}
		

	}

}
