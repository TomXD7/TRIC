<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>
<html>
</head>
<body>
    <form action="" method="get">
        <fieldset>
            <legend>Datos personales</legend>
                <p>
                        <label for="nombre">Nombre</label>
                        <input id="nombre" type="text" autofocus required>  
                      </p>
               
                       <p>
                           <label for="apellido">Apellidos</label>
                            <input type="text" name="" id="apellido">
                       </p>
                       
                       <p>
                           <label for="email">E-mail</label>
                           <input type="email" name="" id="email">
                       </p>
                       <p>
                           <label for="contraseña">Contraseña</label>
                           <input type="password" id="contraseña">
                       </p>
               
                       <p>
                           <label for="auto">Auto</label>
                           <input type="number" stop="2" max="5" min="1">
                       </p>
               
                       <p>
                           <input type="text" placeholder="Direccion"> 
                       </p>
        </fieldset>
        <fieldset>
                <p>
                        <select name="" id="">
                            <optgroup label="Carro">
                                    <option value="">Fullsize</option>
                                    <option value="">Economico</option>
                                    <option value="">Intermedio</option>     
                            <label for="Fecha">Fecha de inicio</label>
                            <input type="date" id="Fecha"</input>
                            
                            <label for="FechaFin">Fecha de Entrega</label>
                            <input type="date" id="FechaFin"</input>
                            </optgroup>
                            <optgroup label="Cuantos Carros">
                                    <option value=""> 1</option>
                                    <option value=""> 2</option>
                                    <option value=""> 3</option>
                            </optgroup>
                        </select>
                    </p>
            
                    <p>
                        <textarea name="" id="" cols="30" rows="10"></textarea>
                    </p>
            
                    <p>
                        <button>Texto del boton</button>
                    </p>
        </fieldset>
    </body>
</html>
<%@include file = "../_down.jsp" %>
