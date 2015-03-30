
import java.rmi.Naming;

public class EntierClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/ServicesWebEx2_Server2/bin/");
			System.setSecurityManager(new SecurityManager());
			
			int newValue = 2;
			
			String [] l = Naming.list("rmi://localhost:1099");
			int nbObservateurs = l.length;
			Entier e[] = new Entier[nbObservateurs];
			int counter = 0;
			for(String s: l){
				System.out.println(s);
				e[counter]= (Entier) Naming.lookup("rmi:" + s);
				System.out.println("La valeur avant le changement pour l'observateur " + (counter+1) + ": " + e[counter].getEntier());
				e[counter].setEntier(newValue);
				System.out.println("La valeur avant le changement pour l'observateur " + (counter+1) + ": " + e[counter].getEntier());
				counter++;
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}

}
