package fr.dauphine.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.dauphine.bibliotheque.BibliothequeImpl;
import fr.dauphine.bibliotheque.BibliothequeImplServiceLocator;
import fr.dauphine.bibliotheque.LivreService;

public final class ConnexionWebServices {
	
	public static final List<LivreService> getLivresCanSell(){

		try {
			BibliothequeImpl b = new BibliothequeImplServiceLocator().getBibliothequeImpl();
			return Arrays.asList(b.getLivresCanSell()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<LivreService>();

	}
	
	public static final boolean validerPanier(List<LivreService> livres){

		try {
			BibliothequeImpl b = new BibliothequeImplServiceLocator().getBibliothequeImpl();
			long[] tab = new long[livres.size()];
			for (int i=0;i<tab.length;i++)
				tab[i]=livres.get(i).getNumero();
			return b.acheter(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
