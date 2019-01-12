/**
 * Es la clase que junta la clase clsEnemigo y su label. Hereda de clsEnemigo y as� tiene sus atributos, y tambi�n contiene un label, que es el gr�fico.
 * @author ALUMNO
 *
 */
public class clsEnemigoJuego extends clsEnemigo
{
	private lblEnemigo grafico;
	
	/**
	 * Es el contructor de clsEnemigoJuego, que llama al super() y tambi�n junta el gr�fico.
	 */
	public clsEnemigoJuego()
	{
		super();
		grafico = new lblEnemigo();
		this.setPosX(posX);
		this.setPosY(posY);
		this.setDireccion(direccion);
	}	
	
	/**
	 * Pone la posici�n X, con una llamada que cambia el atributo y tambi�n la posici�n del gr�fico.
	 */
	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		grafico.setLocation( (int)posX, (int)posY );
		grafico.repaint();
	}

	/**
	 * Pone la posici�n Y, con una llamada que cambia el atributo y tambi�n la posici�n del gr�fico.
	 */
	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		grafico.setLocation( (int)posX, (int)posY );
		grafico.repaint();
	}

	/**
	 * Pone la direcci�n, con una llamada que cambia el atributo y tambi�n la posici�n del gr�fico.
	 */
	@Override
	public void setDireccion( double dir ) {
		super.setDireccion(dir);
		grafico.setGiro( dir );
		grafico.repaint();
	}

	public lblEnemigo getGrafico() {
		return grafico;
	}

	public void setGrafico(lblEnemigo grafico) {
		this.grafico = grafico;
	}
	
}
