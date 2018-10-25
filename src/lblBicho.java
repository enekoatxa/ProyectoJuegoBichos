import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lblBicho extends JLabel
{
	private final int size=40;
	private final int radius=30;
	
	public lblBicho()
	{
		try {
			setIcon( new ImageIcon( lblBicho.class.getResource( "img/bicho.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: bicho.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, size, size );
	}
}
