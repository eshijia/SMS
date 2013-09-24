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

import com.cloudlab.model.Assistant;
import com.cloudlab.model.Combo;
import com.cloudlab.model.Info;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;

public class TableLoader {
	
	public static Student loadStudent(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int stu_id = rs.getInt("stu_id");
		String stu_no = rs.getString("stu_no");
		String stu_name = rs.getString("stu_name");
		String stu_sex = rs.getString("stu_sex");
		String stu_major = rs.getString("stu_major");
		String stu_phone = rs.getString("stu_phone");
//		String stu_no = new String(rs.getString("stu_no").getBytes("UTF-8"));
//		String stu_name = new String(rs.getString("stu_name").getBytes("UTF-8"));
//		String stu_sex = new String(rs.getString("stu_sex").getBytes("UTF-8"));
//		String stu_major = new String(rs.getString("stu_major").getBytes("UTF-8"));
//		String stu_phone = new String(rs.getString("stu_phone").getBytes("UTF-8"));
		int stu_level = rs.getInt("stu_level");
       // int score = rs.getInt("stu_score");
		
        
        Student user = new Student(stu_id, stu_no, stu_name, stu_sex, stu_major, stu_phone, stu_level);
        return user;
	}
	
	public static Assistant loadAssistant(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int ast_id = rs.getInt("ast_id");
		String ast_name = rs.getString("ast_name");
//		String ast_name = new String(rs.getString("ast_name").getBytes("UTF-8"));
		String ast_phone = rs.getString("ast_phone");
        
		Assistant assistant = new Assistant(ast_id, ast_name, ast_phone);
        return assistant;
	}
	
	public static Info loadInfo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int if_id = rs.getInt("if_id");
		String if_info = rs.getString("if_info");
//		String if_info = new String(rs.getString("if_info").getBytes("UTF-8"));
		String if_ct = rs.getString("if_ct");
        
		Info info = new Info(if_id, if_info, if_ct);
        return info;
	}
	
	
	public static ScoreRecord loadScoreRecord(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int sr_id = rs.getInt("sr_id");
		int sr_student_id = rs.getInt("sr_student_id");
		int sr_score_type_id = rs.getInt("sr_score_type_id");
		
		int st_id = rs.getInt("st_id");
		String st_name = rs.getString("st_name");
//		String st_name = new String(rs.getString("st_name").getBytes("UTF-8"));
		int st_score = rs.getInt("st_score");
		
		ScoreType st = new ScoreType(st_id, st_name, st_score);
		
		String sr_comment = rs.getString("sr_comment");
//		String sr_comment = new String(rs.getString("sr_comment").getBytes("UTF-8"));
		Timestamp sr_ct = rs.getTimestamp("sr_ct");
		
		ScoreRecord sr = new ScoreRecord(sr_id, sr_student_id, sr_score_type_id, st, 
				sr_comment, sr_ct);
		
        return sr;
	}
	
	
	public static Combo loadStudentCombo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("stu_id");
		String text = rs.getString("stu_name");
//		String text = new String(rs.getString("stu_name").getBytes("UTF-8"));
		
		Combo sc = new Combo(id, text);
		
        return sc;
	}
	
	public static Combo loadScoreTypeCombo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("st_id");
		String text = rs.getString("st_name");
//		String text = new String(rs.getString("st_name").getBytes("UTF-8"));
		
		Combo sc = new Combo(id, text);
		
		return sc;
	}
}


