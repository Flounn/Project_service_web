/**
 * BibliothequeImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.bibliotheque;

public interface BibliothequeImplService extends javax.xml.rpc.Service {
    public java.lang.String getBibliothequeImplAddress();

    public fr.dauphine.bibliotheque.BibliothequeImpl getBibliothequeImpl() throws javax.xml.rpc.ServiceException;

    public fr.dauphine.bibliotheque.BibliothequeImpl getBibliothequeImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
