package dao;

import java.util.ArrayList;

import vo.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	
	public ItemDAO() {
		itemList = new ArrayList<Item>();
		
	}
	
	private boolean itemListIsEmpty() {
		if(itemList.size()==0) {
			System.out.println("제품이 없습니다.");
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
}
