public class clsBichoJuego extends clsBicho {
	
	private lblBicho miGrafico;  

public clsBichoJuego(double miPosX, double miPosY)
{
	super(miPosX, miPosY);
	miGrafico = new lblBicho();
	this.setPosX(posX);
	this.setPosY(posY);
	
}	

@Override
public void setPosX(double posX) {
	super.setPosX(posX);
	miGrafico.setLocation( (int)posX, (int)posY );
	miGrafico.repaint();
}

@Override
public void setPosY(double posY) {
	super.setPosY(posY);
	miGrafico.setLocation( (int)posX, (int)posY );
	miGrafico.repaint();
}

public lblBicho getGrafico() {
	return miGrafico;
}

public void setGrafico(lblBicho grafico) {
	this.miGrafico = grafico;
}

public void add(clsBichoJuego crearBicho) {
	// TODO Auto-generated method stub
	
}

public void mueve(double posXActual, double posYActual) 
{
setPosX(posXActual);
setPosY(posYActual);
	
}

public void pasarDireccion()
{
miGrafico.setGiro(grados);	
}
}