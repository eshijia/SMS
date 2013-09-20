<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*, java.util.*" %>
 
<table class="dv-table" border="0" style="width:100%;">
    <tr>
    	<td class="dv-label">加分序号</td>
    	<td class="dv-label">加分类型</td>
        <td class="dv-label">加分分数</td>
        <td class="dv-label">加分备注</td>
        <td class="dv-label">加分时间</td>
    </tr>
    
    <%
	List<ScoreRecord> srs = (ArrayList<ScoreRecord>)request.getAttribute("srs");

    int size = srs.size();
	for(ScoreRecord sr : srs) {
%>
	<tr>
        <td><%=size %></td>
        <td><%=sr.getSt().getSt_name() %></td>
        <td><%=sr.getSt().getSt_score() %></td>
        <td><%=sr.getSr_comment() %></td>
        <td><%=sr.getSr_ct() %></td>
    </tr>
<%
		size--;
	}
%>
</table>