package vo;

public class Item {
	String name;
	int price;
	String category; // 카테고리 // 육류 , 과자 , 어류 , 과일 등등
	
	public Item(String name, int price, String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
	
}
