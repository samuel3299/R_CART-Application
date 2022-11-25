-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: cart
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `orders1`
--

DROP TABLE IF EXISTS `orders1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders1` (
  `SNO` int NOT NULL,
  `ProductId` int DEFAULT NULL,
  `UserId` varchar(225) DEFAULT NULL,
  `NameofProd` varchar(225) DEFAULT NULL,
  `Price` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`SNO`),
  KEY `ProductId` (`ProductId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `orders1_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `products` (`SNO`),
  CONSTRAINT `orders1_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `login` (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders1`
--

LOCK TABLES `orders1` WRITE;
/*!40000 ALTER TABLE `orders1` DISABLE KEYS */;
INSERT INTO `orders1` VALUES (1,4,'1','Jimson Weed','60,00,00'),(2,2,'1','Ducati','50,00,000'),(3,5,'1','Oppenheimer Blue Diamond','25,00,00,000'),(4,2,'1','Ducati','50,00,000'),(5,2,'1','Ducati','50,00,000'),(6,3,'am@gmail.com','The Great GatsBy - F.Scott','1,00,000'),(7,8,'am@gmail.com','The Hutton-Mdivani Necklace','21,00,00,000'),(8,9,'am@gmail.com','The Star of Asia','70,00,00,000'),(9,2,'am@gmail.com','Ducati','50,00,000'),(10,1,'Ksamuel32@gmail.com','Mercedes Benz','2,00,00,000'),(11,9,'Ksamuel32@gmail.com','The Star of Asia','70,00,00,000'),(12,1,'pal@gmail.com','Mercedes Benz','2,00,00,000'),(13,2,'1','Ducati','50,00,000'),(14,3,'1','The Great GatsBy - F.Scott','1,00,000'),(15,3,'1','The Great GatsBy - F.Scott','1,00,000'),(16,13,'vish','Ru Guanyao Brush Washer','37,00,00,000'),(17,9,'vish','The Star of Asia','70,00,00,000');
/*!40000 ALTER TABLE `orders1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 16:05:28
