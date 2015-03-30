import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;


public class DicoUniC extends UnicastRemoteObject implements DicoUni{

	protected DicoUniC() throws RemoteException {
		super();
	}

	public final HashMap<Long,LivreUni> livres = new HashMap<Long,LivreUni>();

	@Override
	public boolean del(long ISBN) throws RemoteException {
		return livres.remove(ISBN) != null;
	}

	@Override
	public ArrayList<LivreUni> getLivresByAuteur(String auteur) throws RemoteException {
		ArrayList<LivreUni> result = new ArrayList<LivreUni>();
		for (long key : livres.keySet()){
			if (livres.get(key).getAuteur().equals(auteur))
				result.add(livres.get(key));
		}
		return result.size()>0?result:null;
	}

	@Override
	public LivreUni getLivreByName(String name) throws RemoteException {
		for (long key : livres.keySet()){
			if (livres.get(key).getTitre().equals(name))
				return livres.get(key);
		}
		return null;
	}

	@Override
	public boolean add(String titre, String auteur, long ISBN) throws RemoteException {
		LivreUni livre = new LivreUniC();
		livre.setAuteur(auteur);
		livre.setISBN(ISBN);
		livre.setTitre(titre);
		return livres.put(livre.getISBN(), livre) != null;
	
	}

}
