/**
 * 文件名：UserDAO.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.dao;

import java.util.List;
import java.util.Map;

import com.cloudlab.model.Combo;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.ScoreTypeScoreCombo;
import com.cloudlab.model.Student;
import com.cloudlab.model.User;

public interface StudentDAO {
	public List<Student> getAllUsers();
	public List<Student> getAllUserBasicInfo();
	public List<ScoreRecord> getStudentScoreDetail(int studentId);
	public List<Combo> getStudentNameList();
	public List<Combo> getScoreTypeList();
	public Map<Integer, String> getStudentMap();
	public Map<Integer, String> getScoreTypeMap();
	public List<ScoreTypeScoreCombo> getScoreTypeScore(String scoretypeid);
	public int validate(User user);
	public int save(ScoreRecord st);
}


