package com.gc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.SaveData;
import com.gc.service.SaveDataService;
import com.gc.service.UserService;

public class OperatorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String datetime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String s = new String(request.getParameter("message").getBytes("iso8859-1"),"UTF-8");
		System.out.println(s);
		
		SaveData savedata =new SaveData();
		SaveDataService saveDateservice =new SaveDataService();
		savedata.setUsername(request.getParameter("username"));
		savedata.setMessage(s);
		savedata.setDateTime(datetime);
		if (savedata.getUsername()!=null){
			saveDateservice.addMessage(savedata);
		}
		
		request.getRequestDispatcher("/PageServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
