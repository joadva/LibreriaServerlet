package maestria.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;


import maestria.DTO.LibrosDTO;
import maestria.interfaces.ILibros;
import util.UConnection;

public   class LibrosDAO implements ILibros{

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	


	@Override
	public boolean guardarLibro( String name, String año, String autor, String editorial) {
	      try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "INSERT INTO libros( name, año, editorial) VALUES(?,?,?,?)";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	       
	         pstm.setString(1,name);
	         pstm.setString(2,año);
	         pstm.setString(3,autor);
	         pstm.setString(4,editorial);
	         	         
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
	public boolean eliminarLibro(int id) {
		try{
	     	con = (Connection) UConnection.getConnection(); 
	         String sql="DELETE FROM libros where id=?";
	         pstm=(PreparedStatement) con.prepareStatement(sql);
	         pstm.setInt(1,id);  
	         
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
	public boolean editarLibro(int id, String name, String año, String autor, String editorial) {
		try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "UPDATE libros SET id, name, año, editorial where id = ? ";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         pstm.setInt(1,id);
	         pstm.setString(2,name);
	         pstm.setString(3,año);
	         pstm.setString(4,editorial);
	         
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

	@Override
	public Collection<LibrosDTO> buscarTodosLosLibros() {
	      try
	      {
	         con = (Connection) UConnection.getConnection();
	         
	         String sql = "SELECT * FROM libros";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         rs = pstm.executeQuery();
	         
	         Vector<LibrosDTO> vector = new Vector<LibrosDTO>();
	        		         
	         while(rs.next())
	         {
	        	 LibrosDTO libroEncontrado = new LibrosDTO();
	          
	        	 libroEncontrado.setId(rs.getInt("id"));
	        	 libroEncontrado.setName(rs.getString("name"));
	        	 libroEncontrado.setAño(rs.getString("año"));
	        	 libroEncontrado.setAutor(rs.getString("autor"));
	        	 libroEncontrado.setEditorial(rs.getString("Editorial"));

	            vector.add(libroEncontrado);
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


	
}
