package Vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.CadeteController;
import Controllers.MainController;

public class PerfilUsuario extends JPanel {
	private JTextField campoNombre;
	private JTextField campoId;
	private JTextField campoApellidos;
	private JTextField campoEdad;
	private JTextField campoNacionalidad;
	private CadeteController cc;
	private Principal principal;
	private PerfilEquipo panelEquipo;

	public PerfilUsuario() {
		setBounds(100, 100, 450, 350);
		setLayout(null);
		
		cc = new CadeteController();
		
		etiquetas();
		camposDatos();
		boton();
		//volcadoDatos();
	}
	
	//JLabels del panel Usuario.
	public void etiquetas(){
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(197, 21, 71, 29);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(359, 21, 40, 29);
		add(lblId);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(197, 75, 79, 29);
		add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(197, 132, 54, 29);
		add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(197, 184, 110, 29);
		add(lblNacionalidad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PerfilUsuario.class.getResource("/img/yo.jpg")));
		lblNewLabel.setBounds(43, 35, 125, 123);
		add(lblNewLabel);
	}
	
	//JTextField de panel usuarios
	public void camposDatos(){
		campoNombre = new JTextField();
		campoNombre.setEditable(false);
		campoNombre.setBounds(197, 47, 143, 28);
		add(campoNombre);
		campoNombre.setColumns(10);
				
		campoId = new JTextField();
		campoId.setEditable(false);
		campoId.setBounds(352, 47, 61, 28);
		add(campoId);
		campoId.setColumns(10);
		
		campoApellidos = new JTextField();
		campoApellidos.setEditable(false);
		campoApellidos.setBounds(197, 103, 143, 28);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		campoEdad = new JTextField();
		campoEdad.setEditable(false);
		campoEdad.setBounds(197, 156, 143, 28);
		add(campoEdad);
		campoEdad.setColumns(10);
		
		campoNacionalidad = new JTextField();
		campoNacionalidad.setEditable(false);
		campoNacionalidad.setBounds(197, 211, 143, 28);
		add(campoNacionalidad);
		campoNacionalidad.setColumns(10);
	}
	
	public void boton(){
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) principal.getContentPane().getLayout();
				layout.show(principal, "panelEquipo");
			}
		});
		btnSiguiente.setBounds(296, 253, 117, 29);
		add(btnSiguiente);
	}
	
	public void volcadoDatos(){
		campoNombre.setText(cc.getCadete().getNombre());
		campoApellidos.setText(cc.getCadete().getApellidos());
		campoEdad.setText(String.valueOf(cc.getCadete().getEdad()));
		campoId.setText(String.valueOf(cc.getCadete().getId()));
		campoNacionalidad.setText(cc.getCadete().getNacionalidad());
	}
}
