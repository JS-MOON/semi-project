package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2014-11-12.
 */
public class DBConn {

	private static Connection conn = null;

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@192.168.6.88:1521:testdb";
		String user = "nori";
		String password = "card";

		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

	public static void close() {
		if (conn == null)
			return;
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}