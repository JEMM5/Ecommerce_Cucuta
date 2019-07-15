<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">	
	<div class="navbar row">
    <!-- LOGO -->
		<div class="col-sm-2" >
      <!--onmouseover-->
      
      <a href='<c:url value="/" />'>
			<img src='<c:url value="res/LOGOS/logo.jpg" />' class="logo" id="imagen"/>
      </a>
		</div>
    <!-- BUSCAR -->
		<div class="col-sm-8 formulario" style="background-image: linear-gradient(#FFFF00, #D7DF01);z-index:-3;">
			<form method="post" action="" class="formBusqueda">
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
<%--         <sf:form action="${pageContext.request.contextPath}/validarEmpresa" class="form-container" method="post" commandName="pymeR"> --%>
<!--           <button type="button" class="btn cancel" onclick="closeForm()"><span class="glyphicon glyphicon-remove"></span></button> -->

<!--           <h1>Login</h1> -->

<!--           <label for="email"><b>Correo</b></label> -->
<%--           <sf:input path="email" type="text" placeholder="Ingresar tu correo" name="email" required /> --%>

<!--           <label for="pws"><b>Contraseña</b></label> -->
<%--           <sf:input path="contrasena" type="password" placeholder="Ingresar Contraseña" name="psw" required /> --%>

<!--           <button type="submit" class="btn">Login</button> -->

<%--           <a href='<c:url value="/registroEmpresa"/>'>Crear Cuenta!</a> --%>
<%--           <c:out value="${mensajeNoValido}" /> --%>
<%--         </sf:form> --%>


<!--  EL FORMULARIO DE LOGIN NORMAL SIN SPRING SECURITY

        <form action="${pageContext.request.contextPath}/validarEmpresa" class="form-container" method="post">
          <button type="button" class="btn cancel" onclick="closeForm()"><span class="glyphicon glyphicon-remove"></span></button>

          <h1>Login</h1>

          <label for="email"><b>Correo</b></label>
          <input type="text" placeholder="Ingresar tu correo" name="email" required />

          <label for="pws"><b>Contraseña</b></label>
          <input type="password" placeholder="Ingresar Contraseña" name="psw" required />

          <button type="submit" class="btn">Login</button>

          <a href='<c:url value="/registroEmpresa"/>'>Crear Cuenta!</a>
          <c:out value="${mensajeNoValido}" />
        </form>
 
 -->       
	
         <form name="f" action="j_spring_security_check" class="form-container" method="POST">
          <button type="button" class="btn cancel" onclick="closeForm()"><span class="glyphicon glyphicon-remove"></span></button>
	
		  <sec:authorize access="!isAuthenticated()">  
		  	
          <h1>Login</h1>

          <label for="email"><b>Usuario</b></label>
          <input type="text" placeholder="Ingresar tu correo" name="usuario" required />

          <label for="pws"><b>Contraseña</b></label>
          <input type="password" placeholder="Ingresar Contraseña" name="clave" required />

          <button type="submit" class="btn">Login</button>

          <a href='<c:url value="/registroEmpresa"/>'>Crear Cuenta!</a>
          <c:if test="${param.error != null}">
          	<span style="color:red;">¡Error de Credenciales!</span>
          </c:if>
          

 		      
        	Por favor inicia sesión
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        	Usuario ha iniciado sesión como:
        	<sec:authentication property="principal" var="principal" />
<%--         	<c:set var="username" value="${principal.username}" /> --%>
        	<c:out value="${principal}" />
        	
        	<br/>
 			<a href='<c:url value="/cerrarSesion" />'>Cerrar Sesión</a>
        </sec:authorize>
          
          
        </form>
        

 		
 		
      </div>
</div>