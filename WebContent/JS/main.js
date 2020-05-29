

function eliminar(ID){

	console.log(ID);
	
	$.post( 'SVerificaUsuario', {eliminar: ID, action:"delete"}, 
			
	function (res,status) {
		
		
		console.log(status);
		
		if (status == "success" ){
		
			alert("Se Elimino el usuario ");
			
	location.reload();
			
			
		} else {
			
			alert("no se elimino");
		}
		}
	
	
	
	);
	
	
	
	
	
}


function modificar(ID){
	
	
}