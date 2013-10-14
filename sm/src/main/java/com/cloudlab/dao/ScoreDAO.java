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

public interface ScoreDAO {
	public List<ScoreRecord> getLastestScore(int n);
	public List<ScoreRecord> getScore();
	public List<ScoreRecord> getHighestScore();
}


