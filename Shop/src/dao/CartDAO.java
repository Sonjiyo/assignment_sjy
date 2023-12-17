package dao;

import java.util.ArrayList;

import vo.Cart;

public class CartDAO {
	private ArrayList<Cart> cartList;
	
	public CartDAO(){
		cartList = new ArrayList<Cart>();
	}
	
	private int cartIdCheck(String id) {
		if(cartList.size()==0) return -1;
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartList.get(i).getUserId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addcartList(String id, ItemDAO itemDAO) {
		String name = itemDAO.itemSelect();
		cartList.add(new Cart(id, name));
	}
	
	public void removeCartList(String id) {
		
	}
}
