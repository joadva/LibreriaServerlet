package maestria.interfaces;

import java.util.Collection;


import maestria.DTO.UsuariosDTO;


public interface IUsuario{
	public UsuariosDTO verificarUsuario(String _user, String _clave);
	public boolean guardarUsuario(int id,String _username, String _clave, int _privilegio);
	public boolean eliminarUsuario(int _ID);
	public boolean editarUsuario(int _ID, String username, String clave, int privilegio );
	public Collection<UsuariosDTO> buscarTodosLosUsuarios();
	

}
