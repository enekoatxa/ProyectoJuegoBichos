import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Clase para la ventana que sirve para ense�arnos la puntuaci�n cuando hemos acabado la partida, extiende de JFrame y implementa ActionListener. Nos da la opci�n de reintentar o salir.
 * Esta clase contiene unos componentes de Swing; como lo son dos botones y un label.
 * Logger logger: Sirve para ense�ar en consola y guardar en un fichero cierta informaci�n de la ejecuci�n(p.e excepciones).
 */
public class vtFinal extends JFrame implements ActionListener
{
	private static Logger logger = Logger.getLogger( vtFinal.class.getName() );
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
	 try {
	 logger.addHandler( new FileHandler(
	 "Loggerrak.log.xml", ANYADIR_A_FIC_LOG ));
	 } catch (SecurityException | IOException e) {
	 logger.log( Level.SEVERE, "Log fitxeroaren sorkuntzan arazoak" );
	 }
	}
	private BufferedImage image;
	private JPanel contentPane;
	private clsUsuario usuario;
	/**
	 * Constructor con dos par�metros (usuario que ha jugado, la puntuaci�n que ha logrado) de la ventana.
	 * @param usuario
	 * @param puntuacion
	 */
	public vtFinal(clsUsuario usuario, int puntuacion)
	{
		this.usuario=usuario;
		try {                
	         image = ImageIO.read(new File(".\\src\\Imagenes\\E.jpg"));
	      } catch (IOException ex) {
	    	  logger.log(Level.WARNING, "Fondoa kargatzean arazoak");
	           
	      }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 900, 560);
		contentPane = new JPanel(){
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this); 
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblTitulo= new JLabel("Zure Puntuazioa: ");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("T", Font.PLAIN, 50));
		lblTitulo.setBounds(10, 50, 500, 46);
		contentPane.add(lblTitulo);
		
		JLabel lblPuntuacion = new JLabel("" + puntuacion);
		lblPuntuacion.setForeground(Color.WHITE);
		lblPuntuacion.setFont(new Font("P", Font.BOLD, 100));
		if(puntuacion<10)lblPuntuacion.setBounds(10, 100, 100, 100);
		else if(puntuacion<100)lblPuntuacion.setBounds(11, 100, 200, 100);
		else if(puntuacion<1000)lblPuntuacion.setBounds(11, 100, 300, 100);
		else if(puntuacion<10000)lblPuntuacion.setBounds(11, 100, 400, 100);
		else if(puntuacion<100000)lblPuntuacion.setBounds(11, 100, 500, 100);
		contentPane.add(lblPuntuacion);
		
		JButton btnMenu= new JButton("HASIERA");
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMenu.setForeground(new Color(0, 100, 0));
		btnMenu.setBounds(10, 200, 250, 60);
		JButton btnReintentar = new JButton("BERRIRO SAIATU");
		btnReintentar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReintentar.setForeground(new Color(0, 100, 0));
		btnReintentar.setBounds(270, 200, 250, 60);
		
		btnMenu.setActionCommand("menu");
		btnReintentar.setActionCommand("reintentar");
		btnMenu.addActionListener(this);
		btnReintentar.addActionListener(this);
		
		contentPane.add(btnMenu);
		contentPane.add(btnReintentar);
	}
	/**
	 * M�todo para gestionar las pulsaciones a los botones de la ventana mediante el Listener.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		String com=e.getActionCommand();
		switch(com)
		{
		case "menu":
			vtPrincipal principal = new vtPrincipal(usuario);
			principal.setVisible(true);
			this.setVisible(false);
			break;
		case "reintentar":
			vtPartida partida = new vtPartida(usuario);
			partida.setVisible(true);
			partida.startHilos();	
			this.setVisible(false);
			break;
		}
	}
	 
}
