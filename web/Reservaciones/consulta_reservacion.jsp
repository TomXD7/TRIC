<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<h1>Reservacion</h1>
<br/>
<form name="form_reservacion" onsubmit="return validar();"
      action="${pageContext.servletContext.contextPath}/Reservacion?accion=insertar_modificar"
      method="POST">
    <table border="0" id="table">
        <thead>
            <tr>
                <th colspan="">Complete la información<br><br></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>IDReservacion</td>
                <td><input type="text" name="txtIdReservacion" value="${pais.idpais}" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>Nombre </td>
                <td><input type="text" name="txtNombre" id="txtPais" value="${pais.pais}" /></td>
            </tr>
             <tr>
                <td>Fecha Inicio</td>
                <td><input type="text" name="txtFechaInicio" value="${pais.idpais}" readonly="readonly" /></td>
            </tr>
             <tr>
                <td>Fecha Entrega</td>
                <td><input type="text" name="txtFechaFin" value="${pais.idpais}" readonly="readonly" /></td>
            </tr>
             <tr>
                <td>ID Tipo de auto</td>
                <td><input type="text" name="txtIdTipo" value="${pais.idpais}" readonly="readonly" /></td>
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
        var pais = document.getElementById('txtPais');
        if (pais.value.length == 0) {
            pais.focus();
            alert("Complete todos los campos");
            return false;
        }
        return true;
    }
</script>


<%@include file = "../_down.jsp" %>