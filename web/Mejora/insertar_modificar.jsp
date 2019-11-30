<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<h1>Paises</h1>
<br/>
<form name="form_mejoras" onsubmit="return validar();"
      action="${pageContext.servletContext.contextPath}/Mejoras?accion=insertar_modificar" method="POST">
    <table border="0" id="table">
        <thead>
            <tr>
                <th colspan="">Complete la información<br><br></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID Mejora</td>
                <td><input type="text" name="txtIdmejora" value="${mejora.idmejora}" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>Nombre Mejora</td>
                <td><input type="text" name="txtMejora" id="txtMejora" value="${mejora.nombre}" /></td>
            </tr>
            <tr>
                <td>Precio</td>
                <td><input type="text" name="txtPrecio" id="txtPrecio" value="${mejora.precio}" /></td>
            </tr>
            <tr>
                <td>Detalle del servicio</td>
                <td><input type="text" name="txtDetalle" id="txtDetalle" value="${mejora.detalle_servicio}" /></td>
            </tr>
        </tbody>
    </table>
    <br/>
    <div class="buttons">
        <ul>
            <li><input type="submit" value="Guardar" name="guardar"/></li>
            <li><a href="#" onclick="javascript: return window.history.back()">Regresar</a></li>
        </ul>
    </div>
</form>
<script>
    function validar() {
        var mejora = document.getElementById('txtMejora');
        var precio = document.getElementById('txtPrecio');
        var detalle = document.getElementById('txtDetalle');
        if (mejora.value.length == 0 || precio.value.length == 0 || detalle.value.length == 0) {
            mejora.focus();
            alert("Complete todos los campos.");
            return false;
        }
        return true;
    }
</script>
<%@include file = "../_down.jsp" %>

