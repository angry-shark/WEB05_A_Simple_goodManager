<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getAttribute("message") !=  null){
        out.println(request.getAttribute("message") + "<br/>");
    }
%>
<form action="<%=request.getContextPath()%>/login_do" method="post">
    登陆
    <hr/>
    用户名：<input type="text" name="username"/>
    <br/>
    密码：<input type="password" name="password"/>
    <br/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
