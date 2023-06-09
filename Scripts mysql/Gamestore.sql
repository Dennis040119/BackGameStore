drop database Gamestore;
create database Gamestore;
use Gamestore;

SHOW FULL TABLES FROM Gamestore;

drop table if exists usuario ;
create table usuario(
id int primary key auto_increment,
username varchar(20) unique ,
password varchar(80) ,
email varchar(20),
tarjetaCredito varchar(16),
direccion varchar(100),
rol varchar(6)
);

insert into usuario values(0,'user1','pass1','123@gmail.com','1234123412341234','jr algo 1234','admin');
insert into usuario values(0,'user2','pass2','123@gmail.com','1234123412341234','jr algo 1234','usua');
Select * from usuario; 
/*-------------------------------------------------------*/

/*-------------------------------------------------------*/
drop table if exists videoconsola;
create table videoconsola(
id varchar(20) primary key,
nombre varchar(20),
precio double,
descripcion varchar(50),
marca varchar(20),
img varchar(100)
);

/*-------------------------------------------------------*/
drop table if exists computadora;
create table computadora(
id varchar(20) primary key,
nombre varchar(20),
precio double,
descripcion varchar(50),
funcion varchar(15),
marca varchar(20),
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
insert into Videojuego values ('vj001','Gears of war 2',20.99,'odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','pf001,pf002','ge001','v','../../assets/GearsOfWar2.jpg');
insert into Videojuego values ('vj002','Infinity',15.99,'odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','pf001','ge001','v','../../assets/Destiny.jpg');

Select c.vjid,c.nombre,c.precio,g.nombre as 'Genero',c.plataformas from Videojuego c inner join genero g on c.genero=g.genId ; 
Select * from Videojuego where nombre like 'gears Of War 2'; 
