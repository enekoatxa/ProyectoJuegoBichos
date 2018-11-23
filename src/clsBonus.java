
import java.util.Random;

public class clsBonus
{
	protected int bonus; //Determina el tipo de bonus que será, de puntuación o de tiempo.
	protected int premio;
	protected double posX;
	protected double posY;
//public clsBonus()
//{
//	
//}
public clsBonus(int bonus) //Constructor sin parámetros(solo 1 parámetro que utilizaremos para decidir la clase de bonus que será entre los dos que hemos definido. )
{
	System.out.println("m");
	if(bonus==0)//Si es 0 el bonus será de puntuación.
	{
		System.out.println("a");

		bonuspuntuacion(); //Le da una puntuación aleatoria entre 5 puntuaciones a nuestro bonus.
		
	}
	else	//Si es 1 el bonus será de tiempo
	{
		bonustiempo(); //Le da tiempo extra a nuestro bonus, entre 5, 10, 15, 20 o 35 segundos.
	}
	posicion();
	
	
}
private void posicion()
{
	System.out.println("o");

	Random rand = new Random();

//	posX=30;
//	posY=30;
	posX=1920*rand.nextDouble();
	posY=1080*rand.nextDouble();
}
private void bonuspuntuacion()
{
	System.out.println("n");

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
private void bonustiempo()
{
	Random rand = new Random();

	int  n = rand.nextInt(5)+1;
	switch(n)
	{
	case 1:premio=5;
		break;
	case 2:premio=10;
		break;
	case 3:premio=15;
		break;
	case 4:premio=20;
		break;
	case 5:premio=25;
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


}