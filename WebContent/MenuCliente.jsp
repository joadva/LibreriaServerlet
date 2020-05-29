<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page session="true" %>

<%-- Validar inicio de sesion --%>
<%
HttpSession sesion = request.getSession();
if (sesion.getAttribute("usuario") == null) {
    response.sendRedirect("login.html");
} 
%>

<%-- Finalizar validaciones --%>




<html>
<head>
<title>.:PAW-Consultar Productos</title>
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
      <h4><a href="MostrarProductos.jsp">Consultar Productos</a> | <a href="AgregarProducto1.jsp">Agregar al Carrito</a> | <a href="SCerrarSesion">Cerrar Sesion</a> </h4></td>
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

         

        </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
</body>
</html>
