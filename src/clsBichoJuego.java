public class clsBichoJuego extends clsBicho {
	
	private lblBicho miGrafico;  

	/**
	 * 
	 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
	 * Es la clase que junta la clase clsBicho y su label. Hereda de clsBicho y así tiene sus atributos, y también contiene un label, que es el gráfico.
	 *
	 */
	
public clsBichoJuego(double miPosX, double miPosY)
{
	super(miPosX, miPosY);
	miGrafico = new lblBicho();
	this.setPosX(posX);
	this.setPosY(posY);
	
}	

/**
 * Constructor sin parámetros de la clase, llamando primero a su super(clsBicho).
 */
@Override
public void setPosX(double posX) {
	super.setPosX(posX);
	miGrafico.setLocation( (int)posX, (int)posY );
	miGrafico.repaint();
}

@Override
public void setPosY(double posY) {
	super.setPosY(posY);
	miGrafico.setLocation( (int)posX, (int)posY );
	miGrafico.repaint();
}

public lblBicho getGrafico() {
	return miGrafico;
}

public void setGrafico(lblBicho grafico) {
	this.miGrafico = grafico;
}

public void add(clsBichoJuego crearBicho) {
	// TODO Auto-generated method stub
	
}
/**
 * Metodo que nos permitira el movimiento de nuestro bicho en la ventana vtPartida mediante sus coordenadas
 * de posiciones X e Y.
 */
public void mueve(double posXActual, double posYActual) 
{
setPosX(posXActual);
setPosY(posYActual);
	
}

public void pasarDireccion()
{
miGrafico.setGiro(grados);	
}
}