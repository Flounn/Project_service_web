package fr.dauphine.main;

import fr.dauphine.banque.Compte;

public final class CompteBancaire {
	
	private static Compte compte;

	/**
	 * @return the compte
	 */
	public final static Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public final static boolean seConnecter(String email, String mdp) {
		compte = ConnexionWebServices.getCompteBancaire(email, mdp);
		if (compte!=null)
			return true;
		return false;
	}
	
	public final static boolean isConnected(){
		return compte!=null;
	}
	
	public final static boolean retrait(double montant){
		return ConnexionWebServices.retrait(compte.getEmail(), compte.getMdp(), montant)==1;
	}
	
	public final static boolean depot(double montant){
		return ConnexionWebServices.depot(compte.getEmail(), compte.getMdp(), montant);
	}
	
	public final static double getSolde(){
		compte.setSolde(ConnexionWebServices.getSolde(compte.getEmail(), compte.getMdp()));
		return compte.getSolde();
	}

	public final static void seDeconnecter(){
		compte=null;
	}
	
	public final static void modifier(String nom, String prenom, String devise){
		if (ConnexionWebServices.modifierCompteBancaire(nom, prenom,compte.getEmail(),compte.getMdp(), devise)){
			compte.setDevise(devise);
			compte.setNom(nom);
			compte.setPrenom(prenom);
		}
			
	}
	
}
