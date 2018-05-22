<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setAttribute("basePath", basePath);

	request.setCharacterEncoding("utf-8");

	application.setAttribute("access_num", application.getAttribute("access_num") == null ? 1
			: (Integer) (application.getAttribute("access_num")) + 1);

	String[] strs = { "123", "321", "1234567" };
	request.setAttribute("strs", strs);
%>
<!DOCTYPE html>
<html>
<head>
<title>Entor图书管理系统-登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 基本 -->
<link rel="shortcut icon"
	href="${requestScope.basePath}img/bitbug_favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${requestScope.basePath}css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${requestScope.basePath}css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${requestScope.basePath}css/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="${requestScope.basePath}css/demo/demo.css">
<script type="text/javascript"
	src="${requestScope.basePath}js/jquery.min.js"></script>
<script type="text/javascript"
	src="${requestScope.basePath}js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${requestScope.basePath}js/datagrid-filter.js"></script>
<script type="text/javascript"
	src="${requestScope.basePath}js/easyui-lang-zh_CN.js"></script>

<!-- 自定义 -->
<script type="text/javascript"
	src="${requestScope.basePath}js/user/login.js"></script>
<style type="text/css">
.form-control {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	${header['accept-language'] }${initParam._init_}
	访问login.jsp总人数：${applicationScope.access_num }
	<!-- 请求方式: get/post，默认get -->
	<form id="form" action="LoginValidateServlet" method="post"
		style="border: 1px solid black; width: 800px; margin: 0 auto; text-align: center;">
		<div class="form-control">
			<h1>
				欢迎使用Entor图书馆里系统<sup>v2018</sup>
			</h1>
		</div>
		<div class="form-control">
			<c:if test="${msg != null}">
				<span style="color: red">${sessionScope.msg }</span>
			</c:if>
			<c:if test="${param.login_msg !=  null}">
				<span style="color: red">${param.login_msg }</span>
				<%-- <c:out value="${param.login_msg }" /> --%>
			</c:if>
		</div>
		<div class="form-control">
			<input id="idCard" name="idCard" /><span
				style="display: none; color: red" id="idCard_err_msg">用户名不存在</span>
		</div>
		<div class="form-control">
			<input id="password" name="password" />
		</div>
		<div class="form-control ">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				style="width: 100px;" onclick="submitForm(); ">登&emsp;录</a>
		</div>
		<div class="form-control ">
			<!-- 此处实现99乘法表 -->
			<c:forEach var="row" begin="1" end="9">
				<c:forEach var="col" begin="1" end="${row }">
					${row}*${col }=${row * col }&emsp;
				</c:forEach>
				<br>
			</c:forEach>
			<!-- 此处实现分割符遍历字符串 -->
			<c:forTokens items="a:b:c:d" delims=":" var="x" varStatus="status">
				${x},${status.index }<br>
			</c:forTokens>
			<!-- 遍历集合元素 -->
			<c:forEach items="${strs }" var="string">
				${string }<br>
			</c:forEach>
			<c:forEach items="${list }" var="string" varStatus="status">
				${string },${status.index }<br>
			</c:forEach>
			<!-- 重定向到index2.jsp，并携带请求参数 -->
			<%-- <c:redirect url="index2.jsp">
				<c:param name="id" value="888" />
			</c:redirect> --%>
		</div>
	</form>
</body>
</html>