import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class lblBonus extends JLabel //Bonus Puntuacion
{
	private static final long serialVersionUID = 1L;
	public static final int BONUS_TAMANYO = 50; 
	
<<<<<<< HEAD
	public lblBonus(int m)
=======
	public lblBonus(int bonus)
>>>>>>> 7bfe514e6c90ed959a890d9c2698a7eceb0031bf
	{
		if(bonus==0)
		{
			try
			{
				this.setIcon( new ImageIcon( lblBonus.class.getResource( "hemen bonus normala" ).toURI().toURL() ) );
			}
			catch(Exception e)
			{
				System.out.println("Error: label de bonus no encontrado");
			}
		}
		else
		{
			try
			{
				this.setIcon( new ImageIcon( lblBonus.class.getResource( "hemen bonus denbora" ).toURI().toURL() ) );
			}
			catch(Exception e)
			{
				System.out.println("Error: label de bonus no encontrado");
			}
		}
		this.setBounds(0, 0, BONUS_TAMANYO, BONUS_TAMANYO);
	}
}
