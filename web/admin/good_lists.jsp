<%@ page import="java.util.List" %>
<%@ page import="model.Good" %><%--
  Created by IntelliJ IDEA.
  User: SG-ZT
  Date: 2019/2/1
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    商品管理
    <hr/>
    添加
    <table border="1">
        <tr>
            <td>商品名</td><td>描述</td><td>价格</td><td>库存</td><td>操作</td>
        </tr>

        <c:forEach items="${requestScope.list}" var="g">
            <tr>
                <td>${g.name}</td><td>${g.des}</td><td>${g.price}</td><td>${g.inventory}</td><td>删除修改</td>
            </tr>
        </c:forEach>



        <%--<%--%>
            <%--List<Good> list = (List<Good>) request.getAttribute("list");--%>
            <%--if(list != null){--%>
                <%--for (Good good:list) {--%>
                    <%--%>--%>
                        <%--<tr>--%>
                            <%--<td><%=good.getName()%></td><td><%=good.getDes()%></td><td><%=good.getPrice()%></td><td><%=good.getInventory()%></td><td>删除 修改</td>--%>
                        <%--</tr>--%>
                    <%--<%--%>
                <%--}--%>
            <%--}--%>
        <%--%>--%>

        <%--<tr>--%>
            <%--<td>香蕉</td><td>菲律宾香蕉</td><td>500</td><td>78</td><td>删除 修改</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>香蕉</td><td>菲律宾香蕉</td><td>500</td><td>78</td><td>删除 修改</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>香蕉</td><td>菲律宾香蕉</td><td>500</td><td>78</td><td>删除 修改</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>香蕉</td><td>菲律宾香蕉</td><td>500</td><td>78</td><td>删除 修改</td>--%>
        <%--</tr>--%>
    </table>

</body>
</html>
