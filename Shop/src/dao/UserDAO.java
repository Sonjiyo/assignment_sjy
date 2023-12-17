package dao;

import java.util.ArrayList;

import vo.User;

public class UserDAO {
	private ArrayList<User> userList;
	
	private void init() {
		userList = new ArrayList<User>();
	}
	
	public void userDataLoad(String data){
		if(data.isEmpty()) return;
		userList.clear();
		String[] arr = data.split("\n");
		for(int i =0; i<arr.length; i++) {
			String[] temp = arr[i].split("/");
			
			userList.add(new User(temp[0],temp[1],temp[2]));
		}
	}
	
	public String userDataSave(){
		String data = "";
		if(userList.size()==0) return data;
		for(User u : userList) {
			data += "%d/%s/%s\n".formatted(u.getId(),u.getPw(),u.getName());
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
}
