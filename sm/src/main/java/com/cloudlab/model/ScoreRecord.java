/**
 * 文件名：StudentScoreDetail.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-17
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreRecord {
	int sr_id;
	int sr_student_id;
	int sr_score_type_id;
	
	ScoreType st;
	
	String sr_comment;
	Timestamp sr_ct;
	
	public ScoreRecord() {
		
	}
	
	public ScoreRecord(int sr_id, int sr_student_id, int sr_score_type_id,
			ScoreType st, String sr_comment, Timestamp sr_ct) {
		super();
		this.sr_id = sr_id;
		this.sr_student_id = sr_student_id;
		this.sr_score_type_id = sr_score_type_id;
		this.st = st;
		this.sr_comment = sr_comment;
		this.sr_ct = sr_ct;
	}
	
	public ScoreRecord(String studentId, String scoreTypeId, String ct, String comment) {
		this.sr_student_id = Integer.parseInt(studentId);
		this.sr_score_type_id = Integer.parseInt(scoreTypeId);
		
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        try {  
            Date date = sdf.parse(ct);  
            Timestamp ts = new Timestamp(date.getTime());
            this.sr_ct = ts;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        
        this.sr_comment = comment;

	}

	public ScoreType getSt() {
		return st;
	}

	public void setSt(ScoreType st) {
		this.st = st;
	}

	public ScoreRecord(int sr_id, int sr_student_id, int sr_score_type_id,
			String sr_comment, Timestamp sr_ct) {
		super();
		this.sr_id = sr_id;
		this.sr_student_id = sr_student_id;
		this.sr_score_type_id = sr_score_type_id;
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

	public int getSr_score_type_id() {
		return sr_score_type_id;
	}

	public void setSr_score_type_id(int sr_score_type_id) {
		this.sr_score_type_id = sr_score_type_id;
	}

	public String getSr_comment() {
		return sr_comment;
	}

	public void setSr_comment(String sr_comment) {
		this.sr_comment = sr_comment;
	}

	public Timestamp getSr_ct() {
		return sr_ct;
	}

	public void setSr_ct(Timestamp sr_ct) {
		this.sr_ct = sr_ct;
	}
}


