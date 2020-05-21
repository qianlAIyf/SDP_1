<%--
  Created by IntelliJ IDEA.
  User: 陈乾
  Date: 2020/5/20
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>register</title>
    <style>
        body {background-color:#b0c4de;}
        h1 {color: chartreuse;font-size: 80px;}
        h2 {color: gold;font-size: 30px;}
    </style>
</head>
<body>
<div><input type="button" value="返回登录" onclick="window.location.href='index.jsp'" style="float: right"></div>
<center>
    <h1>软件缺陷预测系统</h1>
    <h2>用户注册</h2>
</center>
<s:form action="user_registerUser" method="POST">
    <table align="center">
        <tr>
            <td><s:text name="账号"></s:text></td>
            <td><input type="text" name="name" style="width: 200px"></td>
        </tr>
        <tr>
            <td><s:text name="密码"></s:text></td>
            <td><input type="password" name="password" style="width: 200px"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" name="重置"></td>
        </tr>
    </table>
</s:form>
</body>
</html>
