<%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
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
    <title>Title</title>
</head>
<body>
    <%--<%--%>
        <%--if (request.getAttribute("message") !=  null){--%>
            <%--System.out.println(request.getAttribute("message"));--%>
            <%--out.println(request.getAttribute("message") + "<br/>");--%>
        <%--}--%>
    <%--%>--%>



    <%--el表达式--%>
    ${requestScope.message}<br/>
    <form action="<%=request.getContextPath()%>/register_do" method="post">
        注册
        <hr/>
        用户名：<input type="text" name="username"/><div id="msg"></div>
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
