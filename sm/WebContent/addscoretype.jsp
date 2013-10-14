<%@ page language="java" contentType="text/html; charset=utf8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>添加新信息</title>
	<%@ include file="header.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			$('#ff').form({
				success:function(data){
					$.messager.alert('Info', data, 'info');
					
					if(data == '发布信息成功') {
						$("#createTime").attr("value","");
						$("#comment").val('');
					}
				}
			});
		});
	</script>

</head>
<body>

<form id="ff" action="AddScoreType.do" method="post">
    <table>
        <tr>
            <td>新加分类型:</td>
            <td>
            	<input type="text"  id="st_name" name="st_name" class="easyui-validatebox" data-options="required:true"></input>
			</td>
		</tr>
		
		<tr>
            <td>加分预设分值:</td>
            <td>
           	 	<input type="text"  id="st_score" name="st_score" class="easyui-validatebox" data-options="required:true"></input>
        	</td>
        </tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="添加新类型"></input></td>
        </tr>
    </table>
</form>

</body>
</html>
