
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>User Information Management</title>
    <style>
        body{background-color: #66CC99;}
    </style>
</head>
<body>
<div>
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

<form action="getReport_action" method="post">
    <input type="submit" value="查看报告">
</form>

<s:iterator value="reports">
    <form action="about.jsp" method="post">
    <s:property value="id"></s:property>
    <s:property value="name"></s:property>
    <s:property value="path"></s:property>
        <s:property value="madeTime"></s:property>
        <s:property value=""></s:property>
    <s:property value="numberTrue"></s:property>
    <s:property value="numberFalse"></s:property>
        <input type="submit" value="查看"><br>
    </form>
</s:iterator>
</body>
</html>
