import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PersonneImpl extends UnicastRemoteObject implements Personne {

	private static final long serialVersionUID = 1L;
	long id;
	String nom;
	String prenom;
	String role;
	/**
	 * Les livres empruntés
	 */
	List<LivreImpl> livres;
	
	public PersonneImpl() throws RemoteException {
		super();
		livres = new ArrayList<LivreImpl>();
	}

	public PersonneImpl(long id, String role, String nom, String prenom) throws RemoteException {
		super();
		this.id = id; 
		this.role = role; 
		this.nom = nom;
		this.prenom = prenom;
		livres = new ArrayList<LivreImpl>();
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
	 * @return livres. La liste des livres empruntés
	 * @throws RemoteException
	 */
	@Override
	public List<LivreImpl> getLivres() throws RemoteException  {
		return livres;
	}
	/**
	 * Rajoute un livre à liste des livres empruntés
	 * @throws RemoteException
	 */
	/*@Override
	public void addLivre(LivreImpl livre) throws RemoteException  {
		this.livres.add(livre);
	}*/
	/**
	 * Enlève un livre de liste des livres empruntés. Appelle la methode qui 
	 * prête le livre à la personne suivante sur la liste d'attente.
	 * @throws RemoteException
	 */
	/*@Override
	public void returnLivre(LivreImpl livre) throws RemoteException  {
		this.livres.remove(livre);
		if(livre.getAttente()!=null)
			livre.enleveFromAttente(livre.getAttente().get(0));
	}*/
	/**
	 * Notifie une personne que le livre souhaité est disponible et lui a été prété.
	 * @param livre
	 * @throws RemoteException
	 */
	/*@Override
	public void notification(LivreImpl livre) throws RemoteException {
		System.out.println(livre.toString() + " est désormais disponible "
				+ "et vous attend. N'oubliez pas de venir le chercher");
	}*/
	
}
