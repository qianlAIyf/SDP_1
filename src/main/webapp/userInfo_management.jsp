<%@ taglib prefix="logic" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="action.GetDatasetsAction" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈乾
  Date: 2020/5/23
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information Management(Dataset Management)</title>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <style>
        body{background-color: #66CC99;}
        .div{width: 50%;border: 1px solid silver;float: left;box-sizing: border-box}
    </style>
</head>
<body>
<div style="height: 10%">
    <button onclick="window.location.href='home.jsp'" style="float: right ;background-color: chartreuse">返回</button>
    <center><h1>信息管理</h1></center>
</div>
<div style="color: lightsteelblue; height: 10%; width:100%;">
    <table bgcolor="#006400" border="1" width="100%" style="cursor: pointer">
        <tr><th onclick="window.location.href='userInfo_management.jsp'">数据集管理</th>
            <th onclick="window.location.href='model_management.jsp'">模型管理</th>
            <th onclick="window.location.href='report_management.jsp'">报告管理</th></tr>
    </table>
</div>
<%--<div style="float: left; width: 45%;height: 60%">
    <label>数据集</label>
</div>
<div style="width: 5%;float: left;border: 1px solid blue;height: 60%" >
    <button>查看</button><br>
    <br><button>删除</button><br>
    <br><button>重命名</button>
</div>
<div style="float: right; width: 50%;height: 60%">
    <label>内容</label>
</div>--%>
<div>
<script type="text/javascript">
    $(function () {
        $("#upload").bind("click", function () {
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
            if (regex.test($("#fileUpload").val().toLowerCase())) {
                if (typeof (FileReader) != "undefined") {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var table = $("<table />");
                        var rows = e.target.result.split("\n");
                        for (var i = 0; i < rows.length; i++) {
                            var row = $("<tr />");
                            var cells = rows[i].split(",");
                            for (var j = 0; j < cells.length; j++) {
                                var cell = $("<td />");
                                cell.html(cells[j]);
                                row.append(cell);
                            }
                            table.append(row);
                        }
                        $("#dvCSV").html('');
                        $("#dvCSV").append(table);
                    }
                    reader.readAsText($("#fileUpload")[0].files[0]);
                } else {
                    alert("This browser does not support HTML5.");
                }
            } else {
                alert("Please upload a valid CSV file.");
            }
        });
    });
</script>
<form action="dataset_upload" method="post" enctype="multipart/form-data">
    <input type="file" id="fileUpload" name="file"/>
    <input type="button" id="upload" value="查看" />
    <input type="submit" value="上传">
</form>

</div>
<div id="dvCSV" class="div" style="overflow-x: auto;overflow-y: auto;border: 1px solid silver;"></div>
<div id="dvCSV_" class="div" style="overflow-x: auto;overflow-y: auto;border: 1px solid silver;">
<%--    <logic:iterator name="">--%>
    <form action="getDataset_action" method="post">
        <input type="submit" value="查看历史数据集">
    </form>
    <s:iterator value="datasets" status="li">
        <label><s:property value="id"></s:property></label>
        <label><s:property value="name"></s:property></label>
        <label><s:property value="loadTime"></s:property></label><br>
    </s:iterator>
<%--    </logic:iterator>--%>
</div>
</body>
</html>
