import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PersonneImpl extends UnicastRemoteObject implements Personne {

	private static final long serialVersionUID = 1L;
	protected long id;
	protected String nom;
	protected String prenom;
	protected String role;
	/**
	 * Les livres empruntes
	 */
	protected List<Livre> livres;
	
	public PersonneImpl() throws RemoteException {
		super();
		livres = new ArrayList<Livre>();
	}

	public PersonneImpl(long id, String role, String nom, String prenom) throws RemoteException {
		super();
		this.id = id; 
		this.role = role; 
		this.nom = nom;
		this.prenom = prenom;
		livres = new ArrayList<Livre>();
	}
	
	@Override
	public String toString() {
		return "Personne [Id=" + id + ", Role="
				+ role +  ", Nom=" + nom + ", Prenom=" + prenom + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof PersonneImpl))
			return false;
		PersonneImpl temp = (PersonneImpl) obj;
		return temp.id==id&&temp.role==role&&temp.nom==nom&&temp.prenom==prenom;
	}
	@Override
	public String getNom() throws RemoteException {
		return nom;
	}
	@Override
	public void setNom(String nom) throws RemoteException {
		this.nom = nom;
	}
	@Override
	public String getPrenom() throws RemoteException {
		return prenom;
	}
	@Override
	public void setPrenom(String prenom) throws RemoteException {
		this.prenom = prenom;
		
	}
	@Override
	public String getRole() throws RemoteException {
		return role;
	}
	@Override
	public void setRole(String role) throws RemoteException {
		this.role = role;
	}
	@Override
	public long getId() throws RemoteException {
		return id;
	}
	@Override
	public void setId(long id) throws RemoteException {
		this.id=id;
	}
	
	/**
	 * 
	 * @return livres. La liste des livres empruntes
	 * @throws RemoteException
	 */
	@Override
	public List<Livre> getLivres() throws RemoteException  {
		return livres;
	}
	/**
	 * Rajoute un livre a  liste des livres empruntes
	 * @throws RemoteException
	 */
	@Override
	public void addLivre(Livre livre) throws RemoteException  {
		this.livres.add(livre);
	}
	/**
	 * EnlÃ¨ve un livre de liste des livres empruntees. Appelle la methode qui 
	 * prÃªte le livre a  la personne suivante sur la liste d'attente.
	 * @throws RemoteException
	 */
	@Override
	public void returnLivre(Livre livre) throws RemoteException  {
		this.livres.remove(livre);
		if(livre.getAttente()!=null)
			livre.enleveFromAttente(livre.getAttente().get(0));
	}

	/**
	 * Notifie une personne que le livre souhaite est disponible et lui a ete prete.
	 * @param livre
	 * @throws RemoteException
	 */
	@Override
	public void notification(Livre livre) throws RemoteException {
		System.out.println(livre.remoteToString() + " est desormais disponible "
				+ "et vous attend. N'oubliez pas de venir le chercher");
		
	}
	
}
