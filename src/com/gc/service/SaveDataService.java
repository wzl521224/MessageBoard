package com.gc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.gc.model.SaveData;
import com.gc.util.SQLHelper;


public class SaveDataService {

	
public void addMessage(SaveData savedata){
		String sql="INSERT INTO `messageboard`.`savedate` (`datetime`, `message`, `username`) VALUES (?, ?, ?);";
		String[]parameters={savedata.getDateTime(),savedata.getMessage(),savedata.getUsername()};
		SQLHelper.executeUpdate(sql, parameters);
	}


public ArrayList<SaveData> getAllData(){
	ArrayList<SaveData> al=new ArrayList<SaveData>();
	
	String sql="select * from savedate order by pank desc";
	al=SQLHelper.executeQuery2(sql, null);
	return al;
}


public void delMessage(String pank) {
	String sql="DELETE FROM `messageboard`.`savedate` WHERE `pank`="+pank+"";
	SQLHelper.executeUpdate(sql, null);
	System.out.println("ÒÑÉ¾³ý");
}


public ArrayList<SaveData> getMessageByPank(String pank) {
	ArrayList<SaveData> savedata=null;
	
	String sql="select * from savedate where "+pank+"";
	
	
	savedata=SQLHelper.executeQuery2(sql, null);
	
	return savedata;
}




}
