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
		out.println("<title>Le Petit Prince�����԰�</title>");
		out.println("<center>");
		out.println("<img src='./images/titlelogin.gif' alt='ͼƬ����ʧ��'");
		out.println("<hr>");
		out.println("<hr>");
		out.println("<form action='/MessageBoard/LoginServlet' method='post'>");
		out.println("<table border='1px' bordercolor='gray' cellspacing='0px'>");
		out.println("<tr><td>�û�����</td><td><input type='text' name='uname'/></td></tr>");
		out.println("<tr><td>�ܡ��룺</td><td><input type='password' name='pwd'/></td></tr>");
		out.println("<tr><td colspan='2'><input type='submit' value='��¼'/><a href='Register.jsp'>ע��</a></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
		//���ݽػ�ĳ�����Ϣ����Ӧ����ʾ����
		String error=  (String) request.getAttribute("error");
		if(error!=null){
			out.println(error);
		}else{
			
		}
		
		
		out.println("<hr>");
		//out.println("<img src='./images/footer.png' alt='ͼƬ����ʧ��'");
		out.println("</center>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Ϊ�˿ͻ���ʹ�� get post ���ַ�ʽ�ύ����������
		this.doGet(request, response);
	}

}
