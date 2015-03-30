
import java.rmi.Naming;
import java.util.HashMap;

public class BibliothequeClient {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/ServicesWebEx1_Server/bin/");
			System.setSecurityManager(new SecurityManager());
				
			Bibliotheque b =  (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			
			
			b.add(1234, "TestT1", "TestA1");
			b.add(1235, "TestT1", "TestA2");
			b.add(1236, "TestT2", "TestA1");
			b.add(1237, "TestT2", "TestA2");
			HashMap<Long, Livre> l = b.findByTitre("TestT1");
			for(long key: l.keySet()){
				System.out.println(l.get(key).getAuteur() + " " + l.get(key).getTitre());
			}
			System.out.println();
			l = b.findByAuteur("TestA1");
			for(long key: l.keySet()){
				System.out.println(l.get(key).getAuteur() + " " + l.get(key).getTitre());
			}
			b.del(1234);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}

}
