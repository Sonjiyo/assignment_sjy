package dao;

import java.util.ArrayList;

import vo.User;

public class UserDAO {
	private ArrayList<User> userList;
	
	private void init() {
		userList = new ArrayList<User>();
	}
	
	public void userDataLoad(String data){
		
	}
	
	public String userDataSave(){
		return "";
	}
}
