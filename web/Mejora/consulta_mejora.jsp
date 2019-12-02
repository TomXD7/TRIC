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
    <h2>Listado de Mejoras</h2>
    <div class="busqueda" style="width: 100%; text-align: center">
        <form action="${pageContext.servletContext.contextPath}/Mejoras" method="get">
            <input type="text" name="txtBusqueda" id="txtBusqueda" value="${valor}"/>
            <input type="submit" value="Buscar"/>
        </form>
    </div>
    <br>
    <div class="buttons" style="margin-left: 35%;">
        <ul>
            <li><a href="${pageContext.servletContext.contextPath}/Mejoras?accion=insertar" id="Res">Nuevo</a></li>
        </ul>
    </div>
</article>
<br/>
${tabla}
<script>
    window.onload = function () {
        document.getElementById("txtBusqueda").focus();
    };
</script>

<%@include file = "../_down.jsp" %>

