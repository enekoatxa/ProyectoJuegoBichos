public class clsBichoJuego extends clsBicho
{

	private lblBonus grafico;
	
	public clsBichoJuego(double posX, double posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
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