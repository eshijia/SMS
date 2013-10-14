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
import com.cloudlab.model.ScoreRecordTb;

public interface ScoreRecordDAO {
	public List<ScoreRecordTb> getAllScoreRecord();
	public int save(ScoreRecordTb sr);
	public int update(String sr_id, String sr_student_id, String sr_student_name,
			String sr_score_type_id, String sr_score_type_name, String sr_score_type_score, String sr_ct, String sr_comment);
	public int delete(String sr_id);
}


