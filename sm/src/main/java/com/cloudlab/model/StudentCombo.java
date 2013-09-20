/**
 * 文件名：StudentCombo.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-20
 * Copyright by menuz
 */
package com.cloudlab.model;

public class StudentCombo {
	int id;
	String text;
//	String selected;
	
//	public String getSelected() {
//		return selected;
//	}
//
//	public void setSelected(String selected) {
//		this.selected = selected;
//	}

	public StudentCombo() {
		
	}
	
	public StudentCombo(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
	
//	public StudentCombo(int id, String text, String selected) {
//		super();
//		this.id = id;
//		this.text = text;
//		this.selected = selected;
//	}

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


