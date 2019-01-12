import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.PrintStream;
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


public class vtEntrar extends JFrame implements ActionListener
{
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnPassword;
	private boolean pasahitza;
	
	private final String PASAHITZAIKUSI = "PASAHITZAIKUSI";
	private final String COMMAND_BUTTON1 = "COMMAND_BUTTON1";
	private Properties props = null;
	
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
				setVisible (false);
				dispose ();
			}
	});
		
		btnPassword = new JButton("");
		btnPassword.setBounds(300, 63, 24, 24);
		getContentPane().add(btnPassword);
		btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		btnPassword.setActionCommand(PASAHITZAIKUSI);
		btnPassword.addActionListener(this);

	}
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
	
	public void inicioSesion()
	{
		String usuario= textField.getText();
		String contrasenya = textField_1.getText();
		
		HashSet usuarios = new HashSet<clsUsuario>();
		//falta leer usuarios de base de datos, comparar e intentar entrar
		
		//usuarios=gestorBD.leerUsuarios;
//		for(clsUsuario u: usuarios)
//		{
//		if(u.getNombre=nombre && u.getContrasenya)
//		{
//			vtPrincipal principal= new vtPrincipal(u);
//		}	
//		}
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
