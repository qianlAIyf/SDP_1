<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="action.LoginAction" %>

<html>
<head>
    <title>SDP</title>
    <style>
        body {background-color:#b0c4de;}
        h1 {color: chartreuse;font-size: 80px;}
    </style>
</head>
<body>
<div>
    <input type="button" value="注册" onclick="window.location.href='register.jsp'" style="float: right">
    <input type="button" value="系统介绍" onclick="window.location.href='register.jsp'" style="float: right">
</div>
<center><h1>软件缺陷预测系统</h1></center>
    <s:form action="loginAction" method="POST">
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
                <td><input type="submit" value="登录"></td>
                <td><input type="reset" name="重置"></td>
            </tr>
        </table>
    </s:form>
</body>
</html>