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
    <title>servlet async support</title>
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>

        deferred();

        function deferred(){
            $.get('defer',function(data){
                console.log(data);
                deferred();
            })
        }
    </script>
</body>
</html>
