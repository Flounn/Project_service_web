/**
 * Banque.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.banque;

public interface Banque extends java.rmi.Remote {
    public boolean modifierCompte(java.lang.String email, java.lang.String mdp, java.lang.String nom, java.lang.String prenom, java.lang.String devise) throws java.rmi.RemoteException;
    public boolean depot(java.lang.String email, java.lang.String mdp, double montant) throws java.rmi.RemoteException;
    public fr.dauphine.banque.Compte getCompte(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException;
    public boolean delCompte(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException;
    public boolean addCompte(java.lang.String nom, java.lang.String prenom, java.lang.String email, java.lang.String mdp, java.lang.String devise) throws java.rmi.RemoteException;
    public int retraitEur(java.lang.String email, java.lang.String mdp, double montant) throws java.rmi.RemoteException;
    public double consultSolde(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException;
    public java.lang.String consultDevise(java.lang.String email, java.lang.String mdp) throws java.rmi.RemoteException;
}
