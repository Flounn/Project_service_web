
import java.rmi.Naming;

/**
 * 
 */
public class BibliothequeServer {

	public static void main(String[] args) {
		try {
			Bibliotheque b = new BibliothequeImpl();
			Naming.rebind("rmi://localhost:1099/Bibliotheque", b);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	}

}
