
import java.rmi.Naming;

/**
 * 
 */
public class Main {

	public static void main(String[] args) {
		try {
			Naming.rebind("rmi://localhost:1099/Bibliotheque", new BibliothequeImpl());
			Naming.rebind("rmi://localhost:1099/Personne", new PersonneImpl());
			Naming.rebind("rmi://localhost:1099/Livre", new LivreImpl());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
