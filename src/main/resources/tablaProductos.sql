drop table if exists productos;

create table productos(id_prod int primary key auto_increment,nombre varchar(75),precio int,fecha_ingreso date);

insert into productos(nombre,precio,fecha_ingreso) values('armario',20000,'2006-12-03');
insert into productos(nombre,precio,fecha_ingreso) values('cpu',100000,'2006-12-13');
insert into productos(nombre,precio,fecha_ingreso) values('mesa',10000,'2007-01-03');
insert into productos(nombre,precio,fecha_ingreso) values('silla',5000,'2007-01-10');
