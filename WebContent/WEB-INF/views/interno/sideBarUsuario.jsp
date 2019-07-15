<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  <!-- LA PARTE LATERAL -->
    <div class="col-sm-3">
      
<!--CATEGORIAS-->

      <!-- SIDEBAR -->
      <div class="sidenav" >
        <a href='<c:url value="admin" />' style="text-align:center;">
      
      <!-- PARTE DEL USUARIO DINAMICA -->    
          <h3><img src='<c:out value="fot/${UsuarioValido.logoEmpresa}" />' style="width:20%;"> ${UsuarioValido.razonSocial}</h3>
          <p style="font-size:80%;white-space:normal;">Bienvenido ${UsuarioValido.nombreEmpresario}</p>
        </a>
      </div>
      <div class="sidenav">
        <a href='<c:url value="misProductos" />'><i class="glyphicon glyphicon-lock"></i> Mis Productos</a>
        <a href="#"><i class="glyphicon glyphicon-tasks"></i> Mis Categorias</a>  
        <a href="#"><i class="glyphicon glyphicon-link"></i> Mis Marcas</a>  
        <a href="#"><i class="glyphicon glyphicon-piggy-bank"></i> Mis Ventas</a>    
        <a href="#"><i class="glyphicon glyphicon-knight"></i> Mi Logo</a>  
        <a href="${pageContext.request.contextPath}/cerrarSesion"><i class="glyphicon glyphicon-off"></i> Cerrar Sesión</a>   
        <a href="#"><i class="glyphicon glyphicon-wrench"></i> Configuraciones</a>
      </div>

      <br/>
      

      <div class="sidenav">
        <a href="#" style="font-size:1.3em;text-align:center;">Multiples métodos de Pagos </a>  
      </div>
      <div class="sidenav">
        <a href="#" style="font-size:3em;"><i class='fab fa-cc-paypal'></i> <span style="font-size:0.4em;">Paypal</span></a>
        <a href="#" style="font-size:3em;"><i class='fab fa-cc-mastercard'></i> <span style="font-size:0.4em;">Pay<b>U</b> Latam</span></a>
        <a href="#" style="font-size:3em;"><i class='fas fa-handshake'></i> <span style="font-size:0.3em;"><b>Concretar con el vendedor</b></span></a>
      </div>
   
  </div>