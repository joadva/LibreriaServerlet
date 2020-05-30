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
				<h1> agregar libro</h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="MostrarLibros.jsp"
					class="nav-link">Volver</a></li>
			</ul>
		</nav>
	</header>
<div class="container">
  <h2>Agrega Libro</h2>
  
  <form class="form-inline" id="agregar" name="agregar">
    <label >name:</label>
    <input type="text" class="form-control" id="name" placeholder="" name="name">
    <label >año:</label>
    <input type="text" class="form-control" id="año" placeholder="" name="año">
    <label >autor:</label>
    <input type="text" class="form-control" id="autor" placeholder="" name="autor">
    <label for="pwd">Editorial:</label>
    <input type="text" class="form-control" id="editorial" placeholder="" name="editorial">
    <div class="form-check">
      
    </div>
    <button type="button" class="btn btn-primary" onclick="Agregar(2)">Submit</button>
  </form>
</div>

</body>
</html>