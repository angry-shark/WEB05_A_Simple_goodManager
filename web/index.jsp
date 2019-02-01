<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%
    Object user = session.getAttribute("user");
    if (user == null){
        System.out.println("no");
        %>
        <a href="<%request.getContextPath();%>/login.jsp">登陆</a> <a href="<%request.getContextPath();%>/register.jsp">注册</a>
        <%
    }else{
      System.out.println("yes");
      out.println("当前登陆用户：" + ((User)user).getUsername());
    }
  %>
  <hr/>
  各种商品的展示
  </body>
</html>
