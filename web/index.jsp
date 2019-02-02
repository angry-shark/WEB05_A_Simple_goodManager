<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <c:choose>
      <%--如果user为空--%>
      <c:when test="${empty sessionScope.user}">
          <a href="<%request.getContextPath();%>/login.jsp">登陆</a> <a href="<%request.getContextPath();%>/register.jsp">注册</a>
      </c:when>
      <c:otherwise>
          当前登录用户：${sessionScope.user.username}
      </c:otherwise>
  </c:choose>



  <%--<%--%>
    <%--Object user = session.getAttribute("user");--%>
    <%--if (user == null){--%>
        <%--System.out.println("no");--%>
        <%--%>--%>
        <%--<a href="<%request.getContextPath();%>/login.jsp">登陆</a> <a href="<%request.getContextPath();%>/register.jsp">注册</a>--%>
        <%--<%--%>
    <%--}else{--%>
      <%--System.out.println("yes");--%>
      <%--out.println("当前登陆用户：" + ((User)user).getUsername());--%>
    <%--}--%>
  <%--%>--%>
  <hr/>
  各种商品的展示
  </body>
</html>
