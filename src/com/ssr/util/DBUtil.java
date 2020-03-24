package com.ssr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ssr";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException 
	 */
	public Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn Connection
	 * @throws Exception
	 */
	public void closeConnection(Connection conn) throws Exception {
		conn.close();
	}

}
