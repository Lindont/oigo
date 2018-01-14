<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-8-10
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<html>
<head>
    <title>Welcome</title>
    <script type="text/javascript" src="${ctx}/static/plugin/jquery/jquery-3.2.1.min.js"></script>
    <style>
        .logo{
            margin: 0 auto;
            width: 80%;
            text-align: center;
        }
        .logo > p {
            font-size: 50px;
        }
    </style>
</head>
<body>
<div class="logo">
    <p>welcome to oigo</p>
</div>
<p>${ctx}</p>
<script type="text/javascript" src="${ctx}/static/js/readyLoad.js"></script>
</body>
</html>
