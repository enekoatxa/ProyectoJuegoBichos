
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	
	
	public clsBonusJuego(int bonus)
	{
		super(bonus);
		grafico = new lblBonus(bonus);
		this.setPosX(posX);
		this.setPosY(posY);
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
 	
 	public lblBonus getGrafico() {
		return grafico;
	}
 	public void setGrafico(lblBonus grafico) {
		this.grafico = grafico;
	}

 	
	
}
