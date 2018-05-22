<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    request.setAttribute("basePath", basePath);
%>
<html>

<head>
    <table>上传成功</table>
</head>
<body><h1>上传成功</h1></body>
</html>