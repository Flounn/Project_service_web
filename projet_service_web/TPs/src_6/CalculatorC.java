import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculatorC extends UnicastRemoteObject implements Calculator {

	protected CalculatorC() throws RemoteException {
		super();
	}

	@Override
	public long add(long a, long b) throws RemoteException {
		return a+b;
	}

	@Override
	public long sub(long a, long b) throws RemoteException {
		return a-b;
	}

	@Override
	public long mul(long a, long b) throws RemoteException {
		return a*b;
	}

	@Override
	public long div(long a, long b) throws RemoteException {
		return a/b;
	}

}
