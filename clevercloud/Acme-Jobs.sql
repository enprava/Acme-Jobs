-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: acme-jobs
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2a5vcjo3stlfcwadosjfq49l1` (`user_account_id`),
  CONSTRAINT `FK_2a5vcjo3stlfcwadosjfq49l1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (4,0,3);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXnhikaa2dj3la6o2o7e9vo01y0` (`moment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (180,0,'2019-10-03 08:35:00.000000',NULL,'This is a description','Sample announcement 01'),(181,0,'2019-06-03 08:35:00.000000','https://twitter.com/','This is a description 2','Sample announcement 02'),(182,0,'2019-11-03 09:35:00.000000',NULL,'This is a description 3','Sample announcement 03');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anonymous`
--

DROP TABLE IF EXISTS `anonymous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anonymous` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6lnbc6fo3om54vugoh8icg78m` (`user_account_id`),
  CONSTRAINT `FK_6lnbc6fo3om54vugoh8icg78m` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anonymous`
--

LOCK TABLES `anonymous` WRITE;
/*!40000 ALTER TABLE `anonymous` DISABLE KEYS */;
INSERT INTO `anonymous` VALUES (2,0,1);
/*!40000 ALTER TABLE `anonymous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `track_id` varchar(255) DEFAULT NULL,
  `application_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_efdfs98q7pj2ux1blpijk6wv1` (`application_id`),
  CONSTRAINT `FKqiviwk3b1rfidhy9cajsblq37` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (229,0,'aaaaa','aaaa123.,.','',228),(231,0,'be','a1.123456788','http://acme.com',230),(233,0,'x','','http://acme.com',232);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `creation_moment` datetime(6) DEFAULT NULL,
  `justification` varchar(255) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `statement` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoa6p4s2oyy7tf80xwc4r04vh6` (`job_id`),
  KEY `FKmbjdoxi3o93agxosoate4sxbt` (`worker_id`),
  CONSTRAINT `FKmbjdoxi3o93agxosoate4sxbt` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FKoa6p4s2oyy7tf80xwc4r04vh6` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (213,0,'2019-01-24 10:35:00.000000','','qualification4','title1','skill1, skill3','Lorem','rejected',203,208),(214,0,'2019-09-24 08:00:00.000000','','qualification1, qualification2','title2','skill2','Lorem','pending',203,208),(215,0,'2019-10-24 08:00:00.000000','','qualification1','title3','skill1','Lorem','pending',205,208),(216,0,'2019-04-04 10:05:00.000000','','qualification3, qualification4','title4','skill4','Lorem','accepted',204,211),(217,0,'2019-09-11 07:30:00.000000',NULL,'qualification3','title5','skill3, skill4','Lorem','accepted',205,211),(227,0,'2020-01-07 13:01:36.090000',NULL,'aaa','EEEE-JJJJ:WWWM','aaa','aaa','pending',223,208),(228,0,'2020-01-07 13:05:37.837000',NULL,'probando','EEEE-JJJJ:WGGG','probando','probando','pending',223,208),(230,0,'2020-01-07 13:08:57.798000',NULL,'g','EEEE-JJJJ:WGGG','g','g','pending',223,208),(232,0,'2020-01-07 13:09:59.855000',NULL,'x','EEEE-JJJJ:WGXX','x','x','pending',223,208);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_record`
--

DROP TABLE IF EXISTS `audit_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `auditor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdcrrgv6rkfw2ruvdja56un4ji` (`auditor_id`),
  CONSTRAINT `FKdcrrgv6rkfw2ruvdja56un4ji` FOREIGN KEY (`auditor_id`) REFERENCES `auditor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_record`
--

