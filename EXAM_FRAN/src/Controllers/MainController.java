package Controllers;

import javax.swing.JPanel;

import Vistas.Principal;

public class MainController {

	private Principal p;
	public MainController() {
		// TODO Auto-generated constructor stub
	}

	public void cambiaPanel(JPanel name){
		p.setVisible(false);
		p.setContentPane(name);
		p.setVisible(true);
	}
}
