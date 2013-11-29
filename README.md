![师说CMS](/src/main/webapp/system/images/logo.png "师说CMS")

## 欢迎使用 “师说CMS”

> 使用Java语言开发的CMS（使用Apache2协议，可免费用于商业用途）<br>
> Spring MVC为表现层，Spring为业务层，MyBatis为数据层。项目大量使用注解，代码注释清晰，文档齐全，是学习和二次开发的首选。

## 演示地址

**前台演示：** http://42.121.56.21:8080/

**后台演示：** http://42.121.56.21:8080/auth/admin/login

## 前言

师说CMS是由长沙师说网络科技有限公司开源的一款CMS产品，其公司推出的“师说" http://www.shishuo.com ，是一个专业人才交流平台，致力于解决人才与企业和人才与人才之间交流的平台。

## 安装

	# 下载代码
	git clone http://git.oschina.net/shishuo/CMS.git
	# 进入CMS目录
	cd CMS
	# 清理
	mvn clean
	# 编译
	mvn compile
	# 修改数据库配置文件
		1、 把 src/main/resources/shishuocms.properties 拷贝到 CMS目录下
		2、 修改shishuocms.properties里的超级管理员的email，和数据库连接的相关信息
	# 安装
	mvn exec:java -Dexec.mainClass="com.shishuo.cms.Install"
	# 运行
	mvn jetty:run
	# 后台地址
	http://127.0.0。1:8080/auth/admin/login
	用户名：(shishuocms.properties里的超级管理员的email)
	密  码：shishuocms


## 目标

 - 为致力于学习Java语言的初学者提供学习和参考的Demo 
 - 帮助企业以更低的成本打造自己的网站
 - 让广大Web前端开发者和设计者，专注前台页面设计和制作
 - 填补各种优秀的开源CMS系统中，使用Java语言开发的空白

## 需求

 - 文章列表模块
 - 图片展示模块
 - 文件下载模块
 - 电子商务模块
 - 用户注册登录模块
 - 后台管理模块

## 开发

[长沙市师说网络科技有限公司][1]

## 版权

    Copyright 2013 Changsha Shishuo Network Technology Co., Ltd. 
    All rights reserved.
    长沙市师说网络科技有限公司
    版权所有
    http://www.shishuo.com
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


  [1]: http://www.shishuo.com
