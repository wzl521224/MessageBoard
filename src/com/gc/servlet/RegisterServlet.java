package com.gc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.User;
import com.gc.service.UserService;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user =new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		UserService userservice = new UserService();
		if(user.getUsername()!="" && user.getPassword()!="" && userservice.checkUser(user)==false)
			{
				request.setAttribute("user", user);
				userservice.addUser(user);
				request.getRequestDispatcher("/RegisterOK.jsp").forward(request, response);
				return ;
			}
		request.setAttribute("errorinfo", "用户已存在/不合法");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
