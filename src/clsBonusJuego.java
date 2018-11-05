
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	private lblBonusTiempo grafico1;
	
	public clsBonusJuego(int bonus)
	{
		super(bonus);

		if(bonus==0)
		{
			grafico = new lblBonus();
		}
		else
		{
			grafico1 = new lblBonusTiempo();
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
	public lblBonusTiempo getGrafico1() {
		return grafico1;
	}
	public void setGrafico1(lblBonusTiempo grafico1) {
		this.grafico1 = grafico1;
	}
 	
	
}
