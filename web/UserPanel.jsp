<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/6/2
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-9">
            <h2 class="text-center">Hello ${sessionScope.user.userid}</h2>
        </div>
            <div class="col-xs-3 nav nav-pills" style="margin: 15px 0 15px 0">
                <a href="<%request.getContextPath();%>/BankList" class="btn btn-default pull-right">添加银行卡账户</a>
                <a href="<%request.getContextPath();%>/CartList" class="btn btn-default pull-right">购物车</a>
            </div>
        </div>
        <hr>
        <h3>商品列表</h3>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Operation</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.list}" var="g">
                    <tr>
                        <td>${g.itemName}</td>
                        <td>${g.price}</td>
                        <td>
                            <button id="${g.itemid}" onclick="buy(${g.itemid})">购买</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        function buy(id) {
            $.ajax({
                url:encodeURI("${pageContext.request.contextPath}/buyitem"),
                type:"post",
                data:{
                    itemid:id
                },
                dataType:"json",
                success:function (msg) {
                    if (msg.isSuccess) {
                        alert("购买成功")
                    }else{
                        alert("库存不足")
                    }
                }
            })
        }
    </script>
</body>
</html>
