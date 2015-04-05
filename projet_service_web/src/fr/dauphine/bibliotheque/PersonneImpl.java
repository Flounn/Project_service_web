package fr.dauphine.bibliotheque;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.dauphine.interfaces.Livre;
import fr.dauphine.interfaces.Personne;

public class PersonneImpl extends UnicastRemoteObject implements Personne {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private String prenom;
	private Role role;
	private String email;
	private String mdp;
	private List<String> notifications;
	private List<Livre> enAttente;
	private HashMap<Livre, Integer> notes = new HashMap<Livre, Integer>();
	private HashMap<Livre, String> commentaires = new HashMap<Livre, String>();


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

	public PersonneImpl(Role role, String nom, String prenom, String email, String mdp) throws RemoteException {
		super();
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
	public Role getRole() throws RemoteException {
		return role;
	}
	@Override
	public void setRole(Role role) throws RemoteException {
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
	public Livre[] getLivres() throws RemoteException  {
		return livres.toArray(new Livre[livres.size()]);
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
			this.enAttente.add(livre);
			livre.addToAttente(this);
			System.out.println(livre.remoteToString() + 
					" n'est pas disponible. Vous avez ete place sur la liste d'attente");
		}
		
	}
	/**
	 * Enlève un livre de liste des livres empruntees. Appelle la methode qui 
	 * prête le livre a la personne suivante sur la liste d'attente.
	 * @throws RemoteException
	 */
	@Override
	public void returnLivre(Livre livre) throws RemoteException  {
		this.livres.remove(livre);
		System.out.println(livre.remoteToString() + " a ete retourne par " 
				+ this.remoteToString());
		livre.passerAuSuivant();
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
	public String[] getNotifications() throws RemoteException {
		return notifications.toArray(new String[notifications.size()]);
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
	public Livre[] getEnAttente() throws RemoteException {
		return enAttente.toArray(new Livre[enAttente.size()]);
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

	@Override
	public void addNote(Livre livre, int note) throws RemoteException {
		notes.put(livre, note);
		livre.addNote(note);
	}

	@Override
	public void addCommentaire(Livre livre, String commentaire)
			throws RemoteException {
		commentaires.put(livre, commentaire);
		livre.addCommentaire(commentaire);
	}

	@Override
	public void addNoteAndCommentaire(Livre livre, int note, String commentaire)
			throws RemoteException {
		addNote(livre, note);
		addCommentaire(livre, commentaire);
	}

	@Override
	public Integer getNote(Livre livre) throws RemoteException {
		return notes.get(livre);
	}

	@Override
	public String getCommentaire(Livre livre) throws RemoteException {
		return commentaires.get(livre);
	}
	
	
	
	
}
