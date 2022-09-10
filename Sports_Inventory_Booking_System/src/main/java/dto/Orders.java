package dto;

public class Orders  {

	public int invoiceId;
	String email;
	int price;
	String status;
	
	
	
	
	
	
	public Orders(int invoiceId, String email, int price,String status) {
		super();
		this.invoiceId = invoiceId;
		this.email = email;
		this.price=price;
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
