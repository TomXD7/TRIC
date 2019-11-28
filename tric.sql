use tric;

drop database tric;


create table vehiculo(
	idvehiculo int primary key identity,
	modelo varchar(50) not null CHECK (modelo IN('Camioneta', 'Sedan', 'Pick up', 'Deportivo')),
	numero_pasajeros int,
	color varchar(10) NOT NULL CHECK (color IN('Negro', 'Blanco', 'Azul', 'Rojo')),
	placa varchar(20) not null,
	precio decimal(5,2) not null,
	marca varchar(10) NOT NULL CHECK (marca IN('Ford', 'Honda', 'Hyundai', 'KIA', 'Mazda', 'Nissan')),
);
 
-- insert into vehiculo(modelo,numero_pasajeros,color,placa,precio,marca) values('Sedan',4,'Negro','P30 777',77,'KIA');
create table mejora(
	idmejora int primary key identity,
	nombre varchar(50),
	precio decimal(3,2),
	detalle_servicio varchar(500)
);

create table seguro(
	idseguro int primary key identity,
	nombre varchar(50),
	precio decimal(3,2),
	detalle_servicio varchar(500)
);

create table prestamo(
	idprestamo int primary key identity,
	reserva date not null,
	fecha_inicio datetime not null,
	fecha_fin datetime not null,
	sucursal varchar(25),
	idusuario varchar(25),
	idvehiculo int,
	idmejora int,
	idproducto int,
	CONSTRAINT fk_usuario FOREIGN KEY (idusuario) REFERENCES usuario (idusuario),
	CONSTRAINT fk_vehiculo FOREIGN KEY (idvehiculo) REFERENCES vehiculo (idvehiculo),
	CONSTRAINT fk_mejoraviaje FOREIGN KEY (idmejora) REFERENCES mejora (idmejora),
	CONSTRAINT fk_productoproteccion FOREIGN KEY (idproducto) REFERENCES seguro (idseguro)
);

create table mejoraprestamo(
	idmejora int,
	idprestamo int,
	cantidad int,
	primary key(idmejora, idprestamo),
	CONSTRAINT fk_mejora FOREIGN KEY (idmejora) REFERENCES mejora (idmejora),
	CONSTRAINT fk_prestamo FOREIGN KEY (idprestamo) REFERENCES prestamo (idprestamo)
);

create table seguroprestamo(
	idproducto int,
	idprestamo int,
	cantidad int,
	primary key(idproducto, idprestamo),
	CONSTRAINT fk_producto FOREIGN KEY (idproducto) REFERENCES seguro (idseguro),
	CONSTRAINT fk_prestamop FOREIGN KEY (idprestamo) REFERENCES prestamo (idprestamo)
);

-- Consultas xD

SELECT
	*
FROM vehiculo
WHERE
	idvehiculo NOT IN (SELECT idvehiculo FROM prestamo WHERE fecha_fin <= CURRENT_TIMESTAMP)
	AND modelo = 'Sedan';
