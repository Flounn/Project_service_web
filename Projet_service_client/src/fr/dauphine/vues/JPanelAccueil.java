package fr.dauphine.vues;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JPanelAccueil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JPanelAccueil(){
		
		JLabel lblNewLabel = new JLabel("TEST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);
		initUi();
	}

	private void initUi() {
	
		
	}

}
