<%@ page language="java" contentType="text/html; charset=utf8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Info Display</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="header.jsp" %>
	
	
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				/* view: detailview, */
				onClickRow:function(index, data) {
					/* alert(data.if_info); */
					$.messager.show({
						title:'详细内容',
						msg:data.if_info,
						timeout:5000,
						showType:'show',
						width:500,
						height:300,
						style:{
							right:'',
							top:document.body.scrollTop+document.documentElement.scrollTop,
							bottom:''
						}
					});
					
				}
			});
		});
		
		$("#dg").style.width = screen.width/32*22;
	</script>
	
</head>
<body>
	<table id="dg" style="height:500px"
			url="GetInfo.do"
			pagination="false"
			title="信息发布查询(单击行查看详细内容)"
			singleSelect="true" fitColumns="false">
		<thead>
			<tr>
				<th field="if_ct">发布时间</th>
				<th field="if_info">发布信息</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>