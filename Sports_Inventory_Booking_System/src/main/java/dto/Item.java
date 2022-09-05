package dto;

public class Item {
String itemName;
int itemId;
int quantity;
double rate;

public Item(String itemName, int itemId, int quantity, double rate) {
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

public double getRate() {
return rate;
}

public void setRate(double rate) {
this.rate = rate;
}

@Override
public String toString() {
return "Item [itemName=" + itemName + ", itemId=" + itemId + ", quantity=" + quantity + ", rate=" + rate + "]";
}
}