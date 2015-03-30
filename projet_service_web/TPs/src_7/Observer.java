import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Observer extends Remote {
	void registry(Observable obs) throws RemoteException;
	void unregistry(Observable obs) throws RemoteException;
	void update(int entier) throws RemoteException;
}
