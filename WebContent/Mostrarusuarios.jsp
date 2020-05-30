<%@page import="com.google.gson.Gson"%>
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



<%-- Obtener Vector de Productos de la BD --%>

    <%
       		IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIOS");
			Collection<UsuariosDTO> resultado= d.buscarTodosLosUsuarios();
			
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
				<h1> crud Usuarios</h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="MenuAdministrador.jsp"
					class="nav-link">Volver</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Usuarios </h3>
			<hr>
			<div class="container text-left">

				<a href="AgregarUser.jsp" class="btn btn-success">agrega nuevo usuario</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>UserName</th>
						<th>Clave</th>
						<th>Privilegio</th>
					
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
				 <%
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(UsuariosDTO registro:resultado   ){
            	Gson json = new Gson();
            	String jSoN = json.toJson(registro);
          %>
          <tr class="padre">
        
            <td   class="hijo" align="right" valign="top"><%=registro.getID() %></td>
            <td class="hijo" align="right" valign="top"><%=registro.getUsername() %></td>
             <td class="hijo" align="right" valign="top"><%=registro.getClave() %></td>
             <td class="hijo"  align="right" valign="top"><%=registro.getPrivilegio() %></td>
           
             <td>
             
               <a type="button"  data-target="#myModal" data-toggle="modal"   onclick="openuser( '<%=registro.getID() %>','<%=registro.getUsername() %>','<%=registro.getClave() %>' ,'<%=registro.getPrivilegio() %>')" />Editar</a>
              
               
               <input  type="hidden"  name="action"  value="delete"  />
             
					<a type="button" onclick="eliminar(<%=registro.getID() %>,1)">Eliminar</a>
		
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
          <h4 class="modal-title">Editar USUARIo</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         <form class="form-inline" id="agregar" name="agregar">
    <label >Id:</label>
    <input type="text" class="form-control" id="id" placeholder="" name="id">
    <label >Username:</label>
    <input type="text" class="form-control" id="username" placeholder="" name="username">
    <label >Clave:</label>
    <input type="text" class="form-control" id="clave" placeholder="" name="clave">
    <label for="pwd">Prioridad:</label>
    <input type="text" class="form-control" id="prioridad" placeholder="" name="prioridad">
    <div class="form-check">
      
    </div>
    <button type="button" class="btn btn-primary" onclick="Update()" >Submit</button>
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