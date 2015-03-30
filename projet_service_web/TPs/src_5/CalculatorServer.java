
import java.rmi.Naming;

/**
 * 
 */

/**
 * @author Sergiu
 *
 */
public class CalculatorServer {

	public static void main(String[] args) {
		try {
			Calculator c = new CalculatorImpl();
			Naming.rebind("rmi://localhost:1099/CalculatorService", c);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	}

}
