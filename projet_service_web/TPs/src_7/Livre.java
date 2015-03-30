import java.io.Serializable;


public class Livre implements Serializable{
	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", ISBN=" + ISBN + ", auteur="
				+ auteur + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof Livre))
			return false;
		Livre temp = (Livre) obj;
		return temp.auteur==auteur&&temp.ISBN==ISBN&&temp.titre==titre;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the iSBN
	 */
	public long getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	private String titre;
	private long ISBN;
	private String auteur;
}
