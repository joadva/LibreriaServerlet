package maestria.controlador;




import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import maestria.DTO.UsuariosDTO;
import maestria.factory.Fabrica;
import maestria.interfaces.ICliente;
import maestria.interfaces.ILibros;
import maestria.interfaces.IUsuario;

@WebServlet("/SLibro")

public class SLibro extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	
	public SLibro() {
		super();
	}
	

    protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action=request.getParameter("action");
    	        
    	        
    	        System.out.println(action);
			   if(action.equals("create")){
				   
				 String id=request.getParameter("id");
    	         String name=request.getParameter("name");
				 ILibros d=(ILibro) Fabrica.getInstancia("libro");
   				 if(d.guardarCliente(id, name)==true){
					 response.sendRedirect("MenuCliente.jsp");
				 }else{
					 response.sendRedirect("error.html");
				 }
					 
			   }else if(action.equals("delete")){
				   
				   int eliminar = Integer.parseInt(request.getParameter("eliminar"));
				  
				   IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIOS");
   	        	if( d.eliminarUsuario(eliminar)) {
   	        		
   	        		response.setStatus(HttpServletResponse.SC_OK);
   	        		
   	        	}else {
   	        		response.sendRedirect("error.html");
   	        	}
				   
				   				   
			   }else if(action.equals("update")){
				   int _ID=Integer.parseInt(request.getParameter("ID"));
	    	         String username=request.getParameter("txtusername");
	    	         String clave=request.getParameter("txtclave");
	    	         int privilegio=Integer.parseInt(request.getParameter("txtprivilegio"));
				   IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   
				   if(d.editarUsuario(_ID, username, clave, privilegio)==true) {
					   response.setStatus(HttpServletResponse.SC_OK);
				   }else {
						response.sendRedirect("error.html");
				   }
				   
				   	
			   }else if(action.equals("search")){
				   
			   }else if(action.equals("searchall")){
				   
			   }else if (action.equals("login")) {
				   String user=request.getParameter("txtUsuario");
	    	        String clave=request.getParameter("txtClave");
	    	        UsuariosDTO u=new UsuariosDTO();
	    	        
	    	        IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIOS");
	    	        	u= d.verificarUsuario(user, clave);
	    	        if(u!=null){
	    	            //El usuario existe en la base de datos y clave correcta
	    	            //Creamos la sesion
	    	            HttpSession sesion=request.getSession(true);
	    	            sesion.setAttribute("usuario", u);
	    	            if(u.getPrivilegio()==0){
	    	                //El usuario tiene el privilegio de cliente
	    	                response.sendRedirect("MenuCliente.jsp");
	    	            }else{
	    	                //El usuario tiene el privilegio de administrador de la empresa
	    	                response.sendRedirect("MenuAdministrador.jsp");
	    	            }
	    	        }else{
	    	            //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
	    	        }
				   
			   }
			   
			   
    	    } 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	procesaSolicitud(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	procesaSolicitud(request, response);
    }
	
	
}
