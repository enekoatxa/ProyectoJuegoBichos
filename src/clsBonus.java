
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

public class clsBonus
{
	protected int bonus; //Determina el tipo de bonus que será, de puntuación o de tiempo.
	protected int premio;
	protected double posX;
	protected double posY;
	protected long creacion;
	
public clsBonus() //Constructor sin parámetros(solo 1 parámetro que utilizaremos para decidir la clase de bonus que será entre los dos que hemos definido. )
{
	creacion=System.currentTimeMillis();
	bonuspuntuacion(); //Le da una puntuación aleatoria entre 5 puntuaciones a nuestro bonus.
		
	posicion();
	
	
}
private void posicion()
{
	Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 

	Random rand = new Random();

	posX=pantallaTamano.getWidth()*rand.nextDouble();
	posY=pantallaTamano.getHeight()*rand.nextDouble();
}
private void bonuspuntuacion()
{
	Random rand = new Random();

	int  n = rand.nextInt(5)+1;
			
	switch(n)
	{
	case 1:premio=10;
		break;
	case 2:premio=25;
		break;
	case 3:premio=50;
		break;
	case 4:premio=100;
		break;
	case 5:premio=200;
		break;
	}
}

public int getBonus() {
	return bonus;
}

public void setBonus(int bonus) {
	this.bonus = bonus;
}

public int getPremio() {
	return premio;
}

public void setPremio(int premio) {
	this.premio = premio;
}

public double getPosX() {
	return posX;
}

public void setPosX(double posX) {
	this.posX = posX;
}

public double getPosY() {
	return posY;
}

public void setPosY(double posY) {
	this.posY = posY;
}
public long getCreacion() {
	return creacion;
}
public void setCreacion(long creacion) {
	this.creacion = creacion;
}


}