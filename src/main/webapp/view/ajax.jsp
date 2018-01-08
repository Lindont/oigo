<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/1/8
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
</head>
<body>
    <div>
        <input type="button" id="ajaxtext" name="ajaxtext" value="一键提交">
    </div>

<script src="static/plugin/jquery/jquery-3.2.1.min.js"></script>
<script>
    $('#ajaxtext').click(function () {

        var json = {'account':123,'password':456};
        $.ajax({
            url:'/ajaxtest2',
            async:true,
            type:'POST',
            data:JSON.stringify(json),
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            success:function (data){

            }
        });
    });
</script>
</body>
</html>
