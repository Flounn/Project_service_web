/**
 * BibliothequeImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.bibliotheque;

public interface BibliothequeImpl extends java.rmi.Remote {
    public boolean acheter(long[] livres) throws java.rmi.RemoteException;
    public fr.dauphine.bibliotheque.LivreService[] getLivresCanSell() throws java.rmi.RemoteException;
}
