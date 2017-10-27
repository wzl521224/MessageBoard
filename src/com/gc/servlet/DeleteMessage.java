package com.gc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.SaveData;
import com.gc.service.SaveDataService;

public class DeleteMessage extends HttpServlet {

	private ArrayList<SaveData> messageByPank;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SaveDataService saveDataService = new SaveDataService();
		String username=(String) request.getSession().getAttribute("username");
		String pank = request.getParameter("pank").substring(2, 4);
//		messageByPank = saveDataService.getMessageByPank(pank);
		saveDataService.delMessage(pank);
		/*if(username.equals("admin")){
			messageByPank.get(0).setUsername("admin");
		}
		if(messageByPank.get(0).getUsername().equals(username)){
			saveDataService.delMessage(pank);
			request.setAttribute("error", "");
		}else{
			System.out.println("你无权删除"+messageByPank.get(0).getUsername());
			request.setAttribute("error", "你无权删除！");
		}*/
		request.getRequestDispatcher("/PageServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
