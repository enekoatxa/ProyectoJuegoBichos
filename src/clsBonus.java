
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
	if(bonus==0)//Si es 0 el bonus será de puntuación.
	{
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
	Random rand = new Random();

	int  n = rand.nextInt(1000)+1;//Suponiendo que la pantalla sea un cuadrado 1000x1000
	posX=n;
	int  m = rand.nextInt(1000)+1;//Suponiendo que la pantalla sea un cuadrado 1000x1000
	posY=m;
}
private void bonuspuntuacion()
{
	Random rand = new Random();

	int  n = rand.nextInt(5)+1;
	if (n==1)
	{
		premio=10;
	}
	if (n==2)
	{
		premio=25;
	}
	if (n==3)
	{
		premio=50;
	}
	if (n==4)
	{
		premio=100;
	}
	if (n==5)
	{
		premio=200;
	}
		
	
}
private void bonustiempo()
{
	Random rand = new Random();

	int  n = rand.nextInt(5)+1;
	if (n==1)
	{
		premio=5;
	}
	if (n==2)
	{
		premio=10;
	}
	if (n==3)
	{
		premio=15;
	}
	if (n==4)
	{
		premio=20;
	}
	if (n==5)
	{
		premio=25;
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