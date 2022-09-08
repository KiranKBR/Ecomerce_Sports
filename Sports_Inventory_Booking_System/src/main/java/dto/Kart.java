package dto;

public class Kart extends Item{
	
	private int quaKart;
	private int priceKart;
	
	public Kart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kart(int itemId, String itemName, int rate, String category, String brand,int priceKart,String file) {
		super(itemId, itemName, rate, category, brand, file);
		this.priceKart=priceKart;
		// TODO Auto-generated constructor stub
	}
	
	

	public Kart(int id, String itemName, int karQuan, int price) {
		// TODO Auto-generated constructor stub
		super(id,itemName);
		this.quaKart=karQuan;
		this.priceKart=price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getItemName() {
		return itemName;
		}

		public void setItemName(String itemName) {
		this.itemName = itemName;
		}

		public int getItemId() {
		return itemId;
		}

		public void setItemId(int itemId) {
		this.itemId = itemId;
		}
	public int getPriceKart() {
		return priceKart;
	}



	public void setPriceKart(int priceKart) {
		this.priceKart = priceKart;
	}



	public int getQuaKart() {
		return quaKart;
	}

	public void setQuaKart(int quaKart) {
		this.quaKart = quaKart;
	}
	

}
