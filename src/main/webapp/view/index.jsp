<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-8-10
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="psc" value="${pageContext.servletContext.contextPath}"></c:set>
<c:set var="prc" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>Welcome</title>
    <script type="text/javascript" src="${psc}/static/plugin/jquery/jquery-3.2.1.min.js"></script>
    <style>
        .opo {
            margin-top: 100px;
        }

        .logo {
            margin: 0 auto;
            width: 80%;
            text-align: center;
        }

        .logo > p {
            font-size: 65px;
        }
    </style>
</head>
<body>
<div class="opo">
    <div class="logo">
        <p>welcome to oigo</p>
    </div>
</div>
<script type="text/javascript" src="${prc}/static/js/readyLoad.js"></script>
</body>
</html>
