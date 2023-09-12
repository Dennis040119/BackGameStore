-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gamestore
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accesorio`
--

DROP TABLE IF EXISTS `accesorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesorio` (
  `id` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `funcion` varchar(15) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesorio`
--

LOCK TABLES `accesorio` WRITE;
/*!40000 ALTER TABLE `accesorio` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computadora`
--

DROP TABLE IF EXISTS `computadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computadora` (
  `id` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `funcion` varchar(15) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `rol` varchar(2) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computadora`
--

LOCK TABLES `computadora` WRITE;
/*!40000 ALTER TABLE `computadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `computadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `gen_id` varchar(5) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES ('ge000',''),('ge001','Terror'),('ge002','Accion'),('ge003','Shooter'),('ge004','Plataforma'),('ge005','Rpg');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataforma`
--

DROP TABLE IF EXISTS `plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataforma` (
  `plat_id` varchar(5) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `generacion` int DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`plat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataforma`
--

LOCK TABLES `plataforma` WRITE;
/*!40000 ALTER TABLE `plataforma` DISABLE KEYS */;
INSERT INTO `plataforma` VALUES ('pf000','',0,''),('pf001','Xbox 360',4,'MicroSoft'),('pf002','Xbox One',5,'MicroSoft'),('pf003','PlayStation 5',5,'Sony'),('pf004','PlayStation 4',4,'Sony'),('pf005','Nintendo Wii',4,'Nintendo'),('pf006','Antiguos',2,'Nintendo'),('pf007','otros',4,'Sony');
/*!40000 ALTER TABLE `plataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_venta`
--

DROP TABLE IF EXISTS `productos_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos_venta` (
  `pro_id` varchar(255) NOT NULL,
  `ven_id` varchar(255) NOT NULL,
  `cantidad` int NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pro_id`,`ven_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_venta`
--

LOCK TABLES `productos_venta` WRITE;
/*!40000 ALTER TABLE `productos_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productosventa`
--

DROP TABLE IF EXISTS `productosventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productosventa` (
  `venId` varchar(255) NOT NULL,
  `proId` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `cantidad` int NOT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`venId`,`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productosventa`
--

LOCK TABLES `productosventa` WRITE;
/*!40000 ALTER TABLE `productosventa` DISABLE KEYS */;
INSERT INTO `productosventa` VALUES ('vt005','vj001','BattleField 3',25.99,1,'pv','vj0011694157032228.jpg'),('vt005','vj005','BloodBorne',20.99,1,'pv','vj0051689764868758.jpg'),('vt005','vj007','God of War',20.99,1,'pv','vj0071689764879295.jpg');
/*!40000 ALTER TABLE `productosventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'PISO'),(2,'LONJA'),(3,'CHALET INDIVIDUAL'),(4,'CHALET ADOSADO');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `userid` varchar(5) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tarjetaCredito` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `tarjeta_credito` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('us001','admin','$2a$04$2th1r3yYp5zs61MEfsbxZeOZ2.gWylksENchigw.WyjyPdtlP0Gy6','123@gmail.com','1234123412341234','jr algo 1234','ac','ROLE_ADMIN',NULL,NULL),('us002','user','$2a$04$nu8m8zIwBmri5fNff0FQDu7nWsIyBiQUfEcA0nIbp0JA5Ntsv0FMq','12345@gmail.com','1234123412341234','jr algo 1234','ac','ROLE_USER','us0021693560911880.jpg',NULL),('us003','admin1','$2a$04$yRaGmXS51WG/gollV6RETeMD5pWoq21LoyWAAGN5qDBD4eTjMZB4K','gonzalesdennis084@gmail.com','','sarrs','ic','ROLE_ADMIN',NULL,NULL),('us004','user2','$2a$04$0wy0uc1jrS8QBJDLBpyGW./Rh20PdZ9FNDkHta5vLvnuC8Aii4MRa','123@gmail.com','1234123412341234','jr algo 1234','ac','ROLE_USER',NULL,NULL),('us005','usuario1','$2a$04$HKUJ3/nYtaPRLWZYfuW8.O3CtzhE8js9naR0j/wExuTRQ31x6OceS','correo@gmail.com',NULL,NULL,'ic','ROLE_USER',NULL,NULL),('us006','user4','$2a$04$TagRPUA0qfoiCHrxWQp0ke0aa3.Ka6tKtdspWL2RYqEqzG6N1zdQO','correo@gmail.com','9798798798798797','widho','ac','ROLE_USER','us061694083043557.jpg',NULL),('us007','use','$2a$04$oKk.7mmYTEaBFczGPFpvou9fBeOgFm9X1NevUgemM7rvV4mhHFObS','12345correo@gmail.com','1234123412341234','jr algo 1234','ac','ROLE_USER',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `venId` varchar(255) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `movil` varchar(255) DEFAULT NULL,
  `tarjeta` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `fCompra` datetime(6) DEFAULT NULL,
  `fEntrega` datetime(6) DEFAULT NULL,
  `horaEntrega` varchar(255) DEFAULT NULL,
  `ven_id` varchar(255) NOT NULL,
  `f_compra` datetime(6) DEFAULT NULL,
  `f_entrega` datetime(6) DEFAULT NULL,
  `hora_entrega` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`venId`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES ('vt005','us002','Dennis Gonzales Moreno','co@gg.com','777777777','7777777777777777',67.97,'dsdsd','vt','2023-09-08 00:00:00.000000','2023-09-15 00:00:00.000000','3:3','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videoconsola`
--

DROP TABLE IF EXISTS `videoconsola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videoconsola` (
  `vcid` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `plataforma` varchar(5) NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  KEY `plataforma` (`plataforma`),
  CONSTRAINT `videoconsola_ibfk_1` FOREIGN KEY (`plataforma`) REFERENCES `plataforma` (`plat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videoconsola`
--

LOCK TABLES `videoconsola` WRITE;
/*!40000 ALTER TABLE `videoconsola` DISABLE KEYS */;
INSERT INTO `videoconsola` VALUES ('vc001','PlayStation 4 clasico 1000 GB','pf004',1200,'PlayStation 4 clasico con almacenamiento de 1000 Gb','Sony','vc','vc0011689836390213.jpg'),('vc002','PlayStation 5 clasico','pf003',2100,'PlayStation 5 clasico con 500Gb de almacenamiento','Sony','vc','vc0021689838571585.jpg'),('vc003','PlayStation 3','pf007',500,NULL,'Sony','vc','vc0031689838577563.jpg'),('vc004','Atari','pf006',200,NULL,'Antiguo','vc','vc0041689838583488.jpg'),('vc005','GameCube','pf006',300,NULL,'Nintendo','vc','vc0051689838628636.jpg'),('vc006','Nes','pf006',100,NULL,'Otros','vc','vc0061689838643816.jpg'),('vc007','Nintendo Wii','pf005',500,NULL,'Nintendo','vc','vc0071689838649563.jpg'),('vc008','Nintendo WiiU','pf005',800,NULL,'Nintendo','vc','vc0081689838655923.jpg'),('vc009','Xbox One','pf002',1200,NULL,'MicroSoft','vc','vc0091689838661875.jpg'),('vc010','Xbox Series X','pf002',2100,NULL,'MicroSoft','vc','vc0101689838667989.jpg'),('vc011','Xbox one Gold Edition','pf001',1599.99,'edicion especial','MicroSoft','vc','01689836153742.jpg');
/*!40000 ALTER TABLE `videoconsola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuego`
--

DROP TABLE IF EXISTS `videojuego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuego` (
  `vjid` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `plataformas` varchar(255) DEFAULT NULL,
  `genero` varchar(5) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`vjid`),
  KEY `genero` (`genero`),
  CONSTRAINT `videojuego_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `genero` (`gen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuego`
--

LOCK TABLES `videojuego` WRITE;
/*!40000 ALTER TABLE `videojuego` DISABLE KEYS */;
INSERT INTO `videojuego` VALUES ('vj001','BattleField 3',25.99,'Juego de disparos multiplayer online','pf001,pf002,pf003','ge003','vj','vj0011694157032228.jpg'),('vj002','Destiny',15.99,'plataforma con mundo abierto','pf001,pf005,pf004','ge004','vj','vj0021694079225206.jpg'),('vj003','Mario Galaxy',30.99,NULL,'pf005','ge004','vj','vj0031689764856023.jpg'),('vj004','Gears of War 2',20.99,'odsauhfodsiuhfkhdasofhdsofhsoiahfoaihfoiash','pf001,pf002','ge003','vj','vj0041689764863104.jpg'),('vj005','BloodBorne',20.99,'Soulslike de estilo terror cosmico','pf003,pf004','ge005','vj','vj0051689764868758.jpg'),('vj006','HomeFront',20.99,'Shooter en un mundo postApocaliptico','pf005,pf002,pf001','ge002','vj','vj0061689764873652.jpg'),('vj007','God of War',20.99,'Secuela de la famosa franquicia de Sony','pf003,pf004','ge002','vj','vj0071689764879295.jpg'),('vj008','Metal Gears V',15.99,'Shooter Rpg iconico de Xbox','pf001,pf002,pf007','ge003','vj','vj0081689765052814.jpg'),('vj009','Destiny2',20.99,'plataforma','pf001,pf002','ge004','vj','vj0091689765604817.jpg'),('vj010','Dark souls 2',30.99,'secuela dark solus','pf002,pf003,pf004','ge005','vj','vj0101694073409382.jpg'),('vj011','ds3',110,NULL,'pf001,pf002,pf003','ge005','vj','vj0111694073638535.jpg');
/*!40000 ALTER TABLE `videojuego` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-12 12:37:06
