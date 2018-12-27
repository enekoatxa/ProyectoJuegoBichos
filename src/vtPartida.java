import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;




public class vtPartida extends JFrame
{
	private static final long serialVersionUID = 1L;
	motorPartida motor;
	ArrayList<clsEnemigoJuego>enemigos = new ArrayList<clsEnemigoJuego>();
	ArrayList<clsBonusJuego>bonuses = new ArrayList<clsBonusJuego>();
	clsBichoJuego bicho;
	private BufferedImage image;
	
	lblBonus bonus1;
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
		
		try {                
	          image = ImageIO.read(new File(".\\src\\Imagenes\\FondoJuego1.jpg"));
	          
	       } catch (IOException ex) {
	            
	       }
		//Creación de los dos hilos
		panel = new JPanel(){
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this); 
			}
		};
		setContentPane(panel);
//		getContentPane().add(panel);
		motor = new motorPartida(panel);
		bicho=motor.crearBicho();
		setSize(1360,760);
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation((pantallaTamano.width/2)-(this.getWidth()/2), (pantallaTamano.height/2)-(this.getHeight()/2)); 
		panel.setLayout(null);

		this.setCursor(this.getToolkit().createCustomCursor(
	            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
	            "null"));

	}
	
	
	public void startHilos()
	{
		spawner = new hiloCreador();
		Thread hiloSpawn = new Thread(spawner);
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
				
				bonuses.add(motor.creaBonus());
				enemigos.add(motor.creaEnemigo());
				if(contador==10)
				{
					
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
				for(int i =0; i<bonuses.size();i++)
				{
				bonuses.get(i).RotarBonus();
				}
				//Hemen for bat erabili beharko da, enemigo 1 baino gehiago egongo direlako batera (arraylista erabili)
				motor.calculaPosBicho();
				for(int i =0; i<enemigos.size();i++)
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
				choquesConBonus();
			}	
		}		
	}
	
	
	public int choquesConBonus() {
		int numChoques = 0;
		for (int i=bonuses.size()-1; i>=0; i--) {
			clsBonusJuego est = bonuses.get(i);
			if (chocaCocheConEstrella(est)) {
				numChoques++;
				System.out.println("sa");
				panel.remove( i );
				panel.repaint();
				bonuses.remove( est );
//				puntosJuego += 5;  // PASO 6
			}
		}
		return numChoques;
	}
	
	private boolean chocaCocheConEstrella( clsBonusJuego est ) {
		double distX = est.getPosX()+lblBonus.BONUS_TAMANYO/2-bicho.getPosX()-lblBicho.BICHO_TAMANYO/2;
		double distY = est.getPosY()+lblBonus.BONUS_TAMANYO/2-bicho.getPosY()-lblBicho.BICHO_TAMANYO/2;
		double dist = Math.sqrt( distX*distX + distY*distY );
		return (dist <= lblBicho.RADIO_ESFERA_BICHO + lblBonus.RADIO_ESFERA_BONUS);
		// Si su distancia es menor que la suma de sus radios, es que tocan
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
		//if(miPosX + mitamaño/2 >= Xenemigo - sutamaño/2 && miPosX - mitamaño/2 <= Xenemigo + sutamaño/2)
		
		//choque arriba y abajo
		//if(miPosY + mitamaño/2 >= Yenemigo - sutamaño/2 && miPosY - mitamaño/2 <= Yenemigo + sutamaño/2)
		return true;
		
	}
	
	public void borraEnemigo(clsEnemigoJuego e)
	{
		enemigos.remove(e);
		motor.borraEnemigoPantalla(e);
	}
	
	public void borrarEnemigos()
	{
		for(int i =0; i<enemigos.size();i++)
		{
			borraEnemigo(enemigos.get(i));
			motor.borraEnemigoPantalla(enemigos.get(i));
		}
	}
	
	
}
