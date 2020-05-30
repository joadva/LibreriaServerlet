

function eliminar(ID,elimina){

	console.log(ID);
console.log(elimina);
	switch (elimina){
		case "1":
	$.post( 'SVerificaUsuario', {eliminar: ID, action:"delete"}, 
					
					function (res,status) {
						
						
						console.log(status);
						
						if (status == "success" ){
						
							alert("Se Elimino el usuario ");
							
					location.reload();
							
							
						} else {
							
							alert("no se elimino");
						}
						});
		break;
			
			
		case '2':
			$.post('SLibro',{eliminar:ID, action :"delete"},
					function (res,status) {
				
				
				console.log(status);
				
				if (status == "success" ){
				
					alert("Se Elimino el Libro ");
					
			location.reload();
					
					
				} else {
					
					alert("no se elimino");
				}
				});
			
			break;
	}}
	
	
	
	


function modificar(ID){
	
	
}



function Agregar(){

	var id= $('#id').val();
	var username= $('#username').val();
	var clave= $('#clave').val();
	var prioridad= $('#prioridad').val();
	console.log(username);
	
	$.post('SVerificaUsuario', 
			{
				id: id,
				username:username,
				clave:clave,
				prioridad:prioridad,
				action: "create"
			}, 
			
				

			function (res,status) {
				
				if (status == "success" ){
				
					alert("Se Agrego el usuario ");
					
			location.reload();
						
				} else {
					
					alert("no se Agrego");
				}
				});
	
}
function Update(){

	var id= $('#id').val();
	var username= $('#username').val();
	var clave= $('#clave').val();
	var prioridad= $('#prioridad').val();
	console.log(username);
	
	$.post('SVerificaUsuario', 
			{
				id: id,
				username:username,
				clave:clave,
				prioridad:prioridad,
				action: "update"
			}, 
			function (res,status) {
				
				if (status == "success" ){				
					alert("Se Agrego el usuario ");	
			location.reload();
				} else {
					alert("no se Agrego");
				}
				});


	
}

