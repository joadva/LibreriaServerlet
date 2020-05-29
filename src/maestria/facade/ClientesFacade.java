package maestria.facade;
import java.util.Collection;

import maestria.DAO.ClientesDAO;
import maestria.DTO.ClientesDTO;

public class ClientesFacade
{
     
   public ClientesDTO obtenerClienteporRFC(String rfc)
   {
      ClientesDAO clientesDAO = new ClientesDAO();
      
      return clientesDAO.buscarClientePorRFC(rfc);
   }
   
   public Collection<ClientesDTO> obtenerClientes()
   {
      ClientesDAO clientesDAO = new ClientesDAO();
      
      return clientesDAO.buscarTodosLosClientes();
   }
  
   public boolean grabarCliente(String rfc, String nom)
   {
      ClientesDAO clienteGrabaDAO = new ClientesDAO();
      
      return clienteGrabaDAO.guardarCliente(rfc, nom);
   }
   
   
}
