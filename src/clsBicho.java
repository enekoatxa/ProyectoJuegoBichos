<<<<<<< HEAD
import java.awt.MouseInfo;

import com.sun.javafx.scene.paint.GradientUtils.Point;
=======
>>>>>>> f7a7e7642312363f54d445bb97f6b93a547602a9
public class clsBicho 
{
	private double posX;
	private double posY;
	private lblBicho label; 
	// tipo bicho elegitzeko aukera ere hemendikan?
	
	
	public clsBicho(double posX, double posY)
	{
		
		this.posX=posX;
		this.posY=posY;
		label = new lblBicho();
		
	}
	
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public lblBicho getLabel() {
		return label;
	}

	public void setLabel(lblBicho label) {
		this.label = label;
	}

	
	
	
}

