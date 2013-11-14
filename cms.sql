CREATE TABLE `config` (
  `key` varchar(45) NOT NULL COMMENT 'Key',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置';

CREATE TABLE `file` (
  `fileId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(500) DEFAULT NULL COMMENT '文件外部URL',
  `images` varchar(500) DEFAULT NULL COMMENT '文件描述图片',
  `description` mediumtext COMMENT '文件描述',
  `type` tinyint(4) DEFAULT NULL COMMENT '文件类型：0 文章 1 下载 2 商品',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件';

CREATE TABLE `folder` (
  `folderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录ID',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '父亲Id，用于构建目录树',
  `name` varchar(100) DEFAULT NULL COMMENT '目录名称',
  `count` int(11) DEFAULT NULL COMMENT '文件数',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态：0 隐藏 1 现实',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型：0 文章 1 下载 2 商品',
  `login` tinyint(4) DEFAULT NULL COMMENT '登录：0 不需要登录 1 需要登录',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `template` varchar(45) DEFAULT NULL COMMENT '模板',
  PRIMARY KEY (`folderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录';

CREATE TABLE `log` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` tinyint(4) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
