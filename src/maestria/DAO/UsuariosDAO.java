package maestria.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;


import maestria.DTO.UsuariosDTO;
import maestria.interfaces.IUsuario;
import util.UConnection;

public class UsuariosDAO implements IUsuario{

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public UsuariosDTO verificarUsuario(String _user, String _clave){
		UsuariosDTO usuarioEncontrado = null;
        try{
        	con = (Connection) UConnection.getConnection();
            String sql="SELECT * FROM usuario WHERE username=? AND clave=?";
             pstm = (PreparedStatement) con.prepareStatement(sql);
	         pstm.setString(1,_user);
	         pstm.setString(2,_clave);
	         rs = pstm.executeQuery();
	         
	         if(rs.next()){
	        	 usuarioEncontrado=new UsuariosDTO();
	        	 usuarioEncontrado.setID(rs.getInt("ID"));
	        	 usuarioEncontrado.setUsername(rs.getString("username"));
	        	 usuarioEncontrado.setClave(rs.getString("clave"));
	        	 usuarioEncontrado.setPrivilegio(rs.getInt("privilegio"));

	         }	         
        }catch(SQLException ex){
            ex.printStackTrace();
           
        }finally{
            try{
                rs.close();
                pstm.close();
             }catch(SQLException ex){

            }
        }
        return usuarioEncontrado;
    }
	public boolean guardarUsuario(String _username, String _clave, int _privilegio)
	   {
	      try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "INSERT INTO CLIENTES(username, clave, privilegio) VALUES(?,?,?)";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         pstm.setString(1,_username);
	         pstm.setString(2,_clave);
	         pstm.setInt(3,_privilegio);
	         	         
	         if(pstm.executeUpdate()==1)
	         {
	              return true;
	         }else{
	            return false;
	         }
	      }
	      
	      catch(Exception e)
	      {
	         e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	      
	      finally
	      {
	         try
	         {
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
	   }
	@Override
	public Collection<UsuariosDTO> buscarTodosLosUsuarios() {
		
		try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "SELECT * FROM usuario";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         rs = pstm.executeQuery();
	         
	         Vector<UsuariosDTO> vector = new Vector<UsuariosDTO>();
	        		         
	         while(rs.next())
	         {
	        	UsuariosDTO usuarioEncontrado = new UsuariosDTO();
	            
	        	 usuarioEncontrado.setID(rs.getInt("ID"));
	        	 usuarioEncontrado.setUsername(rs.getString("username"));
	        	 usuarioEncontrado.setClave(rs.getString("clave"));
	        	 usuarioEncontrado.setPrivilegio(rs.getInt("privilegio"));

	            vector.add(usuarioEncontrado);
	         }
	         
	         return vector;
	      }
	      
	      catch(Exception e)
	      {
	         e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	      
	      finally
	      {
	         try
	         {
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
	}
	@Override
	public boolean eliminarUsuario(int _ID) {
		 try{
	        	con = (Connection) UConnection.getConnection(); 
	            String sql="DELETE FROM usuario where ID=?";
	            pstm=(PreparedStatement) con.prepareStatement(sql);
	            pstm.setInt(1,_ID);  
	            
	            if(pstm.executeUpdate()==1){
	            	return true;
	            	
	            }else{
	            	return false;
	            }
	            
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	         
	         finally
	         {
	            try
	            {
		               if(pstm != null) pstm.close();
	            }
	            
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               throw new RuntimeException(e);
	            }
	         }
	}
	@Override
	public boolean editarUsuario(int _ID, String username, String clave, int privilegio) {
		try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "UPDATE usuario SET ID = ? WHERE username = ?  WHERE clave = ? WHERE privilegio= ?\"";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         pstm.setInt(1,_ID);
	         pstm.setString(2,username);
	         pstm.setString(3,clave);
	         pstm.setInt(4,privilegio);
	         
	         
	         if(pstm.executeUpdate()==1)
	         {
	            return true;
	         }else{
	            return false;
	         }
	      }
	      
	      catch(Exception e)
	      {
	         e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	      
	      finally
	      {
	         try
	         {
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
	}
	
	

	
	
		
}
