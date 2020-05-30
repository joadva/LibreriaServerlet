

function eliminar(ID,elimina){

	console.log(ID);
console.log(elimina);
	switch (elimina){
		case 1:
			$.post( 'SVerificaUsuario', {id: ID, action:"delete"}, 
					
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



function Agregar(agrega){
	 console.log(agrega);
	
	switch(agrega){
	
	
	case 1:
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
		
	case 2:
		
		var id= $('#id').val();
		var name= $('#name').val();
		var año= $('#año').val();
		var autor= $('#autor').val();
		var editorial= $('#editorial').val();
		console.log(name);
		
		$.post('SLibro', 
				{
				
					name:name,
					año:año,
					autor:autor,
					editorial:editorial,
					action: "create"
				}, 
				
					

				function (res,status) {
					
					if (status == "success" ){
					
						alert("Se Agrego el libro ");
						
				location.reload();
							
					} else {
						
						alert("no se Agrego");
					}
					});
	}


	
}




function openlibro(id,name,año,autor,editorial){
	
	var id =$('#id').val(id);
	var name=$('#name').val(name);
	var año=$('#año').val(año);
	var autor=$('#autor').val(autor);
	var editorial=$('#editorial').val(editorial);
}


function UpdateLibro() {
	
	var id =$('#id').val();
	var name= $('#name').val();
	var año= $('#año').val();
	var autor= $('#autor').val();
	var editorial= $('#editorial').val();
	
	$.post('SLibro', 
			{
				ID:id,
				txtname:name,
				txtaño:año,
				txtautor:autor,
				txteditorial:editorial,
				action: "update"
			}, 
						
			function (res,status) {
				
				if (status == "success" ){
				
					alert("Se actualizo el libro ");
					
			location.reload();
						
				} else {
					
					alert("no se actualizo");
				}
				});

	
}


function openuser(id,username,clave,privilegio){
    
	var id= $('#id').val(id);
	var usernae= $('#username').val(username);
	var clave= $('#clave').val(clave);
	var prioridad= $('#prioridad').val(privilegio);
	//console.log(username);
	
}

function Update() {
	var id= $('#id').val();
	var username= $('#username').val();
	var clave= $('#clave').val();
	var prioridad= $('#prioridad').val();
	
	//console.log(clave);
	
	$.post('SVerificaUsuario', 
			{
				ID: id,
				txtusername:username,
				txtclave:clave,
				txtprivilegio:prioridad,
				action: "update"
			}, 
			function (res,status) {
				
				if (status == "success" ){				
					alert("Se actualizo el usuario ");	
			location.reload();
				} else {
					alert("no se actualizo");
				}
				});


	
}