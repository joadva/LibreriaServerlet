<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%@page import="java.util.*" %>
<%@page import="maestria.DAO.*" %>
<%@page import="maestria.DTO.*" %>
<%@page import="maestria.factory.*" %>
<%@page import="maestria.interfaces.*" %>
<%@page session="true" %>
	<%
HttpSession sesion = request.getSession();
if (sesion.getAttribute("usuario") == null) {
    response.sendRedirect("login.html");
} 
%>



<%-- Obtener Vector de Libros de la BD --%>

    <%
    ILibros d = (ILibros)  Fabrica.getInstancia("LIBROS");
    
    //ILibros d=(ILibros) Fabrica.getInstancia("libro");
			Collection<LibrosDTO> resultado= d.buscarTodosLosLibros();
    %>

<html>
<head>
<title>Editar</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<script src="JS/main.js" > </script>
	
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h1> crud Libros</h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="./nose.libros"
					class="nav-link">Volver</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Libros </h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">agrega nuevo libros</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Año</th>
						<th>Autor</th>
						<th>editorial</th>
					
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
				 <%
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(LibrosDTO registro:resultado){
          %>
          <tr>
        
            <td align="right" valign="top"><%=registro.getId() %></td>
            <td align="right" valign="top"><%=registro.getName() %></td>
             <td align="right" valign="top"><%=registro.getAño() %></td>
              <td align="right" valign="top"><%=registro.getAutor() %></td>
             <td align="right" valign="top"><%=registro.getEditorial()%></td>
           
             <td>
             
               <a type="button"  data-target="#myModal" data-toggle="modal"  value='<%=registro.getId() %>'">Editar</a>
              
               
               <input  type="hidden"  name="action"  value="delete"  />
             
					<a type="button" onclick="eliminar('<%=registro.getId()%>','2')">Eliminar</a>
		
					</td>
						</tr>            
          				<%}
             				} %>
					
				</tbody>

			</table>
		</div>
	</div>
	
	
	<div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Editar Libro</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <form name="" method="POST">
          
          
          <input   type="text"  value="">
                    <input   type="text" value="">
          
                    <input   type="text" value="">
          
                    <input   type="text"  value="">
          
          
          
          
          
          
          </form>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
      </div>
</body>
</html>