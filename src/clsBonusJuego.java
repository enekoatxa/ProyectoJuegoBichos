/**
 * 
 * @author Mikel Martinez, Eneko Atxa y Imanol Aizpuru
 * Es la clase que junta la clase clsBonus y su label. Hereda de clsBonus y as� tiene sus atributos, y tambi�n contiene un label, que es el gr�fico.
 *
 */
public class clsBonusJuego extends clsBonus
{
	private lblBonus grafico;
	
	/**
	 * Constructor sin par�metros de la clase, llamando primero a su super(clsBonus).
	 */
	public clsBonusJuego()
	{
		super();
		grafico = new lblBonus();
		this.setPosX(posX);
		this.setPosY(posY);

	}
	public lblBonus labela()
	{
		return grafico;

	}
	/**
	 * Pone la posici�n X, con una llamada que cambia el atributo y tambi�n la posici�n del gr�fico.
	 */
	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		grafico.setLocation( (int)posX, (int)posY );
		
	}
	/**
	 * Pone la posici�n Y, con una llamada que cambia el atributo y tambi�n la posici�n del gr�fico.
	 */
 	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		grafico.setLocation( (int)posX, (int)posY );
	}
 	/**
 	 * Rota el label del bonus de cinco en cinco y lo redibuja en pantalla.
 	 */
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
