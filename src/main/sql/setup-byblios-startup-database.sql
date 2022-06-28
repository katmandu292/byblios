CREATE DATABASE  IF NOT EXISTS `jupiter_1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jupiter_1`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 185.171.187.101    Database: jupiter_1
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.41-MariaDB

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



DROP TABLE IF EXISTS `tbl_books`;
DROP TABLE IF EXISTS `tbl_collections`;
DROP TABLE IF EXISTS `tbl_authors`;
DROP TABLE IF EXISTS `tbl_editors`;
DROP TABLE IF EXISTS `tbl_information`;


--
-- Table structure for table `tbl_genres`
--
DROP TABLE IF EXISTS `tbl_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_genres` (
  `GENRE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificator unic al unui gen de roman',
  `GENRE_LABEL` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'denumirea consacrata a subgenului romanului literar',
  `GENRE_DESCR` varchar(2048) COLLATE utf8_unicode_ci DEFAULT 'TBD' COMMENT 'descriere scurta a unui subgen al romanului literar',
  PRIMARY KEY (`GENRE_ID`),
  UNIQUE KEY `GENRE_ID_IDX` (`GENRE_ID`),
  UNIQUE KEY `GENRE_LABEL_IDX` (`GENRE_LABEL`)
) ENGINE=InnoDB AUTO_INCREMENT=1489112 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='lista scurta a subgenurilor romanului literar';
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `tbl_editors`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_editors` (
  `EDITOR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificator unic al unei edituri',
  `EDITOR_NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'nume editura',
  `ADDRESS` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT 'adresa sediului editurii',
  `EDITOR_INFO` varchar(1024) COLLATE utf8_unicode_ci NOT NULL COMMENT 'scurta prezentare a unei edituri',
  PRIMARY KEY (`EDITOR_ID`),
  UNIQUE KEY `EDITOR_NAME_IDX` (`EDITOR_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=1495001 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='câteva edituri de carte';
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `tbl_authors`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_authors` (
  `PERS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Identificator unic al unui autor de carte',
  `BIRTH_YEAR` mediumint(9) NOT NULL DEFAULT '1900' COMMENT 'Anul nasterii autorului',
  `AUTH_NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'John Doe' COMMENT 'Numele de publicare al unui autor de carte',
  `AUTH_BIO` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'scurta prezentare a unui autor de carte',
  PRIMARY KEY (`PERS_ID`),
  UNIQUE KEY `PERS_ID_IDX` (`PERS_ID`),
  UNIQUE KEY `AUTH_NAME_IDX` (`AUTH_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=1817038 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='lista autorilor de literatura';
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `tbl_collections`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_collections` (
  `collection_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Collection identification number starts with 1323001',
  `collection_name` varchar(45) NOT NULL DEFAULT 'Antologia' COMMENT 'the name of a collection uniquely identifies that list of books',
  `collection_publ` int(11) NOT NULL DEFAULT '1491001' COMMENT 'Foreign key binding the collection to a particular publisher ID',
  `collection_year` int(11) DEFAULT '1900' COMMENT 'the publication year of the first book belonging to the collection',
  `collection_info` varchar(2048) NOT NULL DEFAULT 'TBD' COMMENT 'Short description of the things that make the targeted collection to be a literature asset',
  PRIMARY KEY (`collection_id`),
  UNIQUE KEY `LJKSDHJK` (`collection_id`),
  KEY `PUBLISHER_FK` (`collection_publ`),
  CONSTRAINT `PUBL_CNSTR` FOREIGN KEY (`collection_publ`) REFERENCES `tbl_editors` (`EDITOR_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1323006 DEFAULT CHARSET=utf8 COMMENT='a list of books usually published by the same editor, during several years, from different authors ';
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `tbl_books`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_books` (
  `VOLUME_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Identificator Unic Carte',
  `AUTHOR_ID` int(10) unsigned NOT NULL COMMENT 'numarul unic de identificare al autorului',
  `GENRE_ID` int(11) NOT NULL COMMENT 'identificator unic al genului in care se incadreaza volumul',
  `COLLECT_ID` int(10) unsigned NOT NULL DEFAULT '1323000',
  `LAUNCHED_BY` int(11) NOT NULL COMMENT 'identificatorul unic al editurii care a publicat cartea',
  `LAUNCH_YEAR` int(11) NOT NULL COMMENT 'Anul publicarii cartii',
  `ISBN` varchar(32) DEFAULT 'Not Available' COMMENT 'Codul ISBN sub care a fost publicata',
  `VOL_TITLE` varchar(64) DEFAULT 'MORTULDINTRASURAGOALA' COMMENT 'Titlul sub care a fost publicata cartea',
  `VOL_INFO` text NOT NULL COMMENT 'scurt comentariu introspectiv asupra cartii',
  PRIMARY KEY (`VOLUME_ID`),
  UNIQUE KEY `BOOK_ID_UNIQUE` (`VOLUME_ID`),
  KEY `AUTHOR_FKEY` (`AUTHOR_ID`),
  KEY `EDITOR_FKEY` (`LAUNCHED_BY`),
  KEY `GENRE_FKEY` (`GENRE_ID`),
  KEY `COLLECT_FKEY` (`COLLECT_ID`),
  CONSTRAINT `AUTHOR_FKEY` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `tbl_authors` (`PERS_ID`),
  CONSTRAINT `COLLECT_FKEY` FOREIGN KEY (`COLLECT_ID`) REFERENCES `tbl_collections` (`collection_id`),
  CONSTRAINT `EDITOR_FKEY` FOREIGN KEY (`LAUNCHED_BY`) REFERENCES `tbl_editors` (`EDITOR_ID`),
  CONSTRAINT `GENRE_FKEY` FOREIGN KEY (`GENRE_ID`) REFERENCES `tbl_genres` (`GENRE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1117043 DEFAULT CHARSET=utf8 COMMENT='Cartile/Volumele cu principalele atribute';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Loading data for table `tbl_genres`
--
LOCK TABLES `tbl_genres` WRITE;
/*!40000 ALTER TABLE `tbl_genres` DISABLE KEYS */;
INSERT INTO `tbl_genres` VALUES (1489102,'istoric','romanul istoric ...');
/*!40000 ALTER TABLE `tbl_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Loading data for table `tbl_editors`
--

LOCK TABLES `tbl_editors` WRITE;
/*!40000 ALTER TABLE `tbl_editors` DISABLE KEYS */;
INSERT INTO `tbl_editors` VALUES (1491001,'Litera','OP 53, CP 212, Sector 4, Bucuresti, România','Fondat&#259;');
/*!40000 ALTER TABLE `tbl_editors` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Loading data for table `tbl_authors`
--
LOCK TABLES `tbl_authors` WRITE;
/*!40000 ALTER TABLE `tbl_authors` DISABLE KEYS */;
INSERT INTO `tbl_authors` VALUES (1817000,1900,'Anonymous','&#206;nregistrare generic&#259; ');
/*!40000 ALTER TABLE `tbl_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Loading data for table `tbl_collections`
--
LOCK TABLES `tbl_collections` WRITE;
/*!40000 ALTER TABLE `tbl_collections` DISABLE KEYS */;
INSERT INTO `tbl_collections` VALUES (1323000,'NoName',1494999,2999,'Empty Field for filling out unknown collection situation'),
(1323001,'Delfinul',1491003,1970,'TBD 1234567890ABCD');
/*!40000 ALTER TABLE `tbl_collections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Loading data for table `tbl_books`
--
LOCK TABLES `tbl_books` WRITE;
/*!40000 ALTER TABLE `tbl_books` DISABLE KEYS */;
INSERT INTO `tbl_books` VALUES (1117001,1817001,1489104,1323000,1491009,2012,'978-606-600-900-3','A');
/*!40000 ALTER TABLE `tbl_books` ENABLE KEYS */
UNLOCK TABLES;


-- SELECT A.`VOL_TITLE`, B.`AUTH_NAME`,  C.`GENRE_LABEL`,
--  A.`COLLECT_ID`, D.`EDITOR_NAME`, A.`LAUNCH_YEAR`,
--  A.`ISBN`,   A.`VOLUME_ID`, A.`VOL_INFO`
--  A.`LAUNCHED_BY`
-- FROM `tbl_books` A
-- JOIN `tbl_authors` B
-- ON (A.`AUTHOR_ID` = B.`PERS_ID`)
-- JOIN `tbl_genres` C
-- ON (A.`GENRE_ID` = C.`GENRE_ID`)
-- JOIN `tbl_editors` D
-- ON (A.`LAUNCHED_BY` = D.`EDITOR_ID`)

--
-- Table structure for table `tbl_information`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_information` (
  `MESSG_ID` int(11) NOT NULL DEFAULT '1999' COMMENT 'unique identifier of the intial screen information messages',
  `MESSG_CONTENT` varchar(128) NOT NULL COMMENT 'technical details about the BYBLIOS application setup',
  PRIMARY KEY (`MESSG_ID`),
  UNIQUE KEY `MESSG_ID_UNIQUE` (`MESSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='the splash screen of BYBLIOS, using current configuration infos';
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Loading data for table `tbl_information`
--
LOCK TABLES `tbl_information` WRITE;
/*!40000 ALTER TABLE `tbl_information` DISABLE KEYS */;
INSERT INTO `tbl_information` VALUES (1001,'<td>Server Family:</td><td>Apache Tomcat</td>'),
(1002,'<td>Server version:</td><td>9.0.1.0</td>'),
(1003,'<td>OS Name:</td><td>Windows XP</td>'),
(1004,'<td>OS Version:</td><td>5.1</td>'),
(1005,'<td>Architecture:</td><td>x86</td>'),
(1006,'<td>Java Home:</td><td>C:\\Program Files\\Java\\jre1.8.0_101</td>'),
(1007,'<td>JVM Version:</td><td>1.8.0_101-b13</td>'),
(1008,'<td>JVM Vendor:</td><td>Oracle Corporation</td>'),
(1009,'<td>CATALINA_BASE:</td><td>C:\\Byblios\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0</td>'),
(1010,'<td>CATALINA_HOME:</td><td>C:\\apache-tomcat-9.0.1</td>'),
(1011,'<td>DB connection status:</td><td>SUCCESSFULLY connected to JUPITER_1</td>'),
(1012,'<td>Book Manager Version:</td><td>1.3.1&nbsp;(with pom.xml)</td>'),
(1013,'<td>Initial Archive:</td><td>&nbsp;book_tracker_129</td>'),
(1014,'<td>&nbsp;</td><td>&nbsp;</td>'),
(1101,'<td>Server Family:</td><td>Apache Tomcat</td>'),
(1102,'<td>Server version:</td><td>8.5.43</td>'),
(1103,'<td>OS Name:</td><td>Windows 10</td>'),
(1104,'<td>OS Version:</td><td>10.0</td>'),
(1105,'<td>Architecture:</td><td>amd64</td>'),
(1106,'<td>Java Home:</td><td>C:\\Program Files\\Java\\jre1.8.0_201</td>'),
(1107,'<td>JVM Version:</td><td>1.8.0_201-b09</td>'),
(1108,'<td>JVM Vendor:</td><td>Oracle Corporation</td>'),
(1109,'<td>CATALINA_BASE:</td><td>C:\\JavaWorkss\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0</td>'),
(1110,'<td>CATALINA_HOME:</td><td>C:\\Program Files\\ApacheTomcat</td>'),
(1111,'<td>DB connection status:</td><td>SUCCESSFULLY connected to JUPITER_1</td>'),
(1112,'<td>Book Manager Version:</td><td>1.2.9&nbsp;(with pom.xml)</td>'),
(1113,'<td>Initial Archive:</td><td>&nbsp;byblios_129</td>'),
(1114,'<td>&nbsp;</td><td>&nbsp;</td>');
/*!40000 ALTER TABLE `tbl_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Loading routines for database 'jupiter_1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-14 21:27:35
