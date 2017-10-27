package com.gc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.User;
import com.gc.service.UserService;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//负责处理用户登录判断
		// 得到上一个页面传递过来的用户名和密码
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		UserService userService =new UserService();
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		if( userService.checkUser(user)){ 
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/PageServlet").forward(request, response);
						
		}else{
			//跳转到出错页面或者重新登录页面
			//向request 的  attribute域中置入出错的信息。
			String errorinfo="错误的用户名或密码！";
			request.setAttribute("errorinfo", errorinfo);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		
		out.flush();
		out.close();
	}

}