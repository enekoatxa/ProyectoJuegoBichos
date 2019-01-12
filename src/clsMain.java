import java.awt.EventQueue;

/**
 * Es el main del programa, que genera la primera instancia de vtPrincipal.
 * @author ALUMNO
 *
 */
public class clsMain 
{
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
