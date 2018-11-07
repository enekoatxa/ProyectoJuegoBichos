import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;


public class motorPartida 
{
	JPanel panel;
	clsEnemigoJuego enemigo;
	
	
	public motorPartida(JPanel panel)
	{
		this.panel=panel;
	}
	
	public clsEnemigoJuego creaEnemigo()
	{
		enemigo = new clsEnemigoJuego();
		panel.add(enemigo.getGrafico());
		enemigo.getGrafico().repaint();
		return enemigo;
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
	
	public void calculaPosicionEnemigo(clsEnemigoJuego enemigo)
	{
		enemigo.mueve(40);
	}
	
	
}
