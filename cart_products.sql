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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `SNO` int NOT NULL,
  `Nams` varchar(225) DEFAULT NULL,
  `Price` varchar(225) DEFAULT NULL,
  `Descr` varchar(1000) DEFAULT NULL,
  `ProductUser` varchar(225) NOT NULL,
  PRIMARY KEY (`SNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Mercedes Benz','2,00,00,000','One of World\'s Richest car with Good Facilities','1234@gmail.com'),(2,'Ducati','50,00,000','One of World\'s Richest bike with Good Facilities','2'),(3,'The Great GatsBy - F.Scott','1,00,000','One of World\'s Best selling book showing shock and Chaos of World War 1','abhi@gmail.com'),(4,'Jimson Weed','60,00,000','One of World\'s best Painting by Georgia O\'Keeffe','abhishak@gmail.com'),(5,'Oppenheimer Blue Diamond','25,00,00,000','One of World\'s Best Diamond Ring','Ksamuel@gmail.com'),(6,'Pool with two figures','80,00,000','One of World\'s best art by David Hockney','1234@gmail.com'),(7,'Rabbit',' 7,00,00,000','One of World\'s best Sculpture by Jeff Koons','2'),(8,'The Hutton-Mdivani Necklace','21,00,00,000','One of World\'s Priceless Necklace','2'),(9,'The Star of Asia','70,00,00,000','One of World\'s Ancien crown Jewel made with sapphire','2'),(10,'Napolean Diamond Necklace','40,00,00,000','One of World\'s Best Necklase with 234 Diamonds','abhi@gmail.com'),(11,'The Dresden Green','22,00,00,000','One of World\'s best 41 carats Necklase','abhishak@gmail.com'),(12,'Qing Dynasty Vase','44,00,00,000','One of World\'s Finest Antique','Ksamuel@gmail.com'),(13,'Ru Guanyao Brush Washer','37,00,00,000','One of World\'s Finest  and rare Antique','abhi@gmail.com'),(14,'Persian Rug','35,00,00,000','One of World\'s Finest Persian Carpet of Kerman Origin','Ksamuel@gmail.com'),(15,'Ming Vase','20,00,00,000','Vase from Ming Dynasty. Has History of 3000 years.','tony@gmail.com'),(16,'KingFisher Plane','25,00,00,000','Private Jet with Good features and High Class Integriors.','a'),(17,'CowBoy Pistol','20,00,000','Pistol Used by CowBoys int 18th Century.','a');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 16:05:30
