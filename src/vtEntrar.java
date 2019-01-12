import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * 
 *  @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Clase para la ventana que sirve para entrar con un usuario, extiende de JFrame y implementa ActionListener.
 * Esta clase contiene varios atributos que son componentes de Swing; como textField-s o botones.
 * Por otro lado contiene dos atributos que valen para que el ActionListener pueda distinguir entre componentes.
 * También cuenta con un booleano que sirve para enseñar o ocultar la contraseña.
 *
 */
public class vtEntrar extends JFrame implements ActionListener
{
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnPassword;
	private boolean pasahitza;
	
	private final String PASAHITZAIKUSI = "PASAHITZAIKUSI";
	private final String COMMAND_BUTTON1 = "COMMAND_BUTTON1";
	private Properties props = null;
	/**
	 * Constructor sin parámetros para la creación de la ventana.
	 */
	public vtEntrar() 

	{
	
		setTitle("Sartu");
		getContentPane().setLayout(null);
		
		setSize(387,180);
		pasahitza=false;
		
		JLabel lblUsuario = new JLabel("Erabiltzailea:");
		lblUsuario.setBounds(10, 28, 97, 14);
		getContentPane().add(lblUsuario);
		
		JCheckBox chkUsuario = new JCheckBox("Gorde erabiltzailea");
		chkUsuario.setBounds(5, 48, 153, 14);
		getContentPane().add(chkUsuario);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(10, 68, 73, 14);
		getContentPane().add(lblPasahitza);
		
		JCheckBox chkPassword= new JCheckBox("Gorde pasahitza");
		chkPassword.setBounds(5, 84, 140, 14);
		getContentPane().add(chkPassword);
		
		textField = new JTextField();
		textField.setBounds(186, 45, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(186, 81, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*');
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.setBounds(128, 108, 89, 23);
		getContentPane().add(btnNewButton);
		cargarProperties();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion();
				guardarProperties(chkUsuario.isSelected(), chkPassword.isSelected());
				}
	});
		
		btnPassword = new JButton("");
		btnPassword.setBounds(300, 63, 24, 24);
		getContentPane().add(btnPassword);
		btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		btnPassword.setActionCommand(PASAHITZAIKUSI);
		btnPassword.addActionListener(this);

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
	
		case COMMAND_BUTTON1:
			
		
			break;
		}
	}
	/**
	 * Método para entrar en el usuario correspondiente, mediante la lectura en la base de datos.
	 */
	public void inicioSesion()
	{
		String nombre= textField.getText();
		String contrasenya = textField_1.getText();
		boolean existe=false;
		
		HashSet<clsUsuario> usuarios = new HashSet<clsUsuario>();
		//falta leer usuarios de base de datos, comparar e intentar entrar
		
		try {
			usuarios=clsBD.leerUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(clsUsuario u: usuarios)
		{
			if(u.getUsuario().equals(nombre) && u.getContrasenya().equals(contrasenya))
			{
				vtPrincipal principal= new vtPrincipal(u);
				existe=true;
				principal.setVisible(true);
				dispose();
			}	
		}
		if(existe==false)
		JOptionPane.showMessageDialog(this, "Ez dago izen eta pasahitz hori dituen erabiltzailerik, saiatu berriro.");
		
	}
	
	public void guardarProperties(boolean chkUsuario, boolean chkPassword)
	{
		String usuario = textField.getText();
		String contrasenya = textField_1.getText();
		if(chkUsuario)
		props.setProperty("nombre", usuario);
		else
		props.setProperty("nombre", "");
		if(chkPassword)
		props.setProperty("contrasenya", contrasenya);
		else
			props.setProperty("contrasenya", "");
		
		try {
			props.storeToXML( new PrintStream( "Properties" ), "Propiedades de Configuracion" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarProperties()
	{
		props = new Properties();
		try {
			props.loadFromXML( new FileInputStream( "Properties" ) );
		} catch (Exception e) { }
		
		textField.setText(props.getProperty("nombre"));
		textField_1.setText(props.getProperty("contrasenya"));	
	}
	
}
