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
    <title>title</title>
</head>
<body>
   <div class="upload">
       <form action="upload" enctype="multipart/form-data" method="post">
           <input type="file" name="file"><br/>
           <input type="submit" value="上传">
       </form>
   </div>
</body>
</html>
