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
    <input type="button" id="ajaxtext3" name="ajaxtext3" value="ajaxtext3">
    <input type="button" id="ajaxtext4" name="ajaxtext4" value="ajaxtext4">
    <a href="/pvtest/lindont/123456">PathVariable</a>
</div>

<script src="static/plugin/jquery/jquery-3.2.1.min.js"></script>
<script>
    $('#ajaxtext').click(function () {

        var json = {'account': 'Lindont', 'password': 'coovoo@vip.qq.com'};
        console.log('data: ' + json);
        $.ajax({
            url: '/ajaxtest1',
            async: true,
            cache: false,
            type: 'POST',
            data: JSON.stringify(json),
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            beforeSend: function (XMLHttpRequest) {
                //发送请求前调用
                console.log('---发送前---')
            },
            success: function (data) {
                console.log(data);
            },
            complete: function (XMLHttpRequest, textStatus) {
                //请求完成后回调
                console.log('---请求完成---')
            },
            error: function () {

            }
        });
    });


    $('#ajaxtext3').click(function () {

        var data = 'account=Lindont&password=coovoo@vip.qq.com';
        console.log('data: ' + data);
        $.ajax({
            url: '/ajaxtest3',
            async: true,
            cache: false,
            type: 'GET',
            data: data,
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            beforeSend: function (XMLHttpRequest) {
                //发送请求前调用
                console.log('---发送前---')
            },
            success: function (data) {
                console.log(data);
            },
            complete: function (XMLHttpRequest, textStatus) {
                //请求完成后回调
                console.log('---请求完成---')
            },
            error: function () {

            }
        });
    });



    $('#ajaxtext4').click(function () {

        $.ajax({
            url: '/ajaxtest3?account=Lindont&password=coovoo@vip.qq.com',
            async: true,
            cache: false,
            type: 'GET',
            /*data: '{}',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',*/
            beforeSend: function (XMLHttpRequest) {
                //发送请求前调用
                console.log('---发送前---')
            },
            success: function (data) {
                console.log(data);
            },
            complete: function (XMLHttpRequest, textStatus) {
                //请求完成后回调
                console.log('---请求完成---')
            },
            error: function () {

            }
        });
    });
</script>
</body>
</html>
