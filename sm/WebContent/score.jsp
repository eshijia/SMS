<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Score Display</title>
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
						
						border:true,
						cache:false,
						href:'GetStudentScoreDetail.do?studentId='+row.stu_id,
						onLoad:function(){
							$('#dg').datagrid('fixDetailRowHeight',index);
						}
					});
					$('#dg').datagrid('fixDetailRowHeight',index);
				} 
			});
		});
		
		$("#dg").style.width = screen.width/32*22;
	</script> 
	
</head>
<body>
    
	<table id="dg" style="height:500px"
			url="GetStudentScore.do"
			pagination="false" sortName="stu_id" sortOrder="asc"
			title="学生加分查询"
			singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<!-- <th field="stu_id" width="80" align="center" sortable="true">序号</th> -->
				<th field="stu_name" width="80" align="center">姓名</th>
				<th field="stu_score" width="180" align="center" sortable="true">累计分数</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>