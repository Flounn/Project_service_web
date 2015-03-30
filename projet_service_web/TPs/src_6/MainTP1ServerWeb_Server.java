import java.rmi.Naming;


public class MainTP1ServerWeb_Server {

	public static void main(String[] args) {
		try {
			Naming.rebind("rmi://localhost:1099/CalculatorService", new CalculatorC());
			Naming.rebind("rmi://localhost:1099/DicoService", new DicoC());
			Naming.rebind("rmi://localhost:1099/DicoUniService", new DicoUniC());
			Naming.rebind("rmi://localhost:1099/LivreUniService", new LivreUniC());
			Naming.rebind("rmi://localhost:1099/LivreUniService", new LivreUniC());
			Naming.rebind("rmi://localhost:1099/ObserverService", new ObserverC());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
