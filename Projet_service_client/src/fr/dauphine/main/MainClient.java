package fr.dauphine.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.dauphine.interfaces.Bibliotheque;


public class MainClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

			System.setProperty("java.security.policy", "sec.policy");
			//System.setProperty("java.rmi.server.codebase", "file://C:/Users/utilisateur/git/Project_service_web/projet_service_web/bin/");
			System.setProperty("java.rmi.server.codebase", "file://F:/Eugen/Workspace/Project_service_web/projet_service_web/bin/");
			System.setSecurityManager(new SecurityManager());
				
			Bibliotheque b =  (Bibliotheque) Naming.lookup("rmi://localhost:1099/Bibliotheque");
			new IHM();
	}

}
