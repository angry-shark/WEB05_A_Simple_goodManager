<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 21:38
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
            System.out.println(request.getAttribute("message"));
            out.println(request.getAttribute("message") + "<br/>");
        }
    %>
    <form action="<%=request.getContextPath()%>/register_do" method="post">
        注册
        <hr/>
        用户名：<input type="text" name="username"/>
        <br/>
        密码：<input type="password" name="password"/>
        <br/>
        年龄：<input type="text" name="age"/>
        <br/>
        性别：男<input type="radio" name="sex" value="男" checked="checked">
        女<input type="radio" name="sex" value="女">
        <br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
