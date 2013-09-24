/**
 * 文件名：User.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.model;

public class Student {
	int stu_id;
	String stu_no;
	String stu_name;
	String stu_sex;
	String stu_major;
	String stu_phone;
	int stu_level;
	int stu_score;
	int stu_grp_leader;
	
	public Student(int stu_id, String stu_no, String stu_name, String stu_sex,
			String stu_major, String stu_phone, int stu_level, int stu_score,
			int stu_grp_leader) {
		super();
		this.stu_id = stu_id;
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_major = stu_major;
		this.stu_phone = stu_phone;
		this.stu_level = stu_level;
		this.stu_score = stu_score;
		this.stu_grp_leader = stu_grp_leader;
	}

	public int getStu_grp_leader() {
		return stu_grp_leader;
	}

	public void setStu_grp_leader(int stu_grp_leader) {
		this.stu_grp_leader = stu_grp_leader;
	}

	public Student() {}
	
	public Student(String stu_no, String stu_name, String stu_sex,
			String stu_major, int stu_score) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_major = stu_major;
		this.stu_score = stu_score;
	}
	
	public Student(int stu_id, String stu_no, String stu_name, String stu_sex,
			String stu_major, String stu_phone, int stu_level) {
		super();
		this.stu_id = stu_id;
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_major = stu_major;
		this.stu_phone = stu_phone;
		this.stu_level = stu_level;
	}

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}

	public int getStu_score() {
		return stu_score;
	}

	public void setStu_score(int stu_score) {
		this.stu_score = stu_score;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public int getStu_level() {
		return stu_level;
	}

	public void setStu_level(int stu_level) {
		this.stu_level = stu_level;
	}
	
	
}


