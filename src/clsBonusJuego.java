
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	
	
	public clsBonusJuego()
	{
		super();
		grafico = new lblBonus(bonus);
		this.setPosX(posX);
		this.setPosY(posY);

	}
	public lblBonus labela()
	{
		return grafico;

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
 	
 	public void RotarBonus()
	{
		grafico.addGiro( 5 );
		grafico.repaint();
	}
 	public lblBonus getGrafico() {
		return grafico;
	}
 	public void setGrafico(lblBonus grafico) {
		this.grafico = grafico;
	}	
}
