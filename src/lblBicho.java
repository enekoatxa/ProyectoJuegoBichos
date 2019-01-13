import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * 
 * Clase como estructura para el label del Bicho. Contiene tres atributos:
 * int BICHO_TAMANYO: El tamaño que va a tener el label.
 * int RADIO_ESFERA_BICHO: Atributo para gestionar los choques con los enemigos.
 * double giro: Atributo para ir girando el bicho.
 */

public class lblBicho extends JLabel
{
	private static Logger logger = Logger.getLogger( vtPartida.class.getName() );
	
	public static final int BICHO_TAMANYO = 90; 
	public static final int RADIO_ESFERA_BICHO=30;;
	private double giro=0;
	
	private static final long serialVersionUID = 1L;
	int cont=0;
	
	/**
	 * Constructor sin parámetros para el label. Pone la imagen correspondiente al label y también le adjudica al label su tamaño(BICHO_TAMANYO)
	 */
	public lblBicho()
	{
		
		try {
			
			setIcon( new ImageIcon( lblBicho.class.getResource( "Imagenes/Mantangorria.png" ).toURI().toURL() ) );
			
			
			
			
		} catch (Exception e) {
			logger.log(Level.WARNING,"Mantangorriaren argazkia kargatzean arazoak.");
		}
		setBounds( 0, 0, BICHO_TAMANYO, BICHO_TAMANYO );
	}
	//abria que hacer que cuanto reduzca en Y pase a mirar a abajo por ejemplo, y cuando aumente en X mire a la derecha etc
	
	public void setGiro(double giro)
	{
		this.giro=giro;
	}
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		// Prepara rotación (siguientes operaciones se rotarán)
        g2.rotate( giro, BICHO_TAMANYO/2, BICHO_TAMANYO/2 ); 
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, BICHO_TAMANYO, BICHO_TAMANYO, null );
	}
}
