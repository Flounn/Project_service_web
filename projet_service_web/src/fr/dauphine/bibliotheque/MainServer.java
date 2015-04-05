package fr.dauphine.bibliotheque;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MainServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind("rmi://localhost:1099/Bibliotheque", new BibliothequeImpl());
		Naming.rebind("rmi://localhost:1099/ObserverService", ObserverImpl.getInstance());
	}

}
