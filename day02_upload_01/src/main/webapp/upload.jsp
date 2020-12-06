<%--
  Created by IntelliJ IDEA.
  User: Fanyi Xiao
  Date: 2020/8/15
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面</title>
</head>
<body>
    <h1>一,springmvc传统方式文件上传</h1>
    <form action="/file/upload.do" method="post" enctype="multipart/form-data">
        图片： <input type="file" name="upload"/><br/>
        图片描述:<input type="text" name="pdesc"/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
