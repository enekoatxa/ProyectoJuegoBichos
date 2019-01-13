import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es el main del programa, que genera la primera instancia de vtPrincipal.
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 *
 */
public class clsMain 
{
	private static Logger logger = Logger.getLogger( clsMain.class.getName() );
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
		 try {
		 logger.addHandler( new FileHandler(
		 "Loggerrak.log.xml", ANYADIR_A_FIC_LOG ));
		 } catch (SecurityException | IOException e) {
		 logger.log( Level.SEVERE, "Log fitxeroaren sorkuntzan arazoak" );
		 }
		}
	/**
	 * Main del programa, que crea la primera instancia de vtPrincipal.
	 * @param args parámetro args del main.
	 */
	public static void main(String[] args) {
		
		
		clsBD.conexion();
		
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						
						
						vtPrincipal frame = new vtPrincipal(null);
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
