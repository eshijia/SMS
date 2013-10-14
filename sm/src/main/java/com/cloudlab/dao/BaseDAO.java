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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	private static String driver = "com.mysql.jdbc.Driver";
	
	//private static String url = "jdbc:mysql://localhost:3306/sms?useUnicode=true&amp;characterEncoding=GBK";
	//private static String url = "jdbc:mysql://192.168.1.67:3306/sms?useUnicode=true&amp;characterEncoding=utf8";
	
//	private static String url = "jdbc:mysql://192.168.1.67:3306/sms?useUnicode=true&characterEncoding=utf8";
	private static String url = "jdbc:mysql://localhost:3306/sms?useUnicode=true&characterEncoding=utf8";
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
	
	/**
	 * 
		 * 此方法描述的是：
		 * @author: dmnrei@gmail.com
		 * @version: 2013-3-31 下午4:48:47
	 */
	public void releaseSource(Connection conn, Statement stmt, ResultSet rs) {
	    try {
	    	if(rs != null) {
	    		rs.close();
	    		rs = null;
	    	}
	    	if (conn != null) {
				conn.close();
				conn = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}


