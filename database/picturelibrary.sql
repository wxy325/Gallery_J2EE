-- MySQL dump 10.13  Distrib 5.1.62, for Win64 (unknown)
--
-- Host: localhost    Database: picturelibrary
-- ------------------------------------------------------
-- Server version	5.1.62-community

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
-- Table structure for table `artistmodel`
--

DROP TABLE IF EXISTS `artistmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artistmodel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aliasId` int(10) unsigned DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `creatorId` int(10) unsigned DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123460 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistmodel`
--

LOCK TABLES `artistmodel` WRITE;
/*!40000 ALTER TABLE `artistmodel` DISABLE KEYS */;
INSERT INTO `artistmodel` VALUES (1234,NULL,'达芬奇',NULL,NULL,NULL),(11111,NULL,NULL,NULL,NULL,NULL),(12345,NULL,'毕加索',NULL,NULL,NULL),(123456,NULL,'梵高',NULL,NULL,NULL),(123457,NULL,NULL,NULL,NULL,NULL),(123459,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `artistmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `childids`
--

DROP TABLE IF EXISTS `childids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `childids` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `childId` int(11) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `childids`
--

LOCK TABLES `childids` WRITE;
/*!40000 ALTER TABLE `childids` DISABLE KEYS */;
/*!40000 ALTER TABLE `childids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentsids`
--

DROP TABLE IF EXISTS `commentsids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentsids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerId` int(11) DEFAULT NULL,
  `comment` text,
  `date` datetime DEFAULT NULL,
  `pictureId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentsids`
--

LOCK TABLES `commentsids` WRITE;
/*!40000 ALTER TABLE `commentsids` DISABLE KEYS */;
INSERT INTO `commentsids` VALUES (121,421,'hahaha!!!',NULL,NULL);
/*!40000 ALTER TABLE `commentsids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptionids`
--

DROP TABLE IF EXISTS `descriptionids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descriptionids` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `ownerId` int(10) unsigned DEFAULT NULL,
  `pictureId` int(10) unsigned DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptionids`
--

