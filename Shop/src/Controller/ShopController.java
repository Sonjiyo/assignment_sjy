package Controller;

import Util.InputManager;
import dao.ItemDAO;
import dao.UserDAO;

public class ShopController {
	private static String log;
	
	private void mainMenuPrint() {
		while(true) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인]"+"\n[100.관리자] [0.종료]");
			int sel = InputManager.getValue("입력 : ", 0, 3, 100);
			if(sel ==0 ) return;
			
			if(sel==1) {
				
			}else if(sel==2) {
				
			}else if(sel==3) {
				log = "";
				userMenuPrint();
			}else if(sel==100) {
				
			}
		}
	}
	
	private void userMenuPrint() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [3.로그아웃] [0.뒤로가기]");
			int sel = InputManager.getValue("입력 : ", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				shoppingMenuprint();
			}else if(sel==2) {
				
			}else {
				log = null;
				return;
			}
		}
	}
	
	private void shoppingMenuprint() {
		while(true) {
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel = InputManager.getValue("입력 : ", 0, 3, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				
			}else if(sel==2) {
				
			}else {
				
			}
		}
	}
	
	private void managerMenuPrint() {
		while(true) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기]\n[5.데이터 저장] [6.데이터 불러오기]");
			int sel = InputManager.getValue("입력 : ", 0, 6, 0);
			if(sel ==0 ) return;
			
			if(sel==1) {
				
			}else if(sel==2) {
				
			}else if(sel==3){
				
			}else if(sel==4){
				
			}else if(sel==5) {
				
			}else {

			}
		}
	}
}
