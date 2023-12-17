package dao;

import java.util.ArrayList;

import vo.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	
	private void init() {
		itemList = new ArrayList<Item>();
		
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
