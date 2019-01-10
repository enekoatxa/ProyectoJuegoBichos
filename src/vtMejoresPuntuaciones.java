import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.sun.prism.paint.Color;



public class vtMejoresPuntuaciones extends JFrame 
{

	private JPanel contentPane;

	
	public vtMejoresPuntuaciones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(440, 150, 454, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(java.awt.Color.getHSBColor(40, 40, 50));
		
		JList list = new JList();
		 JScrollPane scrollPane = new JScrollPane(list);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		list.setBounds(0, 51, 454, 264);
		
		DefaultListModel modelo = new DefaultListModel();
		
		//datu hauek gero datu basetik atera eta izen berdina dakan erabiltzaileko puntuazio altuena bakrrik erakutsi
		//+ ordenatu haundienetik txikienera
		
		modelo.addElement("MIKEL MARTINEZ " + "........" + "100" );
		modelo.addElement("IMANOL AIZPURU" + ".........."+ "60");
		modelo.addElement("ENEKO ATXA" + " .................."+ "0");
		
		list.setFont(new Font("Arial",Font.BOLD,18));
	

		list.setModel(modelo);
		contentPane.add(list);
		
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
	}
}
