<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/20
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="psc" value="${pageContext.servletContext.contextPath}"></c:set>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${psc}/formorder" method="post">
    <input type="text" name="customerId">
    <input type="text" name="orderCode">
    <input type="text" name="createtime">
    <input type="submit" value="提交">
</form>
<br>
<br>
<button id="test">123456</button>
<script type="text/javascript" src="${psc}/static/plugin/jquery/jquery-3.2.1.min.js"></script>
<script>
    $("#test").click(function () {
        $.ajax({
            url: '${psc}/getorderajax',
            type:'POST',
            async: true,
            cache: false,
            data:'{}',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            success:function (data) {
                console.log(data)
            }
        });
    });
</script>
</body>
</html>
