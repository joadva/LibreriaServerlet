package maestria.DTO;


import java.io.Serializable;

public class UsuariosDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int ID;
	private String username;
	private String clave;
	private int privilegio;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}
	
	
	
}
