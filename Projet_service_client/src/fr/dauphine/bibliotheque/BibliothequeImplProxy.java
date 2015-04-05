package fr.dauphine.bibliotheque;

public class BibliothequeImplProxy implements fr.dauphine.bibliotheque.BibliothequeImpl {
  private String _endpoint = null;
  private fr.dauphine.bibliotheque.BibliothequeImpl bibliothequeImpl = null;
  
  public BibliothequeImplProxy() {
    _initBibliothequeImplProxy();
  }
  
  public BibliothequeImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initBibliothequeImplProxy();
  }
  
  private void _initBibliothequeImplProxy() {
    try {
      bibliothequeImpl = (new fr.dauphine.bibliotheque.BibliothequeImplServiceLocator()).getBibliothequeImpl();
      if (bibliothequeImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bibliothequeImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bibliothequeImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bibliothequeImpl != null)
      ((javax.xml.rpc.Stub)bibliothequeImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.dauphine.bibliotheque.BibliothequeImpl getBibliothequeImpl() {
    if (bibliothequeImpl == null)
      _initBibliothequeImplProxy();
    return bibliothequeImpl;
  }
  
  public boolean acheter(long[] livres) throws java.rmi.RemoteException{
    if (bibliothequeImpl == null)
      _initBibliothequeImplProxy();
    return bibliothequeImpl.acheter(livres);
  }
  
  public fr.dauphine.bibliotheque.LivreService[] getLivresCanSell() throws java.rmi.RemoteException{
    if (bibliothequeImpl == null)
      _initBibliothequeImplProxy();
    return bibliothequeImpl.getLivresCanSell();
  }
  
  
}