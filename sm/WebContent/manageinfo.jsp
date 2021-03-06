<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>


<!DOCTYPE html>
<html>
<head>
	<title>Score Type Display</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<%@ include file="header.jsp" %>
	
</head>
<body>
    <table id="dg" title="信息管理" class="easyui-datagrid" style="height:500px"
            url="GetInfo.do"
            toolbar="#toolbar" pagination="false"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="if_ct" width="180">发布时间</th>
				<th field="if_info" width="900">发布信息</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加新信息</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑信息</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除信息</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:500px;height:380px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">信息管理</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>发布的信息:</label>
                <textarea cols="30" rows="10" name="if_info" id="info"></textarea>
            </div>
            <div class="fitem">
                <label>发布的时间:</label>  
                <input class="easyui-datetimebox"  id="if_ct" name="if_ct" 
        data-options="required:true,showSeconds:true" style="width:150px">
            </div>
        </form>
    </div>
  	<div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>   
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','添加新信息');
            $('#fm').form('clear');
            url = 'AddInfo.do';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','编辑旧信息');
                $('#fm').form('load',row);
                url = 'UpdateInfo.do?if_id='+row.if_id;
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','确定要删除该信息?',function(r){
                    if (r){
                        $.post('DeleteInfo.do',{if_id:row.if_id},function(result){
                            if (result.errorMsg){
                            	$.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            } else {
                            	  $('#dg').datagrid('reload');    // reload the user data  
                            }
                        },'json');
                    }
                });
            }
        }
        
        $("#dg").style.width = screen.width/32*22;
    </script>
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
</body>
</html>




<!--
<html>
 <body>
    <table id="dg" title="My Users" style="width:700px;height:250px"
            toolbar="#toolbar" pagination="true" idField="st_id"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="st_id" width="50" editor="{type:'validatebox',options:{required:true}}">序号</th>
                <th field="st_name" width="50" editor="{type:'validatebox',options:{required:true}}">分数类型</th>
                <th field="st_score" width="50" editor="{type:'validatebox',options:{required:true}}">类型分值</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">New</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
    </div>
    <script type="text/javascript">
        $(function(){
            $('#dg').edatagrid({
                url: 'GetScoreType.do',
                saveUrl: 'AddScoreType.do',
                updateUrl: 'UpdateScoreType.do',
                destroyUrl: 'DeleteScoreType.do'
            });
        });
        
        
        $('#dg').datagrid({
        	toolbar: [{
        		iconCls: 'icon-edit',
        		handler: function(){
        			alert('edit');
        			
        			var selected = $('#dg').datagrid('getSelected');
        			alert(selected.st_id);  
        		}
        	},'-',{
        		iconCls: 'icon-help',
        		handler: function(){
        			alert('help')
        		}
        	}]
        });
    </script>

	
</body>
</html>
 -->
