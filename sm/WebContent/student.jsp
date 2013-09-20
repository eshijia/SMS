<%@ page language="java" contentType="text/html; charset=utf8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Student Management</title>
	<%@ include file="header.jsp" %>
	
	
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				view: detailview,
				detailFormatter:function(index,row){
					return '<div id="ddv-' + index + '" style="padding:5px 0"></div>';
				},
				onExpandRow: function(index,row){
					$('#ddv-'+index).panel({
						height:80,
						border:false,
						cache:false,
						href:'GetStudentScoreServlet?studentId='+row.stu_id,
						onLoad:function(){
							$('#dg').datagrid('fixDetailRowHeight',index);
						}
					});
					$('#dg').datagrid('fixDetailRowHeight',index);
				}
			});
		});
	</script>
	
		<script type="text/javascript">
		function formatAction(value,row,index){
			if (row.editing){
				var s = '<a href="#" onclick="saverow(this)">Save</a> ';
				return s;
			} else {
				var e = '<a href="#" onclick="editrow(this)">Edit</a> ';
				return e;   
			} 
		}
		
		function getRowIndex(target){
			var tr = $(target).closest('tr.datagrid-row');
			return parseInt(tr.attr('datagrid-row-index'));
		}
		
		/* function editrow(target){
			alert(getRowIndex(target));
			
			var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.alert('Info', row.stu_id+":"+row.productid+":"+row.attr1);
            }
		} */
		
		 function getSelected(){
	            var row = $('#dg').datagrid('getSelected');
	            if (row){
	                $.messager.alert('Info', row.stu_id+":"+row.productid+":"+row.attr1);
	            }
	        }

		</script>
	
	
	

	
	
</head>
<body>
	<!--  <div style="margin:10px 0;">
        <a href="#" class="easyui-linkbutton" onclick="getSelected()">GetSelected</a>
    </div> -->
    
	<table id="dg" style="width:900px;height:500px"
			url="GetUserServlet"
			pagination="false" sortName="stu_id" sortOrder="desc"
			title="学生加分信息"
			singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="stu_id" width="80">stu_id</th>
				<th field="stu_no" width="80">stu_no</th>
				<th field="stu_name" width="120">stu_name</th>
				<th field="stu_sex" width="80" align="right">stu_sex</th>
				<th field="stu_major" width="80" align="right">stu_major</th>
				<th field="stu_phone" width="80">stu_phone</th>
				<th field="stu_level" width="80">stu_level</th>
				<th field="stu_score" width="250">stu_score</th>
				<!-- <th field="action" width="80" align="center" formatter="formatAction">Action</th> -->
			</tr>
		</thead>
	</table>
	
	<div id="win" class="easyui-window" title="My Window" closed="true" style="width:300px;height:100px;padding:5px;">
    	Some Content.
	</div>
	
</body>
</html>