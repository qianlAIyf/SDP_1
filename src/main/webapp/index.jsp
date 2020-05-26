<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>SDP</title>
    <style>
        .theme{
            font-size: 80px;
            color: #FFF;
            font-weight: bolder;
            margin-top: 200px;
            margin-left: 1000px;
        }
        body{background-color: #66CC99;}
        .button{
            border-radius: 25px;
            width: 360px;
            height: 50px;
            color: #3C3;
            font-size: 28px;
            background-color: #FFF;
            margin-top: 25px;
            margin-left: 540px;
        }
        .button1{
            border-radius: 25px;
            width: 70px;
            height: 50px;
            color: #390;
            background-color: #C96;
			font-size: 28px;
            margin-left: 1200px;
        }
    </style>
</head>
<body>
<div>
    <input type="button" value="系统介绍" onClick="window.location.href='about.jsp'" style="font-size: 28px;background-color: #C96;border-radius: 25px;">
</div>
<div  class="theme">软件缺陷预测系统</div>
<div>
<s:form action="loginAction" method="POST" style="margin-top:100px; margin-left: 600px;">
    <input type="text" name="name" class="button" placeholder="账号"><br>
    <input type="password" name="password" class="button" placeholder="密码"><br>
    <input type="submit" value="登录" class="button">
</s:form>
<input type="button" value="注册" onClick="window.location.href='register.jsp'" class="button1">
</div>

</body>
</html>