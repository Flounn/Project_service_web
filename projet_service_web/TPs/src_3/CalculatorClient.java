
import java.rmi.Naming;

public class CalculatorClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/ServicesWebTP1_Server/bin/");
			System.setSecurityManager(new SecurityManager());

			Calculator c =  (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
			System.out.println(c.sub(4, 3));
			System.out.println(c.add(4, 5));
			System.out.println(c.mul(3, 6));
			System.out.println(c.div(9, 3));
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	}

}
