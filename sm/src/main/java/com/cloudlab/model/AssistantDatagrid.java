/**
 * 文件名：Datagrid.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-16
 * Copyright by menuz
 */
package com.cloudlab.model;

import java.util.List;

public class AssistantDatagrid {
	public int total;
	public List<Assistant> rows;
	
	public AssistantDatagrid() {}

	public AssistantDatagrid(int total, List<Assistant> rows) {
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

	public List<Assistant> getRows() {
		return rows;
	}

	public void setRows(List<Assistant> rows) {
		this.rows = rows;
	}
	
	
}


