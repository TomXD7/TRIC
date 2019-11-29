<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>TRIC</title>
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="stylesheet" href="css/main.css" type="text/css" />
    </head>
    <body>
        <div id="header">
            <div class="col-12 col-t-12 flex-contenedor" >
                <div class="col-3 col-t-4 ">
                    <img src="img/logo.png"  alt="mi imagen">
                </div>
                <br>
                <div class="col-6 col-t-4 item-texto">
                    <h1>TRIC Rent a Car </h1>
                </div> 
            </div>  
        </div>
        <div id="content">
            <hr/>
            <h2>Registrate.</h2>
            <br/>
            <form name="resgistro" action="Usuarios" method="POST">
                <table id="table">
                    <tr>
                        <th>  </th>
                        <th>  </th>
                    </tr>
                    <tr>
                        <td> Usuario: </td>
                        <td> <input type="text" name="txtUsuario" size="35"> </td>
                    </tr>
                    <tr>
                        <td> Nombre: </td>
                        <td> <input type="text" name="txtNombre" size="35"> </td>
                    </tr>
                    <tr>
                        <td> Apellido: </td>
                        <td> <input type="text" name="txtApellido" size="35"> </td>
                    </tr>
                    <tr>
                        <td> Correo: </td>
                        <td> <input type="text" name="txtCorreo" size="35"> </td>
                    </tr>
                    <tr>
                        <td> Telefono: </td>
                        <td> <input type="text" name="txtTelefono" size="35"> </td>
                    </tr>
                    <tr>
                        <td> Contraseña: </td>
                        <td> <input type="password" name="txtPassword" size="35"> </td>
                    </tr>
                </table>
                <br/>
                <input type="submit" name="btnEnviar" id="button" value="Resgistrarse">
                <br/>
                <a href="${pageContext.servletContext.contextPath}/Login" id="Res"> Cancelar </a>
            </form>
        </div>
