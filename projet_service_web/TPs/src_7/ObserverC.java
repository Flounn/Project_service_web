import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ObserverC extends UnicastRemoteObject implements Observer{
	
	protected ObserverC() throws RemoteException {
		super();
	}

	private ArrayList<Observable> observables = new ArrayList<Observable>();
	private int entier;
	
	@Override
	public void registry(Observable obs) throws RemoteException {
		observables.add(obs);
		
	}

	@Override
	public void unregistry(Observable obs) throws RemoteException {
		observables.remove(obs);
	}

	@Override
	public void update(int entier) throws RemoteException {
		if (entier==this.entier)
			return;
		this.entier=entier;
		notifyAllObs();
		
	}
	private void notifyAllObs(){
		for (Observable obs : observables)
			try {
				obs.update(entier);
			} catch (RemoteException e) {
				e.printStackTrace();
			
			//-Djava.rmi.server.hostname=""
			}
	}
	
}
