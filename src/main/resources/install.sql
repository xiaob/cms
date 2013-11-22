-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 192.168.1.100    Database: cms
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
  `adminId` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'tianyao','123456',0,'2013-11-19 14:09:55'),(2,'admin','123456',0,'2013-11-19 14:50:21'),(3,'123','123456',0,'2013-11-19 14:50:38');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL,
  `fileId` bigint(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `fatherId` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
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
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES ('function_download','off',NULL),('function_photo','off',NULL),('function_shop','off',NULL),('sitedesc','用Java开发的CMS',NULL),('sitename','df',NULL),('siteurl','http://127.0.0.1/CMS/',NULL),('template','default','2013-09-11 00:00:00');
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
  `folderId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(500) DEFAULT NULL COMMENT '文件外部URL',
  `images` varchar(500) DEFAULT NULL COMMENT '文件描述图片',
  `description` mediumtext COMMENT '文件描述',
  `viewCount` int(11) DEFAULT NULL,
  `commentCount` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '文件类型：0 文章 1 下载 2 商品',
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,4,NULL,'','ccccccc','ccccccc','desc cc',NULL,NULL,0,1,'2013-08-08 00:00:00'),(2,5,NULL,'3333','333','333','desc 444444',NULL,NULL,0,1,'2013-09-09 00:00:00'),(3,6,NULL,'1111','222','1111','desc1111',NULL,NULL,1,1,'2013-08-08 00:00:00'),(4,6,NULL,'22','22','11','desc222',NULL,NULL,1,1,'2013-08-09 00:00:00'),(5,7,NULL,'1111','1111','111','desc3333',NULL,NULL,2,1,'2013-09-09 00:00:00'),(7,1,NULL,'发生哈迪欧房间爱搜id金佛埃索达金佛埃索达金佛i按实际大佛i阿斯达金佛i按实际大佛 ','sdg','dfgh','撒谎idfhi阿苏电话覅速度后iu阿飞hi苏电话覅苏电话覅usd后覅usd合肥市大uhi阿usd后覅usd后覅苏电话覅速度恢复isau盾发hi阿苏电话覅usd后覅u啊是啊收到货红丝带u放大后isau盾后覅usd回复i阿三电话覅就阿萨帝偶发骄傲isd就发哦isd就发哦isd金佛i按实际大佛i阿斯达积分  金佛爱尚家大佛i按实际大佛i啊急哦idf骄傲isd金佛埃索达就发送到   接啊搜id金佛i按实际大佛i按实际大佛i阿斯达金佛i啊设计的覅噢啊世纪东方 吉萨都i就发哦isd金佛埃索达金佛爱尚家大佛i啊世纪东方 就佛阿斯顿就发哦isd就发哦isd就覅哦啊受打击佛i阿斯达积分急哦isa就大佛i按实际大佛埃索达金佛i阿斯达就佛阿斯顿积分 级粉丝哦啊接大佛i阿斯达金佛爱神的箭佛阿斯顿金佛i啊受打击覅偶爱受打击覅哦萨达就覅搜到积分 就度搜覅金佛i阿斯达金佛i按实际大佛爱神的箭  金佛i阿斯达金佛i按实际大佛i爱睡觉的佛爱神的箭 u...',NULL,NULL,0,NULL,'2013-11-18 12:27:13'),(8,1,NULL,'时间斗篷飞洒看打破饭卡上打破防空炮sd卡放炮sd卡富婆奥斯卡大富婆奥斯卡大佛帕斯卡大佛帕克是打破 高科技殴打付款gps反馈给搜到飞 打开破防更可怕搜到付款gps豆腐块公婆的首付款告破第三方看过 ','bb','bbbbb','撒谎idfhi阿苏电话覅速度后iu阿飞hi苏电话覅苏电话覅usd后覅usd合肥市大uhi阿usd后覅usd后覅苏电话覅速度恢复isau盾发hi阿苏电话覅usd后覅u啊是啊收到货红丝带u放大后isau盾后覅usd回复i阿三电话覅u阿三电话覅u阿斯达回复i阿斯达回复i阿道夫hi阿u就发哦四大将佛埃索达金佛埃索达金佛i阿斯顿发就死到哦if奖爱搜嫡福晋奥斯丁就覅搜到激发iso点击撒打飞机奥斯丁就覅哦萨达积分阿斯殴打就覅搜到就佛阿斯顿金佛萨迪金佛i阿斯达就佛啊四季度覅哦萨达积分是底价佛isd和打法哦四大 就搜到i就覅哦萨达将发生的就覅搜到金佛i阿斯达解放军扫地飞机扫大街覅扫大街覅哦萨达飞 吉萨都if奖爱搜id就发哦四大将佛i啊受打击覅哦啊受打击佛i阿加萨都if奖爱搜低级佛阿斯顿金佛i啊 静安寺殴打付骄傲搜i的肌肤i哦啊受打击佛埃索达金佛i阿斯达积分树发的 后覅u阿双方对啊哈大幅i啊哈覅usd回复阿斯顿和辐射大横幅阿斯达还u盾回复i阿斯顿和复旦复id号是否 ',NULL,NULL,0,1,'2013-11-18 14:45:43'),(11,3,NULL,'ggg','ggg','gg','ggg',NULL,NULL,0,0,'2013-11-18 14:55:44'),(12,4,NULL,'zcsc','sdfv','reg','wf',NULL,NULL,0,1,'2013-11-18 15:56:18'),(13,0,1,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384769286635.jpg','','',NULL,NULL,4,NULL,'2013-11-18 18:08:07'),(14,0,1,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384769327072.jpg','','',NULL,NULL,4,NULL,'2013-11-18 18:08:47'),(15,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384824728680.jpg','','',NULL,NULL,4,NULL,'2013-11-19 09:32:09'),(16,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384826158378.jpg','','',NULL,NULL,4,NULL,'2013-11-19 09:55:58'),(17,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384826172435.jpg','','',NULL,NULL,4,NULL,'2013-11-19 09:56:12'),(18,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384826202672.jpg','','',NULL,NULL,4,NULL,'2013-11-19 09:56:43'),(19,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384826386147.jpg','','',NULL,NULL,4,NULL,'2013-11-19 09:59:46'),(20,0,0,'QQ图片20131113170042.jpg','D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CMS\\/upload/1384826651626.jpg','','',NULL,NULL,4,NULL,'2013-11-19 10:04:12');
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
  `topId` bigint(20) DEFAULT NULL COMMENT '顶栏Id',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '父亲Id，用于构建目录树',
  `ename` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '目录名称',
  `count` int(11) DEFAULT NULL COMMENT '文件数',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态：0 隐藏 1 现实',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型：0 文章 1 下载 2 商品3.图片',
  `template` varchar(45) DEFAULT NULL COMMENT '模板',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `rank` tinyint(4) DEFAULT NULL COMMENT '等级',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `ename_UNIQUE` (`ename`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='目录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
INSERT INTO `folder` VALUES (1,1,0,'home','首页',0,0,0,'default',0,0,'2013-08-08 00:00:00'),(2,2,0,'about','关于',0,1,0,'default',0,0,'2013-08-08 00:00:00'),(3,3,0,'join','招聘',0,1,2,'default',0,0,'2013-08-08 00:00:00'),(4,4,0,'template','模板',0,1,1,'default',0,0,'2013-08-08 00:00:00'),(5,4,4,'biz','商业',0,1,1,'folder',0,0,'2013-08-09 00:00:00'),(6,2,2,'about1','关于1',0,1,1,'folder',1,0,'2013-08-20 00:00:00'),(7,2,2,'about2','关于2',0,1,3,'folder',0,0,'2013-09-20 00:00:00'),(8,4,4,'template1','模板1',0,1,0,'default',1,0,'2013-11-18 09:24:33'),(9,4,8,'templateq','aaa',0,0,0,'default',1,0,'2013-11-18 09:40:28'),(11,1,1,NULL,'sdf',0,0,2,'defalut',1,0,'2013-11-19 16:58:55'),(12,2,2,NULL,'下载',0,0,0,'defalut',1,0,'2013-11-19 17:00:00'),(14,3,3,NULL,'教程',0,0,0,'defalut',1,0,'2013-11-19 17:14:20'),(16,4,4,NULL,'学习',0,0,0,'defalut',1,0,'2013-11-19 17:17:04'),(17,4,4,NULL,'方法',0,0,0,'defalut',1,0,'2013-11-19 17:17:38'),(23,NULL,3,NULL,'sweg',0,1,1,'defalut',1,0,'2013-11-19 17:40:38'),(24,2,2,'dfh','sdg',0,1,2,'defalut',1,0,'2013-11-19 17:45:24');
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
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
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
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `tagsId` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`tagsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` tinyint(4) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2013-11-19 18:16:19
