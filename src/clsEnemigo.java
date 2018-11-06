import java.util.Random;

public class clsEnemigo 
{
	private static final int ENEMIGO_TAMANYO = 50;
	protected double posY;
	protected double posX;
	protected double velocidad;
	protected double direccion;
	
	public clsEnemigo()
	{
		Random r = new Random();
		int lugar= r.nextInt(4);
		
		switch (lugar)
		{
		//Spawn de enemigo por arriba
			case 1:
				this.posY=-ENEMIGO_TAMANYO;
				this.posX=1920*r.nextDouble();
				this.velocidad=10*r.nextDouble();
				this.direccion=Math.toRadians(180+180*r.nextDouble());
				break;
		//Spawn de enemigo por derecha
			case 2:
				this.posY=1080*r.nextDouble();
				this.posX=1920+ENEMIGO_TAMANYO;
				this.velocidad=10*r.nextDouble();
				this.direccion=Math.toRadians(90+180*r.nextDouble());
				break;
		//Spawn de enemigo por abajo
			case 3:
				this.posY=180+ENEMIGO_TAMANYO;
				this.posX=r.nextDouble();
				this.velocidad=10*r.nextDouble();
				this.direccion=Math.toRadians(180*r.nextDouble());
				break;
		//Spawn de enemigo por izquierda	
			case 4:
				this.posY=1080*r.nextDouble();
				this.posX=-ENEMIGO_TAMANYO;
				this.velocidad=10*r.nextDouble();
				this.direccion=Math.toRadians(270+180*r.nextDouble());
				break;
		}
		

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
	
	public void mueve( double tiempoDeMovimiento ) {
		setPosX( posX + motorPartida.calcularXEnemigo(0.04, direccion, velocidad));
		setPosY( posY + motorPartida.calcularYEnemigo(0.04, direccion, velocidad));
	}
	
}
