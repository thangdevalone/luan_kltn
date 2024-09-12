-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: iot_food_04
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
-- Table structure for table `account_entity`
--

DROP TABLE IF EXISTS `account_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `img_user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_entity`
--

LOCK TABLES `account_entity` WRITE;
/*!40000 ALTER TABLE `account_entity` DISABLE KEYS */;
INSERT INTO `account_entity` VALUES (1,'','2023-09-03 19:50:49.703000',NULL,NULL,_binary '','ADMIN','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','@ADMIN@','string','ADMIN','viet1234561231@gmail.com'),(55,'ADMIN','2023-10-16 00:27:46.466000',NULL,NULL,_binary '','Linh Linh','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$v6v8CX5Y2.j1d50GO6O5PeYabpa.PFNipsznpYEvZSQOob1OqDJhi','0366092088','A41761','linhthuyduong14923@gmail.com'),(56,'A41761','2023-10-16 02:03:20.976000',NULL,NULL,_binary '','Nguyễn Thị Huyền Trang','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$1TIjQKtWOXds30gnzU7yYuu.cD0BSMCoODGeojC2iUgCbC3UBEBW6','0362206773','A45965',NULL),(57,'A45965','2023-10-16 04:16:08.581000',NULL,NULL,_binary '','Đỗ Quốc Việ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1697415744/e352e672-d68f-4753-ae31-da305079e7b8.jpg','$2a$10$WC2u/SivV73yLScY0lgVeeX.udSXOYnX/mw.tDSlmvvNWrI.d0Rg6','0868292137','A43669','quangthang2003a@gmail.com'),(58,'A43669','2023-10-16 06:24:00.074000',NULL,NULL,_binary '','Luyện Đình Thắng','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$lDdLydpugAR3dDvW/u/66eZUFgt38aZ/9LenlDDdLf83g9ZUMboK6','0355640902','A46135','Luyenthang0207@gmail.com'),(59,'A46135','2023-10-16 06:24:26.603000',NULL,NULL,_binary '','Nguyễn Thị Kim Yến','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$UWOY.cGCBHSKgQSYViPpxuAnQ4OY230RWXqRYrnD1fxqGhKhXHDJ6','0368592107','A46513',NULL),(60,'ADMIN','2023-10-16 07:52:57.770000',NULL,NULL,_binary '','Nguyễn Duy Hưng David','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$WLOSYnTzgldW.6i/OVXwj.KwDWLipWoxlM7eG47bohiw/yjItYkGq','0976098380','A42419',NULL),(62,'A67463','2023-10-16 09:22:12.976000',NULL,NULL,_binary '','Nguyễn Khánh Ngọc','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$Cr7agDqnQlFPR9ZNjs3xpOebw.VlCPyIxl.gzOXLjA8Ik/vTPwhmi','0914376326','A46454',NULL),(64,'A41761','2023-10-16 10:03:56.483000',NULL,NULL,_binary '','Dương Thị Thúy Ngân','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$qBzrx1BwOTaHthIFRf9Xdu5QoVdp9FVFb2ps/kY9YlFnnveamU5JS','0386905086','A48374',NULL),(65,'ADMIN','2023-10-16 10:42:32.776000',NULL,NULL,_binary '','Lê Thành Long','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$JnfThwlUBhtKFt6mePgc0.zGuOhA/TDiEIPK397qD69WZniMIOP1C','0374943586','A45220',NULL),(66,'ADMIN','2023-10-16 12:51:04.208000',NULL,NULL,_binary '','Nguyễn Ngọc Huyền','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$Jq3u6ud/cBGo7KtA9JIMruERKxTD3cAqRd1ChtEceCtBroi.oV1py','0962319014','A43581',NULL),(67,'A43669','2023-10-16 13:21:46.079000',NULL,NULL,_binary '','Quân Lee','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$bd1cdtOzdeBCAFiPtTF45ubrJr9NX1wSEJhyMPJDw.SIPBMit8j/m','0338788007','A46019','lehongquan07102004@gmail.com'),(68,'A43669','2023-10-16 13:29:05.413000',NULL,NULL,_binary '','Phạm Tú','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$69tL6blxFF8XfOsixCVFcu1XE5afOQTjzL0KLLCGf6xPP6LXdX2ra','0968623160','A43647','phamanhtu13042002@gmail.com'),(69,'A43647','2023-10-16 13:38:00.195000',NULL,NULL,_binary '','trung quân','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$iOlpA0pM/hiASXHe1kp.YO3BA14cQ7COmiprZJOhjtd7bFkseKk8e','0973637264','A43215',NULL),(70,'A43215','2023-10-16 13:40:22.881000',NULL,NULL,_binary '','Đinh Thị Hoài','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$wkszTA3O2XEztwtLOpM9LOn.VN97cXqqT7ZtI0O3C12UMIf1gKhc2','0348975471','A39469',NULL),(71,'A43647','2023-10-16 15:43:22.269000',NULL,NULL,_binary '','Đoàn thị quỳnh nga','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$u1t2WsZqy4gBbt.9kG/RgefhVtAs2NS3ygPy6ZggYH7ZkPiKWFu5u','0946240870','A47950',NULL),(72,'A47950','2023-10-16 17:18:39.577000',NULL,NULL,_binary '','Nguyễn Thị Thanh Trà','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$2akQCoRYpQ/LrW5HS2n22e7QpnvVyJVJKEKoHAtNEnctiXiC/ebHu','0398311948','A44464',NULL),(73,'A44464','2023-10-16 17:33:30.387000',NULL,NULL,_binary '','Văn Thị Huyền','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$j3hba15K7L2c6ObMBeUUm.QJxTaFjG/W23BWMPwkSEIIbwIjy2MZa','0398721812','A45571',NULL),(74,'A45571','2023-10-16 20:08:01.518000',NULL,NULL,_binary '','Phạm T Diễm Hương','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$NcMzMZTOcpo9FO7uvbFpn.D3V1SF4vkTtD2H/BLmM/I0QIGBlXDV2','0397211424','A43414',NULL),(75,'A43414','2023-10-16 20:54:38.788000',NULL,NULL,_binary '','Lê Lam Phương','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$KnWNnQY5DOgFBPwbb4dVueak9pmFYhCo2bOZzfhvMKlKWu59AKFEC','0888207720','A47717',NULL),(76,'A47717','2023-10-16 20:59:55.386000',NULL,NULL,_binary '','Cung Việt Anh','http://res.cloudinary.com/ddmwuvynh/image/upload/v1697464842/74eaefbd-ec16-4d75-991e-ec92ff5be058.jpg','$2a$10$LHvekUEp3DOiTiPRoB8LO.5pMuIqkE1VKdPNcifdRSV2JCISgkIb6','0967881968','A44645','cungvietanh04@gmail.com'),(77,'A44645','2023-10-16 21:20:03.800000',NULL,NULL,_binary '','Hoàng Vũ Nghị','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$EWRwH4xa4fPIkrk4MjLO1u1rslelsp5yCTgtNwI1lDcL64C5L/2oC','0971578680','A45156','hoangvunghi2004@gmail.com'),(78,'A45156','2023-10-16 21:43:46.985000',NULL,NULL,_binary '','Tester hack','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$HBwwtS4W3cgfvG5zAWueXusysKb3HTOh9TQIVDKI/RwcAVxHMa40m','0336625312','A45111','faker1842002@gmail.com'),(79,'A45156','2023-10-16 22:09:33.775000',NULL,NULL,_binary '','Lê Thị Yến','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$uu0EyBU6/zZ5/IxVmDiXTewRIuVkGxrHgK0sIvn0U2HfQLBCteVJu','0945230636','A46378',NULL),(81,'ADMIN','2023-10-18 12:01:39.104000',NULL,NULL,_binary '','Nguyễn Hải Yến','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$Nbt9j2qbxFzvBHIgLOryQ./Sg02btZX73CmpLfmyee88F/k7o4n8W','0369326747','A48202',NULL),(82,'ADMIN','2023-10-18 16:07:52.389000',NULL,NULL,_binary '','Bùi Thanh Hà','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$70zWlt/M5A4nj2bUGAGkheep0ljHabZ.av.cj79umOkZns/E1vzSS','0923405469','A40433',NULL),(83,'A40433','2023-10-18 17:50:36.180000',NULL,NULL,_binary '','Bùi Thị Thùy Trang','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$wxwlr1T/QxSs8MQTpTKY0.k324hX54.ewLNg9co8pTbg6tud4rBXu','0377812510','A46205',NULL),(84,'ADMIN','2023-10-19 10:20:53.467000',NULL,NULL,_binary '','Tống Đức Luận','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$I/nqtAIFPJfx5sUePGGIiukh14FG1SYETvydUBBBaSD8jHR./CQsm','0364005035','A44059',NULL),(85,'A43669','2023-10-20 11:28:40.584000',NULL,NULL,_binary '','Nguyễn Thị Hồng Thuý','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$89WpXN6Ay1P9OYHYNrOgAOG8w1vSFB8s0RImGxxvCalW4.sBbBbOG','0906230104','A46635',NULL),(86,'ADMIN','2023-10-20 13:52:39.898000',NULL,NULL,_binary '','Phương Hải Đăng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1697784811/91363fc0-f557-4dec-aa8c-1ef23aab79c8.png','$2a$10$zyivR1uJ2tdBZZLRIOKzxuRDuX7TntCPAns/7DKJHOYk4HQ0XuT3u','0335380952','A41461','haidang02032003@gmail.com'),(87,'A41461','2023-10-20 15:45:40.487000',NULL,NULL,_binary '','Nguyễn Thị Bích Ngọc','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$A.X5Kcd0MO1wdVXklM.TxOTBzikZydbvmu56n8HAiZEvsIrOB1Kda','0373802662','A46621',NULL),(88,'ADMIN','2023-10-21 04:28:36.799000',NULL,NULL,_binary '','Quang Thắng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1698411706/ccf1bf27-985f-464d-8bac-abedfaacb198.png','$2a$10$ojh8.psy3A7AtEPFss28ouvHv/pzAlpNkJckiay4pusZ.10xnUWtG','0965204950','A41820','quangthang2003a@gmail.com'),(89,'','2023-10-23 20:15:56.590000',NULL,NULL,_binary '','Phạm Thanh Mai','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$lmBwJc6yIamIaWro1RYOouygJLumTBnB/jlaK6maJtsTL3fLDklQO','0385456838','A45510',NULL),(90,'A45510','2023-10-23 20:33:26.789000',NULL,NULL,_binary '','Nguyễn Hoài Anh','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$SSrFjYoZphEPHHck5V4EuedDAzdiBlLyRMLwKex9y6NrPTcyF8aFq','0985648673','A31408',NULL),(91,'A31408','2023-10-24 01:06:27.917000',NULL,NULL,_binary '','An Nguyễn','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$HPgRHX2V.jC3L/3JxZbgougUVTHZ5AX7KbM16tM8vIizLx2oel5gy','0123456789','A43000',NULL),(92,'ADMIN','2023-10-24 22:13:54.178000',NULL,NULL,_binary '','Phạm Phương','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$1XQzrC7G0ANm1qZGhxxcceRBvK5LVe6EFrvJS3aVWjKH4eHA68yO6','0123456789','A41717','phuonghieu2202@gmail.com'),(93,'A41820','2023-10-25 20:38:32.931000',NULL,NULL,_binary '','Tiếng Trung','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$MlzW4Tsf4frJaVhl/dmuR.ze7YCbHknCMfvUkHqBEfeZB9X6Aw6kO','0399667738','A41954',NULL),(94,'A41954','2023-10-27 04:38:22.254000',NULL,NULL,_binary '','Trunk kun','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$n4Ibkt4D8l8UH76VHyYTneTc0dJJkvZ0XCyIgOKS6pU3FpTfJ4VJ6','0399667738','A41956',NULL),(95,'A41956','2023-10-27 10:08:17.173000',NULL,NULL,_binary '','Nguyễn An','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$uAm25PevmulMY.pi6Sc.TeW5PAtnXagBwOGLGbk9npR/hvR3nwVHC','0123456789','A12345',NULL),(96,'A12345','2023-10-28 01:30:04.716000',NULL,NULL,_binary '','Luan Tong','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$9rDvKQbsy6HNnFvA6Ic0reMgjoSWv6DzjtVFUma09enug03cICViy','0368728782','A41111',NULL),(97,'ADMIN','2023-11-01 11:39:43.733000',NULL,NULL,_binary '','Lê Anh Đức','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$yDA9KUrZl8ySsuZuD5kCuuFcZAXR3L1fC7U3c6o6fIr4Jfcp25RjS','0812710899','A46991',NULL),(98,'ADMIN','2023-11-08 15:04:49.895000',NULL,NULL,_binary '','Đỗ Quốc Việt','https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg','$2a$10$jTp7qMvkJANSRrSoTZG.iOiFDS/uyCDQJqAZ7PioyNDsBOgF63XIW','0868292137','A43665',NULL);
/*!40000 ALTER TABLE `account_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail_entity`
--

DROP TABLE IF EXISTS `bill_detail_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `bill_entity_id` int DEFAULT NULL,
  `food_entity_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcvg7bn2qaen3tcp5aum4jwack` (`bill_entity_id`),
  KEY `FKp7d413ac33nqsovf6kdrf25fh` (`food_entity_id`),
  CONSTRAINT `FKcvg7bn2qaen3tcp5aum4jwack` FOREIGN KEY (`bill_entity_id`) REFERENCES `bill_entity` (`id`),
  CONSTRAINT `FKp7d413ac33nqsovf6kdrf25fh` FOREIGN KEY (`food_entity_id`) REFERENCES `food_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail_entity`
