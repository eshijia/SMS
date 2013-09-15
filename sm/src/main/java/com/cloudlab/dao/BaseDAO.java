/**
 * 文件名：BaseDAO.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-13
 * Copyright by menuz
 */
package com.cloudlab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/sms";
	private static String user = "xxq";
	private static String password = "xxq";

	/**
	 * 
	 */
	public BaseDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * 
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			if (conn!= null && !conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void main(String[] args) {
		BaseDAO dao = new BaseDAO();
		dao.getConn();
	}
}


