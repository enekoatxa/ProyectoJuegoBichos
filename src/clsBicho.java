
import java.awt.MouseInfo;
import com.sun.javafx.scene.paint.GradientUtils.Point;

public class clsBicho 
{
	protected double posX;
	protected double posY;
	private lblBicho label; 
	
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

	//falta el metodo mueve
	
	
	
}

