package com.entor.bms.role.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.bms.user.entity.UserInfo;
import com.entor.bms.user.service.UserService;
import com.entor.bms.user.service.impl.UserServiceImpl;

public class LoginValidateServlet extends HttpServlet {

	private UserService userService;

	public LoginValidateServlet() {
		userService = new UserServiceImpl();
	}

	// 处理get请求
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get方式请求，doget方法被调用!");
	}

	// 处理post请求
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求的参数
		// 当以post方式请求时，不会再uri中携带参数，而是在请求的报文中
		// post方式提交的参数，在获取之前需要设置编码
		request.setCharacterEncoding("utf-8");
		String idCard = request.getParameter("idCard");
		String password = request.getParameter("password");

		System.out.println("idCard: " + idCard + ", password: " + password);

		// 设置响应的格式是text/html，编码为utf-8
		response.setContentType("text/html;charset=utf-8");

		// 获取完整的上下文路径
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";

		System.out.println(basePath);

		// 验证用户名和密码
		if (userService.loginValidate(idCard, password) == -1) {
			// 请求转发到login.jsp
			request.setAttribute("login_msg", "用户名/密码不匹配");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if (userService.loginValidate(idCard, password) == 0) {
			// 请求转发到login.jsp
			request.setAttribute("login_msg", "用户名不存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 重定向，携带用户信息
		UserInfo user = userService.getUserInfoByIdCard(idCard);
		// 将user信息放到session中，在回话期间都可以访问到
		request.getSession().setAttribute("user", user);
		response.sendRedirect(basePath + "home.jsp");
	}
}
