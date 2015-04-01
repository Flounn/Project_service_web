import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class MainClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/Projet_service_web/bin/");
			System.setSecurityManager(new SecurityManager());
				
			Bibliotheque b =  (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			
			
			b.add(1234, "Herge", "Les Aventures de Tintin");
			b.add(1235, "Herge", "Fred et Mile");
			b.add(1236, "John C.Hull", "Options, Futures and Other Derivatives");
			b.add(1237, "Wallace Wang", "Apprendre la programmation pour les nuls");
			ArrayList<Livre> livres = b.findByTitre("Fred et Mile");
			for(Livre l: livres){
				System.out.println(l.remoteToString());
			}
			System.out.println();
			livres = b.findByAuteur("Herge");
			for(Livre l: livres){
				System.out.println(l.remoteToString());
			}
			
			Personne p = (Personne) Naming.lookup("rmi://localhost:1099/Personne");
			p.setId(1);
			p.setNom("Tiganu");
			p.setPrenom("Eugen");
			p.setRole("Etudiant");
			livres = b.findByTitre("Fred et Mile");
			Livre l=livres.get(0);
			l.addToAttente(p);
			System.out.println(p.getNom() + " " + p.getPrenom() + " a été rajouté à l'attente du " + l.remoteToString());
			p.addLivre(l);
			System.out.println(p.getNom() + " " + p.getPrenom() + " vient d'emprunter " 
					+ p.getLivres().get(p.getLivres().size()-1).remoteToString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		

	}

}