<%@ page language="java" contentType="text/html; charset=utf8"%>


<!DOCTYPE html>
<html>
<head>

	<title>添加分数</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="header.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			$('#ff').form({
				success:function(data){
					$.messager.alert('Info', data, 'info');
					
					if(data == '保存加分记录成功') {
						$("#studentId").attr("value","");
						$("#scoreTypeId").attr("value","");
						$("#scoreTypeScore").attr("value","");
						$("#createTime").attr("value","");
						$("#comment").val('');
					}
				}
			});
		});
	</script>

</head>
<body>

<!-- <div style="padding:3px 2px;border-bottom:1px solid #ccc"></div> -->
<form id="ff" action="AddStudentScore.do" method="post">
    <table>
    	<tr>
            <td>姓名:</td>
            <td><input id="cc" class="easyui-combobox" id="studentId" name="studentId"
    data-options="valueField:'id',textField:'text',url:'GetStudentList.do',required:true"></input></td>
        </tr> 
   		
        <tr>
            <td>加分类型:</td>
            <td><input class="easyui-combobox" id="scoreTypeId" name="scoreTypeId"
    data-options="valueField:'id',textField:'text',url:'GetScoreTypeList.do',required:true,
        onSelect: function(rec){
            var url = 'GetScoreTypeScore.do?st_id='+rec.id;
            $('#xx').combobox('reload', url);
        }"></input></td>
        </tr>
        
        <tr>
        	<td>加分分数:</td>
            <td><input id="xx" name="xx"></input></td>
        </tr>
        
        <tr>
            <td>加分时间:</td>
            <td><input class="easyui-datetimebox"  id="createTime" name="createTime" 
        data-options="required:true,showSeconds:true" style="width:150px"></input></td>
        </tr>
        
        <tr>
            <td>加分备注:</td>
            <td>
            	<textarea cols="30" rows="5" name="comment" id="comment"></textarea>
			</td>
		</tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="添加"></input></td>
        </tr>
    </table>
</form>

</body>
</html>
