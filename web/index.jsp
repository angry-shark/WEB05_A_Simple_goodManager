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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  <body>

    <div class="container">
        <form action="<%=request.getContextPath()%>/login_do" method="post">
            <h2 class="text-center">登陆</h2>
            <hr/>
            <div class="row">
                <div class="col-xs-4"></div>
                <div class="col-xs-4 well">
                    <div class="form-group">
                        customerid：<input type="text" name="customerid" class="form-control"/>
                    </div>
                    <div class="form-group">
                        username：<input type="text" name="username" class="form-control"/>
                    </div>

                    <div class="form-group">
                        password：<input type="password" name="password" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="登陆" class="btn btn-primary pull-left" style="margin: 60px;">
                        <a href="<%request.getContextPath();%>/register.jsp" class="btn btn-primary pull-right" style="margin: 60px;">注册</a>
                    </div>
                </div>
                <div class="col-xs-4"></div>
            </div>

        </form>
    </div>
  </body>
</html>