LOCK TABLES `descriptionids` WRITE;
/*!40000 ALTER TABLE `descriptionids` DISABLE KEYS */;
INSERT INTO `descriptionids` VALUES (1,'a',456,123,'1992-05-10 20:50:30'),(3,'c',456,123,'1990-01-01 01:19:20'),(4,'!!!',NULL,NULL,NULL),(5,'erfewhrfjef',NULL,NULL,NULL),(6,NULL,NULL,1341,NULL);
/*!40000 ALTER TABLE `descriptionids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poolids`
--

DROP TABLE IF EXISTS `poolids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poolids` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerId` int(11) DEFAULT NULL,
  `poolId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poolids`
--

LOCK TABLES `poolids` WRITE;
/*!40000 ALTER TABLE `poolids` DISABLE KEYS */;
/*!40000 ALTER TABLE `poolids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poolmodel`
--

DROP TABLE IF EXISTS `poolmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poolmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `visible` int(10) unsigned DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `postIds` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `postIds` (`postIds`),
  CONSTRAINT `postIds` FOREIGN KEY (`postIds`) REFERENCES `postids` (`FK`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poolmodel`
--

LOCK TABLES `poolmodel` WRITE;
/*!40000 ALTER TABLE `poolmodel` DISABLE KEYS */;
INSERT INTO `poolmodel` VALUES (1,'a',NULL,NULL,123,NULL,NULL),(2,'b',NULL,NULL,123,NULL,NULL),(3,'c',NULL,NULL,1234,NULL,NULL),(4,'d',NULL,NULL,12345,NULL,NULL),(5,'e',NULL,NULL,123,NULL,NULL);
/*!40000 ALTER TABLE `poolmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postids`
--

DROP TABLE IF EXISTS `postids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postids` (
  `FK` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) DEFAULT NULL,
  `poolid` int(11) DEFAULT NULL,
  PRIMARY KEY (`FK`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postids`
--

LOCK TABLES `postids` WRITE;
/*!40000 ALTER TABLE `postids` DISABLE KEYS */;
INSERT INTO `postids` VALUES (1,123,111),(2,1234,111),(3,4343,111),(4,123,112),(5,789,901);
/*!40000 ALTER TABLE `postids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postmodel`
--

DROP TABLE IF EXISTS `postmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `md5` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `artistId` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `visited` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121346 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postmodel`
--

LOCK TABLES `postmodel` WRITE;
/*!40000 ALTER TABLE `postmodel` DISABLE KEYS */;
INSERT INTO `postmodel` VALUES (123,'a',NULL,NULL,NULL,NULL,111,'1983-05-10 00:00:00',NULL,NULL,1,2,NULL,'aaa','aasdf'),(1234,'b',NULL,NULL,NULL,NULL,111,'1992-05-19 00:00:00',NULL,NULL,4,1,NULL,'bbb','asdsds'),(3242,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'eee','sdassd'),(3453,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fff','xcv'),(4343,'d',NULL,NULL,NULL,NULL,111,'1991-05-10 00:00:00',NULL,NULL,2,4,NULL,'ccc','sdf'),(4564,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ggg','df'),(121345,'c',NULL,NULL,NULL,NULL,111,'1990-03-10 00:00:00',NULL,NULL,NULL,0,NULL,'ddd','asda');
/*!40000 ALTER TABLE `postmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remarkids`
--

DROP TABLE IF EXISTS `remarkids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remarkids` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` int(10) unsigned DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `pictureId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remarkids`
--

LOCK TABLES `remarkids` WRITE;
/*!40000 ALTER TABLE `remarkids` DISABLE KEYS */;
INSERT INTO `remarkids` VALUES (1,10,123,NULL,1231),(2,11,123,NULL,2124),(3,12,1234,NULL,123),(4,13,4543,NULL,123123),(5,14,NULL,NULL,123),(7,NULL,12112,NULL,NULL);
/*!40000 ALTER TABLE `remarkids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagids`
--

DROP TABLE IF EXISTS `tagids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tagids` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `tagid` int(11) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagids`
--

LOCK TABLES `tagids` WRITE;
/*!40000 ALTER TABLE `tagids` DISABLE KEYS */;
INSERT INTO `tagids` VALUES (2,3,1234),(3,3,4343),(4,4,123),(5,555,666),(6,12,121),(8,3,3242);
/*!40000 ALTER TABLE `tagids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagmodel`
--

DROP TABLE IF EXISTS `tagmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tagmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `createId` int(11) DEFAULT NULL,
  `creatAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `ambiguous` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagmodel`
--

LOCK TABLES `tagmodel` WRITE;
/*!40000 ALTER TABLE `tagmodel` DISABLE KEYS */;
INSERT INTO `tagmodel` VALUES (1,'wwcy',NULL,NULL,NULL,NULL,NULL,NULL),(2,'w',NULL,NULL,NULL,NULL,NULL,NULL),(3,'wwcy3',NULL,NULL,NULL,NULL,NULL,NULL),(4,'wwcy4',NULL,NULL,NULL,NULL,NULL,NULL),(5,'HA',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tagmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermodel`
--

DROP TABLE IF EXISTS `usermodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `joinedAt` datetime DEFAULT NULL,
  `lastLoginAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11526669 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermodel`
--

LOCK TABLES `usermodel` WRITE;
/*!40000 ALTER TABLE `usermodel` DISABLE KEYS */;
INSERT INTO `usermodel` VALUES (1,NULL,'yu','w1cy',NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL),(111,NULL,'王辰垚11',NULL,NULL,NULL,NULL),(1232,NULL,'hhhh',NULL,NULL,NULL,NULL),(6661,NULL,'王辰垚11WW111',NULL,NULL,NULL,NULL),(122232,NULL,'hhhh',NULL,NULL,NULL,NULL),(1152666,NULL,'妹子','hahah',NULL,NULL,NULL),(1152673,NULL,'王辰垚',NULL,NULL,NULL,NULL),(1152677,NULL,'小宁',NULL,NULL,NULL,NULL),(1162783,NULL,'少侠',NULL,NULL,NULL,NULL),(4213434,NULL,NULL,NULL,NULL,NULL,NULL),(11526266,NULL,NULL,NULL,NULL,NULL,NULL),(11526666,NULL,'王辰垚11WW111',NULL,NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),(11526667,NULL,'hhhh',NULL,NULL,NULL,NULL),(11526668,NULL,'yu',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usermodel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-18  0:34:17
