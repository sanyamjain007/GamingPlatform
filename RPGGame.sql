-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: rpggame
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enemy`
--

DROP TABLE IF EXISTS `enemy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `enemy` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `basehp` int(11) DEFAULT '80',
  `currenthp` int(11) DEFAULT '80',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enemy`
--

LOCK TABLES `enemy` WRITE;
/*!40000 ALTER TABLE `enemy` DISABLE KEYS */;
INSERT INTO `enemy` VALUES (1,'Thanos',100,100),(2,'Zombie',100,100),(3,'Assasin',100,100),(4,'Warrior',100,100);
/*!40000 ALTER TABLE `enemy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'Yoddha','This is a warrior fighting game.');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamestate`
--

DROP TABLE IF EXISTS `gamestate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gamestate` (
  `userid` varchar(45) DEFAULT NULL,
  `playerid` int(11) DEFAULT NULL,
  `playercurrenthp` int(11) DEFAULT NULL,
  `enemyid` int(11) DEFAULT NULL,
  `enemycurrenthp` int(11) DEFAULT NULL,
  `healthpotioncount` int(11) DEFAULT NULL,
  `playermaxhp` int(11) DEFAULT NULL,
  `issave` int(11) DEFAULT NULL,
  `gamesessionid` int(11) NOT NULL AUTO_INCREMENT,
  `damagecount` int(11) DEFAULT NULL,
  `currentrating` float DEFAULT NULL,
  PRIMARY KEY (`gamesessionid`),
  KEY `playerid_idx` (`playerid`),
  KEY `enemyid_idx` (`enemyid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `enemyid` FOREIGN KEY (`enemyid`) REFERENCES `enemy` (`id`),
  CONSTRAINT `playerid` FOREIGN KEY (`playerid`) REFERENCES `player` (`id`),
  CONSTRAINT `user` FOREIGN KEY (`userid`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamestate`
--

LOCK TABLES `gamestate` WRITE;
/*!40000 ALTER TABLE `gamestate` DISABLE KEYS */;
INSERT INTO `gamestate` VALUES ('s',1,119,1,29,3,110,1,1,2,2.46214),('s',1,157,2,94,2,100,0,2,1,2.40007),('c',1,29,3,65,2,100,0,3,4,2.3),('s',1,123,4,98,2,110,1,4,4,2.39976),('c',2,69,1,24,3,120,0,5,3,3.4),('s',2,57,2,61,1,100,0,6,8,2.59516),('sam',1,68,2,43,3,140,0,7,3,3.2),('sam',1,80,1,56,3,120,0,8,5,2.3),('c',1,46,4,21,3,100,0,9,6,1.4),('sam',1,105,4,25,3,110,1,10,3,2.83333),('c',2,76,2,44,3,120,0,11,4,2.3),('c',1,67,1,47,3,100,0,12,2,2.5),('chattu',1,76,3,59,2,100,0,13,3,2.6),('kk',1,160,2,100,3,100,1,14,6,2.02932),('kk',1,229,4,95,3,240,1,15,1,0.5),('kk',1,167,3,6,3,100,1,16,5,2.28691),('kk',1,226,1,97,3,240,0,17,1,0.3),('chattu',3,90,3,81,3,100,0,18,2,1.9),('s',4,23,NULL,0,2,120,0,19,17,2.38458),('sanyam',1,0,3,-6,4,140,0,20,12,1.6),('sanyam',1,0,1,43,4,160,0,21,10,4.7),('kk',4,100,1,100,3,100,1,22,0,0),('s',2,88,3,100,2,100,0,23,2,0),('s',2,69,NULL,0,2,110,0,24,8,2.4592),('s',3,84,1,78,3,100,0,26,1,2.59291),('s',2,79,1,80,3,100,0,27,1,2.53901),('ram',1,96,1,88,3,100,0,28,1,1.2),('ram',2,67,3,6,2,110,0,29,5,1.64),('ram',3,79,2,37,2,100,1,30,4,1.61833),('ram',1,77,3,71,3,100,1,31,1,1.93875),('ram',1,63,4,66,3,100,1,32,2,1.891),('s',1,117,3,79,2,100,0,33,4,2.5242),('s',1,53,NULL,0,3,130,0,35,9,2.57611),('s',1,89,NULL,0,3,110,0,36,6,2.56619),('s',2,21,NULL,0,1,110,0,37,10,2.49141);
/*!40000 ALTER TABLE `gamestate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `id` varchar(20) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('c','c123'),('chattu','chattu123'),('kk','kk123'),('neha','neha123'),('nikhil','nikhil123'),('rajesh','rajesh123'),('ram','ram123'),('rohit','rohit123'),('s','s123'),('sahu','sahu'),('sam','sam123'),('sanyam','jain123'),('sk','sk123'),('skj','skj123');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `basehp` int(11) DEFAULT '100',
  `currenthp` int(11) DEFAULT '100',
  `attackdamage` int(11) DEFAULT '50',
  `numhealthpotions` int(11) DEFAULT '3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'IronMan',100,100,50,3),(2,'Thor',100,100,50,3),(3,'Captain America',100,100,50,3),(4,'SpiderMan',100,100,50,3);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userstatistics`
--

DROP TABLE IF EXISTS `userstatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userstatistics` (
  `userid` varchar(30) NOT NULL,
  `experiencecount` int(11) DEFAULT NULL,
  `starrating` float DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userstatistics`
--

LOCK TABLES `userstatistics` WRITE;
/*!40000 ALTER TABLE `userstatistics` DISABLE KEYS */;
INSERT INTO `userstatistics` VALUES ('c',6,3.95833),('chattu',2,3.9875),('kk',37,2.02932),('ram',5,1.891),('s',32,2.38458),('sam',3,2.83333),('sanyam',3,2.77611);
/*!40000 ALTER TABLE `userstatistics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-06 20:27:00
