-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: o11g01
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `configuraciones`
--

DROP TABLE IF EXISTS `configuraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuraciones` (
  `id_configuraciones` int NOT NULL AUTO_INCREMENT,
  `nombreParqueadero` varchar(45) DEFAULT NULL,
  `valorHoraCarro` double DEFAULT NULL,
  `valorHoraMoto` double DEFAULT NULL,
  `valorFracCarro` double DEFAULT NULL,
  `valorFracMoto` double DEFAULT NULL,
  `valorDiaCarro` double DEFAULT NULL,
  `valorDiaMoto` double DEFAULT NULL,
  `valorSemCarro` double DEFAULT NULL,
  `valorSemMoto` double DEFAULT NULL,
  `valorMesCarro` double DEFAULT NULL,
  `valorMesMoto` double DEFAULT NULL,
  PRIMARY KEY (`id_configuraciones`),
  UNIQUE KEY `idConfiguraciones_UNIQUE` (`id_configuraciones`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuraciones`
--

LOCK TABLES `configuraciones` WRITE;
/*!40000 ALTER TABLE `configuraciones` DISABLE KEYS */;
INSERT INTO `configuraciones` VALUES (1,'EasyParking',3000,1000,1000,500,35000,20000,120000,60000,400000,200000);
/*!40000 ALTER TABLE `configuraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `id_factura` int unsigned NOT NULL AUTO_INCREMENT,
  `codigoFactura` int DEFAULT NULL,
  `placa` varchar(10) NOT NULL,
  `tipoContrato` varchar(10) DEFAULT NULL,
  `fechaEntrada` datetime NOT NULL,
  `fechaSalida` datetime DEFAULT NULL,
  `id_personas` int unsigned NOT NULL,
  `valor` double DEFAULT NULL,
  `fechaFactura` datetime DEFAULT NULL,
  `id_plazas` int unsigned NOT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE KEY `idFactura_UNIQUE` (`id_factura`),
  UNIQUE KEY `codigoFactura_UNIQUE` (`codigoFactura`),
  KEY `FK-factura-personas_idx` (`id_personas`),
  KEY `FK-factura-plazas_idx` (`id_plazas`),
  CONSTRAINT `FK_factura_personas` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`),
  CONSTRAINT `FK_factura_plazas` FOREIGN KEY (`id_plazas`) REFERENCES `plazas` (`id_plazas`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1,'ABC123','normal','2022-08-19 08:15:00','2022-08-26 09:43:00',1,2500,'2022-08-26 09:44:00',2),(6,9,'RFT234','normal','2022-09-18 17:03:28','2022-09-18 17:04:11',1,30000,'2022-09-18 17:04:11',6);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_personas` int unsigned NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `tipDoc` varchar(20) DEFAULT NULL,
  `numDoc` varchar(20) NOT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_personas`),
  UNIQUE KEY `idPersonas_UNIQUE` (`id_personas`),
  UNIQUE KEY `numDoc_UNIQUE` (`numDoc`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Anonimo',NULL,NULL,'0',NULL,NULL,NULL),(2,'Administrador',NULL,NULL,'1',NULL,NULL,NULL),(3,'Recepcionista',NULL,NULL,'2',NULL,NULL,NULL),(12,'cristian','luna','CC','1005284534','calle 9#23432','31523534','cristian@gmail.com'),(13,'elkin','herrera','CC','3454565','calle 163sd','45345','elkin@gmail.com');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plazas`
--

DROP TABLE IF EXISTS `plazas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plazas` (
  `id_plazas` int unsigned NOT NULL AUTO_INCREMENT,
  `codigoPlaza` varchar(5) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id_plazas`),
  UNIQUE KEY `idPlaza_UNIQUE` (`id_plazas`),
  UNIQUE KEY `codigoPlaza_UNIQUE` (`codigoPlaza`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plazas`
--

LOCK TABLES `plazas` WRITE;
/*!40000 ALTER TABLE `plazas` DISABLE KEYS */;
INSERT INTO `plazas` VALUES (1,'M001','moto','libre'),(2,'M002','moto','ocupado'),(3,'M003','moto','libre'),(4,'M004','moto','libre'),(5,'M005','moto','libre'),(6,'C001','carro','libre'),(7,'C002','carro','ocupado'),(8,'C003','carro','libre'),(9,'C004','carro','libre'),(10,'C005','carro','libre');
/*!40000 ALTER TABLE `plazas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuarios` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `id_personas` int unsigned NOT NULL,
  PRIMARY KEY (`id_usuarios`),
  UNIQUE KEY `idUsuarios_UNIQUE` (`id_usuarios`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `FK-_idx` (`id_personas`),
  CONSTRAINT `FK-usuarios-personas` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','12345','Administrador',2),(2,'recepcionista','12345','Recepcionista',3),(12,'cristian10','213435','Administrador',12);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_usuarios`
--

DROP TABLE IF EXISTS `v_usuarios`;
/*!50001 DROP VIEW IF EXISTS `v_usuarios`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_usuarios` AS SELECT 
 1 AS `id_suarios`,
 1 AS `usuario`,
 1 AS `clave`,
 1 AS `rol`,
 1 AS `id_personas`,
 1 AS `nombres`,
 1 AS `apellidos`,
 1 AS `tipDoc`,
 1 AS `numDoc`,
 1 AS `direccion`,
 1 AS `telefono`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_usuarios`
--

/*!50001 DROP VIEW IF EXISTS `v_usuarios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_usuarios` AS select `usuarios`.`id_usuarios` AS `id_suarios`,`usuarios`.`usuario` AS `usuario`,`usuarios`.`clave` AS `clave`,`usuarios`.`rol` AS `rol`,`usuarios`.`id_personas` AS `id_personas`,`personas`.`nombres` AS `nombres`,`personas`.`apellidos` AS `apellidos`,`personas`.`tipDoc` AS `tipDoc`,`personas`.`numDoc` AS `numDoc`,`personas`.`direccion` AS `direccion`,`personas`.`telefono` AS `telefono`,`personas`.`email` AS `email` from (`usuarios` join `personas` on((`usuarios`.`id_personas` = `personas`.`id_personas`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-18 17:34:42
