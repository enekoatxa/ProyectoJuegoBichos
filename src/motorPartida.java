import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class motorPartida 
{
	JPanel panel;
	clsEnemigoJuego enemigo;
	clsBichoJuego bicho;
	clsBonusJuego bonus;
	lblBonus b;
	double posXActual=0;
	double posYActual=0;
	double XVector=0;
	double YVector=0;
	double grados=0;
	JLabel lblPuntuacion;
	
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
	
	
	public clsBichoJuego crearBicho()
	{
		bicho = new clsBichoJuego(posXActual, posYActual);
		panel.add(bicho.getGrafico());
		bicho.getGrafico().repaint();
		return bicho;
	}
	
	public double devuelvePosX()
	{
		posXActual=MouseInfo.getPointerInfo().getLocation().getX()-50;
		return posXActual;
	}
	
	public double devuelvePosY()
	{
		posYActual=MouseInfo.getPointerInfo().getLocation().getY()-75;
		return posYActual;
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
		if(ahora-creacion>10000)
		return true;
		return false;
	}
	

	public void RotarBonus(clsBonusJuego bs)
	{
		bs.RotarBonus();
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

	public void borraBonusPantalla(clsBonusJuego b)
	{
		panel.remove(b.getGrafico());
		b.getGrafico().repaint();
	}
	
	public void calculaPosBicho() 
	{
		devuelvePosX();
		devuelvePosY();
		bicho.mueve(posXActual, posYActual);
		calcularVectorDireccion();
	}
	
	public void calcularVectorDireccion()
	{
		XVector=bicho.getPosX()-bicho.getPosXAnterior()+50;
		YVector=bicho.getPosY()-bicho.getPosYAnterior()+75;
		//System.out.println(XVector+ " "+YVector);
		bicho.calcularGradosDireccion(XVector, YVector);
		bicho.pasarDireccion();
	}
	
	public boolean choqueConEnemigo(clsEnemigoJuego ene)
	{
		double distX = ene.getPosX()+lblEnemigo.ENEMIGO_TAMANYO/2-bicho.getPosX()-lblBicho.BICHO_TAMANYO/2;
		double distY = ene.getPosY()+lblEnemigo.ENEMIGO_TAMANYO/2-bicho.getPosY()-lblBicho.BICHO_TAMANYO/2;
		double dist = Math.sqrt( distX*distX + distY*distY );
		return (dist <= lblBicho.RADIO_ESFERA_BICHO + lblEnemigo.ENEMIGO_RADIO);
	}
	
	public boolean chocaCocheConEstrella( clsBonusJuego est ) 
	{
		double distX = est.getPosX()+lblBonus.BONUS_TAMANYO/2-bicho.getPosX()-lblBicho.BICHO_TAMANYO/2;
		double distY = est.getPosY()+lblBonus.BONUS_TAMANYO/2-bicho.getPosY()-lblBicho.BICHO_TAMANYO/2;
		double dist = Math.sqrt( distX*distX + distY*distY );
		return (dist <= lblBicho.RADIO_ESFERA_BICHO + lblBonus.RADIO_ESFERA_BONUS);
		
	}
	
}
