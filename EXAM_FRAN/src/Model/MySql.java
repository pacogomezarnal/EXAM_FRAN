package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {
	private Connection con;
	
	/*Configuración MYSQL*/
	private String server="localhost";
	private String bbdd="thelaby";
	private String user="root";
	private String password="";
	
	private static MySql instance=null;
	
	MySql(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://"+server+"/"+bbdd+"?"+"user="+user+"&password="+password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MySql getInstance() {
		if(instance==null) {
			instance=new MySql();
		}
		return instance;
	}
		

		//Con este metodo hago los selects
	public ResultSet query(String query){
		
		
		Statement st;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			try{
				rs = st.executeQuery(query);
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		} catch (SQLException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return rs;	
										
	}
	
	//Con este metodo vamos a hacer los inserts, update y deletes.
	public int modifyQuery(String update){
		Statement stmt;
		int rs = 0;
		try{
		stmt = con.createStatement();		
			try{
				rs = stmt.executeUpdate(update);
			}catch (SQLException e){
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
		

}
