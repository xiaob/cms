CREATE DATABASE  IF NOT EXISTS `cmsdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cmsdemo`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 192.168.1.104    Database: cmsdemo
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `email` varchar(45) DEFAULT NULL COMMENT '邮件地址',
  `name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(32) DEFAULT NULL COMMENT '密码 MD5加密',
  `status` varchar(20) DEFAULT NULL COMMENT '状态：0 隐藏 1 显示',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'herbertyang@163.com','admin','408ca3814180fc147c93aa6c619c001a','normal','2013-11-28 00:00:00'),(2,'dfs@shishuo.com','sdgbb','63a17bca737eed781473ec98768e806b','normal','2013-11-29 11:00:57'),(3,'aaaaaa@shishuo.com','sdfbg','2b8eae4a968f87ffcb312c1aeef480b0','freeze','2013-11-29 11:01:10'),(4,'bbbbbb@shishuo.com','xfdh','90ddea2857d741ed996fd3b96ac628b8','init','2013-11-29 11:01:20'),(5,'cccccc@shishuo.com','cccccc','67c7b5f922be79d55f406e2d322681cf','init','2013-11-29 11:01:34'),(6,'dddddd@shishuo.com','dfbfdb','83ec3f235f98cc06ad6206d7ebdac02a','init','2013-11-29 11:01:43');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '父评论ID',
  `fileId` bigint(20) DEFAULT NULL COMMENT '文件ID',
  `name` varchar(45) DEFAULT NULL COMMENT '评论者',
  `email` varchar(45) DEFAULT NULL COMMENT '评论者邮件地址',
  `url` varchar(200) DEFAULT NULL COMMENT '评论者网址',
  `content` text COMMENT '内容',
  `ip` varchar(45) DEFAULT NULL COMMENT 'Ip',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,0,2,'sdvg','zivfoo@shishuo.com','sdfgh','老师说的话给V哦哦V哦ieV哦Iie欧冠哦诶感觉哦ie公积金哦诶个苹果','sdg','display','2013-09-11 00:00:00'),(2,2,0,1,'sdg','sdfgds@shishuo.com','fhtgh','使得各不同企鹅逃不过他呵呵那天我刚问噶而过他和他无关','sfgh','display','2013-09-11 00:00:00'),(3,0,0,15,'fsdb','zivfoo@shishuo.com','erg','sdv','localhost:8080','display','2013-12-02 15:18:49'),(4,1,1,2,'fb','sdfgds@shishuo.com','fdg','但如何都不各位对方忽然回头让他根本人格侮辱睡过头然后突然热个人够温柔个玩法如果','sdg','hidden','2013-12-02 15:18:49'),(5,1,1,3,'dfh','sdfgds@shishuo.com','fgj','然后供热heroI今后is而非哦哦是的感觉俄日ogreio感觉哦我I个送额购物ie给我诶机构I为佛我','sdg','display','2013-12-02 15:18:49'),(15,0,0,1,'发给','',NULL,'发告诉大法官双方各撒地方个','localhost:8080','display','2013-12-05 12:11:30'),(16,0,0,1,'师范大学','',NULL,'阿斯顿发生飞','localhost:8080','display','2013-12-05 12:12:14'),(17,1,1,1,'sdfb','dushvfi@shishuo.com','sdfb','dgdfb凡是被被人V热河人不会特别好','file','display','2013-12-05 12:12:14');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `key` varchar(45) NOT NULL COMMENT 'Key',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `description` text COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES ('article_picture_size','700x300;120x120;','文章图片大小','2012-08-08 00:00:00'),('picture_size','800x600','上传图片大小','2013-09-22 00:00:00'),('sys_function_download','on','是否关闭下载模块','2012-08-08 00:00:00'),('sys_function_photo','on','是否关闭相册模块','2012-08-08 00:00:00'),('sys_function_shop','off','是否关闭商场模块','2012-08-08 00:00:00'),('sys_sitedesc','师者,传道授业解惑者也','网站描述','2012-08-08 00:00:00'),('sys_sitename','师说','网站名称','2012-08-08 00:00:00'),('sys_template','blog','网站模板名称','2012-08-08 00:00:00');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `fileId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `fatherId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL COMMENT '目录ID',
  `adminId` bigint(20) DEFAULT NULL COMMENT '管理员ID',
  `ename` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `title` varchar(200) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `contentType` varchar(45) DEFAULT NULL COMMENT '内容类型，同HTTP协议中的Content_Type',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格，报价',
  `realPrice` decimal(10,2) DEFAULT NULL COMMENT '实际价格',
  `copyCount` int(11) DEFAULT NULL COMMENT '文件被copy的次数，相当于是商品的库存',
  `content` text COMMENT '文件内容',
  `description` varchar(500) DEFAULT NULL,
  `viewCount` int(11) DEFAULT NULL COMMENT '浏览数',
  `commentCount` int(11) DEFAULT NULL COMMENT '评论数',
  `type` varchar(20) DEFAULT NULL COMMENT '文件类型：0 文章 1 照片 2 下载 3 商品',
  `status` varchar(20) DEFAULT NULL COMMENT '状态：0 隐藏 1 显示',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `expireTime` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8 COMMENT='文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,0,1,1,'aa','你好，世界！',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'跨越长城，我们可以到达世界的任何角落。',NULL,49,3,'article','display','2013-11-28 14:29:45',NULL,NULL),(2,0,5,1,'ass','ggg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>ddddd</p>\n<div id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\">&nbsp;</div>',NULL,3,0,'article','display','2013-11-28 15:49:58',NULL,NULL),(3,0,3,1,'asd','sdgg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>rehbebt</p>',NULL,4,0,'article','display','2013-11-28 17:49:00',NULL,NULL),(4,0,6,1,'asfef','zzzz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>ddddddd</p>\n<div id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\">&nbsp;</div>',NULL,1,0,'article','display','2013-11-28 17:53:39',NULL,NULL),(5,0,6,1,'regreg','fdbhdh',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfh</p>',NULL,0,0,'article','display','2013-11-28 17:57:02',NULL,NULL),(6,0,7,1,'rg3g43','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfrb</p>',NULL,0,0,'article','display','2013-11-28 18:02:49',NULL,NULL),(7,0,7,1,'b','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfrb</p>',NULL,0,0,'article','display','2013-11-28 18:03:04',NULL,NULL),(8,0,1,1,'bb','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>ffff</p>',NULL,6,0,'article','display','2013-11-28 18:06:46',NULL,NULL),(9,0,9,1,'bbb','有图片',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>有图片</p>\n<div id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\">&nbsp;</div>',NULL,0,0,'article','draft','2013-11-28 18:11:00',NULL,NULL),(10,0,1,1,'bbbb','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>ffff</p>',NULL,4,0,'article','draft','2013-11-28 18:12:15',NULL,NULL),(11,0,9,1,'bbbbb','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfbg</p>',NULL,0,0,'article','display','2013-11-28 18:13:11',NULL,NULL),(12,0,3,1,'bfvfd','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfbg</p>',NULL,3,0,'article','display','2013-11-28 18:13:37',NULL,NULL),(13,0,3,1,'basafefer','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>erh</p>',NULL,2,0,'article','display','2013-11-28 18:14:17',NULL,NULL),(14,0,10,3,'ss','dfgb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfb</p>',NULL,0,0,'article','display','2013-11-29 14:16:22',NULL,NULL),(15,0,1,3,'sss','sdb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfb</p>',NULL,4,1,'article','display','2013-12-02 11:08:41',NULL,NULL),(16,0,1,3,'s','fdbh',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>gfn</p>',NULL,4,0,'article','display','2013-12-03 09:31:23',NULL,NULL),(17,0,1,3,'sos','sdg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dg</p>',NULL,8,0,'article','display','2013-12-03 09:33:43',NULL,NULL),(18,0,1,3,'asdg','fgn',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>nf</p>',NULL,1,0,'article','display','2013-12-03 09:41:13',NULL,NULL),(19,0,13,3,'hgghb ','sdb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>sdrv</p>',NULL,0,0,'article','display','2013-12-03 09:43:41',NULL,NULL),(20,0,1,3,'erggh','fgb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>gfvb</p>',NULL,0,0,'article','display','2013-12-03 09:44:01',NULL,NULL),(21,0,1,3,'bnn','reh',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>reh4</p>',NULL,0,0,'article','hidden','2013-12-03 09:44:42',NULL,NULL),(22,0,1,3,'n','ds',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>vbfb</p>',NULL,0,0,'article','display','2013-12-03 09:45:56',NULL,NULL),(23,0,13,3,'bvvbv','fdhg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>gn</p>',NULL,0,0,'article','display','2013-12-03 09:51:21',NULL,NULL),(24,0,13,3,'gvhgh','fb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>vdb</p>',NULL,0,0,'article','display','2013-12-03 09:52:18',NULL,NULL),(25,0,9,3,'bnbn','sdbg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>gdn</p>',NULL,0,0,'article','display','2013-12-03 09:54:13',NULL,NULL),(26,0,13,3,'fgil','hg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>fndfn</p>',NULL,0,0,'article','display','2013-12-03 09:56:15',NULL,NULL),(27,0,1,3,'uikiu','sdv',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>fb</p>',NULL,0,0,'article','draft','2013-12-03 09:59:14',NULL,NULL),(29,0,9,3,'yujmy','fdb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfb</p>',NULL,0,0,'article','display','2013-12-03 10:02:48',NULL,NULL),(34,0,5,3,'nhjuuy','fsdbn',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>gfnmm</p>',NULL,0,0,'article','display','2013-12-03 10:37:23',NULL,NULL),(35,0,10,3,'fgnjmjmym','sgb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>xfb</p>',NULL,1,0,'article','hidden','2013-12-04 09:51:02',NULL,NULL),(36,0,27,3,'sdgvdfff','sdgfrdb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>fgngf</p>',NULL,0,0,'article','priv','2013-12-04 09:52:29',NULL,NULL),(37,0,21,3,'fdfffd','gfmhg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>hgmjhgmj</p>',NULL,1,0,'article','priv','2013-12-04 09:52:38',NULL,NULL),(38,0,1,3,'dfbv','activeMq.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'                                          ',NULL,0,0,'photo','display','2013-12-04 16:08:30',NULL,NULL),(39,0,1,3,'sdsdsdsd','yingjingliya.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dgnjn</p>',NULL,0,0,'photo','display','2013-12-04 16:10:02',NULL,NULL),(40,0,1,3,'yytj','标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>csfbgn g</p>',NULL,0,0,'article','display','2013-12-05 10:51:22',NULL,NULL),(41,0,9,3,'gghhhghth','dsgv',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>sfh</p>',NULL,0,0,'article','priv','2013-12-05 10:51:40',NULL,NULL),(42,0,9,3,'jhhjuk','标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>srnhntyr</p>',NULL,0,0,'article','display','2013-12-05 10:52:18',NULL,NULL),(43,0,9,3,'hjkmtyhrt','标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dgjut</p>',NULL,0,0,'article','display','2013-12-05 10:52:42',NULL,NULL),(44,0,1,3,NULL,'标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>sdvghte</p>',NULL,0,0,'article','display','2013-12-05 10:55:02',NULL,NULL),(45,0,1,3,NULL,'标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>dfjyt</p>',NULL,2,0,'article','display','2013-12-05 10:56:13',NULL,NULL),(46,0,27,3,NULL,'fsbh',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>fjmktu</p>',NULL,0,0,'article','display','2013-12-05 10:56:50',NULL,NULL),(47,0,9,3,NULL,'标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>法国不好你呢</p>',NULL,0,0,'article','display','2013-12-05 11:12:54',NULL,NULL),(48,0,9,3,NULL,'标题党',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>法国不好你呢</p>',NULL,1,0,'article','display','2013-12-05 11:13:27',NULL,NULL),(49,0,9,3,NULL,'废话那你',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>今天感觉苦预计</p>',NULL,3,0,'article','display','2013-12-05 11:18:30',NULL,NULL),(51,NULL,1,3,NULL,'dddddddddddddddddd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'<p>asdf</p>',NULL,2,0,'article','display','2013-12-05 11:31:16',NULL,NULL),(253,0,9,3,'','文章1573','色鬼热人不投入','',NULL,0,0.00,0.00,0,'<p>双方都不给他吧<br/></p>','I工笔通融ieU如今日个',8,0,'article','display','2013-12-17 09:47:17',NULL,NULL),(254,253,0,3,'','666.jpg','',NULL,NULL,40374,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:08',NULL,NULL),(255,253,0,3,'','111.jpg','',NULL,NULL,31455,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:16',NULL,NULL),(256,253,0,3,'','4sdgreg.jpg','',NULL,NULL,153859,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:21',NULL,NULL),(257,253,0,3,'','222.jpg','',NULL,NULL,232383,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:26',NULL,NULL),(258,253,0,3,'','888.jpg','',NULL,NULL,141987,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:36',NULL,NULL),(259,253,0,3,'','777.jpg','',NULL,NULL,86979,0.00,0.00,0,'',NULL,0,0,'photo','display','2013-12-17 09:48:44',NULL,NULL),(260,253,0,3,'','Slides-SlidesJS-3.zip','',NULL,NULL,2897123,0.00,0.00,0,'',NULL,0,0,'file','display','2013-12-17 09:48:55',NULL,NULL),(261,0,0,1,'','自动草稿','',NULL,NULL,0,0.00,0.00,0,'',NULL,0,0,'article','hidden','2013-12-17 10:40:52',NULL,NULL),(262,0,0,1,'','自动草稿','',NULL,NULL,0,0.00,0.00,0,'',NULL,0,0,'article','hidden','2013-12-17 13:42:35',NULL,NULL),(263,0,0,1,'','自动草稿','',NULL,NULL,0,0.00,0.00,0,'',NULL,0,0,'article','hidden','2013-12-17 13:54:10',NULL,NULL),(264,0,0,1,'','自动草稿','',NULL,NULL,0,0.00,0.00,0,'',NULL,0,0,'article','hidden','2013-12-17 14:02:05',NULL,NULL),(265,0,0,1,'','自动草稿','',NULL,NULL,0,0.00,0.00,0,'',NULL,0,0,'article','hidden','2013-12-17 14:35:27',NULL,NULL);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folder`
