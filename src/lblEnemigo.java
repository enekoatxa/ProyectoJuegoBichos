import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 *  * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * 
 * Clase como estructura para el label del enemigo. Contiene tres atributos:
 * int ENEMIGO_TAMANYO: El tamaño que va a tener el label, siempre va a ser de 100 pixels.
 * int ENEMIGO_RADIO=: Atributo para gestionar los choques con el bicho.
 * double miGiro: Atributo para que el enemigo tenga un giro.
 * Logger logger: Sirve para enseñar en consola y guardar en un fichero cierta información de la ejecución(p.e excepciones).
 */
public class lblEnemigo extends JLabel
{
	private static Logger logger = Logger.getLogger( vtPartida.class.getName() );
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
	 try {
	 logger.addHandler( new FileHandler(
	 "Loggerrak.log.xml", ANYADIR_A_FIC_LOG ));
	 } catch (SecurityException | IOException e) {
	 logger.log( Level.SEVERE, "Log fitxeroaren sorkuntzan arazoak" );
	 }
	}
	private static final long serialVersionUID = 1L;
	public static final int ENEMIGO_TAMANYO = 100; 
	public static final int ENEMIGO_RADIO= 15;
	private double giro=0;
	/**
	 * Constructor sin parámetros para el label. Pone la imagen correspondiente al label y también le adjudica al label su tamaño(ENEMIGO_TAMANYO).
	 */
	public lblEnemigo()
	{
		Random r = new Random();
		int a = r.nextInt(5)+1;
		try
		{
			switch(a)
			{
			case 1:this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo01.png" ).toURI().toURL() ) );
				break;
			case 2:this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo02.png" ).toURI().toURL() ) );
				break;
			case 3:this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo03.png" ).toURI().toURL() ) );
				break;
			case 4:this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo04.png" ).toURI().toURL() ) );
				break;
			case 5:this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo05.png" ).toURI().toURL() ) );
				break;
			}
			
		}
		catch(Exception e)
		{
			logger.log(Level.WARNING,"Aurkakoen argazkia kargatzean arazoak.");
		}
		this.setBounds(0, 0, ENEMIGO_TAMANYO, ENEMIGO_TAMANYO);
	}
	
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
        g2.rotate( giro+Math.PI/2, ENEMIGO_TAMANYO/2, ENEMIGO_TAMANYO/2 ); // getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 );
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, ENEMIGO_TAMANYO, ENEMIGO_TAMANYO, null );
	}
}

