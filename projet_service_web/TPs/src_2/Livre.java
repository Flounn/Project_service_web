import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Livre extends Remote{
	public String getTitre() throws RemoteException;
	public void setTitre(String titre) throws RemoteException;
	public String getAuteur() throws RemoteException;
	public void setAuteur(String auteur) throws RemoteException;
}
