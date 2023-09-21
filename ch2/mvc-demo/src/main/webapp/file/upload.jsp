<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/21
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form enctype="multipart/form-data" action="/file/upload" method="post">
    <input type="file" name="userUploadFile"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
