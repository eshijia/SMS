/**
 * 文件名：UserDAO.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.dao;

import java.util.List;

import com.cloudlab.model.Assistant;
import com.cloudlab.model.Combo;
import com.cloudlab.model.ScoreRecord;
import com.cloudlab.model.Student;
import com.cloudlab.model.User;

public interface GroupDAO {
	public List<Assistant> getAllAssistants();
	public List<Student> getStudentListByGroupId(String groupId);
}


