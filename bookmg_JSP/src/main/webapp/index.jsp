<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
	List<String> list = new ArrayList<>();
	list.add("abcd");
	list.add("efg");
	list.add("gs");
	list.add("abc123d");
	list.add("123");
	request.setAttribute("list", list);
	request.getRequestDispatcher("login.jsp").forward(request, response);
%>