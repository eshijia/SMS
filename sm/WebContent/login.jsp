<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description"
	content="easyui help you build your web page easily!">
<title>Login Face</title>
<%@ include file="header.jsp"%>

<script type="text/javascript">

	<!-- align table center in a div-->
	$(function() {
		$('#inner').show().width($('#innerTable').width()).css('margin',
				'0 auto');
		
		$('#outer').show().width($('#outer2').width()).css('margin',
		'0 auto');
	});
	
	function login() {
		/* var name = $('#username').val();
		var pwd = $('#password').val();
		
			 alert(name);
			alert(pwd);
		
		$.ajax({
			type: "get",
			url: "ValidateStudent?username="+name+"&password="+pwd,
			beforeSend: function(XMLHttpRequest){
			},
			success: function(data, textStatus){
				if(data == 0) {
					$('#username').val('');
					$('#password').val('');
					alert('username or password error');
				}
			},
			complete: function(XMLHttpRequest, textStatus){
			},
			error: function(){
			}
	}); */
		$('#loginForm').submit();
	}
	
</script>

<style>
.p-search {
	background: #fafafa;
	padding: 5px;
	border: 1px solid #ccc;
	border-bottom: 0;
	overflow: hidden;
}

.p-search input {
	width: 300px;
	border: 1px solid #ccc;
	background: #fff url('images/search.png') no-repeat right top;
}
 
.p-right {
	text-align: center;
	border: 1px solid #ccc;
	border-left: 0;
	width: 150px;
	background: #fafafa;
	padding-top: 10px;
}

h2 {
	text-align: center;
}

table {
	width: 50%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<h2>Login Face, O(∩_∩)O~</h2>
	
	<div id="outer">
	<div id="outer2" class="easyui-panel" title="用户登陆"
		iconCls="icon-search" collapsible="true"
		style="width:600px; margin:0 auto; height:220px;border:1px">
		<div class="easyui-layout" fit="true">
			<div region="center">
				<div class="easyui-layout" fit="true">
					<div region="west" border="false" class="p-right">
						<img src="image/msn.gif" />
					</div>
					<div region="center" border="false" style="border: 1px solid #ccc;">
						<div class="easyui-layout" fit="true">
							<div region="south" split="true" border="false"
								style="height: 60px;">
								<input type="button"
									style="border: 0; width: 100%; height: 100%; resize: none; bgcolor:yellow"
									name="login" value="登陆" onclick="login()"></input>
							</div>
							<div region="center" style="display:none;" id="inner" border="false">
							<form id='loginForm' method='post' action='ValidateUser'>
								<table id="innerTable">
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									
								<%
	
									User user = (User)application.getAttribute("user");
									if(user == null) {
								%>		

									<tr>
										<td>username：</td>
										<td><input type="text" id="username" name="username" value=""></input></td>
									</tr>
									<tr>
										<td>password：</td>
										<td><input type="password" id="password" name="password" value=""></input></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
								
								<%
									} else {
								%>
									<tr>
										<td>username：</td>
										<td><input type="text" id="username" name="username" value=<%=user.getU_username() %>></input></td>
									</tr>
									<tr>
										<td>password：</td>
										<td><input type="password" id="password" name="password" value=<%=user.getU_password() %>></input></td>
									</tr>
									<tr>
										<td></td>
										<td>用户名或者密码错误~~</td>
									</tr>
								<%
										
									}								
								%>
								</table>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	</div>

</body>
</html>