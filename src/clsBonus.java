
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
/**
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 *	Clase que sirve de estructura para los bonus del juego. Estos bonuses tendrán cuatro parámetros:
 *	int premio: La puntuación que tendrá este bonus (aleatorio).
 *	double posX: La posición de la coordenada X en la que se encontrará el bonus (aleatorio).
 *	double posY: La posición de la coordenada Y en la que se encontrará el bonus (aleatorio).
 *	long creacion: En este atributo se guarda el momento en el que fue creado el bonus.
 */
public class clsBonus
{ 
	protected int premio;
	protected double posX;
	protected double posY;
	protected long creacion;
	
	/**
	 * Constructor sin parámetros para la clase. Crea un bonus aleatoriamente en cualquier posición de la pantalla y con el premio aleatorio entre cinco posibles.
	 */
public clsBonus() 
{
	creacion=System.currentTimeMillis();
	bonuspuntuacion(); //Le da una puntuación aleatoria entre 5 puntuaciones a nuestro bonus.
		
	posicion();
	
	
}
/**
 * Método para calcular la posición del bonus de forma aleatoria
 */
private void posicion()
{
	Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 

	Random rand = new Random();

	posX=pantallaTamano.getWidth()*rand.nextDouble();
	posY=pantallaTamano.getHeight()*rand.nextDouble();
}
/**
 * Método para calcular la puntuación de un bonus de forma aleatoria entre cinco valores: 10, 20 , 30, 40 o 50.
 */
private void bonuspuntuacion()
{
	Random rand = new Random();

	int  n = rand.nextInt(5)+1;
			
	switch(n)
	{
	case 1:premio=10;
		break;
	case 2:premio=20;
		break;
	case 3:premio=30;
		break;
	case 4:premio=40;
		break;
	case 5:premio=50;
		break;
	}
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