package maestria.interfaces;

import java.util.Collection;

import maestria.DTO.ClientesDTO;

public interface ICliente {
	public ClientesDTO buscarClientePorRFC(String _rfc);
	public boolean guardarCliente(String _rfc,String _nom);
	public boolean actualizarCliente(String _nombre, String _rfc);
	public boolean eliminarCliente(String _rfc);
	public Collection<ClientesDTO> buscarTodosLosClientes();
}
