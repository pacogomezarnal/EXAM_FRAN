package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCadete {

	public ModeloCadete() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo que me devuelve el cadete con el id=26;
	public Cadete loadCadete(){
		ConexionDB conexion = ConexionDB.getInstance();
		int id = 26;
		ResultSet resultado = conexion.query("SELECT * FROM cadetes WHERE id='"+id+"';");
		
		Cadete cadete = null;
		try{
			if(resultado.next()){
				id = (int) resultado.getObject("id");
				String nombre = (String) resultado.getObject("nombre");
				String apellidos = (String) resultado.getObject("apellidos");
				int edad = (int) resultado.getObject("edad");
				String nacionalidad = (String) resultado.getObject("nacionalidad");
				int equipo = (int) resultado.getObject("equipo");
				cadete = new Cadete (id, nombre, apellidos, edad, nacionalidad, equipo);

			}
		}catch (SQLException error){
			error.printStackTrace();
		}
		return cadete;
	}
	
	//Metodo que me devuelve un arraylist con todos los cadetes del equipo 5
	public ArrayList<Cadete> loadEquipo(){
		ConexionDB conexion = ConexionDB.getInstance();
		int equipo = 5;
		ResultSet resultado = conexion.query("SELECT * FROM cadetes WHERE equipo='"+equipo+"';");
		
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();
		try{
			while(resultado.next()){
				Cadete cadete = new Cadete();
				cadete.setId((int) resultado.getObject("id"));
				cadete.setNombre((String) resultado.getObject("nombre"));
				cadete.setApellidos((String) resultado.getObject("apellidos"));
				cadete.setNacionalidad((String) resultado.getObject("nacionalidad"));
				cadetes.add(cadete);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return cadetes;
	}

}
