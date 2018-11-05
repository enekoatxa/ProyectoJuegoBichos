import javax.swing.JFrame;


public class vtPartida extends JFrame
{
	private static final long serialVersionUID = 1L;
	motorPartida motor;
	clsEnemigoJuego enemigo;
	hiloCreador spawner=null;
	hiloCalculadorPosiciones hiloPosiciones=null;
	boolean partidaSigue=true;
	
	//IMPORTANT bi kalse hauen in ber dituzue, bakoitzak beria, labela ta beste klasia juntzatzeizkienak IZENAK: clsBichoJuego, clsBonusJuego
	//clsBichoJuego jugador;
	//ArrayList <clsBonusJuego> bonuses;
	
	
	public vtPartida()
	{
		//Creación de los dos hilos
		spawner = new hiloCreador();
		hiloPosiciones = new hiloCalculadorPosiciones();
		
	}
	
	class hiloCreador implements Runnable
	{
		//Sleep de unos segundos o un sleep variable segun avance la partida?
		//Con este contador, cada 10 enemigos crea 1 bonus
		int contador=0;
		@Override
		public void run() 
		{
			
			while(partidaSigue)
			{
				motor.creaEnemigo();
				if(contador==10)
				{
					motor.creaBonus();
					contador=0;
				}
				contador++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	class hiloCalculadorPosiciones implements Runnable
	{

		//Sleep de 40 milisegundos
		@Override
		public void run()
		{
			while(partidaSigue)
			{
				
			}
			
		}
		
	}
	
	public void terminaPartida()
	{
		partidaSigue=false;
	}

	
}
