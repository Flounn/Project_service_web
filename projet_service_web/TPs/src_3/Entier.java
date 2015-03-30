
import java.rmi.*;

public interface Entier extends Remote{
	public int getEntier() throws RemoteException;
	public void setEntier(int value) throws RemoteException;
}