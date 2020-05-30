package maestria.controlador;




import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import maestria.factory.Fabrica;

import maestria.interfaces.ILibros;


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
				   
				
    	         String name=request.getParameter("name");
    	         String año=request.getParameter("año");
    	         String autor=request.getParameter("autor");
    	         String editorial=request.getParameter("editorial");
				 ILibros d=(ILibros) Fabrica.getInstancia("libro");
   				 if(d.guardarLibro( name, año, autor, editorial)==true){
					 response.sendRedirect("MenuCliente.jsp");
				 }else{
					 response.sendRedirect("error.html");
				 }
					 
			   }else if(action.equals("delete")){
				   
				   int eliminar = Integer.parseInt(request.getParameter("eliminar"));
				  
				   ILibros d=(ILibros) Fabrica.getInstancia("LIBROS");
   	        	if( d.eliminarLibro(eliminar)) {
   	        		
   	        		response.setStatus(HttpServletResponse.SC_OK);
   	        		
   	        	}else {
   	        		response.sendRedirect("error.html");
   	        	}
				   
				   				   
			   }else if(action.equals("update")){
				   int id=Integer.parseInt(request.getParameter("ID"));
	    	         String name=request.getParameter("txtname");
	    	         String autor=request.getParameter("txtautor");
	    	         String año=request.getParameter("txtaño");
	    	         String editorial=request.getParameter("txteditorial");
				   ILibros d=(ILibros) Fabrica.getInstancia("libro");
				   
				   if(d.editarLibro(id, name, año, autor, editorial) ==true) {
					   response.setStatus(HttpServletResponse.SC_OK);
				   }else {
						response.sendRedirect("error.html");
				   }
				   
				   	
			   }else if(action.equals("search")){
				   
			   }else if(action.equals("searchall")){
				   
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
