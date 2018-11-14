import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class vtPartida extends JFrame
{
	private static final long serialVersionUID = 1L;
	motorPartida motor;
	ArrayList<clsEnemigoJuego>enemigos;
	
	hiloCreador spawner=null;
	hiloCalculadorPosiciones hiloPosiciones=null;
	boolean partidaSigue=true;
	JPanel panel = new JPanel();
	
	
	//IMPORTANT bi kalse hauen in ber dituzue, bakoitzak beria, labela ta beste klasia juntzatzeizkienak IZENAK: clsBichoJuego, clsBonusJuego
	//clsBichoJuego jugador;
	//ArrayList <clsBonusJuego> bonuses;
	
	
	public vtPartida()
	{
		//Creación de los dos hilos
		spawner = new hiloCreador();
		hiloPosiciones = new hiloCalculadorPosiciones();

		motor = new motorPartida(panel);

		setSize(1920,1080);

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
				enemigos.add(motor.creaEnemigo());
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
				//Hemen for bat erabili beharko da, enemigo 1 baino gehiago egongo direlako batera (arraylista erabili)
				for(clsEnemigoJuego e : enemigos)
				{
					motor.calculaPosicionEnemigo(e);
				}
				
				borrarEnemigos();
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public void terminaPartida()
	{
		partidaSigue=false;
	}

	public void borraEnemigo(clsEnemigoJuego e)
	{
		enemigos.remove(e);
	}
	
	public void borrarEnemigos()
	{
		for(clsEnemigoJuego e : enemigos)
		{
			if(e.posX<-50||e.posX>1970||e.posY<-50||e.posY>1130)
			{
				borraEnemigo(e);
			}
		}
	}
	
	int posXBicho;
	int posYBicho;
	
	//para saber donde se coloca el puntero del bicho en cada momento
	 public void addEventos(){
	        addMouseMotionListener(new MouseMotionAdapter(){
	            @Override
	           public void mouseMoved(MouseEvent evento){
	      
	                    posXBicho= evento.getX();
	                    posYBicho =evento.getY();
	                 
	            }
	         });
	        }
	    

}
