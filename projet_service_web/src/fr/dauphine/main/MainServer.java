package fr.dauphine.main;

import java.rmi.Naming;

import fr.dauphine.beans.BibliothequeImpl;

/**
 * 
 */
public class MainServer {

	public static void main(String[] args) {
		try {
			Naming.rebind("rmi://localhost:1099/Bibliotheque", new BibliothequeImpl());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
