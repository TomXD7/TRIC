</div>
<div id="footer">
    <hr/>
    <br/>
    <p>
        <c:forEach var="menu" items="${MenuPrincipal}">
                        <a href="${pageContext.servletContext.contextPath}${menu.url}?accion=${menu.idmenu}">${menu.menu}</a> |
                </c:forEach>
    </p>
    <br/>
    <p>&copy; Copyright 2019 | Design by: DSW | Developed by: DSW </p>
</div>
</body>
</html>
