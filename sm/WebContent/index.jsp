<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Course Introduction</title> <%@ include file="header.jsp"%>
	<script type="text/javascript">
		function addTab(title, url) {
			if ($('#tt').tabs('exists', title)) {
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'
						+ url + '" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add', {
					title : title,
					content : content,
					closable : true
				});
			}
		}
		
		$("#navi").style.width = screen.width/32*6;
		$("#tt").style.width = screen.width/32*24;
	</script>

	<style type="text/css">
body {
	font-family: Georgia, "Times New Roman", Times, serif;
}

h1 {
	font-family: Helvetica, Geneva, Arial, SunSans-Regular, sans-serif
}

p {
	text-indent: 2em; /*em是相对单位，2em即现在一个字大小的两倍*/
}

h1 {
	text-align: center;
	font-size: 200%;
}

ul {
	list-style: none;
	margin: 10px;
}

ul li {
	padding-bottom: 5px;
}

#title {
	text-align: center;
	font-size: 200%;
}

#login {
	text-align: right;
	padding: 10px;
}
</style>
</head>
<body>
	<div id="header">
		<div id="title">数据库系统概论</div>
		<div id="login">
			<%
				User user = (User) session.getAttribute("user");
				if (user == null) {
					response.sendRedirect("login.jsp");
					return;
				} else {
					if (user.getU_admin() == 1) {
			%>
			<a href="#" class="easyui-linkbutton">管理员:<%=user.getU_username()%></a>
			<a href="logout.jsp" class="easyui-linkbutton">注销</a>
			<%
				} else {
			%>
			<a href="#" class="easyui-linkbutton">普通用员:<%=user.getU_username()%></a>
			<a href="logout.jsp" class="easyui-linkbutton">注销</a>
			<%
				}
				}
			%>
		</div>
	</div>
	
	<div class="easyui-layout" style="width:100%; height: 600px;">
		<div id="navi" region="west" split="false" title="功能导航"
			style="width:220px; align:center;">
			<ul>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('课程介绍','course.jsp')">课程介绍</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('信息查询','info.jsp')">信息查询</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('分数查询','score.jsp')">分数查询</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('类型查询','scoretype.jsp')">类型查询</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('学生查询','student.jsp')">学生查询</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('小组查询','group.jsp')">小组查询</a></li>
				<%
					if (user.getU_admin() == 1) {
				%>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('加分管理','managescorerecord.jsp')">加分管理</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('类型管理','managescoretype.jsp')">类型管理</a></li>
				<li><a href="#" class="easyui-linkbutton"
					onclick="addTab('信息管理','manageinfo.jsp')">信息管理</a></li>
				<%
					}
				%>
			</ul>
		</div>

		<div id="tt" class="easyui-tabs" region="center"
			style="height:250px;">
		</div>
	</div>
</body>
</html>