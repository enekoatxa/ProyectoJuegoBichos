import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;


public class vtEntrar extends JFrame implements ActionListener
{
	private JTextField textField;
	private JPasswordField textField_1;
	
	private final String PASAHITZAIKUSI = "PASAHITZAIKUSI";
	private final String PASAHITZAEZKUTATU = "PASAHITZAEZKUTATU";
	private final String COMMAND_BUTTON1 = "COMMAND_BUTTON1";
	
	public vtEntrar() {
		setTitle("Sartu");
		getContentPane().setLayout(null);
		
		setSize(387,180);
		
		JLabel lblUsuario = new JLabel("Erabiltzailea:");
		lblUsuario.setBounds(10, 28, 97, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(10, 68, 73, 14);
		getContentPane().add(lblPasahitza);
		
		textField = new JTextField();
		textField.setBounds(175, 25, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(175, 65, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*');
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.setBounds(128, 108, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnPassword = new JButton("");
		btnPassword.setBounds(300, 63, 24, 24);
		getContentPane().add(btnPassword);
		btnPassword.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia.png")));
		btnPassword.setActionCommand(PASAHITZAIKUSI);
		btnPassword.addActionListener(this);
		
		JButton btnPassword1 = new JButton("");
		btnPassword1.setBounds(337, 63, 24, 24);
		getContentPane().add(btnPassword1);
		btnPassword1.setIcon(new ImageIcon(vtCrear.class.getResource("/Imagenes/Begia2.png")));
		btnPassword1.setActionCommand(PASAHITZAEZKUTATU);
		btnPassword1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) 
	{
		String comando=e.getActionCommand();
		switch(comando)
		{
		
		case PASAHITZAIKUSI:
			
			textField_1.setEchoChar((char) 0); 

			break;
		case PASAHITZAEZKUTATU:
			
			textField_1.setEchoChar('*'); 

			break;
		case COMMAND_BUTTON1:
			
		
			break;
}
}
}
