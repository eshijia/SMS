/**
 * 文件名：UserDAO.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.dao;

import java.util.List;

import com.cloudlab.model.ScoreType;
import com.cloudlab.model.Student;

public interface ScoreTypeDAO {
	public List<ScoreType> getAllScoreType();
	public int save(ScoreType st);
	public int delete(int st_id);
	public int delete(String st_id);
	public int update(String st_id, String st_name, String st_score);
}


