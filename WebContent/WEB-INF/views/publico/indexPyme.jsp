<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>Ecommerce Cúcuta | Los mejores Productos</title>

  <!--CSS-->
  <link href='<c:url value="res/bootstrap-3.4.1-dist/css/bootstrap.css" />' rel="stylesheet" type="text/css"/>
  <link href='<c:url value="res/css/barraFija.css"/>' rel="stylesheet" type="text/css"/>
  

  <!-- LISTA PRODUCTOS -->
  <link href='<c:url value="res/css/listaProductos.css" />' rel="stylesheet" type="text/css" />
  <script src='<c:url value="res/js/listaProductos.js" />'></script>

  <!--SIDEBAR -->
  <link href='<c:url value="res/css/sidebar.css" />' rel="stylesheet" type="text/css"/>
  <script src='<c:url value="res/js/sidebar.js" />'></script>

  <!--LOGO-->
  <script src='<c:url value="res/js/logo.js" />'></script> 

  <!--FUENTES MEDIOS DE PAGOS-->
  <link href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" rel="stylesheet" type="text/css" />

  <!--JQUERY-->
  <script src='<c:url value="res/js/jquery-3.4.1.js" />'></script>
  <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>-->

  <script src='<c:url value="res/bootstrap-3.4.1-dist/js/bootstrap.min.js" />'></script>

  <!--ICONOS DE PAGO-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <!--FOTOS DEL PRODUCTO DINAMICAS DENTRO DEL MODAL-->
  <script src='<c:url value="res/js/fotosProducto.js" />'></script>
  <link rel="stylesheet" href='<c:url value="res/css/fotosProducto.css" />' type="text/css" />

  <!--el sidenav HOVERABLE DE CADA EMPRESA--->
  <link rel="stylesheet" href='<c:url value="res/css/sideNavHover.css" />' type="text/css" />
</head>
<body>

<div class="container">	
	<div class="navbar row">
    <!-- LOGO -->
		<div class="col-sm-2" >
      <!--onmouseover-->
      <a href='<c:url value="/" />'>
      <img src='<c:url value="res/LOGOS/logo.jpg" />' class="logo" id="imagen"/>
      <a>  
      
      
		</div>
    <!-- BUSCAR -->
		<div class="col-sm-8 formulario" style="background-image: linear-gradient(#FFFF00, #D7DF01);z-index:-3;">
			<form method="" action="" class="formBusqueda">
				<input type="text" name="busqueda" placeholder="Buscar...">
				<button type="submit" name="Buscar" value="Buscar"><span class="glyphicon glyphicon-search"></span></button>
			</form>
		</div>
    <!-- LOGIN -->
    <div class="col-sm-2" >

<!--MODAL CARRITO -->

<!--boton-carrito-->
  <a type="button" class="notification carrito" data-toggle="modal" data-target="#myModal">
    <span class="glyphicon glyphicon-shopping-cart"></span>
    <span class="badge">0</span>
  </a> 

   
<!--boton-->  <button class="open-button" onclick="openForm()"><span class="glyphicon glyphicon-user"></span></button>       
    </div>
	</div>


<!--form--> <div class="form-popup" id="myForm">
        <form action="" class="form-container">
          <button type="button" class="btn cancel" onclick="closeForm()"><span class="glyphicon glyphicon-remove"></span></button>

          <h1>Login</h1>

          <label for="email"><b>Correo</b></label>
          <input type="text" placeholder="Ingresar tu correo" name="email" required>

          <label for="pws"><b>Contraseña</b></label>
          <input type="password" placeholder="Ingresar Contraseña" name="psw" required>

          <button type="submit" class="btn">Login</button>

          <a href="registroEcommerce.html">Crear Cuenta!</a>
        </form>
      </div>
</div>

<!--SCROLLMENU-->
<div class="empA" style="padding-top:8em;padding-bottom:1em;width:100%;">
  <p id ="nombreCorporativo" style="font-size:2em;"><c:out value="${pymeEmpRecuperada.razonSocial}" /></p>

</div>

