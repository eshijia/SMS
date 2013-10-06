<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="header.jsp" %>
	
	
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({ 
			});
		});
	</script> 
	
</head>
<body>
    
	<table id="dg" style="width:1130px;height:500px"
			url="GetScore.do"
			pagination="false"
			title="学生加分信息"
			singleSelect="false" fitColumns="true"
			method="get" multiSort="true">
		<thead>
			<tr>
				<th field="sr_id" width="80" align="center" sortable="true">加分记录号</th>
				<th field="stu_no" width="80" align="center">学号</th>
				<th field="stu_name" width="80" align="center">姓名</th>
				<th field="sr_ct_str" width="80" align="center" sortable="true">得分时间</th>
				<th field="st_name" width="120" align="center">得分类型</th>
				<th field="st_score" width="120" align="center">本次得分</th>
				<th field="srt_score" width="120" align="center" sortable="true">累计得分</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>