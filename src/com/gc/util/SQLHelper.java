package com.gc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import com.gc.model.SaveData;
import com.gc.model.User;

public class SQLHelper {

	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static String driver="";
	private static String url="";
	private static String user="";
	private static String password="";
	private static Properties pp=null;
	private static InputStream fis=null;
	
	//读取配置文件，加载到内存
	static{
		
		try {
			pp=new Properties();
			fis=SQLHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			//解析
			driver=pp.getProperty("driver");
			url=pp.getProperty("url");
			user=pp.getProperty("user");
			password=pp.getProperty("password");
			Class.forName(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}	
	
	public static Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}
	
	/*
	//二次封装，返回的是一个 ArrayList<>集合，可以及时关闭rs
	 public static ArrayList<User> executeQuery2(String sql,String[]parameters){
		  ArrayList<User> al=new ArrayList<User>();
		  try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
				
			}
			rs=ps.executeQuery();
			
			//开始封装
			while(rs.next()){
				User user =new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setGrade(rs.getInt(4));
				user.setEmail(rs.getString(5));
				al.add(user);			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		  return al;
	  }
	
	*/
	
	//二次封装，返回的是一个 ArrayList<>集合，可以及时关闭rs
		 public static ArrayList<SaveData> executeQuery2(String sql,String[]parameters){
			  ArrayList<SaveData> al=new ArrayList<SaveData>();
			  try {
				ct=getConnection();
				ps=ct.prepareStatement(sql);
				if(parameters!=null){
					for(int i=0;i<parameters.length;i++){
						ps.setString(i+1, parameters[i]);
					}
					
				}
				rs=ps.executeQuery();
				
				//开始封装
				int x=0;
				while(rs.next()){
					SaveData savedata =new SaveData();
					savedata.setPank(rs.getInt("pank"));
					savedata.setDateTime(rs.getString("datetime"));
					savedata.setMessage(rs.getString("message"));
					savedata.setUsername(rs.getString("username"));
					al.add(savedata);
					
					x+=1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
			}
			  return al;
		  }
		
		
	//写通用的查询方法  无法及时关闭资源。因为需要返回rs，所以必须由调用者 关闭
	  public static ResultSet executeQuery(String sql,String[]parameters){
		  
		  try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
				
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  
		  return rs;
	  }
	//写出非查询通用方法  insert update  delete
	  public static void executeUpdate(String sql,String[]parameters){
		  try {
			  	ct=getConnection();
				ps=ct.prepareStatement(sql);
				if(parameters!=null){
					for(int i=0;i<parameters.length;i++){
						ps.setString(i+1, parameters[i]);
					}
					
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				//因为没有资源返回，所以必须及时关闭资源。
				close(rs,ps,ct);
			}
			  
	  }
	  
	  
	  


	public static void close(ResultSet rs,Statement ps, Connection ct) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
	public static ResultSet getRs(){
		return rs;
	}
	
	
	
	
	
	
}
