/**
 * 文件名：Datagrid.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-16
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.util.List;

public class Datagrid<T> {
	public int total;
	public List<T> rows;
	
	public Datagrid() {}

	public Datagrid(int total, List<T> rows) {
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

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T > rows) {
		this.rows = rows;
	}
	
	
}


