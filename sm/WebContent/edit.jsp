<%@ page language="java" contentType="text/html; charset=utf8"%>


<!DOCTYPE html>
<html>
<head>

	<title>添加分数</title>
	<%@ include file="header.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			$('#ff').form({
				success:function(data){
					$.messager.alert('Info', data, 'info');
				}
			});
		});
		
	/* 	function load()
		{
			$('#language').combobox('load', 'GetStudentList');
		} */
		</script>
	</script>

</head>
<body>

<div style="padding:3px 2px;border-bottom:1px solid #ccc">Ajax Form</div>
<form id="ff" action="AddStudentScore" method="post">
    <table>
    
    	<!-- <tr>
            <td>姓名:</td>
            <td><input id="cc" class="easyui-combobox" name="name"
    data-options="valueField:'id',textField:'text',url:'GetStudentList'"></input></td>
        </tr> -->
        
        <tr>
        	<td>姓名:</td>
        	 <td> <input class="easyui-combobox" id="language" name="language"
            data-options="valueField:'id',textField:'text'"></td>
    	</div>
   		
   		</tr>
   		
     	<!-- <tr>
            <td>姓名:</td>
            <td><input name="name" type="text"></input></td>
        </tr> -->
        
        <tr>
            <td>加分类型:</td>
            <td><input name="email" type="text"></input></td>
        </tr>
        
        <tr>
            <td>加分时间:</td>
            <td><input class="easyui-datetimebox" name="birthday" 
        data-options="required:true,showSeconds:false" style="width:150px"></input></td>
        </tr>
        
        <tr>
            <td>加分备注:</td>
            <td><textarea cols="30" rows="5">
 
				</textarea>
			</td>
		</tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></input></td>
        </tr>
    </table>
    
    
     <input class="easyui-combobox" name="browser" style="width:280px;" id="studentCombo" 
            >
</form>
<script type="text/javascript">
	$("#studentCombo").combobox({
        url: 'GetStudentList',
        method: 'get',
        value:'qingxzs',
        valueField:'id',
        textField:'text'
	});
</script>
</body>
</html>
