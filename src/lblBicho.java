import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lblBicho extends JLabel
{
	private final int size=90;
	private final int radius=90;
	private double giro=0;
	
	private static final long serialVersionUID = 1L;
	
	public lblBicho()
	{
		try {
			setIcon( new ImageIcon( lblBicho.class.getResource( "Imagenes/Mantangorria.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: bicho.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, size, size );
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
        g2.rotate( giro, size/2, size/2 ); 
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, size, size, null );
	}
}
