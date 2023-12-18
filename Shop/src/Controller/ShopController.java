package Controller;

import Util.FileManager;
import Util.InputManager;
import dao.CartDAO;
import dao.ItemDAO;
import dao.UserDAO;

public class ShopController {
	private static String log;
	private ItemDAO itemDAO; 
	private UserDAO userDAO;
	private CartDAO cartDAO;
	
	public ShopController() {
		itemDAO = new ItemDAO();
		userDAO = new UserDAO();
		cartDAO = new CartDAO();
		mainMenuPrint();
	}
	
	private void mainMenuPrint() {
		while(true) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인]"+"\n[100.관리자] [0.종료]");
			int sel = InputManager.getValue("입력", 0, 3, 100);
			if(sel ==0 ) return;
			
			if(sel==1) {
				userDAO.addUserList();
			}else if(sel==2) {
				userDAO.removeUserList();
			}else if(sel==3) {
				log = userDAO.userLogin();
				if(log.isEmpty()) continue;
				userMenuPrint();
			}else if(sel==100) {
				managerMenuPrint();
			}
		}
	}
	
	private void userMenuPrint() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [3.로그아웃] [0.뒤로가기]");
			int sel = InputManager.getValue("입력", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				shoppingMenuprint();
			}else if(sel==2) {
				cartDAO.myCartListPrint(log);
			}else {
				log = null;
				return;
			}
		}
	}
	
	private void shoppingMenuprint() {
		while(true) {
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel = InputManager.getValue("입력", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				cartDAO.myCartListPrint(log);
			}else if(sel==2) {
				cartDAO.removeCartList(log);
			}else {
				cartDAO.addcartList(log,itemDAO);
			}
		}
	}
	
	private void managerMenuPrint() {
		while(true) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니 출력]\n[4.유저관리] [0.뒤로가기]\n[5.데이터 저장] [6.데이터 불러오기]");
			int sel = InputManager.getValue("입력 : ", 0, 6, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				itemManagerMenuPrint();
			}else if(sel==2) {
				categoryManagerMenuPrint();
			}else if(sel==3){
				cartDAO.allCartListPrint();
			}else if(sel==4){
				userManagerMenuPrint();
			}else if(sel==5) {
				FileManager.dataFileSave(userDAO, itemDAO, cartDAO);
			}else {
				FileManager.dataFileLoad(userDAO, itemDAO, cartDAO);
			}
		}
	}
	private void itemManagerMenuPrint() {
		while(true) {
			System.out.println("[1.아이템 목록] [2.아이템 추가] [3.아이템 삭제] [0.뒤로가기]");
			int sel = InputManager.getValue("입력 : ", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				itemDAO.itemListPrint();
			} else if(sel==2) {
				itemDAO.addItemList();
			}else {
				itemDAO.removeItemList();
			}
		}
	}
	
	private void categoryManagerMenuPrint() {
		while(true) {
			System.out.println("[1.카테고리 삭제] [0.뒤로가기]");
			int sel = InputManager.getValue("입력 : ", 0, 1, 0);
			if(sel ==0 ) return;
			
			itemDAO.removeItemCategory();
		}
	}
	
	private void userManagerMenuPrint() {
		while(true) {
			System.out.println("[1.유저 목록] [2.유저 삭제] [3.유저 이름 수정] [0.뒤로가기]");
			int sel = InputManager.getValue("입력 : ", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				userDAO.userListPrint();
			}else if(sel==2) {
				userDAO.removeUserList();
			}else {
				userDAO.userNameSetting();
			}
		}
	}
	

}
