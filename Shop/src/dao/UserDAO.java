package dao;

import java.util.ArrayList;

import Util.InputManager;
import vo.User;

public class UserDAO {
	private ArrayList<User> userList;
	
	public UserDAO() {
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
			data += "%s/%s/%s\n".formatted(u.getId(),u.getPw(),u.getName());
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public void addUserList() {
		String id = InputManager.getValue("아이디 입력");
		if(userIdCheck(id)!=-1) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		String pw = InputManager.getValue("비밀번호 입력");
		String name = InputManager.getValue("이름 입력");
		
		userList.add(new User(id,pw,name));
		System.out.println("[가입 완료]");
	}
	
	public void removeUserList() {
		if(userListIsEmpty()) return;
		String id = InputManager.getValue("아이디 입력");
		int idx = userIdCheck(id);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		String pw = InputManager.getValue("비밀번호 입력");
		if(!userList.get(idx).getPw().equals(pw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		userList.remove(idx);
		System.out.println("[탈퇴 완료]");
	}
	
	public String userLogin() {
		if(userListIsEmpty()) return "";
		String id = InputManager.getValue("아이디 입력");
		int idx = userIdCheck(id);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이디입니다.");
			return "";
		}
		String pw = InputManager.getValue("비밀번호 입력");
		if(!userList.get(idx).getPw().equals(pw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return "";
		}
		
		System.out.println(userList.get(idx).getName()+"님 환영합니다.");
		return id;
	}
	
	public void userNameSetting() {
		String id = InputManager.getValue("아이디 입력");
		int idx = userIdCheck(id);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		String name = InputManager.getValue("변경할 이름 입력");
		if(userList.get(idx).getName().equals(name)) {
			System.out.println("변경 전 이름과 같습니다.");
			return;
		}
		userList.get(idx).setName(name);
		System.out.println("[변경 완료]");
	}
	
	public void userListPrint() {
		if(userListIsEmpty()) return;
		for(User u : userList) {
			System.out.println(u);
		}
	}
}
