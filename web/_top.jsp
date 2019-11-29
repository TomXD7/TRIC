<%@page import="com.tric.entidades.Menu"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% HttpSession sesion = request.getSession();
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    List<Menu> MenuPrincipal = (List<Menu>) sesion.getAttribute("MenuPrincipal");
    if (MenuPrincipal == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRIC Rent a Car</title>
        <link rel="stylesheet" href="css/main.css" type="text/css" />
        <link rel="stylesheet" href="css/reset.css" type="text/css" />
        <link rel="stylesheet" href="css/tabla.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/Principal.css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script src="https://kit.fontawesome.com/2c3cae7245.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div id="header">
            <div class="row">
                <div class="col-12 col-t-12 flex-contenedor" >
                    <div class="col-2 col-t-4 ">
                        <img src="img/logo.png"  alt="mi imagen">
                    </div>
                    <br>
                    <div class="col-1 col-t-4 item-texto">
                        <img src="img/text.png" style="width:400px;"  alt="mi imagen">
                        <br/>
                        <p>tricrentacar@gmail.com</p>
                        <br/>
                        <p>(+503)75682363: WhatsApp</p>
                        <br>
                    </div> 
                </div>
            </div>
        </div>
        <div id="sesion">
            <h2>Usuario: ${User.nombres} ${User.apellidos}
                <strong>[${User.idusuario}]</strong> |
                <a href="Principal?accion=logout">Cerrar Sesión</a>
            </h2>
        </div>
        <div id="menu">
            <ul>
                <c:forEach var="menu" items="${MenuPrincipal}">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}${menu.url}?accion=${menu.idmenu}">${menu.menu}</a>
                        <ul>
                            <c:forEach var="submenu" items="${Permisos}">
                                <c:if test="${submenu.idpadre != null}">
                                    <c:if test="${submenu.idpadre == menu.idmenu}">
                                        <li>
                                            <a href="${pageContext.servletContext.contextPath}${submenu.url}?accion=${submenu.idmenu}">${submenu.menu}</a>
                                        </li>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div id="content">