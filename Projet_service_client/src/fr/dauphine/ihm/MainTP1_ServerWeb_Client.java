package fr.dauphine.ihm;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.dauphine.services.Calculator;
import fr.dauphine.services.Dico;
import fr.dauphine.services.DicoUni;
import fr.dauphine.services.Livre;
import fr.dauphine.services.LivreUni;
import fr.dauphine.services.ObservableC;
import fr.dauphine.services.Observer;


public class MainTP1_ServerWeb_Client {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "sec.policy");
			//System.setProperty("java.rmi.server.codebase", "file://C:/Users/Florian/workspace/TP1_Serveur_Web/bin/");
			System.setProperty("java.rmi.server.codebase", "http://192.168.43.40/");
			System.setSecurityManager(new SecurityManager());

			Calculator r = (Calculator) Naming.lookup("rmi://192.168.43.40:1099/CalculatorService");
			System.out.println(r.add(5, 6));
			Dico dico = (Dico) Naming.lookup("rmi://192.168.43.40:1099/DicoService"); 
			DicoUni dicoUni = (DicoUni) Naming.lookup("rmi://192.168.43.40:1099/DicoUniService");
			new IHM();
			Livre l1 = new Livre();
			l1.setISBN(3);
			l1.setAuteur("moi");
			l1.setTitre("test");
			dico.add(l1);
			Livre livre = dico.getLivreByName("test");
			System.out.println(livre);

			dicoUni.add(l1.getTitre(),l1.getAuteur(),l1.getISBN());
			LivreUni lu1 = dicoUni.getLivreByName("test");
			System.out.println(lu1);
			
			Observer obs = (Observer) Naming.lookup("rmi://192.168.43.40:1099/ObserverService");
			obs.registry(new ObservableC());
			obs.registry(new ObservableC());
			obs.registry(new ObservableC());
			obs.update(5);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		

	}

}
