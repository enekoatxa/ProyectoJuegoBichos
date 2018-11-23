
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	
	
	public clsBonusJuego(int bonus)
	{
		super(bonus);
		grafico = new lblBonus(bonus);
<<<<<<< HEAD
		this.setPosX(posX);
		this.setPosY(posY);
=======

>>>>>>> 5ba7f5166d81fc87fcf77e6cc132a444be4e715f
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