<!------LA EMPRESA PYME--->
<div id="mySidenavH" class="sidenavH" style="width:100%;">
  <a href="#" id="emprePyme">
    <img src='<c:out value="fot/${pymeEmpRecuperada.logoEmpresa}" />' class="logo" id="imagen" style="width:2em;height:2em;">
    &nbsp;
    <span style="font-size:1.1em;">${pymeEmpRecuperada.razonSocial}</span>
  </a>
  <a href="#" id="wsapp"><i class="fa fa-whatsapp"></i> &nbsp;&nbsp;&nbsp;<c:out value="${pymeEmpRecuperada.celular}" /></a>
  <a href="#" id="projects" style="font-size:11px;"><span class="glyphicon glyphicon-envelope"></span> &nbsp;&nbsp;&nbsp;<c:out value="${pymeEmpRecuperada.email}" /></a>
  <a href="#" id="contact"><i class="fa fa-facebook"></i></a>
</div>

<!--CATEGORIAS-->

<div class="container" style="overflow:auto;
  white-space:nowrap;z-index:-1;"  >
  <div class="row" >
    <div class="col-sm-3" id="contendorLateralPyme">
      <!-- SIDEBAR -->
      <h3>CATEGORIAS</h3>
      <!--<a name="retornoDiv"></a>-->

      <div class="sidenav">
        <a href="#">Ropa</a>

        <button class="dropdown-btn">
          <span data-toggle="modal" data-target="#modalMovil">Calzado<i class="glyphicon glyphicon-plus-sign"></i><span>
        </button>

        <div class="dropdown-container">          
          <a href="#">Tennis</a>
          <a href="#">Formal</a>
          <a href="#">Especial</a>
        </div>

        <!-- ModalProductos para moviles -->
        <div id="modalMovil" class="modal fade identMovil" role="dialog">
          <div class="modal-dialog">

            <!--Modal content-->
            <div class="modal-content">
              <!--<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Calzado</h4>
              </div>-->
              <div class="modal-body identMovilCajita">
                <a href="#si" onclick="$('#modalMovil').modal('hide')">Tennis</a>
                <br/>
                <a href="#superdu" onclick="$('#modalMovil').modal('hide')">Formal</a>
                <br/>
                <a href="#jkjkjk" onclick="$('#modalMovil').modal('hide')">Especial</a>
                
              </div><!--
              <div class="modal-footer">
                
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>-->
            </div>

          </div>
        </div>
        
        <a href="#">Celulares</a>
        <a href="#">Maquinaria</a>
        <a href="#">TecnologÃ­a</a>

        <button class="dropdown-btn">
          <span data-toggle="modal" data-target="#modalMovilCosmeticos">Belleza<i class="glyphicon glyphicon-plus-sign"></i></span>
        </button>
        <div class="dropdown-container">
          <a href="#">Cosmeticos</a>
          <a href="#">Cremas</a>
          <a href="#">Alimenticios</a>
        </div>

        <!-- ModalProductos para moviles -->
        <div id="modalMovilCosmeticos" class="modal fade identMovil" role="dialog">
          <div class="modal-dialog">
            <!--Modal content-->
            <div class="modal-content">
              <div class="modal-body identMovilCajita">
                <a href="#xxxxxx" onclick="$('#modalMovilCosmeticos').modal('hide')">Cosmeticos</a>
                <br/>
                <a href="#yyyyyy" onclick="$('#modalMovilCosmeticos').modal('hide')">Cremas</a>
                <br/>
                <a href="#zzzzzz" onclick="$('#modalMovilCosmeticos').modal('hide')">Alimenticios</a>
                
              </div>
            </div>

          </div>
        </div>
        
      
        
          <a hre="#">Saludables</a>


            
       
    </div>
