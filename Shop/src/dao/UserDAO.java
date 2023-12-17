package dao;

import java.util.ArrayList;

import Util.InputManager;
import vo.User;

public class UserDAO {
	private ArrayList<User> userList;
	
	private void init() {
		userList = new ArrayList<User>();
	}
	
	private boolean userListIsEmpty() {
		if(userList.size()==0) {
			System.out.println("유저가 없습니다.");
			return true;
		}
		return false;
	}
	
	private int userIdCheck(String id) {
		if(userList.size()==0) return -1;
		
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
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
	
	public void addUserList() {
		String id = InputManager.getValue("아이디 입력 : ");
		if(userIdCheck(id)!=-1) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		String pw = InputManager.getValue("비밀번호 입력 : ");
		String name = InputManager.getValue("이름 입력 : ");
		
		userList.add(new User(id,pw,name));
	}
}
