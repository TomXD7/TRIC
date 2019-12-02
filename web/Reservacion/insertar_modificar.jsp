<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<h1>Reservacion</h1>
<br/>
<head>
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <script> function abrirVentana (URL){     
            ////funcion javascript para abrir un subventana para realizar     
            ////busquedas, se le pasa la pagina a mostrar como parametro     
            window.open(URL,"ventana1","width=700,height=400,scrollbars=YES,statusbar=YES,top=150,left=30 0") } </script> 
    </head>
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
                <td>ID Reservacion</td>
                <td><input type="text" name="txtIdReservacion" value="${reservacion.reservacion}" readonly="readonly" /></td>
            </tr>
             <tr>
                <td>Fecha Inicio</td>
                <td><input type="date" name="txtFechaInicio"/></td>
            </tr>
             <tr>
                <td>Fecha Entrega</td>
                <td><input type="date" name="txtFechaFin" /></td>
            </tr>
             <tr>
                <td>Agencia</td>
                <td><input type="text" name="txtAgencia" value="${reservacion.agencia}"  /></td>
            </tr>
            <tr>
                <td>ID Vehiculo</td>
                <td><input type="text" name="txtVehiculo" value="${reservacion.idvehiculo}"  /></td>
            </tr>
            <tr>
                <input type="text" name="txtIdmejora" id="txtIdmejora" size="2" readonly="readonly">             
                <input type="text" name="txtMejora" id="txtMejora" readonly="readonly">             
                <input type="button" value="..." class="boton" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Reservaciones?accion=mejoras');"> 
            </tr>
            <tr>
                <td>ID Seguro</td>
                <td><input type="text" name="txtSeguro" value="${reservacion.idseguro}"  /></td>
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
    function setDataMejoras(idmejora, mejora, precio){
        document.getElementById("txtIdmejora").value = idmejora;
        document.getElementById("txtMejora").value = mejora;
    }
</script>
<%@include file = "../_down.jsp" %>