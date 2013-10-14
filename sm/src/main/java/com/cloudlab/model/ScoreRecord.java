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

public class ScoreRecord {
	int sr_id;
	int sr_student_id;
	
	String sr_student_name;
	
	//Student sr_student;
	int stu_id;
	String stu_no;
	String stu_name;
	String stu_sex;
	String stu_major;
	String stu_phone;
	int stu_level;
	int stu_score;
	int stu_grp_leader;
	
	int sr_score_type_id;
	String sr_score_type_name;
	int sr_score_type_score;
	
	public int getSr_score_type_score() {
		return sr_score_type_score;
	}

	public void setSr_score_type_score(int sr_score_type_score) {
		this.sr_score_type_score = sr_score_type_score;
	}

	ScoreType st;
	int st_id;
	String st_name;
	int st_score;
	
	
	String sr_comment;
	Timestamp sr_ct;
	String sr_ct_str;
	int srt_score;
	
	public ScoreRecord() {
		
	}
	
	public ScoreRecord(int sr_id, int sr_student_id, Student sr_student, int sr_score_type_id,
			ScoreType st, String sr_comment, Timestamp sr_ct) {
		super();
		this.sr_id = sr_id;
		this.sr_student_id = sr_student_id;
		
		this.st_id = sr_student.getStu_id();
		this.stu_no = sr_student.getStu_no();
		this.st_name = sr_student.getStu_name();
		this.stu_sex = sr_student.getStu_sex();
		this.stu_major = sr_student.getStu_major();
		this.stu_phone = sr_student.getStu_phone();
		this.stu_level = sr_student.getStu_level();
		this.stu_score = sr_student.getStu_score();
		this.stu_grp_leader = sr_student.getStu_grp_leader();
		
		this.st = st;
		
		this.sr_score_type_id = sr_score_type_id;
		this.st_id = st.getSt_id();
		this.st_name = st.getSt_name();
		this.st_score = st.getSt_score();
		
		this.sr_comment = sr_comment;
		this.sr_ct = sr_ct;
	}
	
	public ScoreRecord(int sr_id, String stu_no, String stu_name, String st_name, String sr_ct,
			int st_score, int srt_score) {
		this.sr_id = sr_id;
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.st_name = st_name;
		this.sr_ct_str = sr_ct;
		this.st_score = st_score;
		this.srt_score = srt_score;
	}
	
	public String getSr_ct_str() {
		return sr_ct_str;
	}

	public void setSr_ct_str(String sr_ct_str) {
		this.sr_ct_str = sr_ct_str;
	}

	public int getSrt_score() {
		return srt_score;
	}

	public void setSrt_score(int srt_score) {
		this.srt_score = srt_score;
	}

	public ScoreType getSt() {
		return st;
	}

	public void setSt(ScoreType st) {
		this.st = st;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
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

	public int getStu_score() {
		return stu_score;
	}

	public void setStu_score(int stu_score) {
		this.stu_score = stu_score;
	}

	public int getStu_grp_leader() {
		return stu_grp_leader;
	}

	public void setStu_grp_leader(int stu_grp_leader) {
		this.stu_grp_leader = stu_grp_leader;
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

	public void setSr_student(Student sr_student) {
		this.st_id = sr_student.getStu_id();
		this.stu_no = sr_student.getStu_no();
		this.stu_name = sr_student.getStu_name();
		this.stu_sex = sr_student.getStu_sex();
		this.stu_major = sr_student.getStu_major();
		this.stu_phone = sr_student.getStu_phone();
		this.stu_level = sr_student.getStu_level();
		this.stu_score = sr_student.getStu_score();
		this.stu_grp_leader = sr_student.getStu_grp_leader();
	}
	
	public void setSr_scoretype(ScoreType st) {
		this.st = st;
		this.st_id = st.getSt_id();
		this.st_name = st.getSt_name();
		this.st_score = st.getSt_score();
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
	
	public ScoreRecord(String studentId, String studentName, String scoreTypeId, String scoreTypeName, String scoreTypeScore, 
			String ct, String comment) {
		this.sr_student_id = Integer.parseInt(studentId);
		this.sr_student_name = studentName;
		this.sr_score_type_id = Integer.parseInt(scoreTypeId);
		this.sr_score_type_name = scoreTypeName;
		this.sr_score_type_score = Integer.parseInt(scoreTypeScore);
		
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
        try {  
            Date date = sdf.parse(ct);  
            Timestamp ts = new Timestamp(date.getTime());
            this.sr_ct = ts;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        
        this.sr_comment = comment;
	}

	public String getSr_student_name() {
		return sr_student_name;
	}

	public void setSr_student_name(String sr_student_name) {
		this.sr_student_name = sr_student_name;
	}

	public String getSr_score_type_name() {
		return sr_score_type_name;
	}

	public void setSr_score_type_name(String sr_score_type_name) {
		this.sr_score_type_name = sr_score_type_name;
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


