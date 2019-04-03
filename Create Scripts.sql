CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `library`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(45) NOT NULL,
  `setdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'ankon','2017-10-18 23:48:36'),(2,'kanon','2017-10-18 23:49:09'),(3,'james','2017-10-18 23:49:22'),(4,'robert','2017-10-21 20:41:32'),(5,'rowan','2017-10-22 02:08:48'),(6,'Shah Kabir','2017-10-22 21:50:21'),(7,'Faiz','2017-10-22 21:51:18'),(8,'Arthur','2017-10-22 22:15:14'),(9,'Nafiz','2017-10-23 00:20:03'),(10,'Faizal','2017-10-25 21:21:47'),(11,'Jordan','2017-10-26 20:56:00'),(12,'Jon Snow','2017-10-26 21:57:05');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_category`
--

DROP TABLE IF EXISTS `book_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `setdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_category`
--

LOCK TABLES `book_category` WRITE;
/*!40000 ALTER TABLE `book_category` DISABLE KEYS */;
INSERT INTO `book_category` VALUES (1,'Science','2017-10-19 01:41:13'),(2,'Physics','2017-10-19 01:41:35'),(3,'Mathmetics','2017-10-19 01:41:44'),(4,'Sociology','2017-10-19 01:41:52'),(5,'Novel','2017-10-19 01:42:03'),(6,'Poetry','2017-10-21 20:43:43'),(7,'History','2017-10-23 00:23:00'),(8,'Chemistry','2017-10-25 21:43:59'),(9,'Biology','2017-10-26 21:58:06');
/*!40000 ALTER TABLE `book_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `setdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ankon111','a12345','Shafiul Haque Ankon','2017-10-19 21:05:43'),(2,'ankon222','$2a$10$QKb53K0R9z6nHAAIajaJhe7FqYl17mMB/t/SHnwdb5VxiI6RsnU1.','Shariful Haque','2017-10-20 00:49:31'),(3,'ankon333','$2a$10$dCCbbYjoKiDTx6PLG85IQODnf1wAXVwa/3A9E.5.uRv9rGcM5Pgyy','Ankon','2017-10-20 14:00:27'),(6,'admin','$2a$10$PDk3Kt/V4pFZ/sU8JDINgOjiw0QvkFvPf47ldzKYWfx7fnQIKIBGa','Admin','2017-10-23 00:17:55'),(7,'admin5','$2a$10$xTVveGcK6pfGij951l0xnuiSckB3roPKRw1AYbsklt0pPU8cRmo1G','Ankon5','2017-10-24 21:49:57'),(8,'admin2','$2a$10$ojFb9xJT5Nf.420dic9KwO3KOFMN4hJj0uWUQUiizqHbUpNPmrmrq','Admin2','2017-10-26 21:56:34');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'library'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26 22:20:11


--
-- Table structure for table `book_details`
--

DROP TABLE IF EXISTS `book_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(45) NOT NULL,
  `category_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `SETDATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_book_details_category_id_idx` (`category_id`),
  KEY `fk_book_details_author_id_idx` (`author_id`),
  CONSTRAINT `fk_book_details_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_details_category_id` FOREIGN KEY (`category_id`) REFERENCES `book_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_details`
--

LOCK TABLES `book_details` WRITE;
/*!40000 ALTER TABLE `book_details` DISABLE KEYS */;
INSERT INTO `book_details` VALUES (1,'Science: Beginning of the era.',1,1,'2017-10-19 01:53:26'),(2,'Newton\'s Law',2,3,'2017-10-19 01:57:13'),(3,'Romeo & Juliet',5,2,'2017-10-19 01:58:09'),(4,'Social Problems',4,4,'2017-10-21 20:46:55'),(5,'Need Change',4,4,'2017-10-21 23:33:48'),(7,'Social Problems',4,2,'2017-10-22 02:27:46'),(8,'Social Problems and Solutions',4,2,'2017-10-23 00:27:19'),(9,'Checmisty Solutions',8,10,'2017-10-25 22:27:40'),(10,'Checmisty Theory',8,10,'2017-10-26 21:07:32');
/*!40000 ALTER TABLE `book_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_issue`
--

DROP TABLE IF EXISTS `book_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `issue_date` datetime NOT NULL,
  `due_date` datetime NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `issue_status` char(1) NOT NULL,
  `setdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_user_user_id_idx` (`user_id`),
  KEY `fk_book_details_book_id_idx` (`book_id`),
  CONSTRAINT `fk_book_details_book_id` FOREIGN KEY (`book_id`) REFERENCES `book_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_issue_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_issue`
--

LOCK TABLES `book_issue` WRITE;
/*!40000 ALTER TABLE `book_issue` DISABLE KEYS */;
INSERT INTO `book_issue` VALUES (1,1,2,'2017-10-19 06:00:00','2017-10-25 06:00:00',NULL,'B','2017-10-19 21:10:10'),(2,2,3,'2017-10-21 06:00:00','2017-10-27 06:00:00','2017-10-22 01:59:27','R','2017-10-22 00:07:47'),(5,2,1,'2017-10-22 02:43:58','2017-10-30 06:00:00','2017-10-22 02:46:32','R','2017-10-22 02:43:57'),(6,2,1,'2017-10-23 00:43:21','2017-10-30 06:00:00','2017-10-23 00:45:24','R','2017-10-23 00:43:21'),(7,2,1,'2017-10-25 23:27:48','2017-10-30 06:00:00','2017-10-25 23:28:25','R','2017-10-25 23:27:48'),(8,2,5,'2017-10-26 21:09:18','2017-10-30 06:00:00','2017-10-26 21:19:54','R','2017-10-26 21:09:18'),(9,2,1,'2017-10-26 22:05:15','2017-10-30 06:00:00','2017-10-26 22:17:21','R','2017-10-26 22:05:15'),(10,2,4,'2017-10-26 22:06:07','2017-10-30 06:00:00',NULL,'B','2017-10-26 22:06:06');
/*!40000 ALTER TABLE `book_issue` ENABLE KEYS */;
UNLOCK TABLES;