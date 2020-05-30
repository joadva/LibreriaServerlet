<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="JS/main.js" > </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h1> agregar Usuarios</h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="Mostrarusuarios"
					class="nav-link">Volver</a></li>
			</ul>
		</nav>
	</header>
<div class="container">
  <h2>Agrega Usuario</h2>
  
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
    <button type="button" class="btn btn-primary" onclick="Agregar()" >Submit</button>
  </form>
</div>

</body>
</html>