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
    <input type="button" class="button" onClick="window.location.href='userInfo_management.jsp'" value="模型训练">
    <input type="button" class="button" onClick="window.location.href='userInfo_management.jsp'" value="缺陷预测">
</div>

<div style="width: 1000px; height:600px;border:#3FF solid 1px; ">
    <p style="color: blue;">欢迎使用软件缺陷预测系统，下面是缺陷预测的执行步骤，请按照顺序依次执行！</p>
    <s:form action="predict_Action" method="POST" enctype="multipart/form-data">
        <div>
            <label style="font-size: 30px;">选择数据集</label><br>
            <input type="file" name="dataset"><br>
        </div>
        <div>
            <label style="font-size: 30px;">选择模型</label><br>
                <%--            <s:radio list="{'LLE-SVM','IGA-SVM','JCUDA-BP'}" name="method"></s:radio>--%>
            <div style="overflow-x: auto;overflow-y: auto;border: 1px solid silver; width: 950px; height: 400px">
                <s:iterator value="models" status="li">
                    <label><input type="radio" name="model_id" value="<s:property value="id"/>"></label>&nbsp;
                    <label><s:property value="name"></s:property> </label>&nbsp;
                    <label><s:property value="madeTime"></s:property> </label>&nbsp;
                    <label><s:property value="accuracy"></s:property> </label><br>
                </s:iterator>
            </div>
        </div>
        <input type="submit" value="开始预测">
    </s:form>
</div>

</body>
</html>
