import javax.swing.JPanel;


public class motorPartida 
{
	JPanel panel= new JPanel();
	clsEnemigoJuego  enemigo;
	
	public void creaEnemigo()
	{
		enemigo = new clsEnemigoJuego();
		panel.add(enemigo.getGrafico());
		enemigo.getGrafico().repaint();
	}
	
	public void creaBonus()
	{
		
	}
	
	public static double calcularXEnemigo(double tiempo, double dir, double vel)
	{
		return Math.cos(dir)*vel*tiempo;
	}
	
	public static double calcularYEnemigo(double tiempo, double dir, double vel)
	{
		return Math.sin(dir)*vel*tiempo;
	}
	
}