LOCK TABLES `audit_record` WRITE;
/*!40000 ALTER TABLE `audit_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditor`
--

DROP TABLE IF EXISTS `auditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `firm` varchar(255) DEFAULT NULL,
  `responsabilty_statement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_clqcq9lyspxdxcp6o4f3vkelj` (`user_account_id`),
  CONSTRAINT `FK_clqcq9lyspxdxcp6o4f3vkelj` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditor`
--

LOCK TABLES `auditor` WRITE;
/*!40000 ALTER TABLE `auditor` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated`
--

DROP TABLE IF EXISTS `authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authenticated` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h52w0f3wjoi68b63wv9vwon57` (`user_account_id`),
  CONSTRAINT `FK_h52w0f3wjoi68b63wv9vwon57` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated`
--

LOCK TABLES `authenticated` WRITE;
/*!40000 ALTER TABLE `authenticated` DISABLE KEYS */;
INSERT INTO `authenticated` VALUES (5,0,3),(189,0,186),(190,0,187),(191,0,188),(199,0,197),(202,0,200),(209,0,207),(212,0,210);
/*!40000 ALTER TABLE `authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `goal_bronze` varchar(255) DEFAULT NULL,
  `goal_gold` varchar(255) DEFAULT NULL,
  `goal_silver` varchar(255) DEFAULT NULL,
  `reward_bronze_amount` double DEFAULT NULL,
  `reward_bronze_currency` varchar(255) DEFAULT NULL,
  `reward_gold_amount` double DEFAULT NULL,
  `reward_gold_currency` varchar(255) DEFAULT NULL,
  `reward_silver_amount` double DEFAULT NULL,
  `reward_silver_currency` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (176,0,'2020-10-10 17:10:00.000000','this is your first challenge','goal B','THE goal','goal S',30,'EUR',50,'EUR',40,'EUR','your first challenge'),(177,0,'2019-12-11 16:15:00.000000','this is your second challenge','goal B','THE goal','goal S',30,'EUR',50,'EUR',40,'EUR','your second challenge'),(178,0,'2100-12-10 19:00:00.000000','this is your last challenge','goal B','THE goal','goal S',30,'EUR',50,'EUR',40,'EUR','your third and last challenge :P');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challengedos`
--

DROP TABLE IF EXISTS `challengedos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challengedos` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jtf410clbn7om36lcis62i7sl` (`job_id`),
  CONSTRAINT `FK2rky893jpnvp9604ka1kqeiej` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challengedos`
--

LOCK TABLES `challengedos` WRITE;
/*!40000 ALTER TABLE `challengedos` DISABLE KEYS */;
/*!40000 ALTER TABLE `challengedos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_record`
--

DROP TABLE IF EXISTS `company_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `ceoname` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `incorporated` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `web` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_record`
--

LOCK TABLES `company_record` WRITE;
/*!40000 ALTER TABLE `company_record` DISABLE KEYS */;
INSERT INTO `company_record` VALUES (185,0,'DefaultCeoname01','DefaultDescription01','DefaultEmail01@DefaultDomain.com',_binary '','DefaultName01','664645707','DefaultSector01',3,'http://DefaultDomain01.com');
/*!40000 ALTER TABLE `company_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumer`
--

DROP TABLE IF EXISTS `consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6cyha9f1wpj0dpbxrrjddrqed` (`user_account_id`),
  CONSTRAINT `FK_6cyha9f1wpj0dpbxrrjddrqed` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumer`
--

LOCK TABLES `consumer` WRITE;
/*!40000 ALTER TABLE `consumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptor`
--

DROP TABLE IF EXISTS `descriptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptor`
--

LOCK TABLES `descriptor` WRITE;
/*!40000 ALTER TABLE `descriptor` DISABLE KEYS */;
/*!40000 ALTER TABLE `descriptor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptor_duty`
--

DROP TABLE IF EXISTS `descriptor_duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptor_duty` (
  `descriptor_id` int(11) NOT NULL,
  `duties_id` int(11) NOT NULL,
  UNIQUE KEY `UK_kvr5rclgwa51d625rmx13ke96` (`duties_id`),
  KEY `FKqitedkrksd2w8qyp1fp5eao9f` (`descriptor_id`),
  CONSTRAINT `FK57eqqlhihwvd53ykpmsiqlx2p` FOREIGN KEY (`duties_id`) REFERENCES `duty` (`id`),
  CONSTRAINT `FKqitedkrksd2w8qyp1fp5eao9f` FOREIGN KEY (`descriptor_id`) REFERENCES `descriptor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptor_duty`
--

LOCK TABLES `descriptor_duty` WRITE;
/*!40000 ALTER TABLE `descriptor_duty` DISABLE KEYS */;
/*!40000 ALTER TABLE `descriptor_duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duboa`
--

DROP TABLE IF EXISTS `duboa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duboa` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `track_id` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_exi92qc35yhscaxi5jpbrahr9` (`job_id`),
  CONSTRAINT `FKem4wvjgce63ps4q3sycg0jinx` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duboa`
--

LOCK TABLES `duboa` WRITE;
/*!40000 ALTER TABLE `duboa` DISABLE KEYS */;
INSERT INTO `duboa` VALUES (224,0,'Probando','http://acme.com',223),(226,0,'sdddddddddddd','http://acme.com',225);
/*!40000 ALTER TABLE `duboa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duty`
--

DROP TABLE IF EXISTS `duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duty` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXis5k42gjhev7mhqajhcxlw4dv` (`percentage`),
  KEY `FKs2uoxh4i5ya8ptyefae60iao1` (`job_id`),
  CONSTRAINT `FKs2uoxh4i5ya8ptyefae60iao1` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duty`
--

LOCK TABLES `duty` WRITE;
/*!40000 ALTER TABLE `duty` DISABLE KEYS */;
INSERT INTO `duty` VALUES (218,0,'Furulafurula',30,'Duty1',203),(219,0,'Esto es parte del trabajo',25,'Duty2',203),(220,0,'Esto es del trabajo 2',100,'Duty3',204),(221,0,'Esto es del trabajo 3',100,'Duty4',205),(222,0,'Esto es del trabajo 4',100,'Duty5',206);
/*!40000 ALTER TABLE `duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_na4dfobmeuxkwf6p75abmb2tr` (`user_account_id`),
  CONSTRAINT `FK_na4dfobmeuxkwf6p75abmb2tr` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (198,0,197,'Employer 1, Inc','Sector 1'),(201,0,200,'Employer 2, Inc','Sector 2');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (234);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investor_record`
--

DROP TABLE IF EXISTS `investor_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investor_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `investing_statement` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stars` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investor_record`
--

LOCK TABLES `investor_record` WRITE;
/*!40000 ALTER TABLE `investor_record` DISABLE KEYS */;
INSERT INTO `investor_record` VALUES (183,0,'In process','investorRecord01','Science',NULL),(184,0,'Lo siento, no se que hay que poner aquí','investorRecord02','Services',5);
/*!40000 ALTER TABLE `investor_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `final_mode` bit(1) NOT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `salary_amount` double DEFAULT NULL,
  `salary_currency` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `employer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7jmfdvs0b0jx7i33qxgv22h7b` (`reference`),
  KEY `IDXrr7tnj8h1bfv46pnsq6lwvxqd` (`deadline`,`final_mode`),
  KEY `FK3rxjf8uh6fh2u990pe8i2at0e` (`employer_id`),
  CONSTRAINT `FK3rxjf8uh6fh2u990pe8i2at0e` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (203,0,'2030-12-11 22:59:00.000000','Lorem ipsum sit dolor amet',_binary '','http://www.example.com','EMP1-JOB1',15000.98,'€','Title 1',198),(204,0,'2030-12-11 22:59:00.000000','Lorem ipsum sit dolor amet',_binary '','http://www.example.com','EMP1-JOB2',20000,'€','Title 2',201),(205,0,'2040-12-11 22:59:00.000000','Lorem ipsum sit dolor amet',_binary '','http://www.example.com','EMP2-JOB3',20000,'€','Title 3',198),(206,0,'2037-10-09 20:59:00.000000','Lorem ipsum sit dolor amet',_binary '\0','http://www.example.com','EMP1-JOB4',10000,'€','Title 4',198),(223,1,'2025-12-10 11:03:00.000000','esto es una prueba',_binary '','http://acme.com','EMP3-JOB8',123123.11,'EUR','Prueba',198),(225,0,'2025-12-10 11:12:00.000000','sdddddddddd',_binary '\0','http://acme.com','EMP3-JOB7',123123.12,'EUR','no',198);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `martinez_bulletin`
--

DROP TABLE IF EXISTS `martinez_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `martinez_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `nota` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `martinez_bulletin`
--

LOCK TABLES `martinez_bulletin` WRITE;
/*!40000 ALTER TABLE `martinez_bulletin` DISABLE KEYS */;
INSERT INTO `martinez_bulletin` VALUES (14,0,'Jose Rodríguez','I like this site','2019-08-06 22:00:00.000000','10'),(15,0,'Pepe Sánchez','don\'t quite like the looks of the site','2019-08-25 22:00:00.000000','4'),(16,0,'SadGuy526','it\'s just OK','2018-11-25 23:00:00.000000','6');
/*!40000 ALTER TABLE `martinez_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message_thread_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn5adlx3oqjna7aupm8gwg3fuj` (`message_thread_id`),
  CONSTRAINT `FKn5adlx3oqjna7aupm8gwg3fuj` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (194,0,'Prueba numero 1','2019-06-04 08:45:00.000000','software,analista','Mensaje1',192),(195,0,'prueba numero 2','2019-06-05 08:45:00.000000','software,analista','Mensaje2',192),(196,0,'Prueba numero 3','2019-06-06 08:45:00.000000',NULL,'Mensaje3',193);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread`
--

DROP TABLE IF EXISTS `message_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `users` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread`
--

LOCK TABLES `message_thread` WRITE;
/*!40000 ALTER TABLE `message_thread` DISABLE KEYS */;
INSERT INTO `message_thread` VALUES (192,0,'2019-06-03 08:35:00.000000','Hilo1','a'),(193,0,'2019-06-03 11:35:00.000000','Hilo2','b');
/*!40000 ALTER TABLE `message_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_authenticated`
--

DROP TABLE IF EXISTS `message_thread_authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_authenticated` (
  `message_thread_id` int(11) NOT NULL,
  `authenticated_id` int(11) NOT NULL,
  KEY `FK2i865560ull83xb6h0gy6mhl1` (`authenticated_id`),
  KEY `FKjb0tx79q4dpibs3mnkp6wfqvf` (`message_thread_id`),
  CONSTRAINT `FK2i865560ull83xb6h0gy6mhl1` FOREIGN KEY (`authenticated_id`) REFERENCES `authenticated` (`id`),
  CONSTRAINT `FKjb0tx79q4dpibs3mnkp6wfqvf` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_authenticated`
--

LOCK TABLES `message_thread_authenticated` WRITE;
/*!40000 ALTER TABLE `message_thread_authenticated` DISABLE KEYS */;
INSERT INTO `message_thread_authenticated` VALUES (27,24),(28,25),(28,24);
/*!40000 ALTER TABLE `message_thread_authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_user_account`
--

DROP TABLE IF EXISTS `message_thread_user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_user_account` (
  `message_thread_id` int(11) NOT NULL,
  `useraccount_id` int(11) NOT NULL,
  KEY `FKcsl6erkfjmaaiqw9niql8tday` (`useraccount_id`),
  KEY `FKtchis3o5qij98x87mty6hdk4d` (`message_thread_id`),
  CONSTRAINT `FKcsl6erkfjmaaiqw9niql8tday` FOREIGN KEY (`useraccount_id`) REFERENCES `user_account` (`id`),
  CONSTRAINT `FKtchis3o5qij98x87mty6hdk4d` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_user_account`
--

LOCK TABLES `message_thread_user_account` WRITE;
/*!40000 ALTER TABLE `message_thread_user_account` DISABLE KEYS */;
INSERT INTO `message_thread_user_account` VALUES (192,186),(193,186),(193,187);
/*!40000 ALTER TABLE `message_thread_user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `maxmoney_amount` double DEFAULT NULL,
  `maxmoney_currency` varchar(255) DEFAULT NULL,
  `minmoney_amount` double DEFAULT NULL,
  `minmoney_currency` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iex7e8fs0fh89yxpcnm1orjkm` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (174,0,'2040-07-11 08:35:00.000000',2000,'€',1000,'€','2019-06-11 08:34:00.000000','Description of offer 01','OERPU-98456','Sample Offer 01'),(175,0,'2041-07-11 08:35:00.000000',2400,'€',1000,'€','2019-06-12 08:34:00.000000','Description of offer 02','OEREU-94865','Sample Offer 02');
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parameter` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `spamthreshold` double DEFAULT NULL,
  `spamwords` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (179,0,10,'sex, hardcore, viagra, cialis, nigeria, you`ve won, million dollar');
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penuela_bulletin`
--

DROP TABLE IF EXISTS `penuela_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `penuela_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `cons` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pros` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penuela_bulletin`
--

LOCK TABLES `penuela_bulletin` WRITE;
/*!40000 ALTER TABLE `penuela_bulletin` DISABLE KEYS */;
INSERT INTO `penuela_bulletin` VALUES (11,0,'I cant speak French','John Doe','I can speak Spanish'),(12,0,'Im lazy','John Dos','I learn so fast!'),(13,0,'Im flawless','John Tres','Im a good person');
/*!40000 ALTER TABLE `penuela_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prada_bulletin`
--

DROP TABLE IF EXISTS `prada_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prada_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prada_bulletin`
--

LOCK TABLES `prada_bulletin` WRITE;
/*!40000 ALTER TABLE `prada_bulletin` DISABLE KEYS */;
INSERT INTO `prada_bulletin` VALUES (20,0,'Richard Stallman','Canonical','Canonical does a nice work with GNU/Linux!!');
/*!40000 ALTER TABLE `prada_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` (`user_account_id`),
  CONSTRAINT `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `reward_amount` double DEFAULT NULL,
  `reward_currency` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9mxq3powq8tqctclj0fbi2nih` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (171,0,'2019-06-10 22:00:00.000000','2019-06-10 08:32:00.000000',1000,'EUR','This is the description of a request','RABCD-00000','Sample request 01'),(172,0,'2019-06-10 23:00:00.000000','2010-06-10 10:15:00.000000',200,'EUR','This is the description of another a request','RABCD-11111','Sample request 02'),(173,0,'2000-11-11 00:00:00.000000','2000-06-10 00:15:00.000000',500,'EUR','This is the description of an old request','RABCD-22222','Sample very old request 03');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rodriguez_bulletin`
--

DROP TABLE IF EXISTS `rodriguez_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rodriguez_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `complexity` int(11) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rodriguez_bulletin`
--

LOCK TABLES `rodriguez_bulletin` WRITE;
/*!40000 ALTER TABLE `rodriguez_bulletin` DISABLE KEYS */;
INSERT INTO `rodriguez_bulletin` VALUES (9,0,'Doors',4,'Cloud migration'),(10,0,'Pear',2,'Web page update');
/*!40000 ALTER TABLE `rodriguez_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shout`
--

DROP TABLE IF EXISTS `shout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shout` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shout`
--

LOCK TABLES `shout` WRITE;
/*!40000 ALTER TABLE `shout` DISABLE KEYS */;
INSERT INTO `shout` VALUES (6,0,'John Doe','2019-08-09 08:00:00.000000','Im Happy!'),(7,0,'Jane Doe','2019-08-09 13:50:00.000000','Im the master of my room!'),(8,0,'Foo Bar','2019-08-06 22:00:00.000000','Im sad!');
/*!40000 ALTER TABLE `shout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spam`
--

DROP TABLE IF EXISTS `spam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spam` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `spamthreshold` double DEFAULT NULL,
  `spamwords` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spam`
--

LOCK TABLES `spam` WRITE;
/*!40000 ALTER TABLE `spam` DISABLE KEYS */;
INSERT INTO `spam` VALUES (14,0,1,'sex, hard core, viagra, cialis, nigeria, you`ve won, million dollar');
/*!40000 ALTER TABLE `spam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toro_bulletin`
--

DROP TABLE IF EXISTS `toro_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toro_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `dislikes` varchar(255) DEFAULT NULL,
  `likes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toro_bulletin`
--

LOCK TABLES `toro_bulletin` WRITE;
/*!40000 ALTER TABLE `toro_bulletin` DISABLE KEYS */;
INSERT INTO `toro_bulletin` VALUES (17,0,'John Doe','No hacer nada, Discutir','Deportes, trabajar'),(18,0,'Jane Doe','Correr, Prisas','No hacer nada'),(19,0,'Daniel Cano','Conducir','Leer, Escribir');
/*!40000 ALTER TABLE `toro_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `identity_email` varchar(255) DEFAULT NULL,
  `identity_name` varchar(255) DEFAULT NULL,
  `identity_surname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_castjbvpeeus0r8lbpehiu0e4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,0,_binary '\0','john.doe@acme.com','John','Doe','$2a$05$AceihbMnV7c0DRQ5JsHe7ecL6h00n27bYBTx8pgzYsfDFFG2a8DDm','anonymous'),(3,0,_binary '','administrator@acme.com','Administrator','Acme.com','$2a$05$55ZXyoKzSi50YTvU/9m8sulXT.JO/szyJEKU1fbTFsAprZLHIwVVm','administrator'),(186,0,_binary '','jose1@us.es','jose','one','$2a$05$YVRfaHqR2pta156ellkj5.H1pOI18/mZU3P6S2QCSk.ZSOEsRLn9a','jose1'),(187,0,_binary '','jose2@us.es','jose','two','$2a$05$.vsZI/Zb12KsdEBozkQuVOQvlH9F7rEhfZrjCEwpYPakmKi03xtn2','jose2'),(188,0,_binary '','jose3@us.es','jose','three','$2a$05$P1fLC/bT7xG58gaaZa9ZJukjRP/jz/.Hglylerr4At/vDnEGVPlgy','jose3'),(197,0,_binary '','employer1@acme.com','Employer','One','$2a$05$FVHiA79UGz35qqVAzns1NO/LXbe0bSgVxyF9MQkdIX1GC1Sxxvifu','employer1'),(200,0,_binary '','employer2@acme.com','Employer2','One','$2a$05$AW4JVHNxKvgYPmb1U6c/leB3QdvzBn35LazMWN7VPbAbMaD1d3sxW','employer2'),(207,0,_binary '','worker1@acme.com','Worker','One','$2a$05$ZwQHMtVFSNDj0FdxtnZikeZFgf1bnsHnrj49k7yR8OEJYE363Fi3m','worker1'),(210,0,_binary '','worker2@acme.com','Worker','Two','$2a$05$KeKjoil2ljq767P5Lk1T5u6v0xHVe/G0p2d5TSRVTMTBywwptlzaS','worker2');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l5q1f33vs2drypmbdhpdgwfv3` (`user_account_id`),
  CONSTRAINT `FK_l5q1f33vs2drypmbdhpdgwfv3` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (208,0,207,'qualification1, qualification2','skill1, skill2'),(211,0,210,'qualification3, qualification4','skill3, skill4');
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xxxx1`
--

DROP TABLE IF EXISTS `xxxx1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xxxx1` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `application_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK97paiyyk5h2isf06f7whffyiq` (`application_id`),
  KEY `FKivqoqgqubr8hn5quyvcmi324` (`job_id`),
  CONSTRAINT `FK97paiyyk5h2isf06f7whffyiq` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
  CONSTRAINT `FKivqoqgqubr8hn5quyvcmi324` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xxxx1`
--

LOCK TABLES `xxxx1` WRITE;
/*!40000 ALTER TABLE `xxxx1` DISABLE KEYS */;
/*!40000 ALTER TABLE `xxxx1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-07 14:11:13
