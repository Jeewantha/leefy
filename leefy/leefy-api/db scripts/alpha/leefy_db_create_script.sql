-- Leefy is a simple social network to narrow the gap between people speaking different
--  languages and to aid the language learning process.
--    Copyright (C) 2015  Jeewantha Samaraweera
--
--    This program is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    This program is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with this program.  If not, see <http://www.gnu.org/licenses/>.
--	
CREATE DATABASE  IF NOT EXISTS `leefy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `leefy`;

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
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `MODULE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page` (
  `PAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `URL` varchar(45) NOT NULL,
  `TAB_ID` int(11) DEFAULT NULL,
  `INDEX_NO` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PAGE_ID`),
  KEY `fk_PAGE_TAB1` (`TAB_ID`),
  CONSTRAINT `fk_PAGE_TAB1` FOREIGN KEY (`TAB_ID`) REFERENCES `tab` (`TAB_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `PRIVILEGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(150) NOT NULL,
  `PAGE_ID` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PRIVILEGE_ID`),
  KEY `fk_PRIVILEGE_PAGE1` (`PAGE_ID`),
  CONSTRAINT `fk_PRIVILEGE_PAGE1` FOREIGN KEY (`PAGE_ID`) REFERENCES `page` (`PAGE_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `privilege_dependency`
--

DROP TABLE IF EXISTS `privilege_dependency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege_dependency` (
  `PRIVILEGE_DEPENDENCY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRIVILEGE_ID` int(11) NOT NULL,
  `DEPENDENCY_ID` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PRIVILEGE_DEPENDENCY_ID`),
  KEY `fk_PRIVILEGE_DEPENDENCY_PRIVILEGE1` (`PRIVILEGE_ID`),
  KEY `fk_PRIVILEGE_DEPENDENCY_DEPENDENCY1` (`DEPENDENCY_ID`),
  CONSTRAINT `fk_PRIVILEGE_DEPENDENCY_DEPENDENCY1` FOREIGN KEY (`DEPENDENCY_ID`) REFERENCES `privilege` (`PRIVILEGE_ID`),
  CONSTRAINT `fk_PRIVILEGE_DEPENDENCY_PRIVILEGE1` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `privilege` (`PRIVILEGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=510 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege` (
  `ROLE_PRIVILEGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ROLE_ID` int(11) NOT NULL,
  `PRIVILEGE_ID` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ROLE_PRIVILEGE_ID`),
  KEY `fk_ROLE_PRIVILEGE_USER_ROLE1` (`USER_ROLE_ID`),
  KEY `fk_ROLE_PRIVILEGE_PRIVILEGE1` (`PRIVILEGE_ID`),
  CONSTRAINT `fk_ROLE_PRIVILEGE_PRIVILEGE1` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `privilege` (`PRIVILEGE_ID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_ROLE_PRIVILEGE_USER_ROLE1` FOREIGN KEY (`USER_ROLE_ID`) REFERENCES `user_role` (`USER_ROLE_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=553 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_tab`
--

DROP TABLE IF EXISTS `role_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_tab` (
  `ROLE_TAB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TAB_ID` int(11) NOT NULL,
  `USER_ROLE_ID` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ROLE_TAB_ID`),
  KEY `fk_ROLE_TAB_TAB` (`TAB_ID`),
  KEY `fk_ROLE_TAB_USER_ROLE1` (`USER_ROLE_ID`),
  CONSTRAINT `fk_ROLE_TAB_TAB` FOREIGN KEY (`TAB_ID`) REFERENCES `tab` (`TAB_ID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_ROLE_TAB_USER_ROLE1` FOREIGN KEY (`USER_ROLE_ID`) REFERENCES `user_role` (`USER_ROLE_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `security_questions`
--

DROP TABLE IF EXISTS `security_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_questions` (
  `SECURITY_QUESTIONS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SECURITY_QUESTION` varchar(100) NOT NULL,
  `MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SECURITY_QUESTIONS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tab`
--

DROP TABLE IF EXISTS `tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab` (
  `TAB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `PARENT_TAB_ID` int(11) DEFAULT NULL,
  `MODULE_ID` int(11) NOT NULL,
  `INDEX_NO` int(11) NOT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`TAB_ID`),
  KEY `fk_TAB_MODULE1` (`MODULE_ID`),
  CONSTRAINT `fk_TAB_MODULE1` FOREIGN KEY (`MODULE_ID`) REFERENCES `module` (`MODULE_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `USER_LOGIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ROLE_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `STATUS` smallint(6) NOT NULL,
  `LOGIN_ATTEMPTS` int(1) DEFAULT '0',
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `GENERATED_PASSWORD` smallint(6) NOT NULL DEFAULT '0',
  `DELETED` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`USER_LOGIN_ID`),
  KEY `fk_USER_LOGIN_USER_ROLE1` (`USER_ROLE_ID`),
  CONSTRAINT `fk_USER_LOGIN_USER_ROLE1` FOREIGN KEY (`USER_ROLE_ID`) REFERENCES `user_role` (`USER_ROLE_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `IS_SYSTEM_ROLE` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USER_ROLE_ID`),
  UNIQUE KEY `ROLE_UNIQUE` (`ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_security_questions`
--

DROP TABLE IF EXISTS `user_security_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_security_questions` (
  `USER_SECURITY_QUESTIONS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_LOGIN_ID` int(11) NOT NULL,
  `SECURITY_QUESTION_ID` int(11) NOT NULL,
  `ANSWER` varchar(100) NOT NULL,
  `MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_SECURITY_QUESTIONS_ID`),
  UNIQUE KEY `UC_USER_SECURITY_QUESTIONS` (`SECURITY_QUESTION_ID`,`USER_LOGIN_ID`),
  KEY `fk_USER_SECURITY_QUESTIONS_USER_LOGIN` (`USER_LOGIN_ID`),
  KEY `fk_USER_SECURITY_QUESTIONS_SECURITY_QUESTIONS` (`SECURITY_QUESTION_ID`),
  CONSTRAINT `fk_USER_SECURITY_QUESTIONS_SECURITY_QUESTIONS` FOREIGN KEY (`SECURITY_QUESTION_ID`) REFERENCES `security_questions` (`SECURITY_QUESTIONS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_USER_SECURITY_QUESTIONS_USER_LOGIN` FOREIGN KEY (`USER_LOGIN_ID`) REFERENCES `user_login` (`USER_LOGIN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `COUNTRY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `ISO_CODE` varchar(45) NOT NULL,
  `CAPITAL_CITY` varchar(255) DEFAULT NULL,
  `FLAG` longblob,
  `MODIFIED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`COUNTRY_ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;