import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;


public class vtCrear extends JFrame implements ActionListener
{
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	
	
	private final String PASAHITZAIKUSI = "PASAHITZAIKUSI";
	private final String PASAHITZAEZKUTATU = "PASAHITZAEZKUTATU";
	private final String COMMAND_BUTTON1 = "COMMAND_BUTTON1";
	
	public vtCrear() {
		
		setTitle("Erabiltzailea sortu");
		getContentPane().setLayout(null);
		
		setSize(387,222);
			
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
		
		JButton btnPassword = new JButton("");
		btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		btnPassword.setBounds(306, 83, 24, 24);
		getContentPane().add(btnPassword);
		btnPassword.addActionListener(this);
		btnPassword.setActionCommand(PASAHITZAEZKUTATU);
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
		
		JButton btnPassword1 = new JButton("");
		btnPassword1.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia2.png")));
		btnPassword1.setBounds(337, 83, 24, 24);
		getContentPane().add(btnPassword1);
		btnPassword1.addActionListener(this);
		btnPassword1.setActionCommand(PASAHITZAIKUSI);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		String comando=e.getActionCommand();
		switch(comando)
		{
		
		case PASAHITZAIKUSI:
			
			textField_1.setEchoChar((char) 0); 
			textField_2.setEchoChar((char) 0); 

			break;
		case PASAHITZAEZKUTATU:
			
			textField_1.setEchoChar('*'); 
			textField_2.setEchoChar('*'); 

			break;
		case COMMAND_BUTTON1:
			
		
			break;
}
}
}
