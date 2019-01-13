public class clsBicho 

/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Clase que sirve de estructura para el bicho manejado por el usuario. El bicho tendrá cinco parámetros:
 *	
 *	double posX: La posición de la coordenada X.
 *	double posY: La posición de la coordenada Y.
 *	double posXAnterior: Para saber la posicion en coordenada X que tenia anteriormente.
 *	double posYAnterior:  Para saber la posicion en coordenada Y que tenia anteriormente.
 *	long grados: Para guardar hacia donde esta mirando el bicho (en grados).
 *
 */

{
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected double posXAnterior;
	protected double posYAnterior;
	protected double grados;
	
	
	/**
	 * Constructor de clsBicho.
	 */
	public clsBicho(double miPosX, double miPosY) {
		
		posX = miPosX;
		posY = miPosY;
	}
	
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
		posXAnterior=posX;
		posYAnterior=posY;
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}

	public double getPosXAnterior() {
		return posXAnterior;
	}

	public void setPosXAnterior(double posXAnterior) {
		this.posXAnterior = posXAnterior;
	}

	public double getPosYAnterior() {
		return posYAnterior;
	}

	public void setPosYAnterior(double posYAnterior) {
		this.posYAnterior = posYAnterior;
	}

	@Override
	public String toString() {
		return "clsBicho [posX=" + posX + ", posY=" + posY + "]";
	}
	
	/**
	 * Metodo para calcular mediante dos vectores de X e Y la posicion a la cual mirara el bicho manejado por el usuario
	 * mediante los dos vectores se debe obtener la orientacion de este en grados. 
	 */
	public void calcularGradosDireccion(double XVector, double YVector) 
	{
		grados =Math.atan(XVector/YVector)*4;
		
	}
	
}
