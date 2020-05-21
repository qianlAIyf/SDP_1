<%--
  Created by IntelliJ IDEA.
  User: 陈乾
  Date: 2020/5/21
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
<%--    <meta http-equiv="refresh" content="3;url=index.jsp">--%>
</head>
<body>
<p style="color: chartreuse">恭喜您注册成功！</p><br>
<script type="text/javascript">
    var t=3;
    setInterval('jump()',1000);
    function jump(){
        if(t==0){
            location="index.jsp";
        }
        document.getElementById('show').innerHTML=""+t+"秒后跳转到登陆页面...";
        t--;
    }
</script>
<span id=show></span>

</body>
</html>
