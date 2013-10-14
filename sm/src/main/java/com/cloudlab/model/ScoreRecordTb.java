/**
 * 文件名：StudentScoreDetail.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-17
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreRecordTb {
	int sr_id;
	int sr_student_id;
	String sr_student_name;
	
	int sr_score_type_id;
	String sr_score_type_name;
	int sr_score_type_score;	
	
	String sr_comment;
	String sr_ct;
	
	public ScoreRecordTb() {
		
	}
	
	public ScoreRecordTb(int sr_id, int sr_student_id, String sr_student_name,
			int sr_score_type_id, String sr_score_type_name,
			int sr_score_type_score, String sr_comment, String sr_ct) {
		super();
		this.sr_id = sr_id;
		this.sr_student_id = sr_student_id;
		this.sr_student_name = sr_student_name;
		this.sr_score_type_id = sr_score_type_id;
		this.sr_score_type_name = sr_score_type_name;
		this.sr_score_type_score = sr_score_type_score;
		this.sr_comment = sr_comment;
		this.sr_ct = sr_ct;
	}



	public int getSr_id() {
		return sr_id;
	}



	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}



	public int getSr_student_id() {
		return sr_student_id;
	}



	public void setSr_student_id(int sr_student_id) {
		this.sr_student_id = sr_student_id;
	}



	public String getSr_student_name() {
		return sr_student_name;
	}



	public void setSr_student_name(String sr_student_name) {
		this.sr_student_name = sr_student_name;
	}



	public int getSr_score_type_id() {
		return sr_score_type_id;
	}



	public void setSr_score_type_id(int sr_score_type_id) {
		this.sr_score_type_id = sr_score_type_id;
	}



	public String getSr_score_type_name() {
		return sr_score_type_name;
	}



	public void setSr_score_type_name(String sr_score_type_name) {
		this.sr_score_type_name = sr_score_type_name;
	}



	public int getSr_score_type_score() {
		return sr_score_type_score;
	}



	public void setSr_score_type_score(int sr_score_type_score) {
		this.sr_score_type_score = sr_score_type_score;
	}



	public String getSr_comment() {
		return sr_comment;
	}



	public void setSr_comment(String sr_comment) {
		this.sr_comment = sr_comment;
	}



	public String getSr_ct() {
		return sr_ct;
	}



	public void setSr_ct(String sr_ct) {
		this.sr_ct = sr_ct;
	}
	
	
	
}


