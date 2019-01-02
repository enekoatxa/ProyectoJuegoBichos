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
	clsUsuario usuario;
	
	private int puntuacion;
	
	
	public vtPartida(clsUsuario usuario)
	{
		this.usuario=usuario;
		puntuacion=0;
		
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
				
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
		setSize(pantallaTamano);
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
				puntuacion++;
				enemigos.add(motor.creaEnemigo());
				if(contador==10)
				{
					bonuses.add(motor.creaBonus());	
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
		//Sleep de 25 milisegundos
		@Override
		public void run()
		{
			while(partidaSigue)
			{
				for(int i =0; i<bonuses.size();i++)
				{
				bonuses.get(i).RotarBonus();
				if(motor.chocaCocheConEstrella(bonuses.get(i)))
				{
					//hacer lo que pasa cuando choca
					puntuacion++;
					borraBonus(bonuses.get(i));
					actualizarLabelPuntuacion();
				}
				
				}
				
				motor.calculaPosBicho();
				for(int i =0; i<enemigos.size();i++)
				{
					motor.calculaPosicionEnemigo(enemigos.get(i));
					if(motor.choqueConEnemigo(enemigos.get(i)))
					{
						terminaPartida();
					}	
										
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
//	
//	
//	public int choquesConBonus() {
//		int numChoques = 0;
//		for (int i=bonuses.size()-1; i>=0; i--) {
//			clsBonusJuego est = bonuses.get(i);
//			if (chocaCocheConEstrella(est)) {
//				numChoques++;
//				panel.remove( i );
//				panel.repaint();
//				bonuses.remove( est );
////				puntosJuego += 5;  // PASO 6
//			}
//=======
//>>>>>>> ce7021064bd8725bd971ae410a135d42e1efe82e
//		}
//
//				
//	}
		
	public void terminaPartida()
	{
		partidaSigue=false;
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
	public void borraBonus(clsBonusJuego b)
	{
		enemigos.remove(b);
		motor.borraBonusPantalla(b);
	}
	
	public void borrarBonuses()
	{
		for(int i =0; i<bonuses.size();i++)
		{
			borraBonus(bonuses.get(i));
			motor.borraBonusPantalla(bonuses.get(i));
		}
	}
	
	private void actualizarLabelPuntuacion() 
	{
		//Puntuazioa erakutsi!!!
	}
}
