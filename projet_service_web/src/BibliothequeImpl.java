import java.rmi.RemoteException;
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
		super();
	}

	@Override
	public boolean del(long ISBN) throws RemoteException {
		return bibliotheque.remove(ISBN) != null;
	}

	@Override
	public ArrayList<LivreImpl> findByAuteur(String auteur) throws RemoteException {
		ArrayList<LivreImpl> result = new ArrayList<LivreImpl>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getAuteur().equals(auteur))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result:null;
	}

	@Override
	public ArrayList<LivreImpl> findByTitre(String titre) throws RemoteException {
		ArrayList<LivreImpl> result = new ArrayList<LivreImpl>();
		for (long key : bibliotheque.keySet()){
			if (bibliotheque.get(key).getTitre().equals(titre))
				result.add(bibliotheque.get(key));
		}
		return result.size()>0?result:null;
	}

	@Override
	public boolean add(long isbn, String auteur, String titre) throws RemoteException {
		LivreImpl livre = new LivreImpl();
		livre.setAuteur(auteur);
		livre.setIsbn(isbn);
		livre.setTitre(titre);
		return bibliotheque.put(isbn, livre) != null;
	
	}

}
