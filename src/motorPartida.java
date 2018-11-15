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
	
	public boolean compararTiempoEnemigo(clsEnemigoJuego enemigo)
	{
		long creacion = enemigo.getCreacion();
		long ahora = System.currentTimeMillis();
		if(ahora-creacion>1000)
		return true;
		return false;
	}
	
<<<<<<< HEAD
=======
		
>>>>>>> 0449f8de7824e8d5a7556cc0629d371e1ddb706d
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
