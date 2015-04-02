
import java.rmi.Naming;

/**
 * 
 */
public class MainServer {

	public static void main(String[] args) {
		try {
			Naming.rebind("rmi://localhost:1099/Bibliotheque", new BibliothequeImpl());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