--

LOCK TABLES `bill_detail_entity` WRITE;
/*!40000 ALTER TABLE `bill_detail_entity` DISABLE KEYS */;
INSERT INTO `bill_detail_entity` VALUES (106,'A48374','2023-10-16 10:06:19.262000',_binary '',82,75,1,'null'),(107,'A41761','2023-10-16 10:27:44.010000',_binary '',83,75,1,'null'),(108,'A41761','2023-10-16 10:27:44.013000',_binary '',83,34,1,'null'),(109,'A45220','2023-10-16 10:44:37.751000',_binary '',84,79,1,'null'),(110,'A43669','2023-10-18 07:30:22.942000',_binary '',85,32,1,'null'),(111,'A43669','2023-10-18 07:39:31.393000',_binary '',86,75,1,'null'),(112,'A43669','2023-10-18 07:43:54.652000',_binary '',87,72,1,'null'),(113,'A43669','2023-10-18 07:44:13.394000',_binary '',88,38,1,'null'),(114,'A46378','2023-10-19 10:26:35.358000',_binary '',89,56,5,'null'),(115,'A44059','2023-10-19 10:28:15.572000',_binary '',90,56,5,'null'),(116,'A43669','2023-10-19 10:47:33.724000',_binary '',91,55,1,'null'),(117,'A46635','2023-10-20 11:32:38.016000',_binary '',92,69,2,'null'),(118,'A41954','2023-10-25 20:40:09.969000',_binary '',93,73,1,'null'),(119,'A41954','2023-10-25 20:40:09.981000',_binary '',93,72,1,'null'),(120,'A41954','2023-10-25 20:40:09.983000',_binary '',93,76,1,'null'),(121,'A41954','2023-10-25 20:42:50.282000',_binary '',94,29,1,'null'),(122,'A41954','2023-10-25 20:42:50.283000',_binary '',94,31,1,'null'),(123,'A41954','2023-10-25 20:59:29.440000',_binary '',95,49,1,'null'),(124,'A41954','2023-10-25 20:59:29.444000',_binary '',95,53,1,'null'),(125,'A41954','2023-10-25 20:59:43.257000',_binary '',96,122,1,'null'),(126,'A41954','2023-10-25 20:59:55.383000',_binary '',97,124,1,'null'),(127,'A41954','2023-10-25 21:00:23.909000',_binary '',98,146,1,'null'),(128,'A41954','2023-10-25 21:00:37.283000',_binary '',99,118,1,'null'),(129,'A41717','2023-10-26 14:35:13.532000',_binary '',100,62,1,'null'),(130,'A41956','2023-10-27 04:38:45.550000',_binary '',101,72,1,'null'),(131,'A41956','2023-10-27 04:38:45.559000',_binary '',101,69,1,'null'),(132,'A41956','2023-10-27 04:41:08.930000',_binary '',102,38,3,'null'),(133,'A41956','2023-10-27 04:41:08.932000',_binary '',102,72,2,'null'),(134,'ADMIN','2023-10-27 19:10:33.556000',_binary '',103,48,1,'null'),(135,'ADMIN','2023-10-27 19:10:33.567000',_binary '',103,149,1,'null'),(136,'ADMIN','2023-10-27 19:10:33.569000',_binary '',103,74,1,'null'),(137,'A41954','2023-10-27 21:14:29.696000',_binary '',104,71,2,'null'),(138,'A41954','2023-10-27 21:14:29.702000',_binary '',104,72,1,'null'),(139,'ADMIN','2023-10-27 21:41:18.423000',_binary '',105,37,1,'null'),(140,'ADMIN','2023-10-27 21:41:18.429000',_binary '',105,39,2,'null'),(141,'ADMIN','2023-10-27 21:41:18.430000',_binary '',105,41,1,'null'),(142,'A41954','2023-10-28 14:04:32.393000',_binary '',106,38,1,'null'),(143,'A41954','2023-10-28 14:04:32.398000',_binary '',106,39,1,'null'),(144,'A41954','2023-10-28 14:04:32.399000',_binary '',106,41,1,'null'),(145,'A41954','2023-10-28 16:46:06.543000',_binary '',107,38,2,'null'),(146,'A41954','2023-10-28 16:46:06.547000',_binary '',107,39,1,'null'),(147,'A46991','2023-11-01 11:40:17.646000',_binary '',108,37,3,'null'),(148,'A43581','2023-11-08 22:05:47.837000',_binary '',109,30,1,'null'),(149,'A43581','2023-11-08 22:05:47.844000',_binary '',109,34,1,'null'),(150,'A43581','2023-11-08 22:05:47.845000',_binary '',109,96,1,'null'),(151,'A43581','2023-11-08 22:05:47.846000',_binary '',109,68,1,'null');
/*!40000 ALTER TABLE `bill_detail_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_entity`
--

DROP TABLE IF EXISTS `bill_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `finish_date` datetime(6) DEFAULT NULL,
  `order_by` varchar(255) DEFAULT NULL,
  `order_status` smallint DEFAULT NULL,
  `total_amount` bigint NOT NULL,
  `account_entity_id` int DEFAULT NULL,
  `name_res` varchar(255) DEFAULT NULL,
  `finish_time` varchar(255) DEFAULT NULL,
  `ship_fee` int NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiv38hu1y4p8p9sbxt612eyi9n` (`account_entity_id`),
  CONSTRAINT `FKiv38hu1y4p8p9sbxt612eyi9n` FOREIGN KEY (`account_entity_id`) REFERENCES `account_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_entity`
--

LOCK TABLES `bill_entity` WRITE;
/*!40000 ALTER TABLE `bill_entity` DISABLE KEYS */;
INSERT INTO `bill_entity` VALUES (82,'A48374','2023-10-16 10:06:19.249000',NULL,NULL,_binary '',NULL,'A41761',3,29000,55,NULL,'12:30 AM',5420,NULL,''),(83,'A41761','2023-10-16 10:27:43.994000',NULL,NULL,_binary '','2023-10-16 12:14:32.207000','A41761',2,54000,55,NULL,'12:30 AM',10786,'#VS15MI50','chè khoai dẻo không ăn đậu đen, đậu đỏ'),(84,'A45220','2023-10-16 10:44:37.735000',NULL,NULL,_binary '','2023-10-16 12:15:13.484000','A45220',2,29000,65,NULL,'12:30 AM',5420,NULL,''),(85,'A43669','2023-10-18 07:30:22.821000',NULL,NULL,_binary '',NULL,'A43669',3,17000,57,NULL,'11:00 AM',7270,NULL,''),(86,'A43669','2023-10-18 07:39:31.375000',NULL,NULL,_binary '',NULL,'A43669',3,29000,57,NULL,'11:00 AM',5420,NULL,''),(87,'A43669','2023-10-18 07:43:54.588000',NULL,NULL,_binary '',NULL,'A43669',3,35000,57,NULL,'12:00 AM',5420,NULL,''),(88,'A43669','2023-10-18 07:44:13.378000',NULL,NULL,_binary '',NULL,'A43669',3,12000,57,NULL,'12:30 AM',8750,NULL,''),(89,'A46378','2023-10-19 10:26:35.335000',NULL,NULL,_binary '',NULL,'A44059',3,100000,84,NULL,'12:30 AM',8220,'#VS8KMI100',''),(90,'A44059','2023-10-19 10:28:15.564000',NULL,NULL,_binary '',NULL,'A44059',1,100000,84,NULL,'12:00 AM',8220,'#VS8KMI100',''),(91,'A43669','2023-10-19 10:47:33.713000',NULL,NULL,_binary '',NULL,'A43669',1,15000,57,NULL,'12:00 AM',5420,NULL,''),(92,'A46635','2023-10-20 11:32:38.007000',NULL,NULL,_binary '','2023-10-21 12:03:57.422000','A46635',2,84000,85,NULL,'10:00 AM',7327,'#VS15MI50',''),(93,'A41954','2023-10-25 20:40:09.939000',NULL,NULL,_binary '',NULL,'A41954',3,89000,93,NULL,'12:30 AM',11820,NULL,''),(94,'A41954','2023-10-25 20:42:50.269000',NULL,NULL,_binary '',NULL,'A41954',3,34000,93,NULL,'12:30 AM',10470,NULL,''),(95,'A41954','2023-10-25 20:59:29.427000',NULL,NULL,_binary '',NULL,'A41954',3,40000,93,NULL,'12:30 AM',8620,NULL,''),(96,'A41954','2023-10-25 20:59:43.247000',NULL,NULL,_binary '',NULL,'A41954',3,25000,93,NULL,'12:30 AM',12080,NULL,''),(97,'A41954','2023-10-25 20:59:55.370000',NULL,NULL,_binary '',NULL,'A41954',3,55000,93,NULL,'12:30 AM',11340,NULL,''),(98,'A41954','2023-10-25 21:00:23.897000',NULL,NULL,_binary '',NULL,'A41954',3,37000,93,NULL,'12:30 AM',6530,NULL,''),(99,'A41954','2023-10-25 21:00:37.272000',NULL,NULL,_binary '',NULL,'A41954',3,25000,93,NULL,'12:30 AM',7270,NULL,''),(100,'A41717','2023-10-26 14:35:13.494000',NULL,NULL,_binary '',NULL,'A41717',0,20000,92,NULL,'12:30 AM',5420,NULL,''),(101,'A41956','2023-10-27 04:38:45.528000',NULL,NULL,_binary '',NULL,'A41956',3,77000,94,NULL,'12:30 AM',8620,NULL,''),(102,'A41956','2023-10-27 04:41:08.918000',NULL,NULL,_binary '',NULL,'A41956',3,106000,94,NULL,'12:30 AM',23770,NULL,''),(103,'ADMIN','2023-10-27 19:10:33.536000',NULL,NULL,_binary '',NULL,'ADMIN',3,82000,1,NULL,'12:30 AM',17370,NULL,''),(104,'A41954','2023-10-27 21:14:29.678000',NULL,NULL,_binary '',NULL,'A41954',3,93000,93,NULL,'11:00 AM',11820,NULL,''),(105,'ADMIN','2023-10-27 21:41:18.397000',NULL,NULL,_binary '',NULL,'ADMIN',0,158000,1,NULL,'11:00 AM',18350,NULL,''),(106,'A41954','2023-10-28 14:04:32.374000',NULL,NULL,_binary '',NULL,'A41954',3,91000,93,NULL,'12:00 AM',15150,NULL,''),(107,'A41954','2023-10-28 16:46:06.521000',NULL,NULL,_binary '',NULL,'A41954',3,66000,93,NULL,'11:00 AM',15150,NULL,''),(108,'A46991','2023-11-01 11:40:17.614000',NULL,NULL,_binary '',NULL,'A46991',3,111000,97,NULL,'12:00 AM',15150,NULL,''),(109,'A43581','2023-11-08 22:05:47.816000',NULL,NULL,_binary '',NULL,'A43581',0,109000,66,NULL,'12:30 AM',25491,NULL,'');
/*!40000 ALTER TABLE `bill_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_entity_food_entities`
--

DROP TABLE IF EXISTS `bill_entity_food_entities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_entity_food_entities` (
  `bill_entity_id` int NOT NULL,
  `food_entities_id` int NOT NULL,
  UNIQUE KEY `UK_mk6naxmpa9afvi43e7s7l46rv` (`food_entities_id`),
  KEY `FKi4nejt6mu2vhn0cyq0buk8bto` (`bill_entity_id`),
  CONSTRAINT `FKi4nejt6mu2vhn0cyq0buk8bto` FOREIGN KEY (`bill_entity_id`) REFERENCES `bill_entity` (`id`),
  CONSTRAINT `FKp40tgyqm2axa204wdblk6dptx` FOREIGN KEY (`food_entities_id`) REFERENCES `food_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_entity_food_entities`
--

LOCK TABLES `bill_entity_food_entities` WRITE;
/*!40000 ALTER TABLE `bill_entity_food_entities` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_entity_food_entities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_entity`
--

DROP TABLE IF EXISTS `food_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `bill_entity_id` int DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `img_food` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `quantity_purchased` int DEFAULT NULL,
  `restaurant_entity_id` int DEFAULT NULL,
  `star` int DEFAULT NULL,
  `type_food_entity_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhnoht4w6plm4v9b16enoebndu` (`bill_entity_id`),
  KEY `FK5mbws0s9wfc9oeobu1817h0a8` (`restaurant_entity_id`),
  KEY `FKmexei6bdlpy45al855r43rhpo` (`type_food_entity_id`),
  CONSTRAINT `FK5mbws0s9wfc9oeobu1817h0a8` FOREIGN KEY (`restaurant_entity_id`) REFERENCES `restaurant_entity` (`id`),
  CONSTRAINT `FKhnoht4w6plm4v9b16enoebndu` FOREIGN KEY (`bill_entity_id`) REFERENCES `bill_entity` (`id`),
  CONSTRAINT `FKmexei6bdlpy45al855r43rhpo` FOREIGN KEY (`type_food_entity_id`) REFERENCES `type_food_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_entity`
--

LOCK TABLES `food_entity` WRITE;
/*!40000 ALTER TABLE `food_entity` DISABLE KEYS */;
INSERT INTO `food_entity` VALUES (29,'ADMIN','2023-09-18 09:52:20.638000',NULL,NULL,_binary '',NULL,'','Chè đậu đỏ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005540/ee1fc27e-77ba-461e-9abc-63537d29d536.jpg',17000,0,18,NULL,7),(30,'ADMIN','2023-09-18 09:53:09.971000',NULL,NULL,_binary '',NULL,'','Chè Thái Thập cẩm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005589/91887101-1b17-41c0-aad1-16eb1bad63b7.jpg',17000,NULL,18,NULL,7),(31,'ADMIN','2023-09-18 10:04:39.473000',NULL,NULL,_binary '',NULL,'','Chè Thái bưởi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695006278/3e18531f-4747-4ea5-ac5b-01a87484acad.jpg',17000,0,18,NULL,7),(32,'ADMIN','2023-09-18 10:05:16.310000',NULL,NULL,_binary '',NULL,'','Chè bưởi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695006315/b6dcecd5-2950-4960-b82e-ca09d11612b2.jpg',17000,0,18,NULL,7),(33,'ADMIN','2023-09-18 10:12:34.686000',NULL,NULL,_binary '',NULL,'','Tàu hũ trân châu đường đen','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695006754/9524c11e-3838-40ac-a88a-ba7118244a68.jpg',17000,0,18,NULL,7),(34,'ADMIN','2023-09-18 10:14:21.581000',NULL,NULL,_binary '',NULL,'','Chè khoai dẻo caramen','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695006861/0ff73175-dbfb-4aed-90fd-d32c8d808294.jpg',25000,0,18,NULL,7),(35,'ADMIN','2023-09-18 10:22:18.690000',NULL,NULL,_binary '',NULL,'','Chè khoai dẻo','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695007338/afa1cd24-afaa-47d5-910c-f371023fd2ba.jpg',17000,0,18,NULL,7),(36,'ADMIN','2023-09-18 10:40:19.111000',NULL,NULL,_binary '',NULL,'','Bánh mì chảo','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695008418/f0a3693e-15c3-4ade-9239-4db3453d16eb.jpg',37000,0,19,NULL,8),(37,'ADMIN','2023-09-18 10:55:39.947000',NULL,NULL,_binary '',NULL,'','Nem nướng nha trang','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695009339/be9812b4-0ee9-4087-a46a-44bc2723c6ba.jpg',37000,0,19,NULL,12),(38,'ADMIN','2023-09-18 10:58:43.035000',NULL,NULL,_binary '',NULL,'','Nem lụi (Chiếc)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695009522/271c9746-f699-4730-9d4e-3d2760d14643.jpg',12000,0,19,NULL,12),(39,'ADMIN','2023-09-18 11:00:50.334000',NULL,NULL,_binary '',NULL,'','Nem lụi (Suất)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695009649/663db9a9-868f-4087-94a1-bcd38aa83df5.jpg',42000,0,19,NULL,12),(41,'ADMIN','2023-09-18 11:08:10.880000',NULL,NULL,_binary '',NULL,'','Bánh xèo (suất)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695010090/409c0f35-f8c3-403a-bcb5-0b48d343ea55.jpg',37000,0,19,NULL,12),(42,'ADMIN','2023-09-18 11:12:54.504000',NULL,NULL,_binary '',NULL,'','Bánh xèo (Cái)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695010373/985b2777-72ed-41a1-a7f6-e655a435ac2e.jpg',22000,0,19,NULL,12),(44,'ADMIN','2023-09-18 11:18:53.121000',NULL,NULL,_binary '',NULL,'','Xúc xích (Chiếc)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695010732/6989c865-01ca-4016-823b-d5af60082234.jpg',12000,0,19,NULL,9),(46,'ADMIN','2023-09-18 11:25:29.607000',NULL,NULL,_binary '',NULL,'','Khoai môn lệ phố','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695011129/2c2c469d-a84c-4353-b4f7-38c6812279fd.jpg',40000,0,19,NULL,9),(47,'ADMIN','2023-09-18 11:26:50.426000',NULL,NULL,_binary '',NULL,'','Khoai lang kén','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695011209/c9c8b55f-2b30-4b43-8e01-fa93940d8ae1.jpg',30000,0,19,NULL,9),(48,'ADMIN','2023-09-18 13:13:28.632000',NULL,NULL,_binary '',NULL,'','Bánh mì chả nóng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695017608/351cea9d-67ca-45eb-8ab7-c8970058b2a6.jpg',15000,0,20,NULL,8),(49,'ADMIN','2023-09-18 13:14:06.481000',NULL,NULL,_binary '',NULL,'Nhiều topping hơn ','Bánh mì chả nóng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695017645/e02fd0bf-c5c4-47c6-99bf-7ad4f827cd0e.jpg',20000,0,20,NULL,8),(50,'ADMIN','2023-09-18 13:14:58.243000',NULL,NULL,_binary '',NULL,'Bao gồm pate + Trứng + xúc xích','Bánh mì pate trứng - xúc xích','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695017697/ed39f77b-318a-4aaa-b57c-1cd16b717ece.jpg',25000,0,20,NULL,8),(51,'ADMIN','2023-09-18 13:16:02.293000',NULL,NULL,_binary '',NULL,'','Bánh mì pate trứng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695017761/654eb315-ab2f-43f7-b4ec-84669fd59d1b.jpg',15000,0,20,NULL,8),(52,'ADMIN','2023-09-18 13:16:44.053000',NULL,NULL,_binary '',NULL,'','Bánh mì trứng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695017803/63f0806a-1953-474d-b615-8eb09caf74b2.jpg',12000,0,20,NULL,8),(53,'ADMIN','2023-09-18 13:21:33.594000',NULL,NULL,_binary '',NULL,'','Bánh tráng trộn','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018093/10ee072b-16b1-4b1a-93b8-74a55ed560d4.jpg',20000,0,20,NULL,9),(54,'ADMIN','2023-09-18 13:24:07.134000',NULL,NULL,_binary '',NULL,'Nhiều topping hơn','Bánh tráng trộn (thêm topping)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018246/72d3763a-d5d7-4b73-b93d-c8234f8c7ae7.jpg',25000,0,20,NULL,9),(55,'ADMIN','2023-09-18 13:30:47.336000',NULL,NULL,_binary '',NULL,'','Xôi chả nóng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018646/20727f51-3461-4681-81de-6f65d47563d0.jpg',15000,0,20,NULL,10),(56,'ADMIN','2023-09-18 13:31:33.054000',NULL,NULL,_binary '',NULL,'Nhiều xôi và topping hơn so với 15k','Xôi chả nóng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018692/ed85a3a4-2c4c-4c3f-85d4-deea510a9c87.jpg',20000,0,20,NULL,10),(57,'ADMIN','2023-09-18 13:34:49.430000',NULL,NULL,_binary '',NULL,'','Trà chanh','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018888/fcecc8f2-b271-4b4f-8ef5-ba1e16a0f395.jpg',10000,NULL,20,NULL,13),(58,'ADMIN','2023-09-18 13:35:20.373000',NULL,NULL,_binary '',NULL,'','Trà chanh bigsize','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018919/2d546d6a-2ba7-4c0b-b9b6-6230de47f79f.jpg',15000,NULL,20,NULL,13),(59,'ADMIN','2023-09-18 13:36:08.804000',NULL,NULL,_binary '',NULL,'','Trà tắc','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018968/54902875-6a3b-40c8-9d17-e3215a485183.jpg',10000,NULL,20,NULL,13),(60,'ADMIN','2023-09-18 13:36:36.769000',NULL,NULL,_binary '',NULL,'','Trà tắc bigsize','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018996/79ba9fc1-099d-424b-85b2-3daeb38a60e0.jpg',15000,NULL,20,NULL,13),(61,'ADMIN','2023-09-18 13:37:18.976000',NULL,NULL,_binary '',NULL,'','Trà đào cam sả','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695019038/d0e3492d-85f3-418b-b48b-1c757dd61061.jpg',15000,NULL,20,NULL,13),(62,'ADMIN','2023-09-18 13:37:53.862000',NULL,NULL,_binary '',NULL,'','Trà đào cam sả bigsize','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695019073/341a2cd7-4b32-43e9-9a0f-b046119bf1c4.jpg',20000,NULL,20,NULL,13),(63,'ADMIN','2023-09-18 13:48:29.257000',NULL,NULL,_binary '',NULL,'','Bún chả','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695019708/57827a91-5a45-4ee6-81d6-db3a7db26038.jpg',30000,NULL,21,NULL,11),(64,'ADMIN','2023-09-18 13:56:22.677000',NULL,NULL,_binary '',NULL,'','Bánh cuốn trứng 1 quả','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020182/7ffabdfd-3ac4-4200-a87f-68a5fdaf283e.jpg',16000,NULL,21,NULL,14),(65,'ADMIN','2023-09-18 13:58:31.432000',NULL,NULL,_binary '',NULL,'','Bánh cuốn không hành chả nướng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020310/7665a34a-68ef-4e5d-a60c-01c58044d88a.jpg',32000,NULL,21,NULL,14),(66,'ADMIN','2023-09-18 14:01:04.187000',NULL,NULL,_binary '',NULL,'','Bánh cuốn không hành chả quế ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020463/8d51d2ac-2aec-442b-9820-990771441605.jpg',27000,NULL,21,NULL,14),(67,'ADMIN','2023-09-18 14:06:17.755000',NULL,NULL,_binary '',NULL,'Bánh cuốn có nhân hành + chả quế thơm','Bánh cuốn nhân hành chả quế','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020777/e49e7a88-d135-4dd7-860e-95518dc027b7.jpg',27000,NULL,21,NULL,14),(68,'ADMIN','2023-09-18 14:06:59.254000',NULL,NULL,_binary '',NULL,'Bánh cuốn nhân hành + chả nướng thơm','Bánh cuốn nhân hành chả nướng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020818/c913bf2b-0593-435f-9ea5-a4e30f14b786.jpg',32000,NULL,21,NULL,14),(69,'ADMIN','2023-09-20 12:32:19.950000',NULL,NULL,_binary '',NULL,'','Mì trộn thập cẩm nhiều mì topping chiên','',42000,NULL,22,NULL,11),(70,'ADMIN','2023-09-20 12:34:04.494000',NULL,NULL,_binary '',NULL,'','Mì trộn thập cẩm topping chiên','',33000,NULL,22,NULL,11),(71,'ADMIN','2023-09-20 12:41:12.771000',NULL,NULL,_binary '',NULL,'','Mì Trộn Thập Cẩm','',29000,NULL,22,NULL,11),(72,'ADMIN','2023-09-20 18:57:36.981000',NULL,NULL,_binary '',NULL,'','Mì Trộn Thập Cẩm Nhiều Mì','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695211056/3ad67809-993b-45d5-9a12-f93b147878a1.jpg',35000,NULL,22,NULL,11),(73,'ADMIN','2023-09-20 19:02:22.677000',NULL,NULL,_binary '',NULL,'','Mì Trộn Xúc Xích','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695211342/e2005ff0-9746-42ad-b623-de5161e2c76b.jpg',25000,NULL,22,NULL,11),(74,'ADMIN','2023-09-20 19:16:29.675000',NULL,NULL,_binary '',NULL,'','Mì trộn trứng cút','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212188/817ef15f-f80c-4eb5-acd9-1fec823a9361.jpg',25000,NULL,22,NULL,11),(75,'ADMIN','2023-09-20 19:17:39.291000',NULL,NULL,_binary '',NULL,'','Mì trộn tôm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212258/e756b185-3301-4615-96d4-cdad5a8d5862.jpg',29000,NULL,22,NULL,11),(76,'ADMIN','2023-09-20 19:19:14.583000',NULL,NULL,_binary '',NULL,'','Mì trộn sủi cảo nhân thịt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212354/2de3d8a7-dfd0-4ace-80c5-1caaaaf1bd62.jpg',29000,NULL,22,NULL,11),(77,'ADMIN','2023-09-20 19:20:55.467000',NULL,NULL,_binary '',NULL,'','Mì trộn mực xoắn','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212454/8b4b6a66-7b62-4bca-81be-e75e7b7f8d81.jpg',29000,NULL,22,NULL,11),(78,'ADMIN','2023-09-20 19:21:23.330000',NULL,NULL,_binary '',NULL,'','Mì trộn hồ lô','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212482/6879e123-bb61-4c54-af13-24f449de6aa6.jpg',29000,NULL,22,NULL,11),(79,'ADMIN','2023-09-20 19:21:51.300000',NULL,NULL,_binary '',NULL,'','Mì trộn bò khô','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212510/1e9de8fc-a285-45c8-b1a4-a55a397b7191.jpg',29000,NULL,22,NULL,11),(80,'ADMIN','2023-09-20 19:22:19.751000',NULL,NULL,_binary '',NULL,'','Mì trộn bò viên','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212539/1332e234-fc6e-4a1f-9f2c-4f4793f79d83.jpg',29000,NULL,22,NULL,11),(81,'ADMIN','2023-09-20 19:23:48.866000',NULL,NULL,_binary '',NULL,'','Kim bắp chiên - 2','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212628/84b4121d-6b36-4e49-8bdf-071f88e65072.jpg',35000,NULL,22,NULL,9),(82,'ADMIN','2023-09-20 19:24:29.941000',NULL,NULL,_binary '',NULL,'','Mì trộn tôm viên','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212669/b1fe6d1b-510e-458e-a3c7-6dc37f5a7577.jpg',29000,NULL,22,NULL,11),(83,'ADMIN','2023-09-20 19:27:00.524000',NULL,NULL,_binary '',NULL,'','Kim bắp chiên - 5','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212820/d78b290e-cbde-4c6d-b5d2-b38c21fc0429.jpg',85000,NULL,22,NULL,9),(84,'ADMIN','2023-09-20 19:29:14.539000',NULL,NULL,_binary '',NULL,'','Mì Trộn Thập Cẩm + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212954/37f14297-2cfc-44d9-a43b-9b620f6cb070.jpg',40000,NULL,22,NULL,11),(85,'ADMIN','2023-09-20 19:29:52.669000',NULL,NULL,_binary '',NULL,'','Mì Trộn Bò Khô + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695212992/c2475438-c38c-49dd-824a-942f04a022fe.jpg',40000,NULL,22,NULL,11),(86,'ADMIN','2023-09-20 19:30:34.091000',NULL,NULL,_binary '',NULL,'','Mì Trộn Tôm + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213032/aa0be823-5e92-4a45-a3db-279d700855cb.jpg',40000,NULL,22,NULL,11),(87,'ADMIN','2023-09-20 19:31:09.798000',NULL,NULL,_binary '',NULL,'','Mì Trộn Bò Viên + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213069/bd88ce4c-8041-4e7c-9a0e-5ab4dc7d2fcd.jpg',40000,NULL,22,NULL,11),(88,'ADMIN','2023-09-20 19:31:49.032000',NULL,NULL,_binary '',NULL,'','Mì Trộn Tôm Viên + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213108/c7fe50fe-d301-4815-a768-cac5792a9932.jpg',40000,NULL,22,NULL,11),(89,'ADMIN','2023-09-20 19:32:25.956000',NULL,NULL,_binary '',NULL,'','Mì Trộn Mực Xoắn + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213145/f13dde07-e436-48c7-bf89-e9d954d7958f.jpg',40000,NULL,22,NULL,11),(90,'ADMIN','2023-09-20 19:33:05.957000',NULL,NULL,_binary '',NULL,'','Mì Trộn Hồ Lô + Pepsi','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213185/949e0b4e-49ec-4664-845c-31f7f5f3a2df.jpg',40000,NULL,22,NULL,11),(91,'ADMIN','2023-09-20 19:33:58.886000',NULL,NULL,_binary '',NULL,'','Mì Trộn Rau Củ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213238/a8e5c2fb-3f49-4892-96c3-bca92bfe1e17.jpg',18000,NULL,22,NULL,11),(92,'ADMIN','2023-09-20 19:37:05.111000',NULL,NULL,_binary '',NULL,'','Mì trộn thập cẩm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213424/d79f1f42-bd10-47fb-86de-54c40b35a240.jpg',28000,NULL,22,NULL,11),(93,'ADMIN','2023-09-20 19:37:56.737000',NULL,NULL,_binary '',NULL,'','Nem chua rán 5 cái','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213475/df33f4c0-00da-4872-83ac-b9c7bcae3799.jpg',28000,NULL,22,NULL,9),(94,'ADMIN','2023-09-20 19:38:50.200000',NULL,NULL,_binary '',NULL,'','Gà xiên que (1 xiên)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213529/0b630729-c818-430c-8061-a5a2e2a90380.jpg',14000,NULL,22,NULL,9),(95,'ADMIN','2023-09-20 19:39:25.798000',NULL,NULL,_binary '',NULL,'','Xúc xích chiên','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213565/578b3980-1b32-497e-aa3b-b505e036c61a.jpg',11000,NULL,22,NULL,9),(96,'ADMIN','2023-09-20 19:41:29.379000',NULL,NULL,_binary '',NULL,'','Đùi gà chiên xù (1 đùi)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213688/7dcd8416-9437-4365-add9-e294a1677643.jpg',35000,NULL,22,NULL,9),(97,'ADMIN','2023-09-20 19:42:53.913000',NULL,NULL,_binary '',NULL,'','Sủi cảo chiên (5 cái)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213773/1867fd42-791a-43f5-abff-e0ae8f2daca8.jpg',24000,NULL,22,NULL,9),(98,'ADMIN','2023-09-20 19:43:24.087000',NULL,NULL,_binary '',NULL,'','Mực xoắn chiên (5 cái)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213803/bda23414-382c-4fc4-a02c-25b4621e8b0d.jpg',24000,NULL,22,NULL,9),(99,'ADMIN','2023-09-20 19:44:14.153000',NULL,NULL,_binary '',NULL,'','Khoai lang lệ phố (5 viên)','',24000,NULL,22,NULL,9),(100,'ADMIN','2023-09-20 19:45:25.096000',NULL,NULL,_binary '',NULL,'','Tôm viên chiên (10 viên)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213924/7457fabd-6f01-4c0b-b16c-6cfe595c8ad7.jpg',26000,NULL,22,NULL,9),(101,'ADMIN','2023-09-20 19:46:00.693000',NULL,NULL,_binary '',NULL,'','Khoai lang kén (10 viên)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695213959/64670bc2-fcd2-4ad6-929b-b502a1c80e0f.jpg',26000,NULL,22,NULL,9),(102,'ADMIN','2023-09-20 19:46:48.302000',NULL,NULL,_binary '',NULL,'','Kim bắp chiên (1 cái)','',17000,NULL,22,NULL,9),(103,'ADMIN','2023-09-20 19:47:49.053000',NULL,NULL,_binary '',NULL,'','Tôm con chiên (x5)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214068/aa6247c5-dbdd-4c4b-8a56-42c57054cd21.jpg',20000,NULL,22,NULL,9),(104,'ADMIN','2023-09-20 19:48:21.119000',NULL,NULL,_binary '',NULL,'','Hồ lô chiên (x5)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214100/20734703-e161-439d-a6d7-34e6e14cc846.jpg',20000,NULL,22,NULL,9),(105,'ADMIN','2023-09-20 19:49:23.476000',NULL,NULL,_binary '',NULL,'','Bò khô (1 túi to)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214162/a2c2b0fa-ddb4-4ab2-843d-2190a51690cc.jpg',38000,NULL,22,NULL,9),(106,'ADMIN','2023-09-20 19:49:55.663000',NULL,NULL,_binary '',NULL,'','Bò viên chiên (x10)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214194/48f7ce6f-0131-4d90-acc3-f9ca118beb4e.jpg',25000,NULL,22,NULL,9),(107,'ADMIN','2023-09-20 19:51:33.484000',NULL,NULL,_binary '',NULL,'','Bánh gà nhân phô mai (x2)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214293/4b378846-d4e2-4ffe-9859-740e34ac8e6a.jpg',24000,NULL,22,NULL,9),(108,'ADMIN','2023-09-20 19:52:25.342000',NULL,NULL,_binary '',NULL,'','Bánh gà nhân phô mai (x5)','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695214344/ff1fe749-cc84-4450-98c6-d53674e7cb53.jpg',60000,NULL,22,NULL,9),(111,'ADMIN','2023-09-24 20:40:57.726000',NULL,NULL,_binary '',NULL,'Cà phê ngọt pha chút mặn và có kem','Cà phê muối','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695562856/be837359-abf9-4bdd-a699-e3128073f4c7.png',25000,NULL,20,NULL,13),(112,'ADMIN','2023-09-24 20:42:47.334000',NULL,NULL,_binary '',NULL,'Đi học buồn ngủ làm cốc cho tỉnh đi bạn','Bạc xỉu','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695562966/0336db39-8e3d-40d7-9b6d-165bdc7532c8.jpg',22000,NULL,20,NULL,13),(113,'ADMIN','2023-09-24 20:44:22.106000',NULL,NULL,_binary '',NULL,'','Cà phê nâu đá','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695563061/1be52ad8-2c3b-442b-9c60-fc5c5d5f587e.jpg',15000,NULL,20,NULL,13),(114,'ADMIN','2023-09-24 20:46:23.210000',NULL,NULL,_binary '',NULL,'','Cà phê đen đá','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695563182/d4554434-e827-47ff-9a1e-61cd98fc744f.png',12000,NULL,20,NULL,13),(115,'ADMIN','2023-09-24 20:54:25.445000',NULL,NULL,_binary '',NULL,'','Bánh cuốn nhân thịt không chả','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695563664/ef4f9197-56b2-4163-831c-a15d2eba434a.jpg',22000,NULL,21,NULL,14),(116,'ADMIN','2023-09-24 20:57:17.835000',NULL,NULL,_binary '',NULL,'Mì ăn tẩm bổ cho các bạn đang trong thời gian ôn thi. Vì gà ác nên giá hơi cao','Mì gà ác tần','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695563837/3005804e-7019-44b3-aafd-45ea2bc3ddd2.jpg',75000,NULL,21,NULL,11),(117,'ADMIN','2023-09-24 20:58:56.027000',NULL,NULL,_binary '',NULL,'','Mì đùi gà tần','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695563935/031befdb-feec-4018-b8bb-27a4407fa8f1.jpg',57000,NULL,21,NULL,11),(118,'ADMIN','2023-09-24 21:48:17.586000',NULL,NULL,_binary '',NULL,'','Bánh mì thịt nướng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695566897/9347804e-dd33-4730-bb22-3e05bf3a0a6d.jpg',25000,NULL,23,NULL,8),(119,'ADMIN','2023-09-25 10:03:12.284000',NULL,NULL,_binary '',NULL,'Ngon từ đậu, thơm từ mắm tôm','Bún đậu đầy đủ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695610991/87886c22-a9fb-419f-a9b3-05099cfb9d60.jpg',35000,NULL,24,NULL,11),(120,'ADMIN','2023-09-25 10:05:23.443000',NULL,NULL,_binary '',NULL,'Đỉnh cao, món ăn của dân chuyên','Bún giả cầy','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695611122/752f5e5e-722c-4021-a457-128c89402043.jpg',40000,NULL,24,NULL,11),(121,'ADMIN','2023-09-25 10:06:57.292000',NULL,NULL,_binary '',NULL,'','Bún đậu chả cốm - thịt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695611216/dc941f88-8290-4d03-bd58-47f69a00c11c.jpg',30000,NULL,24,NULL,11),(122,'ADMIN','2023-09-25 10:08:17.633000',NULL,NULL,_binary '',NULL,'','Bún đậu ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695611297/d53a8630-f196-4e2c-a247-afc9faffb81d.jpg',25000,NULL,24,NULL,11),(123,'ADMIN','2023-09-25 10:36:13.185000',NULL,NULL,_binary '',NULL,'Đã bao gồm 5k tiền hộp','Bún riêu bề bề bò','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695612972/5b68ff72-87e2-46c2-bbba-18fd8e5dd918.jpg',45000,NULL,25,NULL,11),(124,'ADMIN','2023-09-25 10:37:29.478000',NULL,NULL,_binary '',NULL,'','Bún riêu đầy đủ không đậu phụ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613048/45a54ec9-d5c4-4b01-9edf-c158e1c1d09d.jpg',55000,NULL,25,NULL,11),(125,'ADMIN','2023-09-25 10:38:19.064000',NULL,NULL,_binary '',NULL,'Đã bao gồm 5k tiền hộp','Bún riêu bề sườn sụn','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613098/db817631-cea0-488d-bbb4-d33884dd795b.jpg',45000,NULL,25,NULL,11),(126,'ADMIN','2023-09-25 10:38:57.845000',NULL,NULL,_binary '',NULL,'Đã bao gồm 5k tiền hộp','Bún riêu bề mực','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613137/29a90bf6-f9cf-402d-8121-0c712c7ba76c.jpg',55000,NULL,25,NULL,11),(127,'ADMIN','2023-09-25 10:41:51.159000',NULL,NULL,_binary '',NULL,'','Quẩy','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613310/889e3feb-9e10-4440-a8c0-a16578c61a1d.jpg',5000,NULL,25,NULL,11),(128,'ADMIN','2023-09-25 10:44:31.408000',NULL,NULL,_binary '',NULL,'Đã bao gồm 5k tiền hộp','Bún riêu thập cẩm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613470/1c05e8f1-155f-48ea-8f2c-d432437c0cdb.jpg',55000,NULL,25,NULL,11),(129,'ADMIN','2023-09-25 10:49:57.037000',NULL,NULL,_binary '',NULL,'','Bún riêu sườn sụn','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613796/01b3783f-16c1-493c-a050-3a8616eabe0c.jpg',45000,NULL,25,NULL,11),(130,'ADMIN','2023-09-25 10:50:15.551000',NULL,NULL,_binary '',NULL,'','Cơm rang thập cẩm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613815/5c65d492-ac63-4dcd-acb2-36ae61bd8d74.jpg',26000,NULL,26,NULL,10),(131,'ADMIN','2023-09-25 10:50:57.971000',NULL,NULL,_binary '',NULL,'Đã bao gồm 5k tiền hộp','Bún riêu bò','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613857/b873ad47-1fbb-4cac-8053-8e9f894aa3c9.jpg',45000,NULL,25,NULL,11),(132,'ADMIN','2023-09-25 10:50:59.154000',NULL,NULL,_binary '',NULL,'','Cơm rang trứng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613858/cb475d50-c0ab-4498-994f-89c0892a27fe.jpg',26000,NULL,26,NULL,10),(133,'ADMIN','2023-09-25 10:51:56.623000',NULL,NULL,_binary '',NULL,'','Cơm rang dưa bò','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613915/c3c26546-2c76-4efc-abef-b0d4f53f1113.jpg',31000,NULL,26,NULL,10),(134,'ADMIN','2023-09-25 10:52:20.889000',NULL,NULL,_binary '',NULL,'','Cơm rang cải bò','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613940/0cc8089d-8c48-481f-acdc-94aed432b878.jpg',31000,NULL,26,NULL,10),(135,'ADMIN','2023-09-25 10:52:54.855000',NULL,NULL,_binary '',NULL,'','Cơm đùi gà xối mắm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695613974/33cf62b2-d0e9-410e-9e36-ace658f7e388.jpg',36000,NULL,26,NULL,10),(136,'ADMIN','2023-09-25 10:53:44.014000',NULL,NULL,_binary '',NULL,'','Phở tái','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614023/5fe8dade-f947-4e66-941e-2a536d26026b.jpg',32000,NULL,26,NULL,11),(137,'ADMIN','2023-09-25 10:54:14.714000',NULL,NULL,_binary '',NULL,'','Phở chín','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614054/6e635528-68b7-492d-bbf8-0938d8959be8.jpg',32000,NULL,26,NULL,11),(138,'ADMIN','2023-09-25 10:54:41.948000',NULL,NULL,_binary '',NULL,'','Phở tái chín','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614081/c2b6a184-0784-4bf2-85bb-e0c9c394d4d2.jpg',32000,NULL,26,NULL,11),(139,'ADMIN','2023-09-25 10:55:08.780000',NULL,NULL,_binary '',NULL,'','Phở tái nạm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614108/f897c8aa-09d4-465c-81c2-644204d2392b.jpg',37000,NULL,26,NULL,11),(140,'ADMIN','2023-09-25 10:56:07.893000',NULL,NULL,_binary '',NULL,'','Phở tái lăn','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614167/8cfa11af-74bf-47f0-926b-1add695c3679.jpg',37000,NULL,26,NULL,11),(141,'ADMIN','2023-09-25 10:58:08.405000',NULL,NULL,_binary '',NULL,'','Phở áp xào mềm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614287/76f88f86-c067-4d02-b8d2-72823e4ea35a.jpg',37000,NULL,26,NULL,11),(142,'ADMIN','2023-09-25 10:58:40.488000',NULL,NULL,_binary '',NULL,'','Mỳ xào mềm','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614319/33868e68-4e08-4ef1-a310-89007ce3d0a7.jpg',37000,NULL,26,NULL,11),(143,'ADMIN','2023-09-25 11:00:06.512000',NULL,NULL,_binary '',NULL,'','Phở áp chảo','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695614406/8418e376-5e1e-4927-a2bf-8a0f90f60f9c.jpg',37000,NULL,26,NULL,11),(144,'ADMIN','2023-09-25 11:21:01.478000',NULL,NULL,_binary '',NULL,'','Gà quay mật ong sốt teriyaki','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615661/2a9a2a02-4684-4141-8056-607b8b5e6401.jpg',37000,NULL,27,NULL,10),(145,'ADMIN','2023-09-25 11:21:58.828000',NULL,NULL,_binary '',NULL,'','Cơm gà nướng sốt BBQ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615718/c2589eb9-63b9-460a-b4b8-832649e20784.jpg',37000,NULL,27,NULL,10),(146,'ADMIN','2023-09-25 11:23:26.182000',NULL,NULL,_binary '',NULL,'','Cơm thịt xá xíu bỏ lò','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615805/4fe440c8-eb91-4c09-87ac-d49a88dadf85.jpg',37000,NULL,27,NULL,10),(147,'ADMIN','2023-09-25 11:24:15.595000',NULL,NULL,_binary '',NULL,'','Cơm bò sốt tiêu','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615855/d8aa0a4d-f307-4ed7-8197-4c4a7d1f1449.jpg',42000,NULL,27,NULL,10),(148,'ADMIN','2023-09-25 11:25:20.567000',NULL,NULL,_binary '',NULL,'','Cơm sườn nướng sốt ngũ vị','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615919/88a7a54c-9323-43bc-9db1-52a292c84e70.jpg',42000,NULL,27,NULL,10),(149,'ADMIN','2023-09-25 11:26:44.149000',NULL,NULL,_binary '',NULL,'','Cơm sườn xào sốt chua ngọt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695616003/d9d5769d-43be-4fda-81fc-305498926266.jpg',42000,NULL,27,NULL,10),(150,'ADMIN','2023-10-07 00:52:45.063000',NULL,NULL,_binary '',NULL,'','Bún bò Huế','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696614764/728f1592-d5e6-45db-8231-fa70f2605f4c.jpg',35000,NULL,28,NULL,11),(151,'ADMIN','2023-10-07 00:53:12.609000',NULL,NULL,_binary '',NULL,'','Bún bò huế đầy đủ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696614792/ee731fd9-94e4-4461-ba0c-46ed4b606690.jpg',50000,NULL,28,NULL,11),(152,'ADMIN','2023-10-07 01:28:38.180000',NULL,NULL,_binary '',NULL,'Bún trắng, Thịt bò xào, giá trần, trứng luộc, cà rốt, xà lách, hành phi, lạc rang, nước trộn.(Quý khách vui lòng trộn đều cùng nước trộn kèm theo trước khi dùng nhé). CHÚC QUÝ KHÁCH NGON MIỆNG',' Bún trộn Nam Bộ','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696616917/861bb5eb-d8dc-4eeb-9c85-2e6da86738e0.jpg',42000,NULL,29,NULL,11),(153,'ADMIN','2023-10-07 01:30:59.372000',NULL,NULL,_binary '',NULL,'Bún trắng, nem nướng lụi, giá trần, trứng luộc, cà rốt, xà lách, hành phi, lạc rang, nước trộn.(Quý khách vui lòng trộn đều cùng nước trộn kèm theo trước khi dùng nhé). CHÚC QUÝ KHÁCH NGON MIỆNG','Bún trộn nem nướng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617058/167f1cc7-4737-4ad0-8994-f83b5a266d3e.jpg',45500,NULL,22,NULL,11),(154,'ADMIN','2023-10-07 01:32:06.747000',NULL,NULL,_binary '',NULL,'Bún trắng, nem nhân thịt, giá trần, trứng luộc, cà rốt, xà lách, hành phi, lạc rang, nước trộn.(Quý khách vui lòng trộn đều cùng nước trộn kèm theo trước khi dùng nhé). CHÚC QUÝ KHÁCH NGON MIỆNG','Bún trộn nem thịt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617126/16d6047a-ea2a-40ac-9498-c315da7e2bfd.jpg',42000,NULL,29,NULL,11),(155,'ADMIN','2023-10-07 01:32:47.872000',NULL,NULL,_binary '',NULL,'Bún trắng, Thịt bò xào, xúc xích, nem nướng lụi, nem nhân thịt,giá trần, trứng luộc, cà rốt, xà lách, hành phi, lạc rang, nước trộn.(Quý khách vui lòng trộn đều cùng nước trộn kèm theo trước khi dùng nhé). CHÚC QUÝ KHÁCH NGON MIỆNG','Bún trộn đặc biệt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617167/eaf93f4a-8c10-4b6d-9e62-3054158ea276.jpg',69000,NULL,29,NULL,11),(156,'ADMIN','2023-10-07 01:33:59.652000',NULL,NULL,_binary '',NULL,'Bún trắng, xúc xích, giá trần, trứng luộc, cà rốt, xà lách, hành phi, lạc rang, nước trộn.(Quý khách vui lòng trộn đều cùng nước trộn kèm theo trước khi dùng nhé). CHÚC QUÝ KHÁCH NGON MIỆNG','Bún trộn xúc xích','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617238/3ce4b36b-5ab1-4a38-84dd-f5d6fb8b77f8.jpg',42000,NULL,29,NULL,11),(157,'ADMIN','2023-10-07 01:44:03.874000',NULL,NULL,_binary '',NULL,'','Cơm tấm sườn nướng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617843/79fddfaf-56b5-47de-88d9-e29cbaf37030.jpg',42600,NULL,30,NULL,10),(158,'ADMIN','2023-10-07 01:44:27.798000',NULL,NULL,_binary '',NULL,'','Cơm Tấm Sườn Nướng Trứng Ốp La','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617867/c63808e3-fbc7-4e3e-9bf3-1ed79418b7ae.jpg',49200,NULL,30,NULL,10),(159,'ADMIN','2023-10-07 01:45:14.110000',NULL,NULL,_binary '',NULL,'Cơm nóng, trứng ốp la 2 quả','Cơm Tấm Trứng Ốp La','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617913/b61b7def-1e23-48c2-ba47-8190b1b00e90.jpg',22800,NULL,30,NULL,10),(160,'ADMIN','2023-10-07 01:45:46.655000',NULL,NULL,_binary '',NULL,'Cơm tấm sườn, bì, chả, trứng','Cơm Tấm Đặc Biệt','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617945/26b9c063-22c8-40a1-b6b4-dc425f291422.jpg',55800,NULL,30,NULL,10),(161,'ADMIN','2023-10-07 01:46:16.213000',NULL,NULL,_binary '',NULL,'','Cơm Tấm Chả - Trứng Ốp','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617975/c804d2aa-9615-41a1-bc8d-a7aa1fa71a67.jpg',34800,NULL,30,NULL,10),(162,'ADMIN','2023-10-07 01:47:01.233000',NULL,NULL,_binary '',NULL,'','Cơm Tấm Sà Bì Chưởng','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696618020/055f2971-f990-47e1-ad6e-eea6fd17024d.jpg',49200,NULL,30,NULL,10),(163,'A41825','2023-10-07 02:08:47.366000',NULL,NULL,_binary '',NULL,'Chua nhẹ, mát lạnh, ngọt êm, vị trà (hồng trà) vừa đủ làm nổi bật và lan tỏa trọn vẹn mùi thơm đặc biệt của quất tươi vừa chín tới. Ngon hơn khi thêm topping nha đam, trân châu trắng','Trà quất truyền thống','http://res.cloudinary.com/ddmwuvynh/image/upload/v1696620297/056e4784-b73e-4010-850a-79dea41cbe2e.jpg',12500,NULL,31,NULL,9);
/*!40000 ALTER TABLE `food_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_table`
--

DROP TABLE IF EXISTS `log_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_table` (
  `log_id` int NOT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  KEY `FKm0h4dar3hkj00i9mvtj2bttxw` (`log_id`),
  CONSTRAINT `FK7th5wmhorqjxdnkkkdacylw73` FOREIGN KEY (`log_id`) REFERENCES `type_food_entity` (`id`),
  CONSTRAINT `FKm0h4dar3hkj00i9mvtj2bttxw` FOREIGN KEY (`log_id`) REFERENCES `voucher_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_table`
--

LOCK TABLES `log_table` WRITE;
/*!40000 ALTER TABLE `log_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_entity`
--

DROP TABLE IF EXISTS `message_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `account_entity_id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `room_chat_entity_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeorgq3kemoe4ogwal7xalb482` (`account_entity_id`),
  KEY `FKdpjga7w7maniusm317xkjgkk4` (`room_chat_entity_id`),
  CONSTRAINT `FKdpjga7w7maniusm317xkjgkk4` FOREIGN KEY (`room_chat_entity_id`) REFERENCES `room_chat_entity` (`id`),
  CONSTRAINT `FKeorgq3kemoe4ogwal7xalb482` FOREIGN KEY (`account_entity_id`) REFERENCES `account_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_entity`
--

LOCK TABLES `message_entity` WRITE;
/*!40000 ALTER TABLE `message_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_entity`
--

DROP TABLE IF EXISTS `restaurant_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `distance` double DEFAULT NULL,
  `img_res` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `quantity_sold` int DEFAULT NULL,
  `restaurant_name` varchar(255) DEFAULT NULL,
  `star` double DEFAULT NULL,
  `time` int DEFAULT NULL,
  `time_close` varchar(255) DEFAULT NULL,
  `time_start` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_entity`
--

LOCK TABLES `restaurant_entity` WRITE;
/*!40000 ALTER TABLE `restaurant_entity` DISABLE KEYS */;
INSERT INTO `restaurant_entity` VALUES (18,'ADMIN','2023-09-18 09:44:19.793000',NULL,NULL,_binary '','Số 28 Ngõ 282 Đường Kim Giang, P. Đại Kim, Hoàng Mai, Hà Nội','Quán chè sinh viên gần trường Đại học Thăng Long. Mùa hè nóng bức làm cốc chè còn gì bằng',1.23,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005059/60c64dae-674a-4063-be35-170b5a95321f.jpg','0971526266 - 0888289220',2,'Chè Nhi Quán - Kim Giang',5,NULL,'21:00','09:00'),(19,'ADMIN','2023-09-18 10:36:56.301000',NULL,NULL,_binary '','52 Kim Giang, P. Đại Kim, Hoàng Mai, Hà Nội','Quán nem nướng ngon nhiều topping. Các loại nem thường được chế biến từ thịt, tôm, hoặc các loại rau sống, và được cuốn trong lá bánh tráng mỏng. Không những vậy quán còn rất nhiều các món khác',1.5,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695008215/b1925607-e571-4d64-b046-8aab186f80f6.jpg','0966380952',0,'Nem Nướng Nha Trang - Gia Linh',5,NULL,'22:00','09:00'),(20,'ADMIN','2023-09-18 13:02:10.312000',NULL,NULL,_binary '','Số 36 ngõ 250 Kim Giang, Hoàng Mai, Hà Nội','Quán bánh mì tọa lạc tại Kim Giang, Bánh mì cùng với chả nóng sự kết hợp hoàn hảo. Không những vậy quán còn có những món khác mời bạn thưởng thức',0.6,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695016929/ad18406d-f641-4f2a-86b7-800cfa9a836a.jpg','0384296768',0,'Bánh mì chả nóng, bánh tráng trộn Kim Giang',5,NULL,'22:00','09:00'),(21,'ADMIN','2023-09-18 13:46:59.503000',NULL,NULL,_binary '','32 Kim Giang, P. Kim Giang, Thanh Xuân, Hà Nội','Quán bánh cuốn ngon uy tín nhưng đóng cửa vào đầu giờ chiều các bạn nhớ đặt hàng sớm sớm chút nhé',1.6,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695019619/53e0c1e2-7cd6-42b1-97b1-d252aac50ddd.jpg','0986699067',0,'Bánh Cuốn, Bún Chả & Gà Tần - Ba Duy ',5,NULL,'13:00','07:00 '),(22,'ADMIN','2023-09-20 12:23:32.091000',NULL,NULL,_binary '','10 Ngõ 282 Kim Giang, Hoàng Mai, Hà Nội','Mì Trộn Indomie tại Kim Giang - Đức Food là sự kết hợp độc đáo của mì Indomie tươi ngon, thấm đẫm gia vị, và các thành phần tươi ngon khác như rau sống, thịt, và gia vị đậy hương vị. Một trải nghiệm ẩm thực độc đáo và ngon miệng.',0.6,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695187410/030eaa69-f7cb-4e91-8519-96e7cd69ae54.jpg','0357662474',6,'Mì Trộn Indomie - Kim Giang - Đức Food ',5,NULL,'23:59','0.00'),(23,'ADMIN','2023-09-24 21:37:17.283000',NULL,NULL,_binary '','86 Kim Giang, Đại Kim, Hoàng Mai, Hà Nội','Quán bánh mì hải phòng nổi tiêng hoàng mai. Không những vậy bánh mì chảo còn có nước sốt chua ngọt đậm đà chiều lòng mọi vị khách',1.1,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695566236/dca8693d-34d7-4c3f-82ce-f64a4b9a1158.jpg','0352727686 - 0344767660',0,'Pate cột đèn - Kim Giang',5,NULL,'10:00','7:00'),(24,'ADMIN','2023-09-24 22:07:43.682000',NULL,NULL,_binary '','XR7H+H7V, Khu đô thị Linh Đàm, Hoàng Mai, Hà Nội, Việt Nam','Quán bún đậu Linh Đàm giá cả hợp lí. Đậu chiên ngoài giòn trong mềm, thịt chân giò , và các topping đặc biệt,... Bạn hãy thử nhé',2.4,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695568062/ce8776bf-0580-4ed2-b9cf-1b1f712c2aef.jpg','0986061597',0,'Bún đậu Đôn Béo - Linh Đàm',5,NULL,'13:00','8:00'),(25,'ADMIN','2023-09-24 22:19:19.210000',NULL,NULL,_binary '','Kiot 18 HH1C Linh Đàm, Linh Đường, Hoàng Mai, Hà Nội','Món bún riêu cua bề bề thường là một sự kết hợp ngon miệng của các hương vị: hấp dẫn của riêu cua, hương thơm của cà chua và gia vị, và hương vị biển của bề bề.',2.2,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695568758/10836017-7628-4a02-aa09-1ad83da0f298.jpg','0965874010',0,'Bún riêu cua bề bề - Linh Đàm',5,NULL,'21:00 ','6:00'),(26,'ADMIN','2023-09-24 22:51:17.662000',NULL,NULL,_binary '','150 Kim Giang, Hoàng Mai, Hà Nội','Cơm gà xối mắm là một món ăn truyền thống trong ẩm thực Việt Nam. Không những vậy quán còn bán phở nữa các bạn nhớ đặt hàng nhé,..',1,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695570676/fcd07add-31a5-4aed-8103-b723e912ef8c.jpg','0975800280',0,'Cơm gà xối mắm Kim Giang',5,NULL,'20:00','7:00'),(27,'ADMIN','2023-09-25 11:12:53.115000',NULL,NULL,_binary '','20 Ngõ 168 Kim Giang, P. Đại Kim, Hoàng Mai, Hà Nội','Quán cơm gà sốt và sườn sốt ngon, chiều lòng những vị khách khó tính nhất',0.9,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1695615172/831a8f27-2b05-43e8-bb38-51e0299948b1.jpg','0975528768',0,'Cơm gà & Cơm sườn - Kim Giang',5,NULL,'14:00','10:00'),(28,'ADMIN','2023-10-07 00:49:53.839000',NULL,NULL,_binary '','24 Kim Giang, P. Kim Giang, Thanh Xuân, Hà Nội','Quán bún bò Huế lâu đời truyền thống. Món này bao gồm một tô bún mềm mịn, được kết hợp với thịt bò nướng và một nước dùng đậm đà, thường được làm từ xương bò và gia vị.',1.7,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1696614593/4472ea97-b555-40cd-98cc-94429379371e.jpg','0364112222',0,'Bún bò huế Gia Bảo',5,NULL,'22:00','8:00'),(29,'ADMIN','2023-10-07 01:26:41.209000',NULL,NULL,_binary '','Số 10, 750/36 Đ. Kim Giang, Thanh Liệt, Thanh Trì, Hà Nội.','Bún trộn Nam Bộ là một món ăn phổ biến và ngon miệng trong ẩm thực Việt Nam. Món này có nguồn gốc ở miền Nam',1.9,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1696616800/4f453fb9-3778-4fda-bb76-10d4dddb388b.jpg','',0,'A Béo - Bún Trộn Nam Bộ - Kim Giang',5,NULL,'23:59','8:00'),(30,'ADMIN','2023-10-07 01:41:40.059000',NULL,NULL,_binary '','Số 8 ngõ 111 Nguyễn Xiển, P. Hạ Đình, Thanh Xuân, Hà Nội','Quán cơm ngon Nguyễn Xiển. Bạn hãy thử nhé!',1.6,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1696617699/440c7f6d-5532-4c55-b530-8e29e479bbe6.jpg','',0,'Cơm Tấm Sườn Nướng & Gà Ủ Muối - Nguyễn Xiển',5,NULL,'22:00','7:00'),(31,'ADMIN','2023-10-07 01:56:29.634000',NULL,NULL,_binary '','Ki ốt 07, Tòa D, Vinaconex 2, KĐT Kim Văn Kim Lũ, P. Đại Kim, Hoàng Mai, Hà Nội','Quán trà sữa gần Trường Đại học Thăng Long. Khi quá chán với Mixue sao bạn không thử nhỉ <3',0.5,'http://res.cloudinary.com/ddmwuvynh/image/upload/v1696618588/8f1fffbd-7f70-4c0c-8f49-004b59566989.jpg','',0,'2!Tea - Trà Sữa, Trà Chanh & Đồ Ăn Vặt - KĐT Kim Văn Kim Lũ',5,NULL,'17:00','8:00');
/*!40000 ALTER TABLE `restaurant_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_entity`
--

DROP TABLE IF EXISTS `role_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_entity`
--

LOCK TABLES `role_entity` WRITE;
/*!40000 ALTER TABLE `role_entity` DISABLE KEYS */;
INSERT INTO `role_entity` VALUES (1,NULL,NULL,NULL,NULL,NULL,'ADMIN'),(2,NULL,NULL,NULL,NULL,NULL,'USER'),(3,NULL,NULL,NULL,NULL,NULL,'EMPLOYEE');
/*!40000 ALTER TABLE `role_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_chat_entity`
--

DROP TABLE IF EXISTS `room_chat_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_chat_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `shipper_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_chat_entity`
--

LOCK TABLES `room_chat_entity` WRITE;
/*!40000 ALTER TABLE `room_chat_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_chat_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topping_entity`
--

DROP TABLE IF EXISTS `topping_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topping_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `food_entity_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `restaurant_entity_id` int DEFAULT NULL,
  `items` varchar(255) DEFAULT NULL,
  `requi` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKax98bnj85018yp0hc7xm6r7mc` (`food_entity_id`),
  KEY `FK84kwbamw5rvndrrsoew6l9ckj` (`restaurant_entity_id`),
  CONSTRAINT `FK84kwbamw5rvndrrsoew6l9ckj` FOREIGN KEY (`restaurant_entity_id`) REFERENCES `restaurant_entity` (`id`),
  CONSTRAINT `FKax98bnj85018yp0hc7xm6r7mc` FOREIGN KEY (`food_entity_id`) REFERENCES `food_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topping_entity`
--

LOCK TABLES `topping_entity` WRITE;
/*!40000 ALTER TABLE `topping_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `topping_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_food_entity`
--

DROP TABLE IF EXISTS `type_food_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_food_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `img_type` varchar(255) DEFAULT NULL,
  `name_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_food_entity`
--

LOCK TABLES `type_food_entity` WRITE;
/*!40000 ALTER TABLE `type_food_entity` DISABLE KEYS */;
INSERT INTO `type_food_entity` VALUES (7,'ADMIN','2023-09-18 09:47:00.008000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005219/21b14be1-eabe-4806-b894-5fbe41866547.jpg','Chè'),(8,'ADMIN','2023-09-18 09:48:09.353000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005288/57b0b1be-dca3-4269-93ee-74029288fce8.jpg','Bánh mì'),(9,'ADMIN','2023-09-18 09:49:56.590000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005396/1dfb6b95-d628-4930-88b7-933958d6900a.jpg','Trà sữa/Ăn vặt'),(10,'ADMIN','2023-09-18 09:50:07.017000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005406/8a64335f-e008-4f04-bb64-d750c86d8bc4.jpg','Cơm/Xôi'),(11,'ADMIN','2023-09-18 09:51:22.018000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695005481/8cf1a992-6317-4fe9-a084-7a02b09cb35c.jpg','Bún/Mì'),(12,'ADMIN','2023-09-18 10:44:15.301000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695009712/a1972ae9-8c45-4e1e-9163-9e410e2cf8d7.jpg','Nem/Bánh xèo'),(13,'ADMIN','2023-09-18 13:34:05.504000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695018844/cd80aa4f-35fb-462e-876d-df947d2757c9.jpg','Đồ uống'),(14,'ADMIN','2023-09-18 13:54:50.255000',NULL,NULL,_binary '','http://res.cloudinary.com/ddmwuvynh/image/upload/v1695020089/6631982a-bae5-4d8e-8710-afcd6d647126.jpg','Bánh cuốn');
/*!40000 ALTER TABLE `type_food_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK66rggwh2ht8u9ig7hvam1jvai` (`role_id`),
  CONSTRAINT `FK66rggwh2ht8u9ig7hvam1jvai` FOREIGN KEY (`role_id`) REFERENCES `role_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(55,2),(56,2),(57,2),(58,2),(59,2),(60,2),(62,2),(64,2),(65,2),(66,2),(67,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(84,2),(85,2),(86,2),(87,2),(88,2),(89,2),(90,2),(91,2),(92,2),(93,2),(94,2),(95,2),(96,2),(97,2),(98,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher_entity`
--

DROP TABLE IF EXISTS `voucher_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `expired` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `discount` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher_entity`
--

LOCK TABLES `voucher_entity` WRITE;
/*!40000 ALTER TABLE `voucher_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `voucher_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'iot_food_04'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-13 18:08:37
