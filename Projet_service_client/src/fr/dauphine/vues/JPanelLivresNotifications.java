package fr.dauphine.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import fr.dauphine.models.AbstractLivresTableModel;
import fr.dauphine.models.TableModelNotifications;
import fr.dauphine.widgets.JTableLivres;

import javax.swing.LayoutStyle.ComponentPlacement;

public class JPanelLivresNotifications extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTableLivres notifications; 

	public JPanelLivresNotifications(){
		initUi();
	}
	private JLabel lblTitre;
	
	private void initUi(){
		
		JPanel panel_1 = new JPanel();

		lblTitre = new JLabel("Mes Notifications");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setForeground(new Color(255, 140, 0));
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 140, 0));
	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(lblTitre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		panel_1.setLayout(new BorderLayout());  
		
		notifications = new JTableLivres("Notification",new TableModelNotifications());  
		
		panel_1.add(new JScrollPane(notifications));
	}
	
	public void refreshJTable(){
		((AbstractLivresTableModel)notifications.getModel()).resfreshData();
	}

}
