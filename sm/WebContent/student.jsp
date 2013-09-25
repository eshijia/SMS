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
				view: detailview,
				detailFormatter:function(index,row){
					return '<div id="ddv-' + index + '" style="padding:5px 0"></div>';
				},
				onExpandRow: function(index,row){
					$('#ddv-'+index).panel({
						/*height:80,*/
						border:true,
						cache:false,
						href:'GetStudentScore.do?studentId='+row.stu_id,
						onLoad:function(){
							$('#dg').datagrid('fixDetailRowHeight',index);
						}
					});
					$('#dg').datagrid('fixDetailRowHeight',index);
				}
			});
		});
	</script>
	
</head>
<body>
    
	<table id="dg" style="width:1130px;height:500px"
			url="GetStudent.do"
			pagination="false" sortName="stu_score" sortOrder="desc"
			title="学生加分信息"
			singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="stu_id" width="80" align="center" sortable="true">序号</th>
				<th field="stu_no" width="80" align="center">学号</th>
				<th field="stu_name" width="120" align="center">姓名</th>
				<th field="stu_sex" width="80" align="center">性别</th>
				<th field="stu_major" width="120" align="center">专业</th>
				<th field="stu_phone" width="120" align="center">号码</th>
				
				<%  
				User user =(User)session.getAttribute("user");
				if(user.getU_admin() == 1) {
					%>
					<th field="stu_level" width="80" align="center">级别</th>
					<% 
				}
				%>
				<th field="stu_score" width="80" align="center" sortable="true">分数</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>