package vo;

public class Cart {
	String userId; // 구입한 유저 id
	String itemName; // 구입한 아이템
	
	public Cart(String userId, String itemName) {
		super();
		this.userId = userId;
		this.itemName = itemName;
	}

	public String getUserId() {
		return userId;
	}

	public String getItemName() {
		return itemName;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", itemName=" + itemName + "]";
	}
}
