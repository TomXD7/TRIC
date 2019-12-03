<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<h1>Reservacion</h1>
<br/>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script> function abrirVentana(URL) {
        //funcion javascript para abrir un subventana para realizar     
        //busquedas, se le pasa la pagina a mostrar como parametro     
        window.open(URL, "ventana1", "width=700,height=400,scrollbars=YES,statusbar=YES,top=150,left=30 0")
    }
</script> 
<form name="form_reservacion" onsubmit="return validar();"
      action="${pageContext.servletContext.contextPath}/Reservaciones?accion=insertar_modificar"
      method="POST">
    <table border="0" id="table">
        <thead>
            <tr>
                <th colspan="">Complete la información<br><br></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID Reservacion</td>
                <td><input type="text" name="txtIdReservacion" value="${reservacion.idreservacion}" readonly="readonly" /></td>
                <td></td>
            </tr>
            <tr>
                <td>Fecha Inicio</td>
                <td><input type="date" name="txtFechaInicio"/></td>
                <td></td>
            </tr>
            <tr>
                <td>Fecha Entrega</td>
                <td><input type="date" name="txtFechaFin" /></td>
                <td></td>
            </tr>
            <tr>
                <td>Agencia</td>
                <td><input type="text" name="txtAgencia" value="${reservacion.agencia}"  /></td>
                <td></td>
            </tr>
            <tr>
                <td>Vehiculo</td>
                <td><input type="text" name="txtMejora" id="txtVehiculo" readonly="readonly"></td>
                <td><input type="button" value="..." class="boton" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Reservaciones?accion=vehiculos');"> </td>
            </tr>
            <tr>             
                <td>Mejora</td>
                <td><input type="text" name="txtMejora" id="txtMejora" readonly="readonly"></td>
                <td><input type="button" value="..." class="boton" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Reservaciones?accion=mejoras');"> </td>
            </tr>
            <tr>
                <td>Seguro</td>
                <td><input type="text" name="txtMejora" id="txtSeguro" readonly="readonly"></td>
                <td><input type="button" value="..." class="boton" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Reservaciones?accion=seguros');"> </td>
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
        var reservacion = document.getElementById('txtReservacion');
        if (reservacion.value.length == 0) {
            reservacion.focus();
            alert("Complete todos los campos");
            return false;
        }
        return true;
    }
    function setDataMejora(idmejora, mejora, precio) {
        document.getElementById("txtMejora").value = mejora;
    }
</script>
<%@include file = "../_down.jsp" %>