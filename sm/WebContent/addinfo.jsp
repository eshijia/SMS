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

<form id="ff" action="AddInfo.do" method="post">
    <table>
        <tr>
            <td>发布的信息:</td>
            <td>
            	<textarea cols="30" rows="5" name="info" id="info"></textarea>
			</td>
		</tr>
		
		<tr>
            <td>发布的时间:</td>
            <td><input class="easyui-datetimebox"  id="createTime" name="createTime" 
        data-options="required:true,showSeconds:true" style="width:150px"></input></td>
        </tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="添加新信息"></input></td>
        </tr>
    </table>
</form>

</body>
</html>
