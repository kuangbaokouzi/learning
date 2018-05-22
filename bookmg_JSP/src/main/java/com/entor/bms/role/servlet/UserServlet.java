package com.entor.bms.role.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.bms.user.entity.UserInfo;
import com.entor.bms.user.service.UserService;
import com.entor.bms.user.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();;
	private Type listType = new TypeToken<List<UserInfo>>() {
	}.getType();;
	private Gson gson = new Gson();;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestSwitch(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestSwitch(request, response);
	}

	private void requestSwitch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>>tp: " + request.getParameter("tp"));
		switch (request.getParameter("tp")) {
		case "list":
			List<UserInfo> list = userService.getAllUsers();
			String listJson = "{\"total\":" + list.size() + ", \"rows\":" + gson.toJson(list, listType) + "}";
			System.out.println(listJson);

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(listJson);
			out.flush();
			break;
		}
	}

}
