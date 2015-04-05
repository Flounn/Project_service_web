package fr.dauphine.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import fr.dauphine.widgets.SelectionListener;


public class IHM extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txt_titre;
	private JTextField txt_auteur;
	private JTextField txt_isbn;
	private JButton btnAjouter;
	private JTextField txt_prix;
	private final SelectionListener callback;
	
	public IHM(SelectionListener callback) {
		super();
		this.callback=callback;
		this.setSize(800, 600);
		this.setTitle("Bibliotheque");

		txt_titre = new JTextField();
		txt_titre.setColumns(10);

		JLabel lblTitre = new JLabel("Titre : ");

		txt_auteur = new JTextField();
		txt_auteur.setColumns(10);

		txt_isbn = new JTextField();
		txt_isbn.setColumns(10);

		JLabel lblAuteur = new JLabel("Auteur : ");

		JLabel lblIsbn = new JLabel("ISBN : ");

		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);

		txt_prix = new JTextField();
		txt_prix.setColumns(10);

		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setLabelFor(txt_prix);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(16)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblTitre)
																.addComponent(lblAuteur, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
																.addGap(4))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblIsbn)
																		.addGap(20))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(lblPrix, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)))
																				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(txt_isbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addComponent(txt_titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addComponent(txt_auteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addComponent(txt_prix, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
																						.addGroup(groupLayout.createSequentialGroup()
																								.addGap(30)
																								.addComponent(btnAjouter)))
																								.addContainerGap(625, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitre))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAuteur)
										.addComponent(txt_auteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_isbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblIsbn))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(txt_prix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrix))
														.addGap(9)
														.addComponent(btnAjouter)
														.addContainerGap(392, Short.MAX_VALUE))
				);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (Connexion.addLivre(txt_isbn.getText(), txt_auteur.getText(), txt_titre.getText(), Double.parseDouble(txt_prix.getText()))){
			System.out.println("livre ajoute");
			this.dispose();
			//callback.selectionLigne(null);
		}
		else
			System.out.println("erreur!");

	}
}
