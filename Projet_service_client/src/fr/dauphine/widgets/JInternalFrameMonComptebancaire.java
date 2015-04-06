package fr.dauphine.widgets;

import javax.swing.JInternalFrame;

import fr.dauphine.main.CompteBancaire;
import fr.dauphine.main.Panier;
import fr.dauphine.models.ComboBoxModelDevise;
import fr.dauphine.vues.AccueilExterne;
import fr.dauphine.vues.ConnexionOk;
import fr.dauphine.vues.JPanelConnexion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;


/** 
 * @author Flo
 */

public class JInternalFrameMonComptebancaire extends JInternalFrame implements ConnexionOk{

	private static final long serialVersionUID = 1L;
	private final String nom = " Mon Compte bancaire";
	private ActionListener ActionListenerModifierCompte;
	private ActionListener ActionListenerDepot;
	private JTextField txt_prenom;
	private JTextField txt_nom;
	private JTextField txt_montant;
	private JComboBox<String> comboBoxDevises;
	private JLabel lbl_solde;
	
	public JInternalFrameMonComptebancaire(){
		initListeners();
		setClosable(true);
		setTitle(nom);
		setFrameIcon(null);
		if (CompteBancaire.isConnected())
			initUI();
		else
			initUISeConnecter();
		setVisible(true);
	}
		
	private void initUISeConnecter() {
		getContentPane().setLayout(new BorderLayout());
		JPanel pane = new JPanelConnexion(JPanelConnexion.COMPTE_BANCAIRE,this);
		getContentPane().add(pane, BorderLayout.CENTER);		
	}

	private void initListeners() {
		ActionListenerModifierCompte = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = txt_nom.getText();
				String prenom = txt_prenom.getText();
				String devise = (String) comboBoxDevises.getSelectedItem();
				if (nom.isEmpty()||prenom.isEmpty()||devise.isEmpty())
					return;
				CompteBancaire.modifier(nom, prenom, devise);
				majSolde();
				majDevise();
			}
			
		};
		ActionListenerDepot = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					double montant = Double.parseDouble(txt_montant.getText());
					if (montant<=0){
						txt_montant.setText(null);
						return;
					}
					CompteBancaire.depot(montant);
					txt_montant.setText(null);
					majSolde();
				}
				catch (NumberFormatException exp){}
				
			}
			
		};
	}

	private void initUI(){
	
		JLabel lblNewLabel = new JLabel("Nom :");
		
		JLabel lblPrenom = new JLabel("Prenom :");
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe :");
		
		JTextField txt_mdp = new JTextField();
		txt_mdp.setEditable(false);
		txt_mdp.setColumns(10);
		
		JTextField txt_email = new JTextField();
		txt_email.setEditable(false);
		txt_email.setColumns(10);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		
		txt_nom = new JTextField();
		txt_nom.setColumns(10);

		txt_nom.setText(CompteBancaire.getCompte().getNom());
		txt_prenom.setText(CompteBancaire.getCompte().getPrenom());
		txt_email.setText(CompteBancaire.getCompte().getEmail());
		txt_mdp.setText(CompteBancaire.getCompte().getMdp());
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(ActionListenerModifierCompte);
		
		JLabel lblDevise = new JLabel("Devise :");
		
		comboBoxDevises = new JComboBox<String>(new ComboBoxModelDevise(CompteBancaire.getCompte().getDevise()));
		
		JLabel lblSolde = new JLabel("Solde :");
		
		lbl_solde = new JLabel();
		majSolde();
		JLabel lblNewLabel_4 = new JLabel("Depot :");
		
		txt_montant = new JTextField();
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(ActionListenerDepot);
		
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
								.addComponent(lblNewLabel)
								.addComponent(lblDevise))
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxDevises, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_nom, Alignment.LEADING)
								.addComponent(txt_prenom, Alignment.LEADING)
								.addComponent(txt_email, Alignment.LEADING)
								.addComponent(txt_mdp, Alignment.LEADING))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblSolde))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_solde)
								.addComponent(txt_montant, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(btnNewButton)
							.addGap(115)
							.addComponent(btnValider)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
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
							.addGap(8))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSolde)
								.addComponent(lbl_solde))
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDevise)
						.addComponent(comboBoxDevises, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txt_montant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnValider))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	@Override
	public void connexionOk() {
		Panier.setDevise(CompteBancaire.getCompte().getDevise());
		((AccueilExterne)getParent().getParent().getParent()).changerDevise(true);
		getContentPane().removeAll();
		initUI();
		validate();
	}
	
	private void majDevise(){
		comboBoxDevises.setSelectedItem(CompteBancaire.getCompte().getDevise());
	}
	private void majSolde(){
		lbl_solde.setText(CompteBancaire.getSolde()+" ("+CompteBancaire.getCompte().getDevise()+")");
	}
}