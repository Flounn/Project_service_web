package fr.dauphine.bibliotheque;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import fr.dauphine.interfaces.Observable;
import fr.dauphine.interfaces.Observer;


public class ObserverImpl extends UnicastRemoteObject implements Observer{

	private static final long serialVersionUID = 1L;
	private static ObserverImpl singleton;
	
	public ObserverImpl() throws RemoteException {
		super();
	}

	private ArrayList<Observable> observables = new ArrayList<Observable>();
	
	public final static synchronized ObserverImpl getInstance(){
		while (singleton==null){
			try {
				singleton = new ObserverImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	@Override
	public void notifierAll(String message){
		for (Observable obs : observables)
			try {
				obs.newNotification();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void registry(Observable obs) throws RemoteException {
		observables.add(obs);
		
	}

	@Override
	public void unregistry(Observable obs) throws RemoteException {
		observables.remove(obs);
		
	}

	@Override
	public void notifier(long idPersonne, String message)
			throws RemoteException {
		for (Observable p : observables){
			if (p.getIdPersonne()==idPersonne)
				p.newNotification();
		}
		
	}

}
