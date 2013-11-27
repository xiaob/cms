	# 下载代码
	git clone http://git.oschina.net/shishuo/CMS.git
	# 进入CMS目录
	cd CMS
	# 清理
	mvn clean
	# 编译
	mvn compile
	# 修改数据库配置文件
	src/main/resources/shishuocms.properties
	# 安装
	mvn exec:java -Dexec.mainClass="com.shishuo.cms.Install"
	# 运行
	mvn jetty:run