use tric;
-- drop database tric;
create table rol(
	idrol int primary key identity,
	rol varchar(30) not null

);

create table menu(
idmenu int NOT NULL identity,
menu varchar(50) NOT NULL,
descripcion varchar(100),
url varchar(300),
idpadre int,
PRIMARY KEY(idmenu),
FOREIGN KEY (idpadre) REFERENCES menu (idmenu)
);

create table permiso(
idpermiso int NOT NULL identity,
idmenu int NOT NULL,
idrol int NOT NULL,
PRIMARY KEY (idpermiso),
FOREIGN KEY (idmenu) REFERENCES menu (idmenu),
FOREIGN KEY (idrol) REFERENCES rol (idrol)
);

create table usuario(
	idusuario varchar(25) primary key not null,
	nombres varchar(30) not null,
	apellidos varchar(30) not null,
	correo varchar(50) not null,
	telefono varchar(8) not null,
	contraseña varchar(100) not null,
	idrol int not null,
	foreign key (idrol) references rol (idrol)
);
select * from usuario;
-- drop table usuario;

insert into rol(rol) values('Administrador');

insert into rol(rol) values( 'Usuario');

insert into usuario values('Administrador', 'Rosmery', 'Suriano', 'rosmery11@gmail.com', '70000001', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)), 1);

insert into menu(menu, url) values( 'Inicio', '/Principal'); -- 1
insert into menu(menu, url) values( 'Reservaciones', '/Reservacion'); -- 2
insert into menu(menu, url) values ('Agencias', '/Principal'); -- 3
insert into menu(menu, url) values( 'Ofrecemos', '/Principal'); -- 4
insert into menu(menu, url) values( 'Que Somos', '/Principal'); -- 5
insert into menu(menu, url) values( 'Mantenimiento', '/Principal'); -- 6

-- hijos

insert into menu(menu, url, idpadre) values( 'Vehiculos', '/Vehiculos',6); -- 7
insert into menu(menu, url, idpadre) values( 'Mejoras', '/Mejoras', 6); -- 8
insert into menu(menu, url, idpadre) values( 'Seguros', '/Seguros', 6); -- 9

select * from menu;

insert into permiso(idmenu, idrol) select idmenu, 1 from menu;
insert into permiso(idmenu, idrol) select idmenu, 2 from menu where idmenu in (1,2,3,4,5);

