package dto;

public class Kart extends Item{
	private int invoiceId;
	private int quaKart;
	private int priceKart;
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Kart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kart(int invoiceId,int itemId,String itemName,String email,int quantity,int price)
	{
		super(itemId,itemName);
		this.invoiceId=invoiceId;
		this.mail=email;
		this.quaKart=quantity;
		this.priceKart=price;
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

	public Kart(int id, String itemName,String mail, int karQuan, int price) {
		// TODO Auto-generated constructor stub
		super(id,itemName);
		this.mail=mail;
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
