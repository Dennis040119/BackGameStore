drop database Gamestore;
create database Gamestore;
use Gamestore;

SHOW FULL TABLES FROM Gamestore;

drop table if exists usuario ;
create table usuario(
userid varchar(5) primary key,
username varchar(20) unique ,
password varchar(80) ,
email varchar(20),
tarjetaCredito varchar(16),
direccion varchar(100),
rol varchar(6)
);

insert into usuario values('us001','user1','pass1','123@gmail.com','1234123412341234','jr algo 1234','admin');
insert into usuario values('us002','user2','pass2','123@gmail.com','1234123412341234','jr algo 1234','user');
Select * from usuario; 
/*-------------------------------------------------------*/

/*-------------------------------------------------------*/
drop table if exists videoconsola;
create table videoconsola(
vcid varchar(20) primary key,
nombre varchar(50) not null,
plataforma  varchar(5) not null,
precio double not null,
descripcion varchar(50),
marca varchar(20),
rol varchar(2),
img varchar(100),

FOREIGN KEY (plataforma) REFERENCES plataforma(platId)
);
insert into videoconsola values('vc001','PlayStation4','pf004',1200,'','Sony','vc','');
insert into videoconsola values('vc002','PlayStation5','pf003',1600,'','Sony','vc','');

select*from videoconsola;
/*-------------------------------------------------------*/
drop table if exists computadora;
create table computadora(
id varchar(20) primary key,
nombre varchar(20),
precio double,
descripcion varchar(50),
funcion varchar(15),
marca varchar(20),
rol varchar(2),
img varchar(100)
);

/*-------------------------------------------------------*/
drop table if exists accesorio;
create table accesorio(
id varchar(20) primary key,
nombre varchar(20),
precio double,
descripcion varchar(50),
funcion varchar(15),
marca varchar(20),
img varchar(100)
);
/************************************************************/
drop table if exists plataforma ;
create table plataforma(
platId varchar(5) primary key,
nombre varchar(20) ,
generacion int,
marca varchar(20)
);
insert into plataforma values ('pf000','',0,'');
insert into plataforma values ('pf001','Xbox 360',4,'MicroSoft');
insert into plataforma values ('pf002','Xbox One',5,'MicroSoft');
insert into plataforma values ('pf003','PlayStation 5',5,'Sony');
insert into plataforma values ('pf004','PlayStation 4',4,'Sony');

insert into plataforma values ('pf005','Nintendo Wii',4,'Nintendo');
insert into plataforma values ('pf006','Antiguos',2,'Nintendo');
insert into plataforma values ('pf007','otros',4,'Sony');

select * from plataforma;
/************************************************************/
drop table if exists genero ;
create table genero(
genId varchar(5) primary key,
nombre varchar(20)
);
insert into genero values ('ge000','');
insert into genero values ('ge001','Terror');
insert into genero values ('ge002','Accion');
insert into genero values ('ge003','Shooter');
insert into genero values ('ge004','Plataforma');
insert into genero values ('ge005','Rpg');



select * from genero;

/**********************************/
drop table if exists Videojuego;
create table Videojuego(
vjid varchar(5) primary key,
nombre varchar(20) not null,
precio double not null,
descripcion varchar(100),
plataformas varchar(100) not null ,
genero varchar(5),
rol char(2) not null ,
img varchar(255) not null,

FOREIGN KEY (genero) REFERENCES genero(genId)
);
insert into Videojuego values ('vj001','Gears of war 2',20.99,'odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','pf001,pf002','ge001','vj','../../assets/GearsOfWar2.jpg');
insert into Videojuego values ('vj002','Infinity',15.99,'odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','pf001','ge001','vj','../../assets/Destiny.jpg');

Select c.vjid,c.nombre,c.precio,g.nombre as 'Genero',c.plataformas from Videojuego c inner join genero g on c.genero=g.genId ; 
Select * from Videojuego where nombre like 'gears Of War 2'; 
/**********************************************************/
drop table if exists Venta;
create table Venta(

venId varchar(5) primary key,
usuario varchar(20) not null,
nombre varchar(100) not null,
correo varchar(50) not null,
movil varchar(9),
tarjeta varchar(16),
total double not null,
direccion varchar(100) not null,
rol char(2) not null ,
fCompra date not null,
fEntrega date not null,
FOREIGN KEY (usuario) REFERENCES usuario(userid)
);
SET TIME_ZONE='+00:00';
insert into Venta values('vt001','us001',"Jose jose","correo@gmail.com","999888777","1111444433332222",100,'direcionventa1','vt','2023/06/19','2023/07/01');
insert into Venta values('vt002','us001',"Jose maria","correo@gmail.com","999888777","1111444433332222",100,'direcionventa1','vt','2023/06/19','2023/07/01');

select * from Venta;


/**********************************************************/
drop table if exists ProductosVenta;
create table ProductosVenta(
venId varchar(5) ,
proId varchar(5) ,
nombre varchar(20) not null,
precio double not null,
cantidad double not null,
rol char(2) not null ,
img varchar(255) not null,

 PRIMARY KEY(venId,proId)
);

select * from ProductosVenta where venId='vt004';
insert into ProductosVenta values('vt001','vj001','prodcut1',20.99,2,'pv','urlimagen');
insert into ProductosVenta values('vt001','vj002','prodcut1',20.99,2,'pv','urlimagen');

insert into ProductosVenta values('vt002','vj001','prodcut1',20.99,2,'pv','urlimagen');
insert into ProductosVenta values('vt002','vj002','prodcut1',20.99,2,'pv','urlimagen');
insert into ProductosVenta values('vt002','vj003','prodcut1',20.99,2,'pv','urlimagen');


