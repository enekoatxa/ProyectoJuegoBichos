/**
 * Es la clase que junta la clase clsEnemigo y su label. Hereda de clsEnemigo y así tiene sus atributos, y también contiene un label, que es el gráfico.
 * @author ALUMNO
 *
 */
public class clsEnemigoJuego extends clsEnemigo
{
	private lblEnemigo grafico;
	
	/**
	 * Es el contructor de clsEnemigoJuego, que llama al super() y también junta el gráfico.
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
	 * Pone la posición X, con una llamada que cambia el atributo y también la posición del gráfico.
	 */
	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		grafico.setLocation( (int)posX, (int)posY );
		grafico.repaint();
	}

	/**
	 * Pone la posición Y, con una llamada que cambia el atributo y también la posición del gráfico.
	 */
	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		grafico.setLocation( (int)posX, (int)posY );
		grafico.repaint();
	}

	/**
	 * Pone la dirección, con una llamada que cambia el atributo y también la posición del gráfico.
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
