<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link href='<c:url value="/res/bootstrap-3.4.1-dist/css/bootstrap.css"/>' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/res/css/registroEmpresa.css"/>' rel="stylesheet" type="text/css" />
<body style="background-color:yellow;">

<sf:form id="regForm" action="${pageContext.request.contextPath}/registroEmpresa/guardar" enctype="multipart/form-data" method="post" commandName="pyme">
  <b style="color:red;"><c:out value="${mensajeRegistro}"/></b>
  <h1>Registrate:</h1>
  <!-- One "tab" for each step in the form: -->
  <div class="tab">Empresa:
      <p><input placeholder="Razon Social..." oninput="this.className = ''" name="razonSocial"/></p>
    <p><input  placeholder="Nombre Empresario..." oninput="this.className = ''" name="nombreEmpresario"/></p>
    <p><input type="file" placeholder="Ingresa el logo de tu EMpresa" name="logo"/></p>
  </div>
  <div class="tab">Correo y Celular:
    <p><input placeholder="E-mail..." oninput="this.className = ''" name="email"/></p>
    <p><input placeholder="Celular..." oninput="this.className = ''" name="celular"/></p>
  </div>  
  <div class="tab">Login Información:
    <p><input placeholder="Usuario..." oninput="this.className = ''" name="usuario"/></p>
    <p><input placeholder="Contraseña..." oninput="this.className = ''" name="contrasena" type="password"/></p>
  </div>
  <div class="tab">Código:
    <p><input  placeholder="Ingresa el Código asignado" oninput="this.className = ''" name="codigo"/></p>
  
  
  
<%--     <p><sf:input path="razonSocial" placeholder="Razon Social..." oninput="this.className = ''" name="razonSocial"/></p> --%>
<%--     <p><sf:input path="nombreEmpresario" placeholder="Nombre Empresario..." oninput="this.className = ''" name="nombreEmpresario"/></p> --%>
<%--     <p><sf:input path="logoEmpresa" type="file" placeholder="Ingresa el logo de tu EMpresa" name="logo"/></p> --%>
<!--   </div> -->
<!--   <div class="tab">Correo y Celular: -->
<%--     <p><sf:input path="email" placeholder="E-mail..." oninput="this.className = ''" name="email"/></p> --%>
<%--     <p><sf:input path="celular" placeholder="Celular..." oninput="this.className = ''" name="celular"/></p> --%>
<!--   </div>   -->
<!--   <div class="tab">Login Información: -->
<%--     <p><sf:input path="usuario" placeholder="Usuario..." oninput="this.className = ''" name="usuario"/></p> --%>
<%--     <p><sf:input path="contrasena" placeholder="Contraseña..." oninput="this.className = ''" name="contrasena" type="password"/></p> --%>
<!--   </div> -->
<!--   <div class="tab">Código: -->
<%--     <p><sf:input path="codigo_asignado" placeholder="Ingresa el Código asignado" oninput="this.className = ''" name="codigo"/></p> --%>
    
  </div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Anterior</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Siguiente</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
</sf:form>

<a class="btn btn-danger" href='<c:url value="/"/>' style="top:0;">Regresar</a>

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Guardar";
  } else {
    document.getElementById("nextBtn").innerHTML = "Siguiente";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>

</body>
</html>