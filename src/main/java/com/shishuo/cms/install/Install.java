package com.shishuo.cms.install;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import com.mysql.jdbc.Connection;

/**
 * @author Herbert
 * 
 */
public class Install {
	private static String CMS_PROPERTIES = "src/main/resources/cms.properties";

	public static void main(String[] args) {
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(CMS_PROPERTIES));
			Properties props = new Properties();
			props.load(bis);
			String url = props.getProperty("jdbc.url");
			String driver = props.getProperty("jdbc.driverClass");
			String username = props.getProperty("jdbc.user");
			String password = props.getProperty("jdbc.password");
			Install install = new Install();
			install.testConnection(driver, url, username, password);
			// System.out.println(url);
			// Class.forName(driver).newInstance();
			// // DriverManager.setLoginTimeout(30);
			// Connection conn = (Connection) DriverManager.getConnection(url,
			// username, password);
			// // conn.setConnectTimeout(3000);
			//
			// ScriptRunner runner = new ScriptRunner(conn);
			// runner.setErrorLogWriter(null);
			// runner.setLogWriter(null);
			// runner.runScript(Resources
			// .getResourceAsReader("ddl/mysql/jpetstore-mysql-schema.sql"));
			// runner.runScript(Resources
			// .getResourceAsReader("ddl/mysql/jpetstore-mysql-dataload.sql"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testConnection(String driver, String url, String username,
			String password) {
		try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url,
					username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
