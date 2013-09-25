<%@ page language="java" contentType="text/html; charset=utf8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Student Management</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="header.jsp" %>
	
	
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				view: detailview,
				detailFormatter:function(index,row){
					return '<div id="ddv-' + index + '" style="padding:5px 0"></div>';
				}
			});
		});
	</script>
	
</head>
<body>
	<table id="dg" style="width:1130px;height:500px"
			url="GetInfo.do"
			pagination="true"
			title="信息发布"
			singleSelect="true" fitColumns="false">
		<thead>
			<tr>
				<th field="if_id" width="50">序号</th>
				<th field="if_info" width="900">发布信息</th>
				<th field="if_ct" width="180">发布时间</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>