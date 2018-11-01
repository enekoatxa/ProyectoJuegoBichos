import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class vtPrincipal extends JFrame
{
	private JPanel contentPane;

	//main hau probisionala dek
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vtPrincipal frame = new vtPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public vtPrincipal()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 900, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Partida Berria");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setBounds(94, 144, 293, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Denbora Onenak");
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(94, 207, 293, 36);
		contentPane.add(btnNewButton);
		
		JTextArea txtrErabiltzailea = new JTextArea();
		txtrErabiltzailea.setBackground(new Color(154, 205, 50));
		txtrErabiltzailea.setText("Erabiltzailea: ");
		txtrErabiltzailea.setBounds(10, 11, 160, 22);
		contentPane.add(txtrErabiltzailea);
		
		JLabel imag = new JLabel();
		imag.setBounds(0, 0, 900, 562);
		contentPane.add(imag);
		imag.setIcon(new ImageIcon("img/E.png"));
		imag.setIcon(new ImageIcon(".\\src\\E.jpg"));
	}


}
