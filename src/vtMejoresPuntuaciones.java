import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;



public class vtMejoresPuntuaciones extends JFrame 
{

	private JPanel contentPane;

	public vtMejoresPuntuaciones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(373, 31, 17, 194);
		contentPane.add(scrollBar);
		
		JList list = new JList();
		list.setBounds(36, 31, 354, 194);
		contentPane.add(list);
		
		JLabel lblPuntuazioHoberenak = new JLabel("Puntuazio Hoberenak");
		lblPuntuazioHoberenak.setBounds(24, 11, 162, 14);
		contentPane.add(lblPuntuazioHoberenak);
	}
}
