-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: webapp
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `idalumno` int NOT NULL AUTO_INCREMENT,
  `appaterno` varchar(50) NOT NULL,
  `apmaterno` varchar(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `nacimiento` date NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `referencia` varchar(200) DEFAULT NULL,
  `genero` varchar(1) NOT NULL DEFAULT 'M' COMMENT '1=Masculino, 0=Femenino',
  `estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
  PRIMARY KEY (`idalumno`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Torres','Andrade','Juan Julio','1981-03-15','Av. Salaverry 1870 - San Isidro','Referencia 2','M','0'),(2,'Ruiz','Urteaga','Ana Cecilia','1984-06-23','Av. Flora Tristan 2450 - La Molina ','','F','0'),(3,'Medina','Chara','Yaddif','1979-10-07','Av. Alfonso Ugarte 1034 - Lima','','M','0'),(4,'Paz','Calagua','Luisr Anibal','1971-04-06','Av. Arequipa 4021 - Miraflores','','M','0'),(5,'Alva','Zavaleta','Carmen Delia','1976-01-11','Av. Arenales 2050 - San Isidro','','F','0'),(6,'Calderón 👋','Jimenez','Jose Luis','1976-01-11','Av. Los girasoles 2050 - Los Olivos','','F','0'),(7,'Quispe','Vasquez','Igor','1990-12-04','Av. Brasil 673 Dpto. 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(8,'Lazarte ','Tone','Fernando Leonel','1991-09-28','Av. Brasil 673 Dpto 1202 Torre A','Frente al hospital del niñoo.','M','0'),(9,'Perez ','Lima','Marisol','1994-06-29','Arequipa','Al lado de un parque.','F','0'),(10,'Torres','Bardarles','Miguel','1996-10-10','Su casa','Referencia','M','0'),(11,'Quispe','VÃ¡squez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(15,'Quispe','Vásquez','Vásquez','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(19,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(23,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(24,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(25,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(26,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(27,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(28,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(29,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(30,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(31,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(32,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(33,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','F','0'),(34,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','F','0'),(35,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(36,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(37,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(38,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(39,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(40,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(41,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(42,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(43,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(44,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(45,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(46,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(47,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(48,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','0'),(49,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(50,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(51,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(52,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(53,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(54,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(55,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(56,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(57,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(58,'Torres','Andrade','Juan Julio','1981-03-15','Av. Salaverry 1870 - San Isidro','Referencia 1','M','1'),(59,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(60,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(61,'Quispe','Vásquez','Igor Alexander','2024-04-20','Av. Brasil 673 Dpto 1202 Torre A','Al lado del grifo Petroamérica','M','1'),(62,'Quispe','Vasquez','Luis Miguel','1992-10-30','Chepen','Chepen 2','M','1');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'webapp'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_create_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_alumno`(
	IN p_appaterno VARCHAR(50),
	IN p_apmaterno VARCHAR(50),
	IN p_nombres VARCHAR(50),
	IN p_nacimiento DATE,
	IN p_direccion VARCHAR(200),
	IN p_referencia VARCHAR(200),
	IN p_genero VARCHAR(1),
	IN p_estado VARCHAR(1)
)
BEGIN
	INSERT INTO alumno(	
   		appaterno, 		apmaterno, 		nombres, 	nacimiento,
   		direccion, referencia, genero, estado
   ) VALUES (
   		p_appaterno, 	p_apmaterno,	p_nombres, 	p_nacimiento,
   		p_direccion, 	p_referencia, 	p_genero, 	p_estado
   );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_delete_alumnos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_alumnos`(
	IN p_val VARCHAR(255)
)
BEGIN
	DECLARE rowCount INT;
	
	SET @valSQL = CONCAT('UPDATE alumno SET estado = 0 WHERE idalumno IN', CONCAT('(', p_val, ')'));
   	PREPARE stmt FROM @valSQL;
   	EXECUTE stmt;
   	-- DEALLOCATE PREPARE stmt;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_get_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_alumno`(
	IN p_idalumno INT
)
BEGIN
	SELECT    	
		z.idalumno, 
		z.appaterno, 
		z.apmaterno, 
		z.nombres,
		z.nacimiento, 
		z.direccion, 
		z.referencia,
		z.genero, 
		z.estado
	FROM alumno z
	WHERE z.idalumno = p_idalumno
	AND z.estado <> 0;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_get_alumnos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_alumnos`()
BEGIN
    SELECT    	
		z.idalumno, 
		z.appaterno, 
		z.apmaterno, 
		z.nombres,
		z.nacimiento, 
		z.direccion, 
		z.referencia,
		z.genero, 
		z.estado
	FROM alumno z
	WHERE z.estado = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_alumno`(
	IN p_idalumno INT,
	IN p_appaterno VARCHAR(50),
	IN p_apmaterno VARCHAR(50),
	IN p_nombres VARCHAR(50),
	IN p_nacimiento DATE,
	IN p_direccion VARCHAR(200),
	IN p_referencia VARCHAR(200),
	IN p_genero VARCHAR(1)	
)
BEGIN
   UPDATE alumno SET 
   		appaterno = p_appaterno, 
   		apmaterno = p_apmaterno, 
   		nombres = p_nombres, 
   		nacimiento = p_nacimiento, 
   		direccion = p_direccion, 
   		referencia = p_referencia, 
   		genero = p_genero   		
WHERE idalumno = p_idalumno;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-24 20:09:28
