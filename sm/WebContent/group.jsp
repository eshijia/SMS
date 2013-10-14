<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Group Display</title>
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
						href:'GetGroup.do?groupId='+row.ast_id,
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
			url="GetAssistant.do"
			pagination="false"
			title="小组信息查询"
			singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="ast_id" width="80" align="center">小组编号</th>
				<th field="ast_name" width="80" align="center">研究生负责人</th>
				<th field="ast_phone" width="120" align="center">研究生联系方式</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>