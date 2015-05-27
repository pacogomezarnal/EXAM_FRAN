package Controllers;

import java.util.ArrayList;

import Model.Cadete;
import Model.ModeloCadete;

public class CadeteController {
	
	private Cadete cadete;
	private ModeloCadete mc;
	private int id;
	
	public CadeteController() {
		// TODO Auto-generated constructor stub
		cadete = new Cadete();
		mc = new ModeloCadete();
	}
	
	public Cadete getCadete(){
		return mc.loadCadete();
	}
	
	public ArrayList<Cadete> getEquipo(){
		return mc.loadEquipo();
	}
	

}
