package com.entor.bms.role.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.bms.user.service.UserService;
import com.entor.bms.user.service.impl.UserServiceImpl;

public class AlterPassServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("alterPass.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 当发生post请求，表明有表单提交
		String idCard = request.getParameter("idCard");
		String newpass = request.getParameter("newpass");
		System.out.println(idCard + "," + newpass);
		userService.alterPassByIdCard(idCard, newpass);

		request.getSession().setAttribute("msg", "修改密码成功，请重新登录!");
		response.sendRedirect("login.jsp");
	}

}
