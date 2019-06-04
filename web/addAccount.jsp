<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/6/2
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>银行账户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row" style="margin-bottom: 35px">
            <div class="col-xs-9">
                <h2 class="text-center">当前用户： ${sessionScope.user.userid}  银行卡号</h2>
            </div>
            <div class="col-xs-3 nav nav-pills" style="margin: 15px 0 15px 0">
                <button class="btn btn-primary pull-right" onclick="back()">回到首页</button>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-xs-3"></div>
            <div class="col-xs-6">
                <ul class="list-group">
                    <c:forEach items="${sessionScope.BankList}" var="g">
                        <li class="list-group-item">
                            <div>
                                <strong>${g.accountid}</strong>
                                <button  type="button" class="close" aria-label="Close" onclick="removeAccount(${g.accountid})">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-xs-3"></div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-xs-3"></div>
            <div class="col-xs-6">
                银行卡号：
                <input type="text" maxlength="8" class="form-control" id="Account_input">
                <button class="btn btn-primary glyphicon-align-center" style="text-align:center" onclick="addAccount()">
                    添加
                </button>
            </div>
            <div class="col-xs-3"></div>
        </div>
    </div>
    <script>
        function back() {
            history.back();
        }

        function addAccount() {
            var inputDom = document.getElementById("Account_input");
            var bankAccount = inputDom.value;
            changeAccount(bankAccount,1);
        }

        function removeAccount(bankAccount) {
            changeAccount(bankAccount,0);
        }


        function changeAccount(bankAcount,op) {
            $.ajax({
                url:encodeURI("${pageContext.request.contextPath}/changeAccount"),
                type:"post",
                data:{
                    accountid:bankAcount,
                    operation:op
                },
                dataType:"json",
                success:function (msg) {
                    if (msg.isSuccess) {
                        location.reload();
                    }else{
                        alert("修改失败");
                    }
                }
            })
        }
    </script>
</body>
</html>
