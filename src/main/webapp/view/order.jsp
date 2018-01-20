<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/20
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
    <table>
        <c:forEach var="i" items="${orders}">
            <tr>
                <td>${i.customerId}</td>
                <td>${i.orderCode}</td>
                <td><fmt:formatDate value="${i.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
