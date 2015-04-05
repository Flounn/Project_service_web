package fr.dauphine.main;

import java.util.ArrayList;
import java.util.List;

import fr.dauphine.bibliotheque.LivreService;

public final class Panier {
	
	private static List<LivreService> panier = new ArrayList<LivreService>();
	private static String devise = "EUR";
	
	/**
	 * @return the panier
	 */
	public final static List<LivreService> getLivres() {
		return panier;
	}

	/**
	 * @param panier the livre to add
	 */
	public final static void addLivres(LivreService livre) {
		panier.add(livre);
	}

	/**
	 * @param panier the livre to remove
	 */
	public final static void removeLivres(LivreService livre) {
		panier.remove(livre);
	}

	/**
	 * @param panier the livre to remove
	 */
	public final static void removeLivres(int index) {
		panier.remove(index);
	}

	public final static double getTotalPanier(){
		double result = 0;
		for (LivreService livre : panier)
			result+=livre.getPrixEuros();
		return result;
	}

	/**
	 * @return the devise
	 */
	public final static String getDevise() {
		return devise;
	}

	/**
	 * @param devise the devise to set
	 */
	public final static void setDevise(String devise) {
		Panier.devise = devise;
	}
	
	public final static void vider(){
		panier = new ArrayList<LivreService>();
	}

	public final static void valider(){
		if (panier.isEmpty())
			return;
		ConnexionWebServices.validerPanier(panier);
		panier.clear();
	}
	
	public final static double getPrixDevise(double prixEuro){
		if (prixEuro==0)
			return 0;
		return ConnexionWebServices.getPrixDevise(devise, prixEuro);
	}
	
}
