import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;



public class clsTest 
{
	
	clsEnemigoJuego enemigo;
	clsBonusJuego bonus;
	clsBichoJuego bicho;
	motorPartida motor;
	
	@Before
	public void setUp()
	{
		enemigo= new clsEnemigoJuego();
		bonus= new clsBonusJuego();
		bicho = new clsBichoJuego(500, 500);
		motor= new motorPartida();
	}
	
	
	@Test
	public void testPosicionEnemigo() 
	{
		enemigo.setPosX(500);
		enemigo.setPosY(500);
		enemigo.setVelocidad(10);
		enemigo.setDireccion(0);
		enemigo.mueve(1);
		assertEquals(510, enemigo.getPosX(), 0.0001);
		assertEquals(500, enemigo.getPosY(), 0.0001);
		enemigo.mueve(10);
		assertEquals(610, enemigo.getPosX(), 0.0001);
		assertEquals(500, enemigo.getPosY(), 0.0001);
	}
	
	@Test
	public void testPosicionBonus() 
	{
		bonus.setPosX(300);
		bonus.setPosY(400);
		assertEquals(300, bonus.getPosX(), 0.0001);
		assertEquals(400, bonus.getPosY(), 0.0001);
		
	}
	
	@Test
	public void testPosicionBicho() 
	{
		bicho.setPosX(300);
		bicho.setPosY(400);
		assertEquals(300, bicho.getPosX(), 0.0001);
		assertEquals(400, bicho.getPosY(), 0.0001);
		
	}
	
	@Test
	public void testColision()
	{
		boolean hayChoque=true;
		boolean noHayChoque=false;
		motor.crearBichoTest();
		motor.bicho.setPosicion(300, 300);
		enemigo.setPosX(310);
		enemigo.setPosY(310);
		assertEquals(hayChoque, motor.choqueConEnemigo(enemigo));
		enemigo.setPosX(500);
		enemigo.setPosY(500);
		assertEquals(noHayChoque, motor.choqueConEnemigo(enemigo));
	}
	
	@Test
	public void testDesapareceBonus()
	{
		boolean haDesaparecido=true;
		boolean noHaDesaparecido=false;
		assertEquals(noHaDesaparecido, motor.compararTiempoBonus(bonus));
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		assertEquals(haDesaparecido, motor.compararTiempoBonus(bonus));
	}
	
	@Test
	public void testDesapareceEnemigo()
	{
		boolean haDesaparecido=true;
		boolean noHaDesaparecido=false;
		assertEquals(noHaDesaparecido, motor.compararTiempoEnemigo(enemigo));
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			
		}
		assertEquals(haDesaparecido, motor.compararTiempoEnemigo(enemigo));
	}

	@After
	public void close()
	{
		enemigo= null;
		bonus= null;
		bicho = null;
		motor= null;
	}
}
