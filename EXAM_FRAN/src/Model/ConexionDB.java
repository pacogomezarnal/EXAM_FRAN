package Model;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexionDB {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS POR DEFECTO
	private static final String HOST="localhost";
	private static final String BBDD="thelaby";
	private static final String USER="root";
	private static final String PASS="";
	
	//DATOS DE LA BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//Conexion
	private static Connection conexion = null;// maneja la conexi�
	
	//Instancia unica
	private static ConexionDB instance = null;
	
	private ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//Implementar SingleTon
	public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new ConexionDB(HOST, BBDD, USER, PASS);
	      }
	      return instance;
	   }
	//Este m�todo es el mismo que el anterior pero no es necesario
	//pasar par�metros de base de datos ya que toma los
	//valores por defecto
	public static ConexionDB getInstance() {
	      if(instance == null) {
	         instance = new ConexionDB(ConexionDB.HOST, ConexionDB.BBDD, ConexionDB.USER, ConexionDB.PASS);
	      }
	      return instance;
	  }
	
	//Metodo que permite la conexion a la base de datos
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual autom�ticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Metodo que devuelve la conexion a la base de datos
	public static Connection getConexion(){
		return conexion;
	}
	
	//Con este metodo hago los selects
	public ResultSet query(String query){
	
	
		Statement st;
		ResultSet rs = null;

		try {
			st = conexion.createStatement();
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

}