<!--CATEGORIAS-->

      <!-- SIDEBAR -->
      <h3>MARCAS/EMPRESAS</h3>
      <div class="sidenav">
        <a href="#">Empresa 1</a>  
        <a href="#">Empresa 2</a>  
        <a href="#">Empresa 3</a>  
        <a href="#">Empresa 4</a>  
        <a href="#">Empresa 5</a>  
        <a href="#">Empresa 6</a>  
        <a href="#">Empresa 7</a>
      </div>

      <br/>

      <div class="sidenav" id="metodosPagoPyme">
        <a href="#" style="font-size:1.3em;text-align:center;">Multiples métodos de Pagos </a>  
      </div>
      <div class="sidenav">
        <a href="#" style="font-size:3em;"><i class='fab fa-cc-paypal'></i> <span style="font-size:0.4em;">Paypal</span></a>
        <a href="#" style="font-size:3em;"><i class='fab fa-cc-mastercard'></i> <span style="font-size:0.4em;">Pay<b>U</b> Latam</span></a>
        <a href="#" style="font-size:3em;"><i class='fas fa-handshake'></i> <span style="font-size:0.3em;"><b>Concretar con el vendedor</b></span></a>
      </div>    
  </div>

      


    <div class="col-sm-9">
  <!-- Modal del carrito-->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog" >
    
      <!-- Modal content-->
      <div class="modal-content" style="overflow-y: scroll;">
        <div class="modal-header" style="background-color:yellow;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Carrito | Lista de Productos</h4>
        </div>
        <div class="modal-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td> 
                <a href="" class="btn btn-danger" style="width:2em;height:2em;padding:0px;">&times;</a>  
                Celular tal
                </td>
                <td>400000</td>
                <td>1</td>
                <td>400000</td>
              </tr>
              <tr>
                <td> 
                <a href="" class="btn btn-danger" style="width:2em;height:2em;padding:0px;">&times;</a>  
                Celular tal
                </td>
                <td>400000</td>
                <td>1</td>
                <td>400000</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <a type="button" class="btn btn-success" href="di" target="_blank" style="background-color:blue;">Pagar <i class="fa fa-paypal"></i></a>
          <a type="button" class="btn btn-success" href="di" target="_blank" style="background-color:blue;">Pagar <b>PayU</b> <i class="fa fa-credit-card"></i></a>

          <a type="button" class="btn btn-warning" data-dismiss="modal" style="background-color:orange;" id="seguirComprando">Continuar Comprando</a>
        </div>
      </div>
      
    </div>
  </div>
  <!--fin del modal carrito-->
  <!--------------------------- MODAL GENERICO PARA CADA PRODUCTO ------------------------>    
  <div class="modal fade" id="modalProducto" role="dialog">
    <div class="modal-dialog">
      
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4>Descripcion</h4>
        </div>
        <div class="modal-body">
          <!--LAS IMAGENES-->
          <div class="col-xs-8 fotosProducto">
            <div class="contendorImagen">
              <div class="mySlides">
                <div class="numbertext">1 / 5</div>
                <img src="img/celular1.jpg" style="width:100%">
              </div>

              <div class="mySlides">
                <div class="numbertext">2 / 5</div>
                <img src="img/celular2.jpg" style="width:100%">
              </div>

              <div class="mySlides">
                <div class="numbertext">3 / 5</div>
                <img src="img/celular3.jpg" style="width:100%">
              </div>
                
              <div class="mySlides">
                <div class="numbertext">4 / 5</div>
                <img src="img/celular4.jpg" style="width:100%">
              </div>

              <div class="mySlides">
                <div class="numbertext">5 / 5</div>
                <img src="img/celular5.jpg" style="width:100%">
              </div>
                
              <a class="prev anterior" onclick="plusSlides(-1)">â®</a>
              <a class="next siguiente" onclick="plusSlides(1)">â¯</a>

              <div class="caption-container">
                <p id="caption"></p>
              </div>

              <div class="fila">

                <div class="columna">
                  <img class="demo cursor" src="img/celular1.jpg" style="width:100%" onclick="currentSlide(1)" alt="The Woods">
                </div>
                <div class="columna">
                  <img class="demo cursor" src="img/celular2.jpg" style="width:100%" onclick="currentSlide(2)" alt="Cinque Terre">
                </div>
                <div class="columna">
                  <img class="demo cursor" src="img/celular3.jpg" style="width:100%" onclick="currentSlide(3)" alt="Mountains and fjords">
                </div>
                <div class="columna">
                  <img class="demo cursor" src="img/celular4.jpg" style="width:100%" onclick="currentSlide(4)" alt="Northern Lights">
                </div>
                <div class="columna">
                  <img class="demo cursor" src="img/celular5.jpg" style="width:100%" onclick="currentSlide(5)" alt="Nature and sunrise">
                </div>    
              </div>
            </div>
          </div>

          
          <div class="col-xs-4" style="background-color:yellow;">
            <!--caracteristicas producto-->
            <p style="white-space:normal;">
              <!-- ejecute el metodo currentSlide(1) para que sea la primera imagen q aparezca -->
              <a data-toggle="modal" data-target="#modalProducto">Apple iPhone 7 / 128GB / Oro / Libre</a>
              <br/>
              ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple
              <br/>
              <b style="font-size:2em">COP $837 965.20</b>
              <a href="" class="btn btn-success"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
              
              <p style="white-space:normal;text-align:center;">
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>

                &nbsp;&nbsp;&nbsp;&nbsp;
                <i class="glyphicon glyphicon-ok-sign"></i>
                <b>(200)Disponibles</b>


                <br/><br/>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
              </p>  
              
            </p>




          </div>
        </div>
        <div class="modal-footer">
          <!--<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>-->
        </div>
      </div>
    </div>
  </div>  
  <!--------------------------- fin   GENERICO PARA CADA PRODUCTO ------------------------>      
      <!--
      <p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p><p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p><p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p><p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p>
  <p>Some text some text some text some text..</p>-->


  <!--LEER DESPUES-->

  <!------ PENDIENTE PASAR  A HOJA DE ESTILO-------->
  <h3>Productos Destacados</h3>
  <div id="btnContainer">
  <button class="btn" onclick="listView()"><i class="fa fa-bars"></i> Lista</button> 
  <button class="btn active" onclick="gridView()"><i class="fa fa-th-large"></i> Cuadro</button>
