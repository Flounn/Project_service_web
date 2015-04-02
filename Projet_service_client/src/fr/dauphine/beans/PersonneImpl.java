package fr.dauphine.beans;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;

public class PersonneImpl extends UnicastRemoteObject implements Personne {

	private static final long serialVersionUID = 1L;
	protected long id;
	protected String nom;
	protected String prenom;
	protected String role;
	protected String email;
	protected String mdp;
	protected List<String> notifications;
	protected List<Livre> enAttente;


	/**
	 * Les livres empruntes
	 */
	protected List<Livre> livres;
	
	public PersonneImpl() throws RemoteException {
		super();
		livres = new ArrayList<Livre>();
		notifications = new ArrayList<String>();
		enAttente = new ArrayList<Livre>();
	}

	public PersonneImpl(String role, String nom, String prenom, String email, String mdp) throws RemoteException {
		super();
		this.id = 0; 
		this.role = role; 
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		livres = new ArrayList<Livre>();
		notifications = new ArrayList<String>();
		enAttente = new ArrayList<Livre>();
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
	public String remoteToString() throws RemoteException {
		return "Personne [Id=" + id + ", Role="
				+ role +  ", Nom=" + nom + ", Prenom=" + prenom + "]";
	}
	@Override
	public boolean remoteEquals(Object obj) throws RemoteException {
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
	@Override
	public String getEmail() throws RemoteException  {
		return email;
	}
	@Override
	public void setEmail(String email) throws RemoteException  {
		this.email = email;
	}
	@Override
	public String getMdp() throws RemoteException  {
		return mdp;
	}
	@Override
	public void setMdp(String mdp) throws RemoteException  {
		this.mdp = mdp;
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
	 * Rajoute un livre a liste des livres empruntes si celui-ci est disponible
	 * @throws RemoteException
	 */
	@Override
	public void addLivre(Livre livre) throws RemoteException  {
		if(livre.isDisponible()){
			System.out.println(livre.remoteToString() + " a ete emprunte par " 
					+ this.remoteToString());
			this.livres.add(livre);
			livre.setDisponible(false);
			livre.setCompteurPrets(livre.getCompteurPrets()+1);
		} else {
			System.out.println(livre.remoteToString() + 
					" n'est pas disponible est ne peut pas etre emprunté");
		}
		
	}
	/**
	 * Enlève un livre de liste des livres empruntees. Appelle la methode qui 
	 * prête le livre a� la personne suivante sur la liste d'attente.
	 * @throws RemoteException
	 */
	@Override
	public void returnLivre(Livre livre) throws RemoteException  {
		this.livres.remove(livre);
		System.out.println(livre.remoteToString() + " a ete retourne par " 
				+ this.remoteToString());
		livre.setDisponible(true);
		if(livre.getAttente()!=null)
			livre.passerAuSuivant(livre.getAttente().get(0));
	}

	/**
	 * Notifie une personne que le livre souhaite est disponible et lui a ete prete.
	 * @param livre
	 * @throws RemoteException
	 */
	@Override
	public void notification(Livre livre) throws RemoteException {
		String notification = livre.remoteToString() + " est desormais disponible "
				+ "et vous attend. N'oubliez pas de venir le chercher";
		System.out.println(notification);
		this.addNotification(notification);
	}
	@Override
	public List<String> getNotifications() throws RemoteException {
		return notifications;
	}
	@Override
	public void addNotification(String notification) throws RemoteException {
		this.notifications.add(notification);
	}
	@Override
	public void delNotification(int i) throws RemoteException {
		this.notifications.remove(i);
	}
	@Override
	public void delAllNotifications() throws RemoteException {
		this.notifications.clear();
	}
	@Override
	public List<Livre> getEnAttente() throws RemoteException {
		return enAttente;
	}
	@Override
	public void addEnAttente(Livre l) throws RemoteException {
		System.out.println(l.remoteToString() + " a ete rajoute a la liste d'attente");
		this.enAttente.add(l);
	}
	@Override
	public void delEnAttente(Livre l) throws RemoteException {
		System.out.println(l.remoteToString() + " a ete enleve de la liste d'attente");
		this.enAttente.remove(l);
	}
	@Override
	public void delAllEnAttente() throws RemoteException {
		this.enAttente.clear();
	}
	
}
