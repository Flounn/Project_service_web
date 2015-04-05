package fr.dauphine.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Observer extends Remote {
	void registry(Observable obs) throws RemoteException;
	void unregistry(Observable obs) throws RemoteException;
	void notifierAll(String message) throws RemoteException;
	void notifier(long idPersonne, String message) throws RemoteException;
}