</div>
<br>


<div class="row">

<!-- facil y despues pensamos CICLAR X Q HAY 2 POR CADA COLUMN-->
<c:forEach var="producto" items="${productosByPyme}">



<%-- <c:set var="contador" value="${0}" scope="request" /> --%>

<%! int contador = 0; %>

<% if(contador == 0) {%>
  <div class="column" style="background-color:#aaa;">
<% }%>
<% if(contador == 1) {%>
  <div class="column" style="background-color:#bbb;">
<% }%>
<% if(contador == 2) {%>
  <div class="column" style="background-color:#ccc;">
<% }%>
<% if(contador == 3) {%>
  <div class="column" style="background-color:#ddd;">
<% }%>
    <img src='fp/<c:url value="${producto.img1}" />' width="100" class="producto" style="float:left"/>    
    <p style="white-space:normal;text-align:center;">
      <!-- ejecute el metodo currentSlide(1) para que sea la primera imagen q aparezca -->
      
      <a data-toggle="modal" data-target="#modalProducto" onclick="currentSlide(1)">${producto.nombre}</a>
	  <br/>
	  ${producto.descripcion}
	  <br/>
<%--       <a href='<c:url value="/eliminarProducto?webid=${producto.webid}" />' class="btn btn-danger" style="float:right;"><i class="glyphicon glyphicon-remove"></i></a> --%>

      
      <b style="font-size:1.5em">$ ${producto.precio}</b>
      <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
            
      <p style="white-space:normal;text-align:center;">
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        
        &nbsp;&nbsp;&nbsp;&nbsp;
        <i class="glyphicon glyphicon-ok-sign"></i>
        <b>(${producto.stock})Disponibles</b>
<%--         <a href="${pageContext.request.contextPath}/modProducto?webid=${producto.webid}" class="btn btn-success" style="float:right;"><i class="glyphicon glyphicon-pencil"></i></a> --%>
<!--         <a href="" class="btn btn-success" style="float:right;"><i class="glyphicon glyphicon-pencil"></i></a> -->
      </p>  
      
      
      
      <% contador++; %>
      <% if(contador > 3){ %>
      	<% contador=0; %>
      <%} %>
 
  </div>
</c:forEach>

</div>
<!-- -- -->

<div class="row">
  <div class="column" style="background-color:#aaa;">
    <img src="img/celular.jpg" width="100" class="producto" style="float:left"/>
    
    <p style="white-space:normal;">
      <!-- ejecute el metodo currentSlide(1) para que sea la primera imagen q aparezca -->
      <a data-toggle="modal" data-target="#modalProducto" onclick="currentSlide(1)">Apple iPhone 7 / 128GB / Oro / Libre</a>
      <br/>
      ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple
      <br/>
      <b style="font-size:2em">COP $837 965.20</b>
      <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
      
      <p style="white-space:normal;text-align:center;">
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>

        &nbsp;&nbsp;&nbsp;&nbsp;
        <i class="glyphicon glyphicon-ok-sign"></i>
        <b>(200)Disponibles</b>
      </p>  
      
    </p>  
  </div>

  <div class="column" style="background-color:#bbb;">
    <img src="img/celular.jpg" width="100" class="producto" style="float:left"/>
    
    <p style="white-space:normal;">
      <!-- ejecute el metodo currentSlide(1) para que sea la primera imagen q aparezca -->
      <a data-toggle="modal" data-target="#modalProducto" onclick="currentSlide(1)">Apple iPhone 7 / 128GB / Oro / Libre</a>
      <br/>
      ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple
      <br/>
      <b style="font-size:2em">COP $837 965.20</b>
      <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
      <p style="white-space:normal;text-align:center;">
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>
        <i class="glyphicon glyphicon-star"></i>

        &nbsp;&nbsp;&nbsp;&nbsp;
        <i class="glyphicon glyphicon-ok-sign"></i>
        <b>(200)Disponibles</b>
      </p>   
  </div>
