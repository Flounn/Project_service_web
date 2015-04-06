package fr.dauphine.banque;

public class BanqueProxy implements fr.dauphine.banque.Banque {
  private String _endpoint = null;
  private fr.dauphine.banque.Banque banque = null;
  
  public BanqueProxy() {
    _initBanqueProxy();
  }
  
  public BanqueProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueProxy();
  }
  
  private void _initBanqueProxy() {
    try {
      banque = (new fr.dauphine.banque.BanqueServiceLocator()).getBanque();
      if (banque != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banque)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banque != null)
      ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.dauphine.banque.Banque getBanque() {
    if (banque == null)
      _initBanqueProxy();
    return banque;
  }
  
  public boolean addCompte(java.lang.String nom, java.lang.String prenom, java.lang.String email, java.lang.String mdp, java.lang.String devise) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.addCompte(nom, prenom, email, mdp, devise);
  }
  
  public boolean depot(java.lang.String email, java.lang.String mdp, double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.depot(email, mdp, montant);
  }
  
  public int retraitEur(java.lang.String email, java.lang.String mdp, double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.retraitEur(email, mdp, montant);
  }
  
  public double consultSolde(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.consultSolde(email, mdp);
  }
  
  public java.lang.String consultDevise(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.consultDevise(email, mdp);
  }
  
  public boolean delCompte(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.delCompte(email, mdp);
  }
  
  public fr.dauphine.banque.Compte getCompte(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.getCompte(email, mdp);
  }
  
  
}