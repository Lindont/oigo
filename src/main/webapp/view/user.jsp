<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/7
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="psc" value="${pageContext.servletContext.contextPath}"></c:set>
<html>
<head>
    <title>AllUser</title>
</head>
<body>
    <c:forEach var="i" items="${allUser}">
        <table>
            <tr>
                <th>${i.id}</th>
                <th>${i.username}</th>
                <th>${i.nickname}</th>
            </tr>
        </table>
    </c:forEach>
</body>
</html>
