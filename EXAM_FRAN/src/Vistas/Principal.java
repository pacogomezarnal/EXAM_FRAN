package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private PerfilUsuario pu;
	private PerfilEquipo pe;
	private Comprobacion comp;

	public Principal() {
		setTitle("THE LABY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		pu = new PerfilUsuario();
		pe = new PerfilEquipo();
		comp = new Comprobacion();
		
		this.getContentPane().add(pu, "PerfilUsuario");
		this.getContentPane().add(pe, "PerfilEquipo");
		this.getContentPane().add(comp, "Comprobacion");
	}

}
