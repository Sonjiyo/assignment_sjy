package dao;

import java.util.ArrayList;

import Util.InputManager;
import vo.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	
	public ItemDAO() {
		itemList = new ArrayList<Item>();
	}
	
	private boolean itemListIsEmpty() {
		if(itemList.size()==0) {
			System.out.println("아이템이 없습니다.");
			return true;
		}
		return false;
	}
	
	private int itemNameCheck(String id) {
		if(itemList.size()==0) return -1;
		
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public void itemDataLoad(String data){
		if(data.isEmpty()) return;
		itemList.clear();
		String[] arr = data.split("\n");
		for(int i =0; i<arr.length; i++) {
			String[] temp = arr[i].split("/");
			
			itemList.add(new Item(temp[0],Integer.parseInt(temp[1]),temp[2]));
		}
	}
	
	public String itemDataSave(){
		String data = "";
		if(itemList.size()==0) return data;
		for(Item i : itemList) {
			data += "%d/%s/%s\n".formatted(i.getName(),i.getPrice(),i.getCategory());
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public void addItemList() {
		String category = InputManager.getValue("카테고리 이름 입력");
		String name = InputManager.getValue("아이템 이름 입력");
		if(itemNameCheck(name)!=-1) {
			System.out.println("이미 등록된 아이템입니다.");
			return;
		}
		int price = InputManager.getValue("아이템 가격 입력", 100, 99999, 100);
		
		itemList.add(new Item(name,price,category));
		System.out.println("[아이템 추가 완료]");
	}
	
	public void removeItemList() {
		if(itemListIsEmpty()) return;
		String name = InputManager.getValue("아이템 이름 입력");
		int idx = itemNameCheck(name);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이템입니다.");
			return;
		}
		
		itemList.remove(idx);
		System.out.println("[아이템 삭제 완료]");
	}
	
	public void removeItemCategory() {
		if(itemListIsEmpty()) return;
		String category = InputManager.getValue("카테고리 입력");
		
		for(int i=0; i<itemList.size(); i++) {
			int idx = -1;
			if(itemList.get(i).getCategory().equals(category)) {
				idx = i;
			}
			if(idx==-1) {
				System.out.print(i==0 ? "존재하지 않는 카테고리 이름입니다.\n" : "");
				return;
			}
			itemList.remove(idx);
			i=0;
		}
	}
	
	public void itemListPrint() {
		if(itemListIsEmpty()) return;
		for(Item i : itemList) {
			System.out.println(i);
		}
	}
	
	public String itemSelect() {
		if(itemListIsEmpty()) return "";
		for(int i =0; i<itemList.size(); i++){
			System.out.println((i+1)+") "+itemList.get(i));
		}
		int sel = InputManager.getValue("번호 입력", 1, itemList.size()+1, 1);
		return itemList.get(sel-1).getName();
	}
}
