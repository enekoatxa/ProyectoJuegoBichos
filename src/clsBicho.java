public class clsBicho 

{
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected double posXAnterior;
	protected double posYAnterior;
	protected double grados;
	
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
	
	
	public void calcularGradosDireccion(double XVector, double YVector) 
	{
		grados = Math.asin(YVector/XVector);
	}
	
}
