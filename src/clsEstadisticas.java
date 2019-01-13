import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



public class clsEstadisticas extends JFrame 
{
	 static String applicationTitle;
	 String chartTitle ;
	 
	public clsEstadisticas(  ) {
		
		
	      super( applicationTitle );        
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Erabiltzaileak",            
	         "Puntuazioak",            
	         createDataset(),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	      setSize(700,500);
	      ChartPanel chartPanel = new ChartPanel( barChart );        
	      chartPanel.setPreferredSize(new java.awt.Dimension( 700 , 500 ) );        
	      setContentPane( chartPanel ); 
	   }
	
	
	   
	   private CategoryDataset createDataset( ) {
		   
		   
		   
	      final String fiat = "ERABILTZAILEAK";        
     
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  

			ArrayList usuariosConPuntuaciones = new ArrayList<clsUsuario>();
			try {
				usuariosConPuntuaciones = clsBD.leerPuntuaciones();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
						{final String usuario =  (((clsUsuario) usuariosConPuntuaciones.get(x)).getUsuario().toUpperCase(getLocale()));
						  dataset.addValue( array[i] , usuario , usuario ); }
							   
							 
						
						}
					}
			}
        
	           
	      return dataset; 
	   }
	   
	
}
