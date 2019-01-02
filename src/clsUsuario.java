import java.util.ArrayList;


public class clsUsuario 
{
	private String usuario;
	private String contrasenya;
	private ArrayList<Integer>puntuaciones;
	
	public clsUsuario(String usuario, String contrasenya)
	{
		this.usuario=usuario;
		this.contrasenya=contrasenya;
		puntuaciones = new ArrayList<Integer>();
	}	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public ArrayList<Integer> getPuntuaciones() {
		return puntuaciones;
	}
	public void setPuntuaciones(ArrayList<Integer> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
	
}
