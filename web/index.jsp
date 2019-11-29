<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>TRIC</title>
        <link rel="stylesheet" type="text/css" href="css/index.css" />
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
            <div class="col-12 col-t-12  fondo2" >
                <article class="col-4 col-t-3 ">
                </article>
                <article class="col-4 col-t-8 caja">
                    <hr/>
                    <h2>Inicio de Sesion</h2><br/>
                    <center>
                        <c:if test="${error!=null}">
                            <c:if test="${error==2}">
                                <p><strong style="color: red">Usuario y/o contraseña incorrectos</strong></p>
                            </c:if>
                        </c:if>
                    </center> 
                    <form name="main" action="Login?accion=login" method="POST">
                        <table class="login">
                            <tr><td>Usuario</td></tr>
                            <tr><td><input type="text" name="txtUsuario" /></td></tr>
                            <tr><td>Contraseña</td></tr>
                            <tr><td><input type="password" name="txtClave"></td></tr>
                            <tr><td>
                                    <div class="buttons">
                                        <input id="button" type="submit" value="Entrar" name="btnEntrar"/> <br> 
                                        <a href="Usuarios?accion=insertar" id="Res"> Registrarse </a>
                                    </div>
                                </td></tr>
                        </table>
                    </form>
                    <br/><br/><br/><br/>
                    <hr/>
                </article>  
            </div>
        </div>
    </body>
</html>
