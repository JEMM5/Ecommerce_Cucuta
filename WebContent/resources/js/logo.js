window.addEventListener('load', iniciar, false);

function iniciar(){
/*	
  var imagen=document.getElementById('imagen');
  imagen.addEventListener('mouseover', peligro, false);
  imagen.addEventListener('mouseout', peligro, false);
*/
  //cambiar el contenido boton del modal
  if(screen.width < 450){
  	document.getElementById('seguirComprando').innerHTML="<b>▲</b>";
    //
    var anadirBotones = document.getElementsByClassName("botonAnadir");
    var i;

for (i = 0; i < anadirBotones.length; i++) {

    document.getElementsByClassName('botonAnadir')[i].innerHTML="<i class='glyphicon glyphicon-shopping-cart'></i>";
}
  }else{
  	document.getElementById('seguirComprando').innerHTML="Seguir Comprando";
    //
    document.getElementsByClassName('botonAnadir')[0].innerHTML="<i class='glyphicon glyphicon-shopping-cart'></i> Agregar al carrito";
    
  }
}

/* MIRAR DESPUES LA FUNCION DE LOGO A INICIO
function peligro(){
	
	
	if(imagen=document.getElementById('imagen').src.indexOf('<c:url value="res/LOGOS/logo.jpg" />')>= 0){
		var imagen=document.getElementById('imagen').src= '\'<c:url value=\"res/LOGOS/inicio.jpg\" />\'';
	}else{
		var imagen=document.getElementById('imagen').src= '\'<c:url value=\"res/LOGOS/logo.jpg\" />\'';
	}
  
}*/