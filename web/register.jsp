<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("input[name='username']").blur(verifyUsername);
    });
    function verifyUsername() {
        //$("input[name='username']").val()
        $.ajax({
            url:encodeURI("${pageContext.request.contextPath}/verifyusername"),
            type:"post",
            data:{
                username:$("input[name='username']").val()
            },
            dataType:"json",
            success:function (msg) {
                if (msg.isSuccess) {
                    $("#msg").html("<font color='green'>用户名可以用</font>")
                }else{
                    $("#msg").html("<font color='red'>用户名不可以用</font>")
                }
            }
        })
    }
</script>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <div class="container">
            <h2 class="text-center">注册</h2>
            <hr/>
            <div class="row">
                <div class="col-xs-4"></div>
                <div class="col-xs-4 well">
                    ${requestScope.message}<br/>
                    <form action="<%=request.getContextPath()%>/register_do" method="post">
                        <hr/>
                        <div class="form-group">
                            用户名：<input type="text" name="username" class="form-control"/><div id="msg"></div>
                        </div>
                        <div class="form-group">
                            密码：<input type="password" name="password" class="form-control"/>
                        </div>
                        <div class="form-group">
                            Customerid：<input type="text" name="customerid" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="注册" class="btn btn-primary center-block">
                        </div>
                    </form>
                </div>
                <div class="col-xs-4"></div>
            </div>

    </div>

    <%--el表达式--%>

</body>
</html>
