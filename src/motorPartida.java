import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase es el motor que se utiliza para llevar a cabo las diferentes funciones que se necesitan en la partida. Como atributo tiene un JPanel, un clsEnemigoJuego,
 * un clsBichoJuego, un clsBonusJuego, un lblBonus, un lblPuntuacion y otros atributos para el calculo de la direcci�n del label del jugador.
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 *
 */
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
	
	/**
	 * Constructor del motor, que recoge el panel en el cual se est� llevando a cabo la parte gr�fica del juego.
	 * @param panel Panel en el cual se lleva a cabo la parte gr�fica.
	 */
	public motorPartida(JPanel panel)
	{
		this.panel=panel;
		panel.setVisible(true);		
	}
	
	/**
	 * Constructor vacio para test de JUnit
	 */
	public motorPartida() {
		
	}

	/**
	 * Este m�todo crea un clsEnemigoJuego, con su parte de atributos, y tambi�n la parte gr�fica, la cual la a�ade al panel. 
	 * @return Devuelve el propio enemigo
	 */
	public clsEnemigoJuego creaEnemigo()
	{
		enemigo = new clsEnemigoJuego();
		panel.add(enemigo.getGrafico());
		enemigo.getGrafico().repaint();
		return enemigo;
	}
	
	/**
	 * Este m�todo crea un clsBichoJuego, con su parte de atributos, y tambi�n la parte gr�fica, la cual la a�ade al panel. 
	 * @return Devuelve el propio bicho
	 */
	public clsBichoJuego crearBicho()
	{
		bicho = new clsBichoJuego(posXActual, posYActual);
		panel.add(bicho.getGrafico());
		bicho.getGrafico().repaint();
		return bicho;
	}
	
	/**
	 * M�todo para usar en un test de JUnit, que no dispone de un JPanel.
	 * @return El bicho que se crea.
	 */
	public clsBichoJuego crearBichoTest()
	{
		bicho = new clsBichoJuego(posXActual, posYActual);
		return bicho;
	}
	
	/**
	 * M�todo para poder recoger la posici�n X del rat�n.
	 * @return Posici�n X del rat�n (double).
	 */
	public double devuelvePosX()
	{
		posXActual=MouseInfo.getPointerInfo().getLocation().getX()-50;
		return posXActual;
	}
	
	/**
	 * M�todo para poder recoger la posici�n Y del rat�n.
	 * @return Posici�n Y del rat�n (double).
	 */
	public double devuelvePosY()
	{
		posYActual=MouseInfo.getPointerInfo().getLocation().getY()-75;
		return posYActual;
	}
	
	/**
	 * Este m�todo crea un clsBonusJuego, con su parte de atributos, y tambi�n la parte gr�fica, la cual la a�ade al panel. 
	 * @return Devuelve el propio bonus
	 */
	public clsBonusJuego creaBonus()
	{
		bonus= new clsBonusJuego();
		panel.add(bonus.getGrafico());
		bonus.getGrafico().repaint();
		return bonus;
	}
		
	/**
	 * M�todo que compara el momento en el cual se ha creado el enemigo y el momento actual de la partida. Controla si han pasado 10 segundos.
	 * @param enemigo Enemigo del cual se mira el tiempo de creaci�n.
	 * @return Devuelve un true si ya han pasado 10 segundos y false si no han pasado.
	 */
	public boolean compararTiempoEnemigo(clsEnemigoJuego enemigo)
	{
		long creacion = enemigo.getCreacion();
		long ahora = System.currentTimeMillis();
		if(ahora-creacion>10000)
		return true;
		return false;
	}
	
	/**
	 * M�todo que compara el momento en el cual se ha creado el bonus y el momento actual de la partida. Controla si han pasado 5 segundos.
	 * @param bonus Bonus del cual se mira el tiempo de creaci�n.
	 * @return  Devuelve un true si ya han pasado 5 segundos y false si no han pasado.
	 */
	public boolean compararTiempoBonus(clsBonusJuego bonus)
	{
		long creacion = bonus.getCreacion();
		long ahora = System.currentTimeMillis();
		if(ahora-creacion>5000)
		return true;
		return false;
	}

	/**
	 * M�todo que llama a RotarBonus, el cual rota el gr�fico del bonus.
	 * @param bs Recoge un clsBonusJuego, el cual rota.
	 */
	public void RotarBonus(clsBonusJuego bs)
	{
		bs.RotarBonus();
	}


	/**
	 * M�todo que hace el c�lculo trigonom�trico de la posici�n X de un enemigo que recoge, en funci�n de su velocidad, direcci�n y tiempo de movimiento.
	 * @param tiempo El tiempo que dura el movimiento.
	 * @param dir La direcci�n que tiene el enemigo, del cual se calcula la posici�n X.
	 * @param vel La velocidad que tiene el enemigo, del cual se calcula la posici�n X.
	 * @return Devuelve la posici�n X.
	 */
	public static double calcularXEnemigo(double tiempo, double dir, double vel)
	{
		return Math.cos(dir)*vel*tiempo;
	}
	
	/**
	 * M�todo que hace el c�lculo trigonom�trico de la posici�n Y de un enemigo que recoge, en funci�n de su velocidad, direcci�n y tiempo de movimiento.
	 * @param tiempo El tiempo que dura el movimiento.
	 * @param dir La direcci�n que tiene el enemigo, del cual se calcula la posici�n Y.
	 * @param vel La velocidad que tiene el enemigo, del cual se calcula la posici�n Y.
	 * @return Devuelve la posici�n Y.
	 */
	public static double calcularYEnemigo(double tiempo, double dir, double vel)
	{
		return Math.sin(dir)*vel*tiempo;
	}
	
	/**
	 * M�todo que recoge un enemigo y calcula sus coordenadas X e Y, cambia los atributos X e Y, y mueve el enemigo en la pantalla. Esto lo hace mediante
	 * llamadas a diferentes m�todos de diferentes clases.
	 * @param enemigo El enemigo el cual se mueve.
	 */
	public void calculaPosicionEnemigo(clsEnemigoJuego enemigo)
	{
		enemigo.mueve(0.025);
		enemigo.getGrafico().repaint();
	}
	
	/**
	 * M�todo que borra un enemigo de la pantalla.
	 * @param e El enemigo borrado.
	 */
	public void borraEnemigoPantalla(clsEnemigoJuego e)
	{
		panel.remove(e.getGrafico());
		e.getGrafico().repaint();
	}

	/**
	 * M�todo que borra un bonus de la pantalla.
	 * @param b El bonus borrado.
	 */
	public void borraBonusPantalla(clsBonusJuego b)
	{
		panel.remove(b.getGrafico());
		b.getGrafico().repaint();
	}
	
	/**
	 * M�todo que calcula la posici�n del jugador. Mediante varias llamadas, calcula la posici�n del jugador y luego mueve el gr�fico en el panel. Tambi�n
	 * llama a un m�todo calcula un vector que se usa para girar el jugador, para darle animaci�n.
	 */
	public void calculaPosBicho() 
	{
		devuelvePosX();
		devuelvePosY();
		bicho.mueve(posXActual, posYActual);
		calcularVectorDireccion();
	}
	
	/**
	 * Es el m�todo que calcula el vector que se usa para rotar al jugador y darle un poco de animaci�n.
	 */
	public void calcularVectorDireccion()
	{
		XVector=bicho.getPosX()-bicho.getPosXAnterior()+50;
		YVector=bicho.getPosY()-bicho.getPosYAnterior()+75;
		bicho.calcularGradosDireccion(XVector, YVector);
		bicho.pasarDireccion();
	}
	
	/**
	 * Es un m�todo que mira si el jugador ha chocado con un enemigo espec�fico.
	 * @param ene Es el enemigo que se mira si ha habido choque con �l.
	 * @return True si hay choque, false si no lo hay.
	 */
	public boolean choqueConEnemigo(clsEnemigoJuego ene)
	{
		double distX = ene.getPosX()+lblEnemigo.ENEMIGO_TAMANYO/2-bicho.getPosX()-lblBicho.BICHO_TAMANYO/2;
		double distY = ene.getPosY()+lblEnemigo.ENEMIGO_TAMANYO/2-bicho.getPosY()-lblBicho.BICHO_TAMANYO/2;
		double dist = Math.sqrt( distX*distX + distY*distY );
		return (dist <= lblBicho.RADIO_ESFERA_BICHO + lblEnemigo.ENEMIGO_RADIO);
	}
	
	/**
	 * Es un m�todo que mira si el jugador ha chocado con un bonus espec�fico.
	 * @param est Es el bonus que se mira si ha habido choque con �l.
	 * @return True si hay choque, false si no lo hay.
	 */
	public boolean chocaCocheConEstrella( clsBonusJuego est ) 
	{
		double distX = est.getPosX()+lblBonus.BONUS_TAMANYO/2-bicho.getPosX()-lblBicho.BICHO_TAMANYO/2;
		double distY = est.getPosY()+lblBonus.BONUS_TAMANYO/2-bicho.getPosY()-lblBicho.BICHO_TAMANYO/2;
		double dist = Math.sqrt( distX*distX + distY*distY );
		return (dist <= lblBicho.RADIO_ESFERA_BICHO + lblBonus.RADIO_ESFERA_BONUS);
		
	}
	
}
