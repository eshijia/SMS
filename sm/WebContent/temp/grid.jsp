<%@ page language="java" contentType="text/html; charset=utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Custom DataGrid Paging - jQuery EasyUI Demo</title>
	<%@ include file="../header.jsp"%>
</head>
<body>
	<h2>Custom DataGrid Paging</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>You can append some buttons to the standard datagrid pager bar.</div>
	</div>
	
	<table id="tt" title="Load Data" class="easyui-datagrid" style="width:700px;height:250px"
			url="GetUserServlet"
			iconCls="icon-save" pagination="true">
		<thead>
			<tr>
				<th field="stu_no" width="80">stu_no</th>
				<th field="stu_name" width="120">stu_name</th>
				<th field="stu_sex" width="80" align="right">stu_sex</th>
				<th field="stu_major" width="80" align="right">stu_major</th>
				<th field="stu_score" width="250">stu_score</th>
			</tr>
		</thead>
	</table>
</body>

</html>