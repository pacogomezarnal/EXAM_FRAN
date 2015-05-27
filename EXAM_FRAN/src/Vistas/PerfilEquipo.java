package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.CadeteController;
import Model.Cadete;

public class PerfilEquipo extends JPanel {
	private JTextField campoNombre;
	private JTextField campoId;
	private JTextField campo1apellido;
	private JTextField campo2apellido;
	private JTextField campoNacionalidad;
	private JComboBox comboBox;
	private CadeteController cc;
	private Cadete cadeteSelected;
	private Principal principal;

	public PerfilEquipo() {
		setBounds(100, 100, 450, 350);
		setLayout(null);
		
		
		etiquetas();
		campoDatos();
		comboBox();
		botones();
		//vuelcaDatos();

	}
	
	public void etiquetas(){
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(17, 26, 78, 24);
		add(lblEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(177, 26, 78, 24);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(329, 26, 56, 24);
		add(lblId);
		
		JLabel lblerApellido = new JLabel("1er Apellido:");
		lblerApellido.setBounds(177, 88, 106, 24);
		add(lblerApellido);
		
		JLabel lbldoApellido = new JLabel("2º Apellido:");
		lbldoApellido.setBounds(177, 150, 112, 24);
		add(lbldoApellido);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(177, 198, 112, 24);
		add(lblNacionalidad);
	}
	
	public void campoDatos(){
		campoNombre = new JTextField();
		campoNombre.setBounds(173, 49, 134, 27);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoId = new JTextField();
		campoId.setBounds(329, 49, 90, 27);
		add(campoId);
		campoId.setColumns(10);
		
		campo1apellido = new JTextField();
		campo1apellido.setBounds(173, 111, 134, 27);
		add(campo1apellido);
		campo1apellido.setColumns(10);
		
		campo2apellido = new JTextField();
		campo2apellido.setBounds(177, 171, 134, 27);
		add(campo2apellido);
		campo2apellido.setColumns(10);
		
		campoNacionalidad = new JTextField();
		campoNacionalidad.setBounds(177, 220, 134, 27);
		add(campoNacionalidad);
		campoNacionalidad.setColumns(10);
	}
	
	public void comboBox(){
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadeteSelected = cc.getCadete();
				vuelcaDatos();
			}
		});
		//reloadComboBox();
		comboBox.setBounds(17, 51, 121, 27);
		add(comboBox);
	}
	
	public void reloadComboBox(){
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(cc.getEquipo().toArray());
		comboBox.setModel(modelo);
		comboBox.repaint();
	}
	
	public void botones(){
		JButton button = new JButton("<< Atras");
		button.setBounds(17, 265, 117, 29);
		add(button);
		
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.setBounds(302, 265, 117, 29);
		add(btnSiguiente);
	}
	
	public void vuelcaDatos(){
		campoNombre.setText(cadeteSelected.getNombre());
		campoNacionalidad.setText(cadeteSelected.getNacionalidad());
	}
}
