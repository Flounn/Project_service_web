import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ObservableC extends UnicastRemoteObject implements Observable{

	protected ObservableC() throws RemoteException {
		super();
	}

	@Override
	public void update(int entier) throws RemoteException {
		System.out.println("value change : "+entier);
	}

}
