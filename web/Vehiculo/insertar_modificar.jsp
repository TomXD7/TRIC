<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/insertar_modificar.css" />
<%@include file = "../_top.jsp" %>
<c:if test="${resultado!=null}">
    <c:if test="${resultado==1}">
        <p style="color:darkgreen"><strong>Operación realizada correctamente.</strong></p>
    </c:if>
    <c:if test="${resultado==0}">
        <p style="color:darkred"><strong>La operación no se realizó.</strong></p>
    </c:if>
</c:if>
<article class="caja">
    <h2>Listado de Vehiculos</h2><br>
    <div class="busqueda">
        <form action="${pageContext.servletContext.contextPath}/Vehiculos" method="get">
            <input type="text" name="txtBusqueda" id="txtBusqueda" value="${valor}" />
            <input type="submit" value="Buscar"/>
        </form>
    </div>
    <div class="buttons" style="margin-left: 70%;">
        <ul>
            <li><a href="${pageContext.servletContext.contextPath}/Vehiculos?accion=insertar" id="Res">Nuevo</a></li>
        </ul>
    </div>
    <br/>
</article>
${tabla}
<script >
    window.onload = function () {
        document.getElementById("txtBusqueda").focus();
    };
</script>
<%@include file = "../_down.jsp" %>

