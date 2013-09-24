/**
 * 文件名：ComparatorStudent.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-22
 * Copyright by menuz
 */
package com.cloudlab.comparator;

import java.util.Comparator;

import com.cloudlab.model.Student;

public class ComparatorStudentDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Student s0=(Student)o1;
		Student s1=(Student)o2;
		
		int score0 = s0.getStu_score();
		int score1 = s1.getStu_score();
		
		if(score0 < score1) {
			return 1;
		} else if(score0 == score1) {
			int stu_id0 = s0.getStu_id();
			int stu_id1 = s1.getStu_id();
			
			if(stu_id0 <= stu_id1) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

}


