<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Score Type Display</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="header.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
			});
		});
		
		$("#dg").style.width = screen.width/32*22;
	</script>
	
</head>
<body>
	<table id="dg" style="height:500px"
			url="GetScoreType.do"
			pagination="false"
			title="加分类型查询"
			singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="st_name" width="120" align="center">类型名称</th>
				<th field="st_score" width="80" align="center">类型分值</th>
			</tr>
		</thead>
	</table>
</body>
</html>