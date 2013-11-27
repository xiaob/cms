git clone http://git.oschina.net/shishuo/CMS.git
cd CMS
mvn clean
mvn install
mvn compile
# 修改shishuocms
mvn exec:java -Dexec.mainClass="com.shishuo.cms.Install"
mvn jetty:run