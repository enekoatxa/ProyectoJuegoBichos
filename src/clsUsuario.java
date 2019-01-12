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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsUsuario other = (clsUsuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
