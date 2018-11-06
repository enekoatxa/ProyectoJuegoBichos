import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class lblBonus extends JLabel //Bonus Puntuacion
{
	private static final long serialVersionUID = 1L;
	public static final int BONUS_TAMANYO = 50; 
	
	public lblBonus()
	{
		try
		{
			this.setIcon( new ImageIcon( lblBonus.class.getResource( "" ).toURI().toURL() ) );
		}
		catch(Exception e)
		{
			System.out.println("Error: label de bonus no encontrado");
		}
		this.setBounds(0, 0, BONUS_TAMANYO, BONUS_TAMANYO);
	}
}
