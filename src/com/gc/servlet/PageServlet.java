package com.gc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.SaveData;
import com.gc.service.SaveDataService;
import com.gc.service.UserService;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageNow=1;		//当前页码
		int pageSize=10;		//每页显示多少留言
		int pageCount=1;	//一共有几页
		SaveDataService savedataservice =new SaveDataService();
		ArrayList<SaveData> al = savedataservice.getAllData();
		request.setAttribute("al", al);
		
		request.getRequestDispatcher("/MessageBox.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
