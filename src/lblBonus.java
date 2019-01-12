import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



//import com.sun.prism.Graphics;
import java.awt.Graphics;

/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * 
 * Clase como estructura para el label del bonus. Contiene tres atributos:
 * int BONUS_TAMANYO: El tamaño que va a tener el label, siempre va a ser de 50 pixels.
 * int RADIO_ESFERA_BONUS: Atributo para gestionar los choques con el bicho.
 * double miGiro: Atributo para ir girando los bonuses.
 */
public class lblBonus extends JLabel //Bonus Puntuacion
{
	private static final long serialVersionUID = 1L;
	public static final int BONUS_TAMANYO = 50; 
	public static final int RADIO_ESFERA_BONUS = 23; 
	private double miGiro = 0;
	/**
	 * Constructor sin parámetros para el label. Pone la imagen de la margarita al label y también le adjudica al label su tamaño(BONUS_TAMANYO).
	 */
	public lblBonus()

	{
		
			try
			{
				this.setIcon( new ImageIcon( lblBonus.class.getResource( "Imagenes/margarita.png" ).toURI().toURL() ) );
			}
			catch(Exception e)
			{
				System.out.println("Error: label de bonus no encontrado");
			}
		
		this.setBounds(0, 0, BONUS_TAMANYO, BONUS_TAMANYO);
	}
	/**
	 * Método para ir girando el bonus.
	 * @param gradosGiro
	 */
	public void addGiro( double gradosGiro ) {
		miGiro -= gradosGiro/180*Math.PI;
	}

	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
//        if (DIBUJAR_RECTANGULO) g2.drawRect(0, 0, TAMANYO_ESTRELLA-1, TAMANYO_ESTRELLA-1);
		// Prepara rotación (siguientes operaciones se rotarán)
        g2.rotate( miGiro, getIcon().getIconWidth()/2,getIcon().getIconHeight()/2 ); // getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 );
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, BONUS_TAMANYO, BONUS_TAMANYO, null );
//        if (DIBUJAR_ESFERA) g2.drawOval( TAMANYO_ESTRELLA/2-RADIO_ESFERA, TAMANYO_ESTRELLA/2-RADIO_ESFERA,
//        		RADIO_ESFERA*2, RADIO_ESFERA*2 );
	}

}
