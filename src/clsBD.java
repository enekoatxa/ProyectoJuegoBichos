import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsBD {
	private static Logger logger = Logger.getLogger( vtPartida.class.getName() );
	private static Connection connection;
	private static Statement statement;
	public static void conexion() 
	{
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:puntuaciones.db");
			statement = connection.createStatement();
			statement.executeUpdate("create table if not exists usuarios (nombre string, contrasenya string)");
			statement.executeUpdate("create table if not exists puntuaciones (nombre string, puntuacion int(6))");
			
		} catch (SQLException e) {
			logger.log(Level.WARNING,"Datu basea sortzean arazoak");
		}
	}
	

	
	public static void escribirUsuario(clsUsuario usuario) throws SQLException
	{
		String nombre = usuario.getUsuario();
		String contrasenya = usuario.getContrasenya();
		statement.executeUpdate("insert into usuarios values ('" + nombre+"', '"+ contrasenya+"');");
	}
	
	public static ArrayList <String> leerNombresUsuario() throws SQLException
	{
		ArrayList <String> nombres = new ArrayList<String>();
		ResultSet rs = statement.executeQuery("select nombre from usuarios");
		while(rs.next())
		{
			nombres.add(rs.getString("nombre"));
		}
		return nombres;
	}
	
	public static HashSet<clsUsuario> leerUsuarios()throws SQLException
	{
		HashSet<clsUsuario>usuarios = new HashSet<clsUsuario>();
		
		String nombre="";
		String contrasenya="";
				
		ResultSet rs = statement.executeQuery("select * from usuarios;");
		while(rs.next())
		{
			nombre=rs.getString("nombre");
			contrasenya=rs.getString("contrasenya");
			clsUsuario usuario = new clsUsuario(nombre, contrasenya);
			usuarios.add(usuario);
		}
		return usuarios;
		
	}
	
	public static void escribirPuntuacion(clsUsuario usuario, int puntuacion) throws SQLException
	{
		String nomUsuario=usuario.getUsuario();
		statement.executeUpdate("insert into puntuaciones values ('"+ nomUsuario + "', '" + puntuacion + "');");
	}
	
		
	public static ArrayList<clsUsuario> leerPuntuaciones() throws SQLException
	{
		ArrayList<clsUsuario> usuariosConPuntuaciones = new ArrayList<clsUsuario>();
		String nombre="";
		int puntuacion=0;
		boolean existe=false;
				
		ResultSet rs = statement.executeQuery("select * from puntuaciones");
		while(rs.next())
		{
			nombre=rs.getString("nombre");
			puntuacion=rs.getInt("puntuacion");
			for(int i=0; i<usuariosConPuntuaciones.size();i++)
			{
				if(nombre.equals(usuariosConPuntuaciones.get(i).getUsuario()))
				{
					usuariosConPuntuaciones.get(i).getPuntuaciones().add(puntuacion);
					existe=true;
				
				}
			}
			if(existe==false)
			{
				clsUsuario usuario = new clsUsuario(nombre, "");
				usuario.getPuntuaciones().add(puntuacion);
				usuariosConPuntuaciones.add(usuario);
			}
			existe=false;
		}
		
		return usuariosConPuntuaciones;
	}
	
	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}