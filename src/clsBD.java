import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Esta es la clase que se encarga de gestionar la base de datos. Para hacer uso de una base de datos hemos tenido que
 * añadir unas librerias de sqlite jsbc que nos permite guardar la informacion de todos los usuarios con todos las puntuaciones 
 * que han realizado en diferentes momentos.
 */
public class clsBD {

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
			e.printStackTrace();
		}
	}
	

	/**
	 * Se escribe la informacion de entrada del Usuario : el nickName y el password
	 */
	public static void escribirUsuario(clsUsuario usuario) throws SQLException
	{
		String nombre = usuario.getUsuario();
		String contrasenya = usuario.getContrasenya();
		statement.executeUpdate("insert into usuarios values ('" + nombre+"', '"+ contrasenya+"');");
	}
	/**
	 * Metodo que nos permita la lectura de datos desde nuestra base de datos:
	 */
	
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
	
	/**
	 *
	 * * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
	 * Este metodo es necesario para poder luego sacar la informacion de los usuarios con sus puntuaciones en la clase 
	 * clsMejoresPuntuaciones
	 * Guardara en un arraylist de tipo clsUsuario el nombre de usuario de este y un arraylist de todas lasç
	 * puntuaciones que haya podido hacer.
	 */
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
	

	/**
	 *
	 * * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
	 * Metodo para terminar conexion de la Base de datos
	 */
	
	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}