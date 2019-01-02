import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class vtFinal extends JFrame implements ActionListener
{
	private BufferedImage image;
	private JPanel contentPane;
	private clsUsuario usuario;
	
	public vtFinal(clsUsuario usuario, int puntuacion)
	{
		this.usuario=usuario;
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
