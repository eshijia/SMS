/**
 * 文件名：UserDAO.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.dao;

import java.util.List;

import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.Student;
import com.cloudlab.model.StudentCombo;

public interface StudentDAO {
	public List<Student> getAllUsers();
	public List<ScoreRecord> getStudentScoreDetail(int studentId);
	public List<StudentCombo> getStudentNameList();
}


