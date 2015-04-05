package fr.dauphine.main;

import java.util.ArrayList;
import java.util.List;

import fr.dauphine.bibliotheque.LivreService;

public final class Panier {
	
	private static List<LivreService> panier = new ArrayList<LivreService>();
	
	/**
	 * @return the panier
	 */
	public static List<LivreService> getLivres() {
		return panier;
	}

	/**
	 * @param panier the livre to add
	 */
	public static void addLivres(LivreService livre) {
		panier.add(livre);
	}

	/**
	 * @param panier the livre to remove
	 */
	public static void removeLivres(LivreService livre) {
		panier.remove(livre);
	}

	/**
	 * @param panier the livre to remove
	 */
	public static void removeLivres(int index) {
		panier.remove(index);
	}

	public static double getTotalPanier(){
		double result = 0;
		for (LivreService livre : panier)
			result+=livre.getPrixEuros();
		return result;
	}

}
