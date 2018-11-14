import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;


public class motorPartida 
{
	JPanel panel;
	clsEnemigoJuego enemigo;
	clsBonusJuego bonus;
	
	
	public motorPartida(JPanel panel)
	{
		this.panel=panel;
		panel.setVisible(true);
		
	}
	
	public clsEnemigoJuego creaEnemigo()
	{
		enemigo = new clsEnemigoJuego();
		panel.add(enemigo.getGrafico());
		enemigo.getGrafico().repaint();
		return enemigo;
	}
	
	public clsBonusJuego creaBonus()
	{
		bonus= new clsBonusJuego(0);
		panel.add(bonus.getGrafico());
		bonus.getGrafico().repaint();
		return bonus;
	}
	
	public clsBonusJuego creaBonusTiempo()
	{
		bonus= new clsBonusJuego(1);
		panel.add(bonus.getGrafico());
		bonus.getGrafico().repaint();
		return bonus;
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
		enemigo.mueve(25);
		enemigo.getGrafico().repaint();
	}
	
	public void borraEnemigoPantalla(clsEnemigoJuego e)
	{
		panel.remove(e.getGrafico());
		e.getGrafico().repaint();
	}
	
	
}
