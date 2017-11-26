-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pro
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `configuracion`
--

DROP TABLE IF EXISTS `configuracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracion` (
  `clave` varchar(45) NOT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracion`
--

LOCK TABLES `configuracion` WRITE;
/*!40000 ALTER TABLE `configuracion` DISABLE KEYS */;
INSERT INTO `configuracion` VALUES ('bloque_atencion','30'),('hora_fin','18:00:00'),('hora_inicio','10:00:00');
/*!40000 ALTER TABLE `configuracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dias_feriados`
--

DROP TABLE IF EXISTS `dias_feriados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dias_feriados` (
  `fecha` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias_feriados`
--

LOCK TABLES `dias_feriados` WRITE;
/*!40000 ALTER TABLE `dias_feriados` DISABLE KEYS */;
INSERT INTO `dias_feriados` VALUES ('2017-12-19'),('2017-12-25');
/*!40000 ALTER TABLE `dias_feriados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idperfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'cliente');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_permiso`
--

DROP TABLE IF EXISTS `perfil_permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil_permiso` (
  `idperfil_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `id_perfil` int(11) DEFAULT NULL,
  `id_permiso` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idperfil_permiso`),
  KEY `id_pefil_idx` (`id_perfil`),
  KEY `id_permiso_idx` (`id_permiso`),
  CONSTRAINT `id_pefil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`idperfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_permiso` FOREIGN KEY (`id_permiso`) REFERENCES `permiso` (`idpermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_permiso`
--

LOCK TABLES `perfil_permiso` WRITE;
/*!40000 ALTER TABLE `perfil_permiso` DISABLE KEYS */;
INSERT INTO `perfil_permiso` VALUES (1,1,'1');
/*!40000 ALTER TABLE `perfil_permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `idpermiso` varchar(100) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idpermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES ('1','nombre');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `fechaReserva` date DEFAULT NULL,
  `servicio` varchar(45) DEFAULT NULL,
  `sucursal` varchar(45) DEFAULT NULL,
  `id_usuario` varchar(45) DEFAULT NULL,
  `hora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`nombreUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (16,'2017-11-27','posventa','Santiago','ciro','10:30:00'),(17,'2017-11-30','posventa','Santiago','ciro','10:30:00'),(18,'2017-11-30','venta','Santiago','ciro','13:00:00'),(19,'2017-11-27','posventa','Santiago','ciro','11:00:00'),(20,'2017-11-29','asd','Puerto Montt','ciro','11:00:00'),(21,'2017-11-28','asd','Concepcion','ciro','13:00:00'),(22,'2017-11-29','asd','Santiago','ciro','12:00:00'),(23,'2017-11-28','aaaaaaaaaaaaaaaaaaaaaaaaaaa','Santiago','ciro','10:30:00'),(24,'2017-11-30','asd','Concepcion','ciro','12:00:00'),(25,'2017-11-30','sdf','Valparaiso','ciro','11:30:00'),(26,'2017-11-27','asd','Puerto Montt','ciro','13:30:00'),(27,'2017-11-27','asdasdasdasdasdasd','Santiago','ciro','11:30:00'),(28,'2017-11-29','asd','Rancagua','ciro','10:30:00'),(29,'2017-11-30','asd','Rancagua','ciro','12:30:00'),(30,'2017-11-27','asd','Valparaiso','ciro','14:00:00'),(31,'2017-11-29','asd','Valparaiso','ciro','12:30:00'),(32,'2017-11-27','asd','Valparaiso','ciro','12:00:00'),(33,'2017-11-30','asd','Puerto Montt','ciro','11:00:00'),(34,'2017-11-29','asd','Concepcion','ciro','14:30:00'),(35,'2017-12-08','venta','Valparaiso','ciro','15:00:00'),(36,'2017-11-28','',NULL,'ciro','15:30:00'),(37,'2017-11-30','posventa','Valparaiso','ciro','16:00:00'),(38,'2017-11-28','',NULL,'ciro','13:30:00'),(39,'2017-12-01','penultima','Santiago','ciro','11:30:00'),(40,'2017-11-30','','Santiago','ciro','13:30:00'),(41,'2017-11-30','','Santiago','ciro','14:00:00'),(42,'2017-11-30','asd','Santiago','ciro','14:30:00'),(43,'2017-11-30','sd','Santiago','ciro','15:00:00'),(44,'2017-11-30','asdasd','Santiago','ciro','15:30:00'),(45,'2017-11-30','asd','Santiago','ciro','16:30:00'),(46,'2017-11-30','asdasd','Concepcion','ciro','17:00:00'),(47,'2017-11-30','asdasd','Concepcion','ciro','17:30:00'),(48,'2017-11-30','asdasd','Concepcion','ciro','18:00:00'),(49,'2017-12-27','Venta','Arica','ciro','11:00:00'),(50,'2017-11-29','Venta','Puerto Montt','ciro','13:30:00');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `idsucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Santiago'),(2,'Rancagua'),(3,'Valparaiso'),(4,'Concepcion'),(5,'Puerto Montt'),(6,'Arica'),(7,'Antofagasta');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `ultimoIngreso` datetime DEFAULT NULL,
  `intentosFallidos` int(11) DEFAULT NULL,
  `id_perfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombreUsuario`),
  KEY `fk_perfil_idx` (`id_perfil`),
  CONSTRAINT `fk_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`idperfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Luis','Torres','Cereño','torrecereno@gmail.com',123123,24,1,'ciro','123','2017-11-26 04:44:12',0,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 12:45:56
