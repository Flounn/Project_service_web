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

}
