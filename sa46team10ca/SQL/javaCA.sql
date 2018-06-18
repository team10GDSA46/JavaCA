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
-- Drop and create sa46team10CA database
--
DROP database sa46team10CA;

CREATE database sa46team10CA;

USE sa46team10CA;

--
-- Table structure for table `booking`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `facilityid` int(11) DEFAULT NULL,
  `timeslotid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `bookingstatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookingid`),
  KEY `userid` (`userid`),
  KEY `facilityid` (`facilityid`),
  KEY `timeslotid` (`timeslotid`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`facilityid`) REFERENCES `facility` (`facilityid`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`timeslotid`) REFERENCES `timeslots` (`timeslotid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,6,5,4,'2018-06-06','Completed'),(2,7,6,4,'2018-06-06','Completed'),(3,8,7,5,'2018-07-07','Cancelled');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facility` (
  `facilityid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`facilityid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,'Hall1'),(2,'Hall2'),(3,'TennisCourt1'),(4,'TennisCourt2'),(5,'Gym'),(6,'BBQPit1'),(7,'BBQPit2'),(8,'BBQPit3'),(9,'BBQPit4'),(10,'BBQPit5');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenance`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `maintenance` (
  `maintenanceid` int(11) NOT NULL AUTO_INCREMENT,
  `facilityid` int(11) DEFAULT NULL,
  `timeslotid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`maintenanceid`),
  KEY `facilityid` (`facilityid`),
  KEY `timeslotid` (`timeslotid`),
  CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`facilityid`) REFERENCES `facility` (`facilityid`),
  CONSTRAINT `maintenance_ibfk_2` FOREIGN KEY (`timeslotid`) REFERENCES `timeslots` (`timeslotid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenance`
--

LOCK TABLES `maintenance` WRITE;
/*!40000 ALTER TABLE `maintenance` DISABLE KEYS */;
INSERT INTO `maintenance` VALUES (1,3,1,'2018-02-02'),(2,4,1,'2018-03-03'),(3,5,1,'2018-04-04');
/*!40000 ALTER TABLE `maintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslots`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `timeslots` (
  `timeslotid` int(11) NOT NULL AUTO_INCREMENT,
  `timeslot` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`timeslotid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslots`
--

LOCK TABLES `timeslots` WRITE;
/*!40000 ALTER TABLE `timeslots` DISABLE KEYS */;
INSERT INTO `timeslots` VALUES (1,'0900-1000'),(2,'1000-1100'),(3,'1100-1200'),(4,'1200-1300'),(5,'1300-1400'),(6,'1400-1500'),(7,'1500-1600'),(8,'1600-1700'),(9,'1700-1800'),(10,'1800-1900'),(11,'1900-2000'),(12,'2000-2100');
/*!40000 ALTER TABLE `timeslots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `nric` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Wingyi','S12345678A','admin','wingyi','password','1993-05-04','98765436','NUS ISS','wingyi@email.com'),(2,'Liyun','S12345678B','admin','liyun','password','1991-04-13','42314733','NUS ISS','liyun@email.com'),(3,'Rohit','S12345678C','admin','rohit','password','1993-12-12','32147092','NUS ISS','rohit@email.com'),(4,'James','S12345678D','admin','james','password','1983-02-12','43274320','NUS ISS','james@email.com'),(5,'HockPeng','S12345678E','admin','hockpeng','password','1975-04-15','42375374','NUS ISS','hockpeng@email.com'),(6,'Dilbert','S98765432A','member','dilbert','memberpass','1950-01-29','43274392','Comic Land','dilbert@email.com'),(7,'Tony Stark','S98765432B','member','tonystark','memberpass','1980-08-16','21389298','Marvel CU','tonystark@email.com'),(8,'Romanoff','S98765432C','member','romanoff','memberpass','1981-10-18','23721492','Marvel CU','natasharomanoff@email.com'),(9,'T\'challa','S98765432D','member','tchalla','memberpass','1984-09-24','98767091','Wakanda','tchalla@email.com'),(10,'Jessica Jones','S98765432E','member','jessicanjones','memberpass','1982-06-07','56320527','Marvel','jessicaj@email.com'),(11,'Peter Parker','S98765432F','member','peterparker','memberpass','1995-02-24','38473234','Marvel CU','peterparker@email.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;