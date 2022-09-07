package dto;

public class Item {
String itemName;
int itemId;
int quantity;
int rate;
String category;
String subCategory;

String brand;
String file;
public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getSubCategory() {
	return subCategory;
}

public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public Item( int itemId,String itemName, int quantity, int rate, String category, String subCategory, String brand,String file) {
	super();
	this.itemName = itemName;
	this.itemId = itemId;
	this.quantity = quantity;
	this.rate = rate;
	this.category = category;
	this.subCategory = subCategory;
	this.brand = brand;
	this.file=file;
}

public String getFile() {
	return file;
}

public void setFile(String file) {
	this.file = file;
}

public Item(String itemName, int itemId, int quantity, int rate) {
super();
this.itemName = itemName;
this.itemId = itemId;
this.quantity = quantity;
this.rate = rate;
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

public int getQuantity() {
return quantity;
}

public void setQuantity(int quantity) {
this.quantity = quantity;
}

public int getRate() {
return rate;
}

public void setRate(int rate) {
this.rate = rate;
}

@Override
public String toString() {
return "Item [itemName=" + itemName + ", itemId=" + itemId + ", quantity=" + quantity + ", rate=" + rate + "]";
}
}