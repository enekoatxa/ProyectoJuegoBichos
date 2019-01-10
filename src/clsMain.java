import java.awt.EventQueue;

public class clsMain 
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						vtPrincipal frame = new vtPrincipal(null);
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
