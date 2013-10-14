/**
 * 文件名：Cache.java
 *
 * 版本信息： version 1.0
 * 日期：2013-10-14
 * Copyright by menuz
 */
package com.cloudlab.util;

import java.util.Map;

import com.cloudlab.dao.StudentDAO;
import com.cloudlab.dao.imp.StudentDAOImp;

public class Cache {
	
	Map<Integer, String> stuMap;
	Map<Integer, String> scoretypeMap;
	
	StudentDAO stuDAO;
	
	public Cache() {
		stuDAO = new StudentDAOImp();
		stuMap = stuDAO.getStudentMap();
		scoretypeMap = stuDAO.getScoreTypeMap();
	}
	
	public String getStuNameById(int id){
		String stuName = stuMap.get(id);
		return stuName;
	}
	public String getScoreTypeNameById(int id) {
		String scoretypeName = scoretypeMap.get(id);
		return scoretypeName;
	}
	
}


