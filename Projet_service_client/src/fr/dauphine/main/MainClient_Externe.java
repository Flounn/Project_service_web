package fr.dauphine.main;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

import fr.dauphine.vues.AccueilExterne;


public class MainClient_Externe {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new AccueilExterne();
			}
		});

	}

}
