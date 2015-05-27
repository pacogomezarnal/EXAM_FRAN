package Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Model.IngresoLaby;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comprobacion extends JPanel {
	private JTextField campoId;
	private JTextField textField;
	private JTextField campoMensaje;
	private IngresoLaby ingreso;

	public Comprobacion() {
		setBounds(100, 100, 450, 350);
		setLayout(null);
		
		etiquetas();
		botones();
		campoDatos();

	}
	
	public void etiquetas(){
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(18, 22, 66, 27);
		add(lblId);
		
		JLabel lblerApellido = new JLabel("1er Apellido:");
		lblerApellido.setBounds(111, 22, 107, 27);
		add(lblerApellido);
	}
	
	public void campoDatos(){
		campoId = new JTextField();
		campoId.setBounds(18, 49, 77, 27);
		add(campoId);
		campoId.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(111, 49, 134, 27);
		add(textField);
		textField.setColumns(10);
		
		campoMensaje = new JTextField();
		campoMensaje.setEditable(false);
		campoMensaje.setBounds(18, 157, 411, 27);
		add(campoMensaje);
		campoMensaje.setColumns(10);
	}
	
	public void botones(){
		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingreso.checkCod(26, "Primo");
			}
		});
		btnComprobar.setBounds(18, 122, 411, 29);
		add(btnComprobar);
		
		JButton button = new JButton("<< Atras");
		button.setBounds(18, 245, 117, 29);
		add(button);
	}

}
