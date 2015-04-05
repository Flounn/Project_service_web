package fr.dauphine.widgets;

import javax.swing.JInternalFrame;

import fr.dauphine.main.Session;
import fr.dauphine.models.TableModelNotifications;
import fr.dauphine.vues.JPanelLivresNotifications;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;


/** 
 * @author Flo
 */

public class JInternalFrameMonProfil extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	private final String nom = " Mon Profil";
	private ActionListener ActionListenerModifierProfil;
	private JTextField txt_mdp;
	private JTextField txt_email;
	private JTextField txt_prenom;
	private JTextField txt_nom;
	
	public JInternalFrameMonProfil(){
		initListeners();
		initUI();
	}
		
	private void initListeners() {
		ActionListenerModifierProfil = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = txt_nom.getText();
				String prenom = txt_prenom.getText();
				String email = txt_email.getText();
				String mdp = txt_mdp.getText();
				if (nom.isEmpty()||prenom.isEmpty()||email.isEmpty()||mdp.isEmpty())
					return;
				Session.modifierProfil(nom, prenom, email,mdp);
				
			}
			
		};
		
	}

	private void initUI(){
		setClosable(true);
		setTitle(nom);
		setFrameIcon(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		
		JLabel lblPrenom = new JLabel("Prenom :");
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe :");
		
		txt_mdp = new JTextField();
		txt_mdp.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		
		txt_nom = new JTextField();
		txt_nom.setColumns(10);
		try {
			txt_nom.setText(Session.getPersonne().getNom());
			txt_prenom.setText(Session.getPersonne().getPrenom());
			txt_email.setText(Session.getPersonne().getEmail());
			txt_mdp.setText(Session.getPersonne().getMdp());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(ActionListenerModifierProfil);
		
		JPanelLivresNotifications panel = new JPanelLivresNotifications();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblPrenom)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_mdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(btnNewButton)))
					.addGap(31)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txt_nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrenom)
								.addComponent(txt_prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(txt_mdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnNewButton)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
}