<%@include file = "_top.jsp" %>
    <ul id="opciones">
        <c:forEach var="opcion" items="${PermisosAsignados}">
            <li><a href="${pageContext.servletContext.contextPath}${opcion.url}?op=${opcion.idmenu}">${opcion.menu}</a></li>    
        </c:forEach>
    </ul>
<%@include file = "_down.jsp" %>