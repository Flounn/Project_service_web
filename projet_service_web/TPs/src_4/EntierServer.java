
import java.rmi.Naming;

/**
 * 
 */
public class EntierServer {

	public static void main(String[] args) {
		try {
			int nbServeur = 0;
			Entier e = new EntierImpl();
			Naming.rebind("rmi://localhost:1099/EntierService" + nbServeur, e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}

}
