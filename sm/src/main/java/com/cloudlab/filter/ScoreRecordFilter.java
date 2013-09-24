/**
 * 文件名：StudentRecordFilter.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-22
 * Copyright by menuz
 */
package com.cloudlab.filter;

import java.util.ArrayList;
import java.util.List;

import com.cloudlab.model.ScoreRecord;

public class ScoreRecordFilter implements Filter{
	List<ScoreRecord> srs;
	
	public ScoreRecordFilter() {}
	
	public ScoreRecordFilter(List<ScoreRecord> srs) {
		super();
		this.srs = srs;
	}

	public List<ScoreRecord> getSrs() {
		return srs;
	}

	public void setSrs(List<ScoreRecord> srs) {
		this.srs = srs;
	}

	@Override
	public List<ScoreRecord> filter() {
		List<ScoreRecord> list = new ArrayList<ScoreRecord>();
		for(ScoreRecord sr : srs) {
			if(sr.getSr_score_type_id() != 1) {
				list.add(sr);
			}  
		}
		return list;
	}
}


