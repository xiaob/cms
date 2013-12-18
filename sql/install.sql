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

CREATE TABLE `config` (
  `key` varchar(45) NOT NULL COMMENT 'Key',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `description` text COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置';

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

CREATE TABLE `log` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `content` text COMMENT '日志内容',
  `level` varchar(20) DEFAULT NULL COMMENT '日志等级：0 DEBUG 1 INFO 2 WARN 3 ERROR 4 FATAL',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` varchar(20) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户';