--

DROP TABLE IF EXISTS `folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `folder` (
  `folderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录ID',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '父亲Id，用于构建目录树',
  `ename` varchar(45) DEFAULT NULL COMMENT '英文名',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名',
  `path` varchar(200) DEFAULT NULL COMMENT '路径',
  `content` text,
  `level` tinyint(4) DEFAULT NULL COMMENT '层级',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `count` int(11) DEFAULT NULL COMMENT '文件数',
  `rank` varchar(20) DEFAULT NULL COMMENT '等级',
  `type` varchar(20) DEFAULT NULL COMMENT '目录类型：0 文章 1 照片 2 下载 3 商品',
  `status` varchar(20) DEFAULT NULL COMMENT '状态：0 隐藏 1 现实',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `ename_UNIQUE` (`ename`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='目录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
INSERT INTO `folder` VALUES (1,0,'default','默认','1',NULL,1,0,34,'everyone','article','display','2012-08-08 00:00:00',NULL),(3,0,'about','关于','3',NULL,1,1,3,'login','photo','display','2013-11-28 17:48:22',NULL),(5,1,'fdggghg','就是','1#5',NULL,2,1,0,'vip','photo','hidden','2013-11-29 10:12:20',NULL),(6,27,'dg','实际','1#6#27#6',NULL,2,0,0,'vip','photo','display','2013-11-29 10:12:34',NULL),(7,22,'sdg','说的不','22#7',NULL,1,1,0,'login','photo','display','2013-11-29 10:12:51',NULL),(9,3,'dvbd','sdfb','3#9',NULL,3,2,14,'login','article','display','2013-11-29 13:41:26',NULL),(10,9,'fbbfd','sdfgb','3#9#10',NULL,4,0,1,'login','file','hidden','2013-11-29 13:56:27',NULL),(12,3,'dddd','fdfff','3#12',NULL,3,2,0,'login','file','display','2013-11-29 13:57:55',NULL),(13,10,'fdb','dsv','3#9#10#13',NULL,5,2,4,'everyone','photo','hidden','2013-11-29 13:58:45',NULL),(14,9,'dfb','sdgb','3#9#14',NULL,4,3,0,'login','photo','hidden','2013-11-29 14:02:13',NULL),(15,7,'ggg','sdd','7#15',NULL,3,2,0,'login','shop','display','2013-11-29 14:03:09',NULL),(21,9,'trnh','fdb','3#9#21',NULL,4,4,0,'login','file','hidden','2013-11-29 14:41:19',NULL),(22,0,'xccc','dsfbg','22',NULL,1,1,0,'login','photo','hidden','2013-11-29 14:46:38',NULL),(23,5,'fdbd','sdg','1#5#23',NULL,3,1,0,'everyone','photo','display','2013-12-03 16:24:52',NULL),(27,6,'template','模版','1#6#27',NULL,3,1,0,'vip','article','display','2013-12-04 09:31:50',NULL),(30,0,'tea','茶','30',NULL,1,1,0,'everyone','shop','display','2013-12-04 14:52:09',NULL),(41,1,'fffffff','fasdfasdf',NULL,NULL,2,1,1,'everyone','article','display','2013-12-05 14:21:57',NULL),(42,1,'dddddd','dsfsadf',NULL,NULL,2,1,0,'everyone','article','display','2013-12-05 14:23:20',NULL),(43,1,'ddddddd','dsfsadf',NULL,NULL,2,1,0,'everyone','article','display','2013-12-05 14:23:30',NULL),(44,1,'撒打发士大夫','dsadf',NULL,NULL,2,1,0,'everyone','article','display','2013-12-05 14:51:01',NULL),(45,41,'sdgv','确定','null#45',NULL,3,1,0,'everyone','article','display','2013-12-06 09:35:32',NULL),(46,5,'fdgg','dfdf','1#5#46',NULL,3,1,0,'everyone','file','display','2013-12-06 13:40:42',NULL),(47,0,'sdf...cvfewq3f中','sfgb','47',NULL,1,1,0,'everyone','article','display','2013-12-06 14:55:33',NULL),(48,0,'中','sdg','48',NULL,1,1,0,'everyone','article','display','2013-12-06 14:57:44',NULL),(49,0,'中肆','dgre','49',NULL,1,1,0,'everyone','article','display','2013-12-06 14:58:57',NULL),(50,0,'sdfg中','dsgr','50',NULL,1,1,0,'everyone','article','display','2013-12-06 15:01:48',NULL),(51,0,'zhong国','收发货人','51',NULL,1,1,0,'everyone','article','display','2013-12-06 15:02:39',NULL),(52,0,'sfvb11','sdg','52',NULL,1,1,0,'everyone','article','display','2013-12-06 15:06:54',NULL),(53,41,'adfe2223_1223','中国','null#53',NULL,3,1,0,'login','shop','hidden','2013-12-06 15:08:11',NULL),(54,5,'dsfs','fd','1#5#54',NULL,3,1,0,'everyone','article','display','2013-12-06 15:10:06',NULL);
/*!40000 ALTER TABLE `folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `content` text COMMENT '日志内容',
  `level` varchar(20) DEFAULT NULL COMMENT '日志等级：0 DEBUG 1 INFO 2 WARN 3 ERROR 4 FATAL',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` varchar(20) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'SHISHUO','dfbh','2013-11-29 10:58:44'),(2,0,'SHISHUO','fdn','2013-11-29 10:58:48'),(3,0,'SHISHUO','ghk','2013-11-29 10:58:51'),(4,0,'SHISHUO','fgjgfj','2013-11-29 10:58:55'),(5,0,'SHISHUO','kjfghf','2013-11-29 10:59:00'),(6,0,'SHISHUO','erehgn','2013-11-29 10:59:03'),(7,0,'SHISHUO','dhbgf','2013-11-29 10:59:06');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-17 14:40:17
