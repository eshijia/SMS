/**
 * 文件名：User.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-22
 * Copyright by menuz
 */
package com.cloudlab.model;

public class Assistant {
	int ast_id;
	String ast_name;
	String ast_phone;
	
	public Assistant() {}
	
	public Assistant(int ast_id, String ast_name, String ast_phone) {
		super();
		this.ast_id = ast_id;
		this.ast_name = ast_name;
		this.ast_phone = ast_phone;
	}
	public int getAst_id() {
		return ast_id;
	}
	public void setAst_id(int ast_id) {
		this.ast_id = ast_id;
	}
	public String getAst_name() {
		return ast_name;
	}
	public void setAst_name(String ast_name) {
		this.ast_name = ast_name;
	}
	public String getAst_phone() {
		return ast_phone;
	}
	public void setAst_phone(String ast_phone) {
		this.ast_phone = ast_phone;
	}
	
}


