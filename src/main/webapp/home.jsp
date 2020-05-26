<%--
  Created by IntelliJ IDEA.
  User: 陈乾
  Date: 2020/5/21
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>the home of sdp</title>
    <style>
        .theme{
            position: relative;
            font-size: 64px;
            color: #FFF;
            font-weight: bolder;
            margin-top: 10px;
            margin-left: 500px;
        }
        body{background-color: #66CC99;}
        .button{
            width:140px;
            height: 50px;
            font-size: 18px;

        }
        .button1{
            border-radius: 25px;
            width: 100px;
            height: 50px;
            color: #390;
            background-color: #C96;
            font-size: 28px;
        }
    </style>
</head>
<body>
<div>
    <button onclick="window.location.href='index.jsp'" class="button1" style="float: left">注销</button>
</div>
<div class="theme">软件缺陷预测系统</div>

<div style="width:500px">
    <input type="button" class="button" onClick="window.location.href='userInfo_management.jsp'" value="用户信息管理">
    <input type="button" class="button" onClick="window.location.href='home.jsp'" value="模型训练">
    <%--<input type="button" class="button" onClick="window.location.href='get_models.jsp'" value="缺陷预测">--%>
    <form action="getModel_action" method="post"> <input type="submit" class="button" value="缺陷预测"></form>
</div>

<div style="width: 1000px; height:600px;border:#3FF solid 1px; ">
    <p style="color: blue;">欢迎使用软件缺陷预测系统，基本原理如下！</p>
    <s:form action="modelTrainAction" method="POST" enctype="multipart/form-data">
        <div>
            <label style="font-size: 30px;">选择数据集</label><br>
            <input type="file" name="dataset"><br>
        </div>
        <hr>
        <div>
            <label style="font-size: 30px;">选择算法</label><br>
<%--            <s:radio list="{'LLE-SVM','IGA-SVM','JCUDA-BP'}" name="method"></s:radio>--%>
            <label><input type="radio" name="method" value="LLE-SVM">LLE-SVM</label>
            <label><input type="radio" name="method" value="IGA-SVM">IGA-SVM</label>
            <label><input type="radio" name="method" value="JCUDA-BP">JCUDA-BP</label>
        </div>
        <hr>
        <input type="submit" value="开始训练">
    </s:form>
</div>

</body>
</html>
