import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;


public class BibliothequeImpl extends UnicastRemoteObject implements
		Bibliotheque {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HashMap<Long, LivreImpl> bibliotheque = new HashMap<Long, LivreImpl>();

	public BibliothequeImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	public BibliothequeImpl(int port) throws RemoteException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public BibliothequeImpl(int port, RMIClientSocketFactory csf,
			RMIServerSocketFactory ssf) throws RemoteException {
		super(port, csf, ssf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(long isbn, String titre, String auteur)
			throws RemoteException {
		LivreImpl l = new LivreImpl();
		l.setAuteur(auteur);
		l.setTitre(titre);
		bibliotheque.put(isbn, l);
		return true;
	}

	@Override
	public boolean del(long isbn) throws RemoteException {
		bibliotheque.remove(isbn);
		return false;
	}

	@Override
	public HashMap<Long, LivreImpl> findByTitre(String titre)
			throws RemoteException {
		HashMap<Long, LivreImpl> result = new HashMap<Long, LivreImpl>();
		for(long key: bibliotheque.keySet()){
			if(bibliotheque.get(key).getTitre().equals(titre)) result.put(key, bibliotheque.get(key));
		}
		
		return result;
	}
	@Override
	public HashMap<Long, LivreImpl> findByAuteur(String auteur)
			throws RemoteException {
		HashMap<Long, LivreImpl> result = new HashMap<Long, LivreImpl>();
		for(long key: bibliotheque.keySet()){
			if(bibliotheque.get(key).getAuteur().equals(auteur)) result.put(key, bibliotheque.get(key));
		}
		
		return result;
	}

}
