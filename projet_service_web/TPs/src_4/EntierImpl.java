import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;


public class EntierImpl extends UnicastRemoteObject implements
		Entier {


	public EntierImpl() throws RemoteException {
		super();
	}
	public EntierImpl(int port, RMIClientSocketFactory csf,
			RMIServerSocketFactory ssf) throws RemoteException {
		super(port, csf, ssf);
	}
	public EntierImpl(int port) throws RemoteException {
		super(port);
	}
	
	private static final long serialVersionUID = 1L;
	private int value = new Integer(0);
	
	@Override
	public int getEntier() throws RemoteException {
		return value;
	}
	@Override
	public void setEntier(int value) throws RemoteException {
		this.value = value;
		System.out.println("L'entier à été modifié, nouvelle valeur: " + this.value);
		
	}

	
}
