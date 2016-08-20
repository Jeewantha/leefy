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
-- Inserting data for table `security_questions`
--

LOCK TABLES `security_questions` WRITE;
/*!40000 ALTER TABLE `security_questions` DISABLE KEYS */;
INSERT INTO `security_questions` VALUES (1,'What is the name of your best friend from Childhood?','2015-05-16 17:47:23'),(2,'What was the name of your first teacher?','2015-05-16 17:47:23'),(3,'What is your mothers madden name?','2015-05-16 17:47:23'),(4,'What is your favorite Vehicle?','2015-05-16 17:47:23'),(5,'What is your favorite Color?','2015-05-16 17:47:23'),(6,'What is your Heros name?','2015-05-16 17:47:23'),(7,'What is your favorite Novel?','2015-05-16 17:47:23');
/*!40000 ALTER TABLE `security_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Inserting data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,1,'Administrator','User','user@mail.com','admin','ceb4f32325eda6142bd65215f4c0f371',1,1,NULL,'2015-05-16 17:47:23',0,0);
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Inserting data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'Admin','admin','2015-05-16 17:47:23',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Inserting data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Sri Lanka','SL','Colombo','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<!-- Created with Sodipodi (\"http://www.sodipodi.com/\") -->\n<!--\nOn October 30, 2003, Brett Roper dedicated to the public domain the\nworks \"SVG graphic of Chad Flag.\", \"SVG graphic of El Salvador Flag.\",\n\"SVG graphic of Sierra Leone Flag.\", \"SVG graphic of Peru Flag.\" Before\nmaking the dedication,\nBrett Roper\nrepresented that Brett Roper owned all copyrights in the\nwork. By making the dedication, Brett Roper made an overt act\nof relinquishment in perpetuity of all present and future rights under\ncopyright law, whether vested or contingent, in \"SVG graphic of Chad\nFlag.\", \"SVG graphic of El Salvador Flag.\", \"SVG graphic of Sierra Leone\nFlag.\", \"SVG graphic of Peru Flag.\"\n\nBrett Roper understands that such relinquishment of all rights\nincludes the relinquishment of all rights to enforce (by lawsuit or\notherwise) those copyrights in the Work.\n\nBrett Roper recognizes that, once placed in the public domain,\n\"SVG graphic of Chad Flag.\", \"SVG graphic of El Salvador Flag.\", \"SVG\ngraphic of Sierra Leone Flag.\", \"SVG graphic of Peru Flag.\" may be\nfreely reproduced,\ndistributed, transmitted, used,\nmodified, built upon, or otherwise exploited by anyone for any\npurpose, commercial or non-commercial, and in any way, including by\nmethods that have not yet been invented or conceived.\n-->\n<svg id=\"canada\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns=\"http://www.w3.org/2000/svg\" fill-opacity=\"14.118\" height=\"480\" width=\"640\" version=\"1.1\" xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" fill=\"#28ff09\">\n <metadata id=\"metadata3128\">\n  <rdf:RDF>\n   <cc:Work rdf:about=\"\">\n    <dc:format>image/svg+xml</dc:format>\n    <dc:type rdf:resource=\"http://purl.org/dc/dcmitype/StillImage\"/>\n   </cc:Work>\n  </rdf:RDF>\n </metadata>\n <g id=\"flag\" fill-rule=\"evenodd\" fill-opacity=\"1\" transform=\"matrix(1.25 0 0 .93750 0 .000019425)\">\n  <rect id=\"rect574\" height=\"170.3\" width=\"512\" y=\"341.7\" x=\"0\" fill=\"#0000cd\"/>\n  <rect id=\"rect573\" height=\"170.3\" width=\"512\" y=\"171.4\" x=\"0\" fill=\"#fff\"/>\n  <rect id=\"rect572\" height=\"171.4\" width=\"512\" y=\"-.000019656\" x=\"0\" fill=\"#00cd00\"/>\n </g>\n</svg>\n','2016-06-04 07:14:58');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;