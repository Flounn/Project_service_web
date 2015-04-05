package fr.dauphine.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import fr.dauphine.interfaces.Observable;

public class ObservableImpl extends UnicastRemoteObject implements Observable{

	private static final long serialVersionUID = 1L;

	public ObservableImpl() throws RemoteException {
		super();
	}

	@Override
	public void newNotification() throws RemoteException {
		String lastMessage = Session.getPersonne().getNotifications()[Session.getPersonne().getNotifications().length-1];
		JOptionPane.showMessageDialog(null, lastMessage);
	}

	@Override
	public long getIdPersonne() throws RemoteException {
		return Session.getPersonne().getId();
	}

}