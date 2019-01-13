import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.sun.prism.paint.Color;



public class vtMejoresPuntuaciones extends JFrame 
{

	private JPanel contentPane;
	private clsEstadisticas estadistica;

	
	public vtMejoresPuntuaciones() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(440, 150, 454, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(java.awt.Color.getHSBColor(71,456,999));
		
		JList list = new JList();
		 JScrollPane scrollPane = new JScrollPane(list);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		list.setBounds(40, 51, 350, 264);
		
		DefaultListModel modelo = new DefaultListModel();
		
		ArrayList usuariosConPuntuaciones = new ArrayList<clsUsuario>();
		usuariosConPuntuaciones = clsBD.leerPuntuaciones();
	    int[]array=new int[usuariosConPuntuaciones.size()];
	    ArrayList puntuaciones = new ArrayList<>();
	   
	    
		for (int i = 0; i < usuariosConPuntuaciones.size(); ++i) 
		{
			puntuaciones= ((clsUsuario) usuariosConPuntuaciones.get(i)).getPuntuaciones();
			int puntuacionMasAlta=0;
			int aux=0;
			
			for (int x = 0; x < puntuaciones.size(); ++x) 
			{
			aux=(int) puntuaciones.get(x);
			if(aux>puntuacionMasAlta)
			{
			puntuacionMasAlta =  (int) puntuaciones.get(x);
			}
			}
			
			array [i]= puntuacionMasAlta;
			
		}
		for (int x = 0; x < array.length; x++) {
	        for (int i = 0; i < array.length-x-1; i++) {
	            if(array[i] < array[i+1]){
	                int tmp = array[i+1];
	                array[i+1] = array[i];
	                array[i] = tmp;
	            }
	        }
	    }
		
		
		
		
		for(int i=0;i<(array.length);i++)
		{
			
			for (int x = 0; x < usuariosConPuntuaciones.size(); ++x) 
			{
				puntuaciones= ((clsUsuario) usuariosConPuntuaciones.get(x)).getPuntuaciones();
				int aux=0;
				
				for (int y = 0; y< puntuaciones.size(); ++y) 
				{
					aux=(int) puntuaciones.get(y);
					if(aux==array[i])
					{
					modelo.addElement(((clsUsuario) usuariosConPuntuaciones.get(x)).getUsuario().toUpperCase(getLocale()) + 		
						"                                 "+						array[i]);
				
					
					}
					}
				}
		}
		
		list.setFont(new Font("Times New Roman",Font.BOLD,15));		
		list.setModel(modelo);
		contentPane.add(list);
		
		JLabel imag = new JLabel();
		imag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		imag.setBounds(5, 48, 20, 20);
		contentPane.add(imag);
		imag.setIcon(new ImageIcon(".\\src\\Imagenes\\primero.png"));
		
		JLabel imag2 = new JLabel();
		imag2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		imag2.setBounds(5, 70, 20, 20);
		contentPane.add(imag2);
		imag2.setIcon(new ImageIcon(".\\src\\Imagenes\\segundo.jpg"));
		
		JLabel imag3 = new JLabel();
		imag3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		imag3.setBounds(5, 92, 20, 20);
		contentPane.add(imag3);
		imag3.setIcon(new ImageIcon(".\\src\\Imagenes\\tercero.jpg"));
		
		JLabel lblPuntuazioHoberenak = new JLabel("PUNTUAZIO HOBERENAK");
		lblPuntuazioHoberenak.setBounds(140, 11, 162, 14);
		contentPane.add(lblPuntuazioHoberenak);
		
		JButton btnNewButton = new JButton("Atzera");
		btnNewButton.setBounds(180, 370, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible (false);
				dispose ();
			}
	});
		
		JButton btnNewButton2 = new JButton("Estadistikak");
		btnNewButton2.setBounds(320, 10, 110, 20);
		contentPane.add(btnNewButton2);
		
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				estadistica=new clsEstadisticas();
				estadistica.setVisible(true);
				
				setVisible (false);
				dispose ();
			}
	});
	}
}
