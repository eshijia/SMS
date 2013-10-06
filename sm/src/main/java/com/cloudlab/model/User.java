/**
 * 文件名：User.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-22
 * Copyright by menuz
 */
package com.cloudlab.model;

/**
 * 
 * 此类描述的是：登陆用户
 * @author: dmnrei@gmail.com
 * @version: 2013-10-6 下午2:15:52
 */
public class User {
	public int u_id;
	public String u_username;
	public String u_password;
	public int u_admin;
	
	public User() {}
	
	public User(String username, String password) {
		this.u_username = username;
		this.u_password = password;
	}
	
	public User(int u_id, String u_username, String u_password, int u_admin) {
		super();
		this.u_id = u_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_admin = u_admin;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public int getU_admin() {
		return u_admin;
	}

	public void setU_admin(int u_admin) {
		this.u_admin = u_admin;
	}
}


