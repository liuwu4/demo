-- MySQL dump 10.13  Distrib 8.0.17, for osx10.14 (x86_64)
--
-- Host: localhost    Database: profile
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `address_name` varchar(255) NOT NULL COMMENT '详细地址',
  `login_id` int(11) NOT NULL COMMENT '地址关联的用户',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'测试修改地址',1),(2,'还是用户1的地址',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(18) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '12345' COMMENT '用户登录账号',
  `nickname` varchar(18) COLLATE utf8mb4_general_ci DEFAULT '0',
  `password` varchar(18) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '123456' COMMENT '用户登录密码',
  `sex` int(1) DEFAULT '2' COMMENT '0[男],1[女],2[保密], 性别',
  `phone` varchar(12) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '用户手机号',
  `address` int(11) DEFAULT '0' COMMENT '地址',
  `email` varchar(20) COLLATE utf8mb4_general_ci DEFAULT 'xx' COMMENT '用户邮箱',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1[启用], 0[禁用], 账号状态',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `phone_email` (`phone`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'1222234','admin','123',1,'15082000855',1,'1234',1,'2020-01-08 00:00:00'),(2,'1222234222','123413','13424',1,'12343214321',2,'@.com',2,'2020-01-08 08:21:44'),(5,'string','string','string',0,'1234',3,'string',1,'2020-01-22 22:01:35'),(8,'123ewds','string','string',0,'12345',4,'string',0,'2020-02-14 21:24:19'),(9,'12345','0','123456',2,'12345678901',5,'xx',1,'2020-02-16 19:55:30'),(11,'12345','0','123456',2,'12345678900',6,'xx',1,'2020-02-16 19:57:28');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `no` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '产品类型',
  `name` varchar(150) NOT NULL COMMENT '产品名称 ',
  `price` decimal(10,6) DEFAULT NULL COMMENT '产品价格',
  `number` int(11) NOT NULL DEFAULT '0' COMMENT '产品库存',
  `picture` varchar(200) DEFAULT NULL COMMENT '产品图片',
  `production_date` datetime NOT NULL COMMENT '生产日期',
  `production_address` varchar(200) DEFAULT NULL COMMENT '生产地址',
  `expiration_date` datetime DEFAULT NULL COMMENT '过期日期',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '产品状态[1: 上架, 0: 下架]',
  `description` varchar(255) DEFAULT NULL COMMENT '产品描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '产品备注',
  UNIQUE KEY `no` (`no`),
  KEY `fk_product_typ` (`type`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`type`) REFERENCES `product_type` (`type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('78282',20,'党委书记抓基层党建工作考核评议-2019第一季度',123.000000,123,NULL,'2020-03-05 13:53:54',NULL,NULL,1,NULL,NULL),('987',20,'istudy',12.000000,123,NULL,'2020-03-05 13:59:12',NULL,NULL,0,NULL,NULL),('123',123422,'132',123.000000,123,NULL,'2020-03-06 16:53:14',NULL,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品类型id',
  `type_name` varchar(155) NOT NULL COMMENT '产品类型名称',
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_id` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123425 DEFAULT CHARSET=utf8 COMMENT='产品类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (5,'1234214'),(11,'测试类型23'),(20,'只修改name'),(123422,'12453'),(123424,'sfdsa范德萨发');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-10 13:44:21
