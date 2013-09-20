/**
 * 文件名：ScoreType.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-17
 * Copyright by menuz
 */
package com.cloudlab.model;

public class ScoreType {
	int st_id;
	String st_name;
	int st_score;
	
	public ScoreType() {
		
	}
	
	public ScoreType(int st_id, String st_name, int st_score) {
		super();
		this.st_id = st_id;
		this.st_name = st_name;
		this.st_score = st_score;
	}

	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public int getSt_score() {
		return st_score;
	}
	public void setSt_score(int st_score) {
		this.st_score = st_score;
	}
	
	
}


