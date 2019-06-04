<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/6/2
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-9">
                <h2 class="text-center">当前用户： ${sessionScope.user.userid}  购物车</h2>
            </div>
            <div class="col-xs-3 nav nav-pills" style="margin: 15px 0 15px 0">
                <span><button class="btn btn-primary pull-right" onclick="back()">回到首页</button></span>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-8">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <td>货物名</td>
                        <td>价格</td>
                        <td>个数</td>
                        <td>小计</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.showList}" var="g">
                        <tr>
                            <td>${g.itemName}</td><td>${g.price}</td>
                            <td>
                                <button class="btn btn-primary" onclick="minusItem(${g.itemid})">-</button>
                                <span>
                                    ${g.itemCount}
                                </span>
                                <button class="btn btn-primary" onclick="addItem(${g.itemid})">+</button>
                            </td>
                            <td class="text-center">
                                    ${g.price * g.itemCount}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-xs-2"></div>
            <div class="row">
                <div class="col-xs-3"></div>
                <div class="col-xs-6">
                    <div class="well">
                        总计：$<strong id="sumPrice">${sessionScope.SumPrice}</strong>
                        <div class="pull-right">
                            <label>银行账户</label>
                            <select name="bankList" id="bankAccount">
                                <c:forEach items="${requestScope.BankList}" var="g">
                                    <option value="${g.accountid}">${g.accountid}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <button class="btn btn-primary pull-right" id="paybtn" onclick="pay()">支付</button>
                </div>
                <div class="col-xs-3"></div>
            </div>
        </div>
    </div>
    <script>
        var bankAccountDOM = document.getElementById("bankAccount");
        var SumPriceDOM = document.getElementById("sumPrice");

        function checkbtnCanUse() {
            return ((bankAccountDOM.value !== "") && (parseInt(SumPriceDOM.innerHTML) !== 0));

        }

        function minusItem(id) {
            //TODO
            //use ajax transfer itemid customerid and count(-1) to /changeCount
            changeItem(id,-1);
        }

        function addItem(id) {
            //TODO
            //use ajax transfer itemid customerid and count(+1) to /changeCount
            changeItem(id,1)
        }

        function changeItem(id,count) {
            $.ajax({
                url:encodeURI("${pageContext.request.contextPath}/changeCount"),
                type:"post",
                data:{
                    itemid:id,
                    itemcount:count
                },
                dataType:"json",
                success:function (msg) {
                    if (msg.isSuccess) {
                        location.reload();
                    }else{
                        alert("库存不足")
                    }
                }
            })
        }

        function back() {
            history.back();
        }
        
        function pay() {
            if(checkbtnCanUse()){
                $.ajax({
                    url:encodeURI("${pageContext.request.contextPath}/pay"),
                    type:"post",
                    data:{
                        accountid:bankAccountDOM.value
                    },
                    dataType:"json",
                    success:function (msg) {
                        if (msg.isSuccess) {
                            location.reload();
                            alert("支付成功");
                            history.back(2);
                        }else{
                            alert("支付失败")
                        }
                    }
                })
            }else{
                if((bankAccountDOM.value === "")){
                    alert("Please add your Account in add bank card panel!");
                }
                if((parseInt(SumPriceDOM.innerHTML) === 0)){
                    alert("Please select your item in your index!");
                }
            }
        }
    </script>
</body>
</html>
