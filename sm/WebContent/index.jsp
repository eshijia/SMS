<%-- <%@ page contentType="text/html; charset=utf8" %> --%>
<%@ page language="java" contentType="text/html; charset=utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>Build border layout for web pages - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">		
		function addTab(title, url){
		    if ($('#tt').tabs('exists', title)){
		        $('#tt').tabs('select', title);
		    } else {
		        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		        $('#tt').tabs('add',{
		            title:title,
		            content:content,
		            closable:true
		        });
		    }
		}
	</script>
</head>
<body>
	<h2>数据库系统原理课程</h2>
	
	<div class="easyui-layout" style="width:90%;height:600px;">
		<div region="west" split="true" title="功能导航" style="width:200px;">
			<ul>
				<li><a href="#" class="easyui-linkbutton" onclick="addTab('课程介绍','course.jsp')">课程介绍</a></li>
    			<li><a href="#" class="easyui-linkbutton" onclick="addTab('信息发布','info.jsp')">信息通知</a></li>
    			<li><a href="#" class="easyui-linkbutton" onclick="addTab('学生管理','student.jsp')">学生管理</a></li>
			</ul>
		</div>
		
		<div id="tt" class="easyui-tabs"  region="center" style="width:400px;height:100px;">
			<div title="课程介绍">
    			
    		</div>
		</div>
	
		<div region="east" split="true" title="功能导航" style="width:200px;">
			<ul>
				<li><a href="javascript:void(0)" onclick="showcontent('java')">课程介绍</a></li>
				<li><a href="javascript:void(0)" onclick="showcontent('cshape')">信息发布</a></li>
				<li><a href="javascript:void(0)" onclick="showcontent('vb')">学生管理</a></li>
			</ul>
		</div>
	</div>
</body>
</html>