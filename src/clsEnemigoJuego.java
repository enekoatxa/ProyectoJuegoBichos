
public class clsEnemigoJuego extends clsEnemigo
{
	private lblEnemigo grafico;
	
	public clsEnemigoJuego()
	{
		grafico = new lblEnemigo();
	}
	
	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		grafico.setLocation( (int)posX, (int)posY );
	}

	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		grafico.setLocation( (int)posX, (int)posY );
	}

	@Override
	public void setDireccion( double dir ) {
		super.setDireccion(dir);
		grafico.setGiro( dir );
		grafico.repaint();
	}

	public lblEnemigo getGrafico() {
		return grafico;
	}

	public void setGrafico(lblEnemigo grafico) {
		this.grafico = grafico;
	}
	
}
