import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;




import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class vtPartida extends JFrame
{
	private static final long serialVersionUID = 1L;
	motorPartida motor;
	ArrayList<clsEnemigoJuego>enemigos = new ArrayList<clsEnemigoJuego>();
	
	clsBonusJuego bonus;
	hiloCreador spawner=null;
	hiloCalculadorPosiciones hiloPosiciones=null;
	boolean partidaSigue=true;
	JPanel panel; 
	
	
	//IMPORTANT bi kalse hauen in ber dituzue, bakoitzak beria, labela ta beste klasia juntzatzeizkienak IZENAK: clsBichoJuego, clsBonusJuego
	//clsBichoJuego jugador;
	//ArrayList <clsBonusJuego> bonuses;
	
	
	public vtPartida()
	{
		//Creaci�n de los dos hilos
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		motor = new motorPartida(panel);
		setSize(1920,1080);
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setBounds(341, 38, 46, 14);
//		panel.add(lblNewLabel);
//		try
//		{
//			lblNewLabel.setIcon( new ImageIcon( vtPartida.class.getResource( "Imagenes/margarita.png" ).toURI().toURL() ) );
//		}
//		catch(Exception e)
//		{
//			System.out.println("Error: label de bonus no encontrado");
//		}
		
	}
	
	
	public void startHilos()
	{
		spawner = new hiloCreador();
		Thread hiloSpawn = new Thread( spawner);
		hiloSpawn.start();
		
		hiloPosiciones = new hiloCalculadorPosiciones();
		Thread hiloPosi = new Thread (hiloPosiciones);
		hiloPosi.start();
				
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
				
				bonus=motor.creaBonus();

				enemigos.add(motor.creaEnemigo());
				if(contador==10)
				{
//					motor.creaBonus();

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
				for(int i=0; i<enemigos.size(); i++)
				{
					motor.calculaPosicionEnemigo(enemigos.get(i));
					
					//meter aqui los choques
					
					if(motor.compararTiempoEnemigo(enemigos.get(i)))
					{
						motor.borraEnemigoPantalla(enemigos.get(i));
						enemigos.remove(enemigos.get(i));
					}
				}
						
				try {
					Thread.sleep(25);
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

	
	// programar choques
	public boolean compararChoques(clsEnemigoJuego enemigo)
	{
//		double Xenemigo = enemigo.getPosX();
//		double Yenemigo = enemigo.getPosY();
//		double miPosX = bicho.getPosX();
//		double miposY = bicho.getPosY();
		
		//choque lateral
		//if(miPosX + mitama�o/2 >= Xenemigo - sutama�o/2 && miPosX - mitama�o/2 <= Xenemigo + sutama�o/2)
		
		//choque arriba y abajo
		//if(miPosY + mitama�o/2 >= Yenemigo - sutama�o/2 && miPosY - mitama�o/2 <= Yenemigo + sutama�o/2)
		return true;
		
	}
	
	public void borraEnemigo(clsEnemigoJuego e)
	{
		enemigos.remove(e);
		motor.borraEnemigoPantalla(e);
	}
	
	public void borrarEnemigos()
	{
		for(clsEnemigoJuego e : enemigos)
		{
			if(e.posX<-50||e.posX>1970||e.posY<-50||e.posY>1130)
			{
				borraEnemigo(e);
				motor.borraEnemigoPantalla(e);
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
