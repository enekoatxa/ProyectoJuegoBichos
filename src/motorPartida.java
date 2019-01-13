import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase es el motor que se utiliza para llevar a cabo las diferentes funciones que se necesitan en la partida. Como atributo tiene un JPanel, un clsEnemigoJuego,
 * un clsBichoJuego, un clsBonusJuego, un lblBonus, un lblPuntuacion y otros atributos para el calculo de la dirección del label del jugador.
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
	 * Constructor del motor, que recoge el panel en el cual se está llevando a cabo la parte gráfica del juego.
	 * @param panel Panel en el cual se lleva a cabo la parte gráfica.
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
	 * Este método crea un clsEnemigoJuego, con su parte de atributos, y también la parte gráfica, la cual la añade al panel. 
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
	 * Este método crea un clsBichoJuego, con su parte de atributos, y también la parte gráfica, la cual la añade al panel. 
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
	 * Método para usar en un test de JUnit, que no dispone de un JPanel.
	 * @return El bicho que se crea.
	 */
	public clsBichoJuego crearBichoTest()
	{
		bicho = new clsBichoJuego(posXActual, posYActual);
		return bicho;
	}
	
	/**
	 * Método para poder recoger la posición X del ratón.
	 * @return Posición X del ratón (double).
	 */
	public double devuelvePosX()
	{
		posXActual=MouseInfo.getPointerInfo().getLocation().getX()-50;
		return posXActual;
	}
	
	/**
	 * Método para poder recoger la posición Y del ratón.
	 * @return Posición Y del ratón (double).
	 */
	public double devuelvePosY()
	{
		posYActual=MouseInfo.getPointerInfo().getLocation().getY()-75;
		return posYActual;
	}
	
	/**
	 * Este método crea un clsBonusJuego, con su parte de atributos, y también la parte gráfica, la cual la añade al panel. 
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
	 * Método que compara el momento en el cual se ha creado el enemigo y el momento actual de la partida. Controla si han pasado 10 segundos.
	 * @param enemigo Enemigo del cual se mira el tiempo de creación.
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
	 * Método que compara el momento en el cual se ha creado el bonus y el momento actual de la partida. Controla si han pasado 5 segundos.
	 * @param bonus Bonus del cual se mira el tiempo de creación.
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
	 * Método que llama a RotarBonus, el cual rota el gráfico del bonus.
	 * @param bs Recoge un clsBonusJuego, el cual rota.
	 */
	public void RotarBonus(clsBonusJuego bs)
	{
		bs.RotarBonus();
	}


	/**
	 * Método que hace el cálculo trigonométrico de la posición X de un enemigo que recoge, en función de su velocidad, dirección y tiempo de movimiento.
	 * @param tiempo El tiempo que dura el movimiento.
	 * @param dir La dirección que tiene el enemigo, del cual se calcula la posición X.
	 * @param vel La velocidad que tiene el enemigo, del cual se calcula la posición X.
	 * @return Devuelve la posición X.
	 */
	public static double calcularXEnemigo(double tiempo, double dir, double vel)
	{
		return Math.cos(dir)*vel*tiempo;
	}
	
	/**
	 * Método que hace el cálculo trigonométrico de la posición Y de un enemigo que recoge, en función de su velocidad, dirección y tiempo de movimiento.
	 * @param tiempo El tiempo que dura el movimiento.
	 * @param dir La dirección que tiene el enemigo, del cual se calcula la posición Y.
	 * @param vel La velocidad que tiene el enemigo, del cual se calcula la posición Y.
	 * @return Devuelve la posición Y.
	 */
	public static double calcularYEnemigo(double tiempo, double dir, double vel)
	{
		return Math.sin(dir)*vel*tiempo;
	}
	
	/**
	 * Método que recoge un enemigo y calcula sus coordenadas X e Y, cambia los atributos X e Y, y mueve el enemigo en la pantalla. Esto lo hace mediante
	 * llamadas a diferentes métodos de diferentes clases.
	 * @param enemigo El enemigo el cual se mueve.
	 */
	public void calculaPosicionEnemigo(clsEnemigoJuego enemigo)
	{
		enemigo.mueve(0.025);
		enemigo.getGrafico().repaint();
	}
	
	/**
	 * Método que borra un enemigo de la pantalla.
	 * @param e El enemigo borrado.
	 */
	public void borraEnemigoPantalla(clsEnemigoJuego e)
	{
		panel.remove(e.getGrafico());
		e.getGrafico().repaint();
	}

	/**
	 * Método que borra un bonus de la pantalla.
	 * @param b El bonus borrado.
	 */
	public void borraBonusPantalla(clsBonusJuego b)
	{
		panel.remove(b.getGrafico());
		b.getGrafico().repaint();
	}
	
	/**
	 * Método que calcula la posición del jugador. Mediante varias llamadas, calcula la posición del jugador y luego mueve el gráfico en el panel. También
	 * llama a un método calcula un vector que se usa para girar el jugador, para darle animación.
	 */
	public void calculaPosBicho() 
	{
		devuelvePosX();
		devuelvePosY();
		bicho.mueve(posXActual, posYActual);
		calcularVectorDireccion();
	}
	
	/**
	 * Es el método que calcula el vector que se usa para rotar al jugador y darle un poco de animación.
	 */
	public void calcularVectorDireccion()
	{
		XVector=bicho.getPosX()-bicho.getPosXAnterior()+50;
		YVector=bicho.getPosY()-bicho.getPosYAnterior()+75;
		bicho.calcularGradosDireccion(XVector, YVector);
		bicho.pasarDireccion();
	}
	
	/**
	 * Es un método que mira si el jugador ha chocado con un enemigo específico.
	 * @param ene Es el enemigo que se mira si ha habido choque con él.
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
	 * Es un método que mira si el jugador ha chocado con un bonus específico.
	 * @param est Es el bonus que se mira si ha habido choque con él.
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
