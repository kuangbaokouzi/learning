<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/18 0018
  Time: 下午 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>混合属性绑定</title>
</head>
<body>
<form action="remix" method="post">
    学号:<input type="text" name="student.id">
    姓名:<input type="text" name="student.name">
    班级:<input type="text" name="classes.name">
    老师:<input type="text" name="teacher.name">
    <input type="submit" value="提交">
</form>
</body>
</html>
