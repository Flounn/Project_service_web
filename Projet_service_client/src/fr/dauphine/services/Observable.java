package fr.dauphine.services;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Observable extends Remote {
	void update(int entier) throws RemoteException;
}
