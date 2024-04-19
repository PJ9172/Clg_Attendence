-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bba
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `ty_presenty`
--

DROP TABLE IF EXISTS `ty_presenty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_presenty` (
  `subject` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `tid` varchar(45) NOT NULL,
  `student_rno` int NOT NULL,
  `student_name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_presenty`
--

LOCK TABLES `ty_presenty` WRITE;
/*!40000 ALTER TABLE `ty_presenty` DISABLE KEYS */;
INSERT INTO `ty_presenty` VALUES ('601','','admin',102,'Riya Sharma','Present'),('601','12/03/2024','admin',101,'Vikram Singh','Present'),('601','12/03/2024','admin',102,'Riya Sharma','Present'),('601','12/03/2024','admin',103,'Kiran Patel','Present'),('601','12/03/2024','admin',104,'Neha Gupta','Present'),('601','12/03/2024','admin',105,'Rajesh Kumar','Present'),('601','12/03/2024','admin',106,'Anjali Desai','Absent'),('601','12/03/2024','admin',107,'Rohit Mehta','Absent'),('601','12/03/2024','admin',108,'Pooja Verma','Present'),('601','12/03/2024','admin',109,'Amit Shah','Absent'),('601','12/03/2024','admin',110,'Ananya Joshi','Present'),('603','15/03/2024','teacher2',101,'Vikram Singh','Present'),('603','15/03/2024','teacher2',102,'Riya Sharma','Present'),('603','15/03/2024','teacher2',103,'Kiran Patel','Present'),('603','15/03/2024','teacher2',104,'Neha Gupta','Present'),('603','15/03/2024','teacher2',105,'Rajesh Kumar','Absent'),('603','15/03/2024','teacher2',106,'Anjali Desai','Present'),('603','15/03/2024','teacher2',107,'Rohit Mehta','Present'),('603','15/03/2024','teacher2',108,'Pooja Verma','Absent'),('603','15/03/2024','teacher2',109,'Amit Shah','Absent'),('603','15/03/2024','teacher2',110,'Ananya Joshi','Present'),('602','','teacher2',101,'Vikram Singh','Present'),('602','10/03/2024','teacher2',101,'Vikram Singh','Present'),('602','10/03/2024','teacher2',102,'Riya Sharma','Present'),('602','10/03/2024','teacher2',103,'Kiran Patel','Present'),('602','10/03/2024','teacher2',104,'Neha Gupta','Absent'),('602','10/03/2024','teacher2',105,'Rajesh Kumar','Present'),('602','10/03/2024','teacher2',106,'Anjali Desai','Absent'),('602','10/03/2024','teacher2',107,'Rohit Mehta','Present'),('602','10/03/2024','teacher2',108,'Pooja Verma','Present'),('602','10/03/2024','teacher2',109,'Amit Shah','Present'),('602','10/03/2024','teacher2',110,'Ananya Joshi','Present'),('602','11/02/20','teacher2',101,'Vikram Singh','Present'),('602','11/02/20','teacher2',102,'Riya Sharma','Present'),('602','11/02/20','teacher2',103,'Kiran Patel','Present'),('602','11/02/20','teacher2',104,'Neha Gupta','Present'),('602','11/02/20','teacher2',105,'Rajesh Kumar','Absent'),('602','11/02/20','teacher2',106,'Anjali Desai','Present'),('602','11/02/20','teacher2',107,'Rohit Mehta','Present'),('602','11/02/20','teacher2',108,'Pooja Verma','Present'),('602','11/02/20','teacher2',109,'Amit Shah','Present'),('602','11/02/20','teacher2',110,'Ananya Joshi','Absent');
/*!40000 ALTER TABLE `ty_presenty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-19 18:15:53
