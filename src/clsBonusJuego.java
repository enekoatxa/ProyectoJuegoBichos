
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	
	
	public clsBonusJuego(int bonus)
	{
		super(bonus);

		if(bonus==0)
		{
			grafico = new lblBonus();
		}
		else
		{
		
		}
		

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
