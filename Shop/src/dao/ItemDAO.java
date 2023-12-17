package dao;

import java.util.ArrayList;

import vo.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	
	private void init() {
		itemList = new ArrayList<Item>();
		
	}
	
	public void itemDataLoad(String data){
		
	}
	
	public String itemDataSave(){
		return "";
	}
}
