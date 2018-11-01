import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lblEnemigo extends JLabel
{
	private static final long serialVersionUID = 1L;
	public static final int ENEMIGO_TAMANYO = 50; 
	public static final int ENEMIGO_RADIO= 15;
	private double giro=0;
	
	public lblEnemigo()
	{
		try
		{
			this.setIcon( new ImageIcon( lblEnemigo.class.getResource( "Imagenes/enemigo.png" ).toURI().toURL() ) );
		}
		catch(Exception e)
		{
			System.out.println("Error: label de enemigo no encontrado");
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
        g2.rotate( giro, ENEMIGO_TAMANYO/2, ENEMIGO_TAMANYO/2 ); // getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 );
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, ENEMIGO_TAMANYO, ENEMIGO_TAMANYO, null );
	}
}

