/**
 * 文件名：Datagrid.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-16
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.util.List;

public class InfoDatagrid {
	public int total;
	public List<Info> rows;
	
	public InfoDatagrid() {}

	public InfoDatagrid(int total, List<Info> rows) {
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

	public List<Info> getRows() {
		return rows;
	}

	public void setRows(List<Info> rows) {
		this.rows = rows;
	}
	
	
}


