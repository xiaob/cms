CREATE TABLE `admin` (
  `adminId` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `email` varchar(45) DEFAULT NULL COMMENT '邮件地址',
  `password` varchar(32) DEFAULT NULL COMMENT '密码 MD5加密',
  `name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员';

CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL COMMENT '评论ID',
  `fileId` bigint(20) DEFAULT NULL COMMENT '文件ID',
  `email` varchar(45) DEFAULT NULL COMMENT '评论人的邮件地址',
  `name` varchar(45) DEFAULT NULL COMMENT '评论人的昵称',
  `content` varchar(3000) DEFAULT NULL COMMENT '内容',
  `ip` varchar(45) DEFAULT NULL COMMENT 'Ip',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '评论中的评论',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

CREATE TABLE `config` (
  `key` varchar(45) NOT NULL COMMENT 'Key',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置';

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

CREATE TABLE `file_tags` (
  `fileId` bigint(20) NOT NULL COMMENT '文件ID',
  `tagsId` bigint(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`fileId`,`tagsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件和标签的关链表，多对多，联合主键';

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

CREATE TABLE `log` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';

CREATE TABLE `tags` (
  `tagsId` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`tagsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` tinyint(4) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户';
