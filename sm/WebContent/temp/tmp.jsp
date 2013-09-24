<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nested Panel - jQuery EasyUI Demo</title>
   	
   	<%@ include file="../header.jsp"%>
   	
   	
</head>
<body>

    <div style="margin:10px 0;"></div>
    <div class="easyui-panel" title="Nested Panel" style="width:1200px;height:500px;padding:10px;">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'west',split:true" style="width:100px;padding:10px">
                Left Content
            </div>
            <div data-options="region:'center'" style="padding:10px">
                Right Content
            </div>
        </div>
    </div>
</body>
</html>