import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;


public class vtEntrar extends JFrame
{
	private JTextField textField;
	private JTextField textField_1;
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
		textField.setBounds(189, 25, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 65, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.setBounds(128, 108, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
