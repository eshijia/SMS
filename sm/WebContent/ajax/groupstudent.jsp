<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*, java.util.*" %>
 
<table class="dv-table" border="0" style="width:100%;">
   <!--  <tr>
    	<td class="dv-label">加分序号</td>
    	<td class="dv-label">加分类型</td>
        <td class="dv-label">加分分数</td>
        <td class="dv-label">加分备注</td>
        <td class="dv-label">加分时间</td>
    </tr> -->
    
    <tr>
    	<!-- <td class="dv-label">序号</td> -->
    	<!-- <td class="dv-label">学号</td> -->
        <td class="dv-label">姓名</td>
        <td class="dv-label">性别</td>
        <td class="dv-label">专业</td>
        <td class="dv-label">号码</td>
        <td class="dv-label">组长</td>
    </tr>
    
    
    <%
	List<Student> ss = (ArrayList<Student>)request.getAttribute("ss");

    int size = ss.size();
	for(Student student : ss) {
%>
	<tr>
        <%-- <td><%=size %></td> --%>
        <%-- <td><%=student.getStu_no() %></td> --%>
        <td><%=student.getStu_name()%></td>
        <td><%=student.getStu_sex()%></td>
        <td><%=student.getStu_major() %></td>
        <td><%=student.getStu_phone() %></td>
        
        <% if(student.getStu_grp_leader() == 1) { %>
        <td>小组长</td>
        <%} else {%>
        <td></td>
        <%} %>
    </tr>
<%
		size--;
	}
%>
</table>