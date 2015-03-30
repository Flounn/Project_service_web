
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class LivreImpl extends UnicastRemoteObject implements Livre {

	protected LivreImpl() throws RemoteException {
		super();
	}
	private static final long serialVersionUID = 1L;
	String titre;
	String auteur;
	
	@Override
	public String getTitre() throws RemoteException {
		return titre;
	}
	@Override
	public void setTitre(String titre) throws RemoteException {
		this.titre = titre;
	}
	@Override
	public String getAuteur() throws RemoteException {
		return auteur;
	}
	@Override
	public void setAuteur(String auteur) throws RemoteException {
		this.auteur = auteur;
		
	}




	
	
}
