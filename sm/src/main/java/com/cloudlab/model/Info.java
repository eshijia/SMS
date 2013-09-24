/**
 * 文件名：Info.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-21
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info {
	int if_id;
	String if_info;
	String if_ct;

	public Info() {
	}

	public Info(String info, String ct) {
		super();
		this.if_info = info;
		this.if_ct = ct;
	}

	public Info(int if_id, String if_info, String if_ct) {
		super();
		this.if_id = if_id;
		this.if_info = if_info;
		this.if_ct = if_ct;
	}

	public String getIf_info() {
		return if_info;
	}

	public void setIf_info(String if_info) {
		this.if_info = if_info;
	}

	public String getIf_ct() {
		return if_ct;
	}

	// public Timestamp getCt() {
	// DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	//
	// System.out.println(this.if_ct);
	//
	// Timestamp ts = null;
	// try {
	// Date date = sdf.parse(this.if_ct);
	// ts = new Timestamp(date.getTime());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return ts;
	// }

	public void setIf_ct(String if_ct) {
		this.if_ct = if_ct;
	}

	public int getIf_id() {
		return if_id;
	}

	public void setIf_id(int if_id) {
		this.if_id = if_id;
	}

}