</div>
<!--
<div class="row">
  <div class="column" style="background-color:#ccc;">
    <h2>Producto X</h2>
    <img src="img/celular.jpg" width="100" class="producto" style="float:left;"/>
    <p>Referencia del Producto y de mas Cosas y de mas cosas<br> y demas cosas</p> 
  </div>
  <div class="column" style="background-color:#ddd;">
    <h2>Producto X</h2>
    <img src="LOGOS/logo.jpg" width="100" class="producto"/>
    <p>Referencia del Producto y de mas Cosas y de mas cosas<br> y demas cosas</p>
  </div>
</div>
-->
  </div>
  <div class="col-sm-9">

  <h3>Productos Nuevos</h3>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">

    <!------------------------------------------------------------------------------->    
    <!-- grupo de productos-->
    <div class="prodNue" style="background-color:#ddd;padding-left:11%;padding-right:11%;height:500px;width:100%">
      
      <!--cada producto-->
      <div class="producto" style="background-color:white">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success botonAnadir" id="botonAÃ±adir "style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;text-align:center;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success botonAnadir" id="botonAÃ±adir" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success botonAnadir" id="botonAÃ±adir" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      

    </div>
    <!-------------------------------------------------------------------------------------------------------------------------->
        
      </div>

      <div class="item">

    <!------------------------------------------------------------------------------->    
    <!-- grupo de productos-->
    <div class="prodNue"  style="background-color:#ddd;padding-left:10%;padding-right:10%;height:500px;width:100%">
      
      <!--cada producto-->
      <div class="producto" style="background-color:white">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;text-align:center;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      

    </div>
    <!-------------------------------------------------------------------------------------------------------------------------->

      </div>
    
      <div class="item">

    <!------------------------------------------------------------------------------->    
    <!-- grupo de productos-->
    <div class="prodNue" style="background-color:#ddd;padding-left:10%;padding-right:10%;height:500px;width:100%">
      
      <!--cada producto-->
      <div class="producto" style="background-color:white">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;text-align:center;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      <!--cada producto-->
      <div class="producto" style="background-color:white;">
        <img src="img/celular.jpg" alt="Producto" style="width:100%">
        <div class="contenedor">
          <h4><b>Celular Iphone 7</b></h4>
          <p>ENVIO GRATIS + NUEVO CARGADOR/CABLE + GARANTIA 12 MESES Restauradas Â· Apple iPhone 7 Â· Apple </p>
          
          <b style="font-size:1.4em">COP $837 965.20</b>
          <br/>
          <a href="" class="btn btn-success" style="background-color:green;"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</a>
        </div>
      </div>

      

    </div>
    <!-------------------------------------------------------------------------------------------------------------------------->

      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>









</div>





  </div>







<!--??????????????-->

    
  </div>
</div>

<!-- ?????-->
<footer>
  <div class="col-sm-12 footer">
    <p>Todos los derechos reservados &copy; | Ecommerce CÃºcuta 2019.

      <span class="fa fa-facebook" style="color:blue;"></span>
      <span class="fa fa-youtube" style="color:red;"></span>
      <span class="fa fa-linkedin"style="color:#29D3D3;"></span>
    </p>

    <br/>
  </div>
</footer>




<script>
  function openForm(){
    document.getElementById("myForm").style.display ="block";
  }
  function closeForm(){
    document.getElementById("myForm").style.display ="none";
  }
</script>

<script>
/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;
//los dropdown-container o sub menus de categoria solo disponibles para pantallas > mayores a 767
//en dispositivos moviles usaremos modales de bootstrap
if(window.screen.width > 767){
  for (i = 0; i < dropdown.length; i++) {
    dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
    dropdownContent.style.display = "none";
    } else {
    dropdownContent.style.display = "block";
    }
    });
  }
}
</script>
<!--
<script>
  function soloMoviles(){
    if(window.screen.width > 767){
      $('#modalMovil').modal().data-dismiss='modal';
    }
  }
</script>-->
</body>
</html>