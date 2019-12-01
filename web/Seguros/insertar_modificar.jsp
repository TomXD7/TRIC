<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<h2>Seguros</h2>
<br/>
<form name="form_seguro" onsubmit="return validar();"
      action="${pageContext.servletContext.contextPath}/Seguros?accion=insertar_modificar" method="POST">
    <table border="0" id="table">
        <thead>
            <tr>
                <th colspan ="">Complete la información<br><br></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID Seguro</td>
                <td><input type="text" name="txtIdseguro" value="${seguro.idseguro}" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>Nombre Seguro</td>
                <td><input type="text" name="txtSeguro" id="txtSeguro" value="${seguro.nombre}" /></td>
            </tr>
            <tr>
                <td>Precio</td>
                <td><input type="text" name="txtPrecio" id="txtPrecio" value="${seguro.precio}" /></td>
            </tr>
            <tr>
                <td>Detalle del servicio</td>
                <td> <textarea name="txtDetalle" id="txtDetalle" rows="7" cols="22">${seguro.detalle_servicio}</textarea> </td>
            </tr>
        </tbody>
    </table>
    <br/>
    <div class="buttons">
        <ul>
            <li><input type="submit" value="Guardar" name="guardar" id="Res"/></li>
            <li><a href="#" onclick="javascript: return window.history.back()" id="Res">Regresar</a></li>
        </ul>
    </div>
</form>
<script>
    function validar() {
        var mejora = document.getElementById('txtSeguro');
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

