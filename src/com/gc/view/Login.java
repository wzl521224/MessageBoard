 package com.gc.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<title>Le Petit Prince的留言板</title>");
		out.println("<center>");
		out.println("<img src='./images/titlelogin.gif' alt='图片加载失败'");
		out.println("<hr>");
		out.println("<hr>");
		out.println("<form action='/MessageBoard/LoginServlet' method='post'>");
		out.println("<table border='1px' bordercolor='gray' cellspacing='0px'>");
		out.println("<tr><td>用户名：</td><td><input type='text' name='uname'/></td></tr>");
		out.println("<tr><td>密　码：</td><td><input type='password' name='pwd'/></td></tr>");
		out.println("<tr><td colspan='2'><input type='submit' value='登录'/><a href='Register.jsp'>注册</a></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
		//根据截获的出错信息。相应的显示出来
		String error=  (String) request.getAttribute("error");
		if(error!=null){
			out.println(error);
		}else{
			
		}
		
		
		out.println("<hr>");
		//out.println("<img src='./images/footer.png' alt='图片加载失败'");
		out.println("</center>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//为了客户端使用 get post 两种方式提交，进行联动
		this.doGet(request, response);
	}

}
