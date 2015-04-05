package fr.dauphine.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Observable extends Remote {
	void newNotification() throws RemoteException;
	long getIdPersonne() throws RemoteException;
}
