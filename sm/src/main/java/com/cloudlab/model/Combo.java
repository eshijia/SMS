/**
 * 文件名：StudentCombo.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-20
 * Copyright by menuz
 */
package com.cloudlab.model;

public class Combo {
	int id;
	String text;

	public Combo() {
		
	}
	
	public Combo(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}


