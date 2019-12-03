<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>   
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
<link rel="stylesheet" type="text/css" href="css/reset.css" />         
<link rel="stylesheet" type="text/css" href="css/main.css" media="screen" />                 
<link rel="stylesheet" type="text/css" href="css/tabla.css" media="screen" />            
<style>             
    #table01 td{ padding-top: 8px; cursor: pointer}         
</style> 
<title>Vehiculos</title>     
</head>     
<body>         
    <div id="contenido" style="padding: 10px">         
        <h1>Listado de Vehiculos</h1>         
        ${tabla}     
        <script>               
            function _Seleccionar_(row){                                     
            var idvehiculo = row.cells[0].innerHTML;                        
            var modelo = row.cells[1].childNodes[0].innerHTML;                        
            var numero_pasajeros = row.cells[2].childNodes[0].innerHTML;
            var color = row.cells[3].childNodes[0].innerHTML;
            var placa = row.cells[4].childNodes[0].innerHTML;
            var precio = row.cells[5].childNodes[0].innerHTML;
            var marca = row.cells[6].childNodes[0].innerHTML;
            window.opener.setDataMejora(idseguro, seguro, precio);                       
            window.close();         
            }            
                </script>      
    </div>     
</body> 
</html> 