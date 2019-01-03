import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class clsBD {

	private static Connection connection;
	private static Statement statement;
	public static void conexion() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:puntuaciones.db");
			statement = connection.createStatement();
			try {
				statement.executeUpdate("x string, y integer");
			} catch (SQLException e) {
				if (!e.getMessage().equals("table interaccion already exists"))  
					e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//hay que enseñar puntuaciones (todas ) o si no quedarnos siempre con la mas alta y enseñar la puntuacion mas alta
	
//	public static void insertNuevo( String Usuario, int puntuacion ) {
//		String sent = "insert into interaccion values(" + Usuario + "Puntuacion de " + puntuacion ;
//		try {
//			statement.executeUpdate(sent);
//		} catch (SQLException e) {
//			System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
//			e.printStackTrace();
//		}
//	}
	
	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}