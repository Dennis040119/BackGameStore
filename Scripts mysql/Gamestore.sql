drop database Gamestore;
create database Gamestore;
use Gamestore;

SHOW FULL TABLES FROM Gamestore;

drop table if exists usuario ;
create table usuario(
id int primary key auto_increment,
username varchar(20) ,
password varchar(80) ,
email varchar(20),
tarjetaCredito varchar(16),
direccion varchar(100),
rol varchar(6)
);

insert into usuario values(0,'user1','pass1','123@gmail.com','1234123412341234','jr algo 1234','admin');
insert into usuario values(0,'user2','pass2','123@gmail.com','1234123412341234','jr algo 1234','usua');
insert into usuario values(0,'user3','pass3','123@gmail.com','1234123412341234','jr algo 1234');
Select * from usuario; 
/*-------------------------------------------------------*/
drop table if exists Videojuego;
create table Videojuego(
id int primary key AUTO_INCREMENT,
nombre varchar(20) not null,
precio double not null,
color varchar(20) not null,
descripcion varchar(100),
plataforma1 varchar(20),
plataforma2 varchar(20),
plataforma3 varchar(20),
rol char(2) not null,
img varchar(255) not null
);
insert into Videojuego values (0,'Gears of war 2',20.99,'#E36464','odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','xbox 360','','','v','../../assets/GearsOfWar2.jpg');
insert into Videojuego values (0,'Infinity',15.99,'lightgreen','odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','xbox 360','play station 4','','v','../../assets/Destiny.jpg');

Select * from Videojuego; 
Select * from Videojuego where nombre like 'gears Of War 2'; 
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



