<%@include file = "_top.jsp" %>
<link rel="stylesheet" href="css/Principal.css" type="text/css" />

<ul id="opciones">
    <c:forEach var="opcion" items="${PermisosAsignados}">
        <li><a href="${pageContext.servletContext.contextPath}${opcion.url}?op=${opcion.idmenu}">${opcion.menu}</a></li>    
        </c:forEach>
</ul>

<div class="contenedor">
    <div class="fondito row">
        <main class="col-12 col-t-12">
            <section class="row">
                <article class="col-4 col-t-6  ima">
                    <img src="img/mit.jpg"  alt="mi imagen">
                    <br>
                    <a>Economico</a><br>  
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
                <article class="col-4 col-t-6  ima">
                    <img src="img/toyota-hilux.jpg"  alt="mi imagen">
                    <br>
                    <a>Economico</a><br>   
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
                <article class="col-4 col-t-6  ima">
                    <img src="img/jeep.jpg"  alt="mi imagen">
                    <br>.
                    <a>Economico</a><br>   
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
                <article class="col-4 col-t-6  ima">
                    <img src="img/g4.jpg"  alt="mi imagen">
                    <br>
                    <a>Economico</a><br>   
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
                <article class="col-4 col-t-6  ima">
                    <img src="img/sail.jpg"  alt="mi imagen">
                    <br>
                    <a>Economico</a><br>   
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
                <article class="col-4 col-t-6  ima">
                    <img src="img/sedan-accent.jpg"  alt="mi imagen">
                    <br>
                    <a>Economico</a><br> 
                    <a><i class="icon icon-travel-car">2/4</i></a><br>
                    <a><i class="icon icon-user">5</i></a><br>
                    <a><i class="icon icon-travel-case">3</i></a><br>
                    <h3> $70 diarios</h3>
                    <a href="" class="bo">Reservar</a>
                </article>
            </section>
        </main>
    </div>
</div>  
<%@include file = "_down.jsp" %>
