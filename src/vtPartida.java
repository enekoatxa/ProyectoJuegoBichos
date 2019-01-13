import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;



/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * 
 * Clase de estructura para la ventana donde se va a ejecutar nuestro juego.
 * Varios atributos:
 * Logger logger: Sirve para enseñar en consola la información que queramos.
 * motorPartida motor: La instancia a motorPartida que vamos a utilizar para gestionar nuestro bicho, enemigos y bonuses.
 * ArrayList<clsEnemigoJuego>enemigos: ArrayList donde se guardaran todos los enemigos en juego en cada momento.
 * ArrayList<clsBonusJuego>bonuses: ArrayList donde se guardaran todos los bonuses en juego en cada momento.
 * clsBichoJuego bicho: Atributo para gestionar el bicho.
 * int o: Atributo para gestionar el label del plus de puntuación que nos da un bonus.
 * int puntuacion: La puntuación que lleva el jugador en cada momento.
 */
public class vtPartida extends JFrame
{
	private static Logger logger = Logger.getLogger( vtPartida.class.getName() );
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
	 try {
	 logger.addHandler( new FileHandler(
	 "Loggerrak.log.xml", ANYADIR_A_FIC_LOG ));
	 } catch (SecurityException | IOException e) {
	 logger.log( Level.SEVERE, "Log fitxeroaren sorkuntzan arazoak" );
	 }
	}
	private static final long serialVersionUID = 1L;
	motorPartida motor;
	ArrayList<clsEnemigoJuego>enemigos = new ArrayList<clsEnemigoJuego>();
	ArrayList<clsBonusJuego>bonuses = new ArrayList<clsBonusJuego>();
	clsBichoJuego bicho;
	private BufferedImage image;
	int o=0;
	
	
	lblBonus bonus1;
	JLabel lblpntcn;
	JLabel lblPlus; 
	clsBonusJuego bonus;
	hiloCreador spawner=null;
	hiloCalculadorPosiciones hiloPosiciones=null;
	boolean partidaSigue=true;
	JPanel panel; 
	clsUsuario usuario;
	
	private int puntuacion;
	private int tiempogen=1000;
	/**
	 * Constructor de la clase con el usuario que juega de parámetro. Crea una ventana con el principio del juego(un fondo y un bicho). 
	 * @param usuario
	 */
	public vtPartida(clsUsuario usuario)
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.usuario=usuario;
		puntuacion=0;
	
		logger.log( Level.INFO, "Partida hasi da." );
		try {                
	          image = ImageIO.read(new File(".\\src\\Imagenes\\FondoJuego1.jpg"));
	          
	       } catch (IOException ex) {
	    	   logger.log( Level.WARNING, "Fondoaren kargan arazoak");
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
		
		JLabel lblPuntuacin = new JLabel("Puntuazioa:");
		lblPuntuacin.setForeground(Color.WHITE);
		lblPuntuacin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPuntuacin.setBounds(11, 0, 119, 46);
		panel.add(lblPuntuacin);
		
		lblPlus = new JLabel("");
		lblPlus.setForeground(Color.WHITE);
		lblPlus.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblPlus);
		
		lblpntcn = new JLabel("");
		lblpntcn.setForeground(Color.WHITE);
		lblpntcn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblpntcn.setBounds(140, 0, 97, 46);
		panel.add(lblpntcn);
		
		this.setCursor(this.getToolkit().createCustomCursor(
	            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
	            "null"));
		
		
	
	
	}
	
	/**
	 * Método para dar comienzo a los dos hilos que utilizaremos en esta clase.
	 */
	public void startHilos()
	{
		spawner = new hiloCreador();
		Thread hiloSpawn = new Thread(spawner);
		hiloSpawn.start();
		
		hiloPosiciones = new hiloCalculadorPosiciones();
		Thread hiloPosi = new Thread (hiloPosiciones);
		hiloPosi.start();
				
	}
		/**
		 * 
		 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
		 * Este hilo irá creando enemigos y bonuses(1 cada 10 enemigos) de manera continuada mientras el juego no se termine.
		 * Además va actualizando la puntuación.
		 */
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
				actualizarLabelPuntuacion();
				enemigos.add(motor.creaEnemigo());
				if(contador==10)
				{
					bonuses.add(motor.creaBonus());	
					tiempogen=(int)(tiempogen/1.1);
					contador=0;
				}
				contador++;
				try {
					Thread.sleep(tiempogen);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					 logger.log( Level.WARNING, e.getMessage());
				}
			}
					
		}
		
	}
	/**
	 * 
	 * @author  Mikel Martinez, Eneko Atxa y Imanol Aizpuru
	 * Método para gestionar los choques del bicho con los enemigos o los bonuses.
	 * Además de ello aumenta la puntuación, la actualiza,... Y enseña la puntuación de cada bonus cuando este es cogido o desaparecido(después de 5 segundos desde cuando fue creado).
	 */
	class hiloCalculadorPosiciones implements Runnable
	{
		//Sleep de 25 milisegundos
		@Override
		public void run()
		{
			while(partidaSigue)
			{
				o++;
				if(o==15)
				{
					lblPlus.setVisible(false);
					o=0;
				}
				for(int i =0; i<bonuses.size();i++)
				{
				bonuses.get(i).RotarBonus();
					
					if(motor.chocaCocheConEstrella(bonuses.get(i)))
					{
						//hacer lo que pasa cuando choca
						Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
						lblPlus.setVisible(true);
						o=1;
						Double x=bonuses.get(i).posX;
						Double y=bonuses.get(i).posY;
						int plus=bonuses.get(i).getPremio();
						lblPlus.setText("+"+plus+"!");
						puntuacion=puntuacion+bonuses.get(i).getPremio();
						logger.log( Level.INFO, "+ "+plus+" puntu." );

						if((x.intValue()>pantallaTamano.width-100)&&(y.intValue()>pantallaTamano.height-100))
						{
							lblPlus.setBounds(pantallaTamano.width-200,pantallaTamano.height-100,100,100);
						}
						if(x.intValue()>pantallaTamano.width-100)
						{
							lblPlus.setBounds(pantallaTamano.width-200,y.intValue(),100,100);
						}
						if(y.intValue()>pantallaTamano.height-100)
						{
							lblPlus.setBounds(x.intValue(),pantallaTamano.height-100,100,100);
						}
						else
						{
							lblPlus.setBounds(x.intValue(),y.intValue(),100,100);
	
						}
						borraBonus(bonuses.get(i));
						actualizarLabelPuntuacion();
					}
					else
					{
						if(motor.compararTiempoBonus(bonuses.get(i)))
						{
							lblPlus.setVisible(true);
							o=1;
							Double x=bonuses.get(i).posX;
							Double y=bonuses.get(i).posY;
							int plus=bonuses.get(i).getPremio();
							lblPlus.setText(plus+"...");
							lblPlus.setBounds(x.intValue(),y.intValue(),100,100);
							borraBonus(bonuses.get(i));
							actualizarLabelPuntuacion();

						}
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
						borraEnemigo(enemigos.get(i));
					}
				}		
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					 logger.log( Level.WARNING, e.getMessage());
				}
				

			}

		}		
	}
		/**
		 * Método para terminar la partida cuando el bicho choca contra un enemigo. Guarda en la base de datos la puntuación lograda por el usuario.
		 */
	public void terminaPartida()
	{
		partidaSigue=false;
		try {
			clsBD.escribirPuntuacion(usuario, puntuacion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 logger.log( Level.WARNING, e.getMessage());
		}
		logger.log( Level.INFO, "Partida bukatu da." );
		vtFinal ultima = new vtFinal(usuario, puntuacion);
		ultima.setVisible(true);
		this.dispose();
	}
	/**
	 * Método para boorar un enemigo de la pantalla
	 * @param e Enemigo a borrar
	 */
	public void borraEnemigo(clsEnemigoJuego e)
	{
		enemigos.remove(e);
		motor.borraEnemigoPantalla(e);
	}
	/**
	 * Método para borrar todos los enemigos
	 */
	public void borrarEnemigos()
	{
		for(int i =0; i<enemigos.size();i++)
		{
			borraEnemigo(enemigos.get(i));
			motor.borraEnemigoPantalla(enemigos.get(i));
		}
	}
	/**
	 * Método para boorar un bonus de la pantalla
	 * @param e Bonus a borrar
	 */
	public void borraBonus(clsBonusJuego b)
	{
		bonuses.remove(b);
		motor.borraBonusPantalla(b);
	}
	/**
	 * Método para borrar todos los bonuses
	 */
	public void borrarBonuses()
	{
		for(int i =0; i<bonuses.size();i++)
		{
			borraBonus(bonuses.get(i));
			motor.borraBonusPantalla(bonuses.get(i));
		}
	}
	/**
	 * Método para actualizar el label que nos enseña la puntuación.
	 */
	private void actualizarLabelPuntuacion() 
	{
		lblpntcn.setText(" " +puntuacion);
	}
}
