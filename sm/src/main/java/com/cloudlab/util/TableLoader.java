/**
 * 文件名：ClassLoader.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.util;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;
import com.cloudlab.model.StudentCombo;

public class TableLoader {
	
	public static Student loadUser(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int stu_id = rs.getInt("stu_id");
		String stu_no = new String(rs.getString("stu_no").getBytes("UTF-8"));
		String stu_name = new String(rs.getString("stu_name").getBytes("UTF-8"));
		String stu_sex = new String(rs.getString("stu_sex").getBytes("UTF-8"));
		String stu_major = new String(rs.getString("stu_major").getBytes("UTF-8"));
		String stu_phone = new String(rs.getString("stu_phone").getBytes("UTF-8"));
		int stu_level = rs.getInt("stu_level");
        int score = rs.getInt("stu_score");
        
        Student user = new Student(stu_id, stu_no, stu_name, stu_sex, stu_major, stu_phone, stu_level, score);
        return user;
	}
	
	
	public static ScoreRecord loadScoreRecord(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int sr_id = rs.getInt("sr_id");
		int sr_student_id = rs.getInt("sr_student_id");
		int sr_score_type_id = rs.getInt("sr_score_type_id");
		
		int st_id = rs.getInt("st_id");
		String st_name = new String(rs.getString("st_name").getBytes("UTF-8"));
		int st_score = rs.getInt("st_score");
		
		ScoreType st = new ScoreType(st_id, st_name, st_score);
		
		String sr_comment = new String(rs.getString("sr_comment").getBytes("UTF-8"));
		Timestamp sr_ct = rs.getTimestamp("sr_ct");
		
		ScoreRecord sr = new ScoreRecord(sr_id, sr_student_id, sr_score_type_id, st, 
				sr_comment, sr_ct);
		
        return sr;
	}
	
	
	public static StudentCombo loadStudentCombo(java.sql.ResultSet rs, int i) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("stu_id");
		String text = new String(rs.getString("stu_name").getBytes("UTF-8"));
		
		StudentCombo sc = new StudentCombo(id, text);
		
        return sc;
	}
}


