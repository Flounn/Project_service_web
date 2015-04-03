package fr.dauphine.banque;
import java.io.Serializable;


public class Compte implements Serializable{
	
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private double solde;
	private String devise;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private long noCompte;
	
	
	public Compte() {
		super();
	}
	public Compte(String nom, String prenom, String email, String mdp,
			long noCompte, String devise) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.devise = devise;
		this.noCompte = noCompte;
		this.solde=0;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public long getNoCompte() {
		return noCompte;
	}
	public void setNoCompte(long noCompte) {
		this.noCompte = noCompte;
	}
	@Override
	public String toString() {
		return "Compte [ID=" + noCompte + ", nom=" + nom + ", prenom=" 
				+ prenom + ", noCompte=" + noCompte + ", devise=" + devise + "]";
	}
}
