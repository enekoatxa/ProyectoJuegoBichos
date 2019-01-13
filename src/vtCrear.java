import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Clase para la ventana que sirve para crear un usuario, extiende de JFrame y implementa ActionListener.
 * Esta clase contiene varios atributos que son componentes de Swing; como textField-s o botones.
 * Por otro lado contiene dos atributos que valen para que el ActionListener pueda distinguir entre componentes.
 * También cuenta con un booleano que sirve para enseñar o ocultar la contraseña.
 * Logger logger: Sirve para enseñar en consola y guardar en un fichero cierta información de la ejecución(p.e excepciones).
 */
public class vtCrear extends JFrame implements ActionListener
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
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private boolean pasahitza;
	private boolean pasahitza1;
	private JButton btnPassword;
	private JButton btnPassword1;
	
	private final String PASAHITZAIKUSI = "PASAHITZAIKUSI";
	private final String PASAHITZAIKUSI1 = "PASAHITZAIKUSI1";
	/**
	 * Constructor sin parámetros para la creación de la ventana.
	 */
	public vtCrear() {
		
		setTitle("Erabiltzailea sortu");
		getContentPane().setLayout(null);
		
		setSize(387,222);
		pasahitza=false;
			
		JLabel lblUsuario = new JLabel("Erabiltzailea:");
		lblUsuario.setBounds(10, 28, 97, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(10, 68, 73, 14);
		getContentPane().add(lblPasahitza);
		
		JLabel lblPasahitzaErrepikatu = new JLabel("Pasahitza errepikatu:");
		lblPasahitzaErrepikatu.setBounds(10, 108, 150, 14);
		getContentPane().add(lblPasahitzaErrepikatu);
		
		textField = new JTextField();
		textField.setBounds(189, 25, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(189, 65, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*'); 
 
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(189, 105, 115, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEchoChar('*'); 
		
		JButton btnNewButton = new JButton("Sortu");
		btnNewButton.setBounds(103, 149, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				crearUsuario();
				}
	});
		
		btnPassword = new JButton("");
		btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		btnPassword.setBounds(317, 65, 24, 24);
		getContentPane().add(btnPassword);
		btnPassword.addActionListener(this);
		btnPassword.setActionCommand(PASAHITZAIKUSI);
		
		btnPassword1 = new JButton("");
		btnPassword1.addActionListener(this);
		btnPassword1.setActionCommand(PASAHITZAIKUSI1);
		btnPassword1.setBounds(317, 104, 24, 24);
		getContentPane().add(btnPassword1);
		btnPassword1.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		
//		btnPassword.setIcon(new ImageIcon("img/E.png"));
//		btnPassword.setIcon(new ImageIcon(".\\src\\Begia.png"));
//		try
//		{
//		btnPassword.setIcon( new ImageIcon( vtCrear.class.getResource( "Imagenes/Begia.png" ).toURI().toURL() ) );
//		}
//		catch(Exception e)
//		{
//			System.out.println("Error: label de enemigo no encontrado");
//		}
		
	
		
	}
	/**
	 * Método para gestionar las pulsaciones a los botones de la ventana mediante el Listener.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		String comando=e.getActionCommand();
		switch(comando)
		{
		
		case PASAHITZAIKUSI:
			if(pasahitza)
			{
				textField_1.setEchoChar('*'); 
				pasahitza=false;
				btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));

			}
			else
			{
				textField_1.setEchoChar((char) 0); 
				pasahitza=true;
				btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia2.png")));
				
			}
			break;

	
		case PASAHITZAIKUSI1:
			if(pasahitza1)
			{
				textField_2.setEchoChar('*'); 
				pasahitza1=false;
				btnPassword1.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));

			}
			else
			{
				textField_2.setEchoChar((char) 0); 
				pasahitza1=true;
				btnPassword1.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia2.png")));
				
			}
			

		break;
		}
	}
	/**
	 * Método para crear el usuario y guardarlo en la base de datos.
	 */
	public void crearUsuario()
	{
		String nombre = null;
		String contrasenya = null;
		
		nombre=textField.getText();
		if(textField_1.getText().equals(textField_2.getText()) && textField_1.getText()!="")
		{
			contrasenya=textField_1.getText();
			clsUsuario nuevo = new clsUsuario(nombre, contrasenya);
			HashSet<clsUsuario> usuarios = new HashSet <clsUsuario>();
			try {
				usuarios=clsBD.leerUsuarios();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.log(Level.WARNING,"Datu basea irakurtzean arazoak.");
			}
			if(usuarios.contains(nuevo))
			{
				JOptionPane.showMessageDialog(this, "Jada exititzen da erabiltzaile hori.");
			}
			else
			{
				try {
					clsBD.escribirUsuario(nuevo);
				} catch (SQLException e) {
					logger.log(Level.WARNING,"Datu basean idaztean arazoak.");
				}
				JOptionPane.showMessageDialog(this, "Erabiltzailea datu basean sartu da");
				this.dispose();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Pasahitzak ez dira berdinak, saiatu berriro.");	
		}
				
	}
}
