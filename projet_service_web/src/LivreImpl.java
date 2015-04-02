
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class LivreImpl extends UnicastRemoteObject implements Livre {

	private static final long serialVersionUID = 1L;
	protected String titre;
	protected String auteur;
	protected long numero;
	protected String isbn;
	protected List<String> commentaires;
	protected boolean disponible=true;

	/**
	 * Liste de personnes en attente du livre
	 */
	protected List<Personne> attente;

	public LivreImpl() throws RemoteException {
		super();
		attente = new ArrayList<Personne>();
		commentaires = new ArrayList<String>();
	}

	public LivreImpl(String isbn, String auteur, String titre) throws RemoteException {
		super();
		this.isbn = isbn; 
		this.auteur = auteur;
		this.titre = titre;
		attente = new ArrayList<Personne>();
		commentaires = new ArrayList<String>();
	}

	@Override
	public List<Personne> getAttente() throws RemoteException {
		return attente;
	}

	@Override
	public void setAttente(List<Personne> attente) throws RemoteException {
		this.attente = attente;
	}
	/**
	 * Rajoute une personne à la liste d'attente
	 * @param personne
	 * @throws RemoteException
	 */
	@Override
	public void addToAttente(Personne p) throws RemoteException {
		if(!attente.contains(p)){
			System.out.println(p.remoteToString() 
					+ " a ete mis en attente pour " + this.remoteToString());
			this.attente.add(p);
			p.addEnAttente(this);
		}		
	}
	/**
	 * Enleve une personne de la liste d'attente. Notifie la 
	 * personne suivante de la liste d'attente qu'on lui prête le livre
	 * @param personne
	 * @throws RemoteException
	 */
	@Override
	public synchronized void enleveFromAttente(Personne p) throws RemoteException {
		if(attente.contains(p)){
			this.attente.remove(p);
			p.delEnAttente(this);
		}
	}
	@Override
	public synchronized void passerAuSuivant(Personne p) throws RemoteException {
		this.attente.remove(p);
		p.addLivre(this);
		p.notification(this);
	}

	@Override
	public String toString() {
		return "Livre [ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}

	@Override
	public String remoteToString() throws RemoteException{
		return "Livre [ID=" + numero + ", ISBN=" + isbn + ", titre=" + titre + ", auteur="
				+ auteur + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreImpl))
			return false;
		LivreImpl temp = (LivreImpl) obj;
		return temp.auteur==auteur&&temp.isbn==isbn&&temp.titre==titre&&temp.numero==numero;
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
	public long getNumero() throws RemoteException  {
		return numero;
	}
	@Override
	public void setNumero(long numero) throws RemoteException  {
		this.numero = numero;
	}
	@Override
	public String getIsbn() throws RemoteException {
		return isbn;
	}
	@Override
	public void setIsbn(String isbn) throws RemoteException {
		this.isbn=isbn;
	}
	@Override
	public List<String> getCommentaires() throws RemoteException  {
		return commentaires;
	}
	@Override
	public void addCommentaire(String commentaire) throws RemoteException  {
		this.commentaires.add(commentaire);
	}
	@Override
	public boolean isDisponible() throws RemoteException  {
		return disponible;
	}
	@Override
	public void setDisponible(boolean disponible) throws RemoteException  {
		this.disponible = disponible;
	}

}
