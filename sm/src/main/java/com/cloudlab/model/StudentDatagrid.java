/**
 * 文件名：Datagrid.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-16
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.util.List;

public class StudentDatagrid {
	public int total;
	public List<Student> rows;
	
	public StudentDatagrid() {}

	public StudentDatagrid(int total, List<Student> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Student> getRows() {
		return rows;
	}

	public void setRows(List<Student> rows) {
		this.rows = rows;
	}
	
	
}


