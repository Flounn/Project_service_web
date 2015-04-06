package fr.dauphine.vues;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import fr.dauphine.main.Panier;
import fr.dauphine.models.ComboBoxModelDevise;
import fr.dauphine.models.TableModelLivresVentes;
import fr.dauphine.widgets.JInternalFrameGestionBO;
import fr.dauphine.widgets.JInternalFrameMonComptebancaire;

import javax.swing.JLabel;


public class MenuAccueilExterne extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private ActionListener ActionListenerLivres;
	private ActionListener ActionListenerCompte;
	
	private JMenu menuLivre = new JMenu("Livre");
	private JMenu menuCompte = new JMenu("Compte");
	private JMenuItem menuVoirLivre = new JMenuItem("Voir Livres");
	private JMenuItem menuMonCompte = new JMenuItem("Mon Compte");
	private JMenu menuAide = new JMenu("Aide");
	private ItemListener changerDevise;
	private JComboBox<String> comboBoxDevises;
	private final ListenerDevise listenerDevise;
	
	public MenuAccueilExterne(ListenerDevise listener){
		listenerDevise=listener;
		initUI();
	}


	private void initUI() {
		add(menuLivre);
		add(menuCompte);
		add(menuAide);
		initListeners();
		menuLivre.add(menuVoirLivre);
		menuCompte.add(menuMonCompte);
		
		menuVoirLivre.setName("Livres");

		menuVoirLivre.addActionListener(ActionListenerLivres);
		menuMonCompte.addActionListener(ActionListenerCompte);
		initListeners();
		initCombobox();

	}

	private void initCombobox() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);

		comboBoxDevises = new JComboBox<String>(new ComboBoxModelDevise());

		JLabel label = new JLabel("Devise : ");
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(81, Short.MAX_VALUE)
						.addComponent(label)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(comboBoxDevises, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addGap(98))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxDevises, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);

		comboBoxDevises.addItemListener(changerDevise);

	}


	private void initListeners() {

		changerDevise = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					Panier.setDevise((String) comboBoxDevises.getSelectedItem());
				listenerDevise.changerDevise(false);
			}  
		};
		
		ActionListenerLivres = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
						
					JInternalFrame test = new JInternalFrameGestionBO("Livres",new TableModelLivresVentes());
					getParent().add(test);
					try {
						test.setMaximum(true);
					} catch (PropertyVetoException e) {e.printStackTrace();}
					
			}
		};
		
		ActionListenerCompte = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JInternalFrame test = new JInternalFrameMonComptebancaire();
				getParent().add(test);
				try {
					test.setMaximum(true);
				} catch (PropertyVetoException exp) {exp.printStackTrace();}
				
			}
		};
		
		
	}
	
	public void modifierDevise(){
		comboBoxDevises.setSelectedItem(Panier.getDevise());
	}


}