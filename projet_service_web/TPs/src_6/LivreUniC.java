import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class LivreUniC extends UnicastRemoteObject implements LivreUni{

	protected LivreUniC() throws RemoteException {
		super();
	}
	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", ISBN=" + ISBN + ", auteur="
				+ auteur + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof LivreUni))
			return false;
		LivreUni temp = (LivreUni) obj;
		try {
			return temp.getAuteur()==auteur&&temp.getISBN()==ISBN&&temp.getTitre()==titre;
		} catch (RemoteException e) {
			return false;
		}
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
