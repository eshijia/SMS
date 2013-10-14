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
import java.util.Map;

import com.cloudlab.model.Assistant;
import com.cloudlab.model.Combo;
import com.cloudlab.model.Info;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreRecordTb;
import com.cloudlab.model.ScoreType;
import com.cloudlab.model.ScoreTypeScoreCombo;
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
        
        //System.out.println(user);
        
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
		/*
		 * 这里需要注意，取score_record中得分数，score_type中得分数是预设值，
		 * score_record中得分数才是真实分数
		 * */
		//int st_score = rs.getInt("st_score");
		int st_score = rs.getInt("sr_score_type_score");
				
		ScoreType st = new ScoreType(st_id, st_name, st_score);
		
		String sr_comment = rs.getString("sr_comment");
//		String sr_comment = new String(rs.getString("sr_comment").getBytes("UTF-8"));
		Timestamp sr_ct = rs.getTimestamp("sr_ct");
		
		ScoreRecord sr = new ScoreRecord(sr_id, sr_student_id, sr_score_type_id, st, 
				sr_comment, sr_ct);
		
        return sr;
	}
	
	public static ScoreRecordTb loadScoreRecordTable(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int sr_id = rs.getInt("sr_id");
		int sr_student_id = rs.getInt("sr_student_id");
		String sr_student_name = rs.getString("sr_student_name");
		
		int sr_score_type_id = rs.getInt("sr_score_type_id");
		int sr_score_type_score = rs.getInt("sr_score_type_score");
		String sr_score_type_name = rs.getString("sr_score_type_name");
		
		String sr_comment = rs.getString("sr_comment");
		String sr_ct = rs.getString("sr_ct");
		
		ScoreRecordTb sr = new ScoreRecordTb(sr_id, sr_student_id, sr_student_name, sr_score_type_id, sr_score_type_name,
				sr_score_type_score, sr_comment, sr_ct);
		
        return sr;
	}
	
	
	public static Combo loadStudentCombo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("stu_id");
		String text = rs.getString("stu_name");
//		String text = new String(rs.getString("stu_name").getBytes("UTF-8"));
		
		Combo sc = new Combo(id, text);
		
        return sc;
	}
	
	public static void loadStudentMap(Map<Integer, String> map, java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("stu_id");
		String text = rs.getString("stu_name");
		
		map.put(id, text);
	}
	
	public static Combo loadScoreTypeCombo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("st_id");
		String text = rs.getString("st_name");
		
		Combo sc = new Combo(id, text);
		
		return sc;
	}
	
	public static void loadScoreTypeMap(Map<Integer, String> map, java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("st_id");
		String text = rs.getString("st_name");
		
		map.put(id, text);
	}
	
	public static ScoreTypeScoreCombo loadScoreTypeScoreCombo(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		
		int id = rs.getInt("st_id");
		int text = rs.getInt("st_score");
//		String text = new String(rs.getString("st_name").getBytes("UTF-8"));
		
		ScoreTypeScoreCombo sc = new ScoreTypeScoreCombo(id, text+"");
		
		return sc;
	}
	
	
	public static ScoreType loadScoreType(java.sql.ResultSet rs) throws SQLException, UnsupportedEncodingException {
		int id = rs.getInt("st_id");
		String name = rs.getString("st_name");
		int score = rs.getInt("st_score"); 
		
		ScoreType st = new ScoreType(id, name, score);
		return st;
	}
}


