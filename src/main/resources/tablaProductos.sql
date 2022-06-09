drop table if exists productos;

create table productos(id_prod int primary key auto_increment,nombre varchar(75),precio int,fecha_ingreso date,
FOREIGN KEY(id_categ) REFERENCES Categorias(id_catg));

insert into productos(nombre,precio,fecha_ingreso) values('armario',20000,'2006-12-03');
insert into productos(nombre,precio,fecha_ingreso) values('cpu',100000,'2006-12-13');
insert into productos(nombre,precio,fecha_ingreso) values('mesa',10000,'2007-01-03');
insert into productos(nombre,precio,fecha_ingreso) values('silla',5000,'2007-01-10');

select  * FROM PRODUCTOS;

create table Categorias(id_catg int primary key auto_increment,nombre varchar(45));

create table productos(id_prod int primary key auto_increment,TIPO_CAT INT, nombre varchar(75),
precio int,fecha_ingreso date,   CONSTRAINT FK_CATEG FOREIGN KEY (TIPO_CAT) REFERENCES CATEGORIAS (ID_CATG));