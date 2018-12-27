import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class vtPrincipal extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private vtCrear vtCrear;
	private vtEntrar vtEntrar;
	private vtPartida vtPartida;
	private vtMejoresPuntuaciones vtp;
	private clsUsuario usuario;
	private BufferedImage image;
	//main hau probisionala dek
	private final String COMMAND_BUTTON0 = "COMMAND_BUTTON0";
	private final String COMMAND_BUTTON = "COMMAND_BUTTON";
	private final String COMMAND_BUTTON1 = "COMMAND_BUTTON1";
	private final String COMMAND_BUTTON2 = "COMMAND_BUTTON2";
	private final String COMMAND_BUTTON3= "COMMAND_BUTTON3";
	private final String COMMAND_BUTTON4= "COMMAND_BUTTON4";
	
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
		
		 try {                
	          image = ImageIO.read(new File(".\\src\\Imagenes\\E.jpg"));
	       } catch (IOException ex) {
	            
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
		
		JButton btnNewButton_1 = new JButton("Partida Berria");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setBounds(94, 144, 293, 39);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand(COMMAND_BUTTON1);
		
		JButton btnNewButton = new JButton("Puntuazio Onenak");
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(94, 207, 293, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand(COMMAND_BUTTON2);
		
		
	
		JButton btnErabiltzaileaSortu = new JButton("Erabiltzailea sortu");
		btnErabiltzaileaSortu.setBounds(10, 11, 161, 23);
		contentPane.add(btnErabiltzaileaSortu);
		btnErabiltzaileaSortu.addActionListener(this);
		btnErabiltzaileaSortu.setActionCommand(COMMAND_BUTTON);
		
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setBounds(750, 11, 89, 23);
		contentPane.add(btnSartu);
		btnSartu.addActionListener(this);
		btnSartu.setActionCommand(COMMAND_BUTTON0);
		usuario=null;
		}
				
	
	

	public void actionPerformed(ActionEvent e) 
	{
		String comando=e.getActionCommand();
		switch(comando)
		{
		
		case COMMAND_BUTTON:
			
			vtCrear=new vtCrear();
			vtCrear.setVisible(true);
	
			break;
		case COMMAND_BUTTON0:
			
			vtEntrar=new vtEntrar();
			vtEntrar.setVisible(true);
			
			
			break;
			
case COMMAND_BUTTON2:
			
			vtp=new vtMejoresPuntuaciones();
			vtp.setVisible(true);
			
			
			break;
		case COMMAND_BUTTON1:
			
			vtPartida=new vtPartida();
			vtPartida.setVisible(true);
			vtPartida.startHilos();
			
			break;
}
		
	}
	


}
