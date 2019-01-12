import java.util.Random;

/**
 * clase que tiene los atributos de posición, velocidad, dirección y hora de creación de enemigos.
 * @author ALUMNO
 *
 */
public class clsEnemigo 
{
	protected static final int ENEMIGO_TAMANYO = 50;
	protected double posY;
	protected double posX;
	protected double velocidad;
	protected double direccion;
	protected long creacion;
	
	/**
	 * Constructor de clsEnemigo. Crea un enemigo aleatoriamente en una de las cuatro esquinas de la pantalla, y después de elegir una esquina, genera una 
	 * posición inicial y una velocidad y dirección aleatorias.
	 */
	public clsEnemigo()
	{
		Random r = new Random();
		int lugar= r.nextInt(4)+1;
		
		switch (lugar)
		{
		//Spawn de enemigo por arriba
			case 1:
				this.posY=-ENEMIGO_TAMANYO;
				this.posX=1920*r.nextDouble();
				this.velocidad=300;
				this.direccion=Math.toRadians(45+90*r.nextDouble());
				break;
		//Spawn de enemigo por derecha
			case 2:
				this.posY=1080*r.nextDouble();
				this.posX=1920+ENEMIGO_TAMANYO;
				this.velocidad=300;
				this.direccion=Math.toRadians(135+90*r.nextDouble());
				break;
		//Spawn de enemigo por abajo
			case 3:
				this.posY=1080+ENEMIGO_TAMANYO;
				this.posX=1920*r.nextDouble();
				this.velocidad=300;
				this.direccion=Math.toRadians(225+90*r.nextDouble());
				break;
		//Spawn de enemigo por izquierda	
			case 4:
				this.posY=1080*r.nextDouble();
				this.posX=-ENEMIGO_TAMANYO;
				this.velocidad=300;
				this.direccion=Math.toRadians(90*r.nextDouble());
				break;
		}
		
		creacion=System.currentTimeMillis();

	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getDireccion() {
		return direccion;
	}

	public void setDireccion(double direccion) {
		this.direccion = direccion;
	}
	
	
	public long getCreacion() {
		return creacion;
	}

	public void setCreacion(long creacion) {
		this.creacion = creacion;
	}

	/**
	 * Mediante dos llamadas a motorPartida, que calcula las posiciones según la dirección y velocidad de un enemigo, después de ese calculo, los
	 * mueve físicamente en la pantalla.
	 * @param tiempoDeMovimiento Es el tiempo que se utiliza para calcular el movimiento.
	 */
	public void mueve( double tiempoDeMovimiento ) {
		setPosX( posX + motorPartida.calcularXEnemigo(tiempoDeMovimiento, direccion, velocidad));
		setPosY( posY + motorPartida.calcularYEnemigo(tiempoDeMovimiento, direccion, velocidad));
	}
	
}
