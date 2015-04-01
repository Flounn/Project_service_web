
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class LivreImpl extends UnicastRemoteObject implements Livre {

	private static final long serialVersionUID = 1L;
	String titre;
	String auteur;
	long isbn;
	/**
	 * Liste de personnes en attente du livre
	 */
	List<PersonneImpl> attente;
	
	public LivreImpl() throws RemoteException {
		super();
		attente = new ArrayList<PersonneImpl>();
	}
	
	public LivreImpl(long isbn, String auteur, String titre) throws RemoteException {
		super();
		this.isbn = isbn; 
		this.auteur = auteur;
		this.titre = titre;
		attente = new ArrayList<PersonneImpl>();
	}
	
	@Override
	public List<PersonneImpl> getAttente() throws RemoteException {
		return attente;
	}
	
	@Override
	public void setAttente(List<PersonneImpl> attente) throws RemoteException {
		this.attente = attente;
	}
	/**
	 * 
	 * @return vrai, si le livre est disponible (Si la liste d'attente est vide)
	 * @throws RemoteException
	 */
	@Override
	public boolean isDisponible() throws RemoteException {
		return attente!=null;
	}
	/**
	 * Rajoute une personne à la liste d'attente
	 * @param personne
	 * @throws RemoteException
	 */
	/*@Override
	public void addToAttente(PersonneImpl p) throws RemoteException {
		if(!attente.contains(p)){
			this.attente.add(p);
		}		
	}*/
	/**
	 * Enlève une personne de la liste d'attente. Notifie la 
	 * personne suivante de la liste d'attente qu'on lui prête le livre
	 * @param personne
	 * @throws RemoteException
	 */
	/*@Override
	public synchronized void enleveFromAttente(PersonneImpl p) throws RemoteException {
		if(attente.contains(p)){
			if(attente.get(0).equals(p)){
				p.addLivre(this);
				p.notification(this);
			}
			this.attente.remove(p);
		}
	}*/
	
	@Override
	public String toString() {
		return "Livre [ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}
	
	@Override
	public String remoteToString() throws RemoteException{
		return "Livre [ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreImpl))
			return false;
		LivreImpl temp = (LivreImpl) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre;
	}
	@Override
	public boolean remoteEquals(Object obj) throws RemoteException {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreImpl))
			return false;
		LivreImpl temp = (LivreImpl) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre;
	}
	
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
	@Override
	public long getIsbn() throws RemoteException {
		return isbn;
	}
	@Override
	public void setIsbn(long isbn) throws RemoteException {
		this.isbn=isbn;
	}




	
	
}
