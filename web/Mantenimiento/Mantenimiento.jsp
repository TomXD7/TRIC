<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<br><br>
<section class="portafolio">
    
    <div class="portafolio-container">
        <section class="col-4 portafolio-item">
            <a href="${pageContext.servletContext.contextPath}/Vehiculos?accion=7" ><img src="img/car.png"><br><br><br><br></a>
            <section class="portafolio-text">
                <h3>VEHICULO</h3>
                <p>El automóvil requiere mantenimiento, no es solo poner gasolina y nos vamos a viajar. Del mantenimiento que le realicemos al auto depende que la vida útil se prolongue o se reduzca</p>            </article>
            </section>
        </section>
        <section class="col-4 portafolio-item">
            <a href="${pageContext.servletContext.contextPath}/Mejoras?accion=8" ><img src="img/tu.png"><br></a>
            <section class="portafolio-text">
                <h3>MEJORA</h3>
                <p>Las comodidades prestadas a nuestros clientes mejoran y dan la satisfaccion de un buen servio al cliente, prestando servicios extras para su entera comodidad. El coche de alquiler es muy amplia, y los precios y la disponibilidad de modelos que te ofrecemos.</p>            </article>
            </section>
        </section>
        <section class="col-4 portafolio-item">
            <a href="${pageContext.servletContext.contextPath}/Seguros?accion=9" ><img src="img/segur.png"><br></a>
            <section class="portafolio-text">
                <h3>SEGUROS</h3>
                <p>Seguros de auto que proporcionan las coberturas únicas para que adquieras la protección de tu vehículo, ajustándose a tus necesidades y conveniencia.</p>
            </section>
        </section>
    </div>
</section>
<br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>
<%@include file = "../_down.jsp" %>
