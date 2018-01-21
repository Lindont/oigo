<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/20
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>classinfo</title>
</head>
<body>
<c:forEach var="i" items="${info}">
    <label>classinfo: </label><li>${i.classId}</li>
    <li>${i.className}</li>
    <li>${i.studentCount}</li>
</c:forEach>
</body>
</html>
