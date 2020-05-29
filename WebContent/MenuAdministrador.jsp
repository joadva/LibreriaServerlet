<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="maestria.DAO.*" %>
<%@page import="maestria.DTO.*" %>
<%@page import="maestria.factory.*" %>
<%@page import="maestria.interfaces.*" %>
<%@page session="true" %>

<%-- Validar inicio de sesion --%>
<%
HttpSession sesion = request.getSession();
if (sesion.getAttribute("usuario") == null) {
    response.sendRedirect("login.html");
} 
%>

<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
       		ICliente d=(ICliente) Fabrica.getInstancia("CLIENTES");
			Collection<ClientesDTO> resultado= d.buscarTodosLosClientes();
			
    %>

<%-- Finalizar --%>
<html>
<head>
<title>.:PAW-Consultar Clientes</title>
<style type="text/css">
<!--
body {
	background-color: #FFFF99;
}
body,td,th {
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="84" bgcolor="#FF0000"><img src="includes/img/porrin.png" alt="libro" width="140" height="65"></td>
    <td width="716" bgcolor="#993300"><h1 style="color:#FFFFFF">Carrito de Compras con JSP y Sesiones</h1></td>
  </tr>
  <tr align="center">
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="2">
      <h4><a href="Mostrarusuarios.jsp">Consultar Usuarios</a> | <a href="libros.jsp">Nuevo Cliente</a> | <a href="SCerrarSesion">Cerrar Sesion</a> </h4></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">

      <table width="100%" border="0">
  <tr bgcolor="#FF6600" style="color: #FFFFFF">
            <td width="68%" bgcolor="#993300"><h4>Nombre</h4></td>
            <td width="16%" align="right" valign="top" bgcolor="#993300"><h4><span class="Estilo3">Stock</span></h4></td>
            <td width="16%" align="right" valign="top" bgcolor="#993300"><h4><span class="Estilo3">Precio</span></h4></td>
        </tr>

          <%
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(ClientesDTO registro:resultado){
          %>
          <tr>
        
            <td align="right" valign="top"><%=registro.getRfc() %></td>
            <td align="right" valign="top"><%=registro.getNombre() %></td>
          </tr>
          <%}
             } %>

        </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
</body>
</html>
