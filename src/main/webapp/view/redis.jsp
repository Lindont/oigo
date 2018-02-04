<%--
  Created by IntelliJ IDEA.
  User: Lindont
  Date: 2018/2/4
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Redis Test</h2>
<div>
    <label>redis:key&nbsp;&nbsp;&nbsp;</label><input type="text" id="rekey" name="rekey"> <br>
    <label>redis:value</label><input type="text" id="reval" name="reval"> <br>
    <input type="button" id="sub" value="提交">
</div>
<script src="static/plugin/jquery/jquery-3.2.1.min.js"></script>
<script>
    $('#sub').click(function () {
        var rekey = $('#rekey').val();
        var reval = $('#reval').val();

        if (rekey != null && rekey != '' && reval != null && reval != '') {
            $.ajax({
                url: '/setredis?rekey=' + rekey + '&reval=' + reval,
                type: 'POST',
                success: function (data) {
                    alert(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log("error: " + textStatus);
                    console.log(errorThrown);
                }
            });
        }
    });
</script>
</body>
</html>
