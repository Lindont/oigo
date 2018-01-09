<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/9
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/formtest2" method="post">
    <table>
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" id="account" name="account"></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="text" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
