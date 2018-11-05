import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class vtCrear extends JFrame
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 65, 115, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 105, 115, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sortu");
		btnNewButton.setBounds(103, 149, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
