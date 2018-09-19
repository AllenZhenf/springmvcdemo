<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14 0014
  Time: 下午 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSE Demo</title>
</head>
<body>
   <div id="msgFromPush"></div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        if(!!window.EventSource){
            var source=new EventSource('push');
            s='';
            source.addEventListener('message',function(e){
                s+=e.data+"</br>";
                $("#msgFromPush").html(s)
            });
            source.addEventListener('open',function(e){
               console.log("连接打开");
            });
            source.addEventListener('error',function (e){
                if(e.readyState==EventSource.CLOSED){
                    console.log("连接关闭")
                }else{
                    console.log(e.readyState);
                }
            })

    }else{
            console.log("你的浏览器不支持SSE");
    }
    </script>
</body>
</html>
