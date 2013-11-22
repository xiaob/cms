package com.shishuo.cms.install;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * 师说CMS安装程序 如果出现乱码请在控制台运行 Windows: set MAVEN_OPTS=-Dfile.encoding=UTF-8 Linux:
 * export MAVEN_OPTS=-Dfile.encoding=UTF-8
 * 
 * @author Herbert
 * 
 */
public class Welcome {

	private static String CMS_PROPERTIES = "src/main/resources/cms.properties";

	Console console = System.console();

	public static void main(String[] args) {
		Welcome welcome = new Welcome();
		welcome.welcome();
		welcome.testConnection();

		// welcome.checkCmsProperties();
		// welcome.writeCmsProperties("url", "user", "password");
		// Console console = System.console(); // 获得Console实例对象
		// if (console != null) { // 判断是否有控制台的使用权
		// String user = new String(console.readLine("Enter username:")); //
		// 读取整行字符
		// String pwd = new String(console.readPassword("Enter passowrd:")); //
		// 读取密码,输入时不显示
		// console.printf("Username is: " + user + "\n"); // 显示用户名
		// console.printf("Password is: " + pwd + "\n"); // 显示密码
		// } else {
		// System.out.println("Console is unavailable."); // 提示无控制台使用权限
		// }

		// try {
		// // 加载MySql的驱动类
		// String url =
		// "jdbc:mysql://127.0.0.1:3306/cms?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
		// String username = "root1";
		// String password = "";
		// Class.forName("com.mysql.jdbc.Driver");
		// Connection conn = DriverManager.getConnection(url, username,
		// password);
		// if (conn != null) {
		// System.out.println("数据连接成功。");
		// }
		// } catch (ClassNotFoundException e) {
		// System.out.println("找不到驱动程序类 ，加载驱动失败！");
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private void welcome() {
		Properties props = System.getProperties();
		System.out.println("\n\n欢迎使用【师说CMS】\n\n");
		System.out.println("操作系统的名称\t\t" + props.getProperty("os.name"));
		System.out.println("操作系统的架构\t\t" + props.getProperty("os.arch"));
		System.out.println("操作系统的版本\t\t" + props.getProperty("os.version"));
		System.out.println("用户的账户名称\t\t" + props.getProperty("user.name"));
		System.out.println("用户的主目录\t\t" + props.getProperty("user.home"));
		System.out.println("用户的当前工作目录\t" + props.getProperty("user.dir"));
		System.out.println("运行时环境版本\t\t" + props.getProperty("java.version"));
		System.out.println("Java安装目录\t\t" + props.getProperty("java.home"));
		System.out
				.println("Java虚拟机供应商\t" + props.getProperty("java.vm.vendor"));
		System.out.println("Java虚拟机名称\t\t" + props.getProperty("java.vm.name"));

		System.out.println("\n\n【重要】在开始前，您需要配置 " + CMS_PROPERTIES
				+ "，此文件包含数据连接的相关信息。");
		console.readLine("\n按任意键继续。。。");
	}

	/**
	 * 1、 检查 src/main/resources/cms.properties 配置文件 2、 测试数据库连接
	 */
	private boolean testConnection() {
		//
		File file = new File(CMS_PROPERTIES);
		if (!file.exists()) {
			System.out.println(CMS_PROPERTIES + "【不存在】");
			return false;
		} else {
			System.out.println(CMS_PROPERTIES + "【存在】");
			return true;
		}
	}

	/**
	 * 检查师说CMS的配置文件是否存在
	 * 
	 * @return true 不安装 false 可以安装
	 */
	private boolean checkCmsProperties() {
		try {
			new BufferedInputStream(new FileInputStream(CMS_PROPERTIES));
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
