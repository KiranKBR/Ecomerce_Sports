package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ILoginDaoIMPL;
import dao.IitemDaoIMPL;
import dao.InvoiceDaoIMPL;
import dto.Item;
import dto.Orders;
import dto.User;

public class adminService {
Scanner scan =new Scanner(System.in);
IitemDaoIMPL idb;
ILoginDaoIMPL udb;
InvoiceDaoIMPL vdb;
public boolean addItem(int itemId,String itemName,int quantity,int price,String category,String subCategory,String brand,String file)
{
		
		idb=new IitemDaoIMPL();
return idb.addItem(new Item(itemId,itemName,quantity,price,category,subCategory,brand,file));
}

public ArrayList<Item> viewAllItems()
{
	idb=new IitemDaoIMPL();
	return idb.getItems();
}


public boolean removeItem(int id)
{
		idb=new IitemDaoIMPL();
		return idb.removeItem(id);
}


public boolean changedetails()
{
		idb=new IitemDaoIMPL();
		System.out.println("enter them item Id");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("enter the name ");
		String name=scan.nextLine();
		System.out.println("enter the quantity");
		int quan=scan.nextInt();
		System.out.println("enter the price");
		double rate=scan.nextDouble();
		return idb.changeDetails(id,name,quan,rate);
}

public ArrayList<User> viewAllUsers()
{
		udb=new ILoginDaoIMPL();
		return udb.viewAllUsers();
}

public boolean removeUser(String uid)
{
		udb=new ILoginDaoIMPL();
		
		return udb.removeUser(uid);
}

public boolean validateAdmin(User usr) {
	// TODO Auto-generated method stub
	return false;
}

public boolean changePrice(int bId, int nwPrice) {
	// TODO Auto-generated method stub
	idb=new IitemDaoIMPL();
	
	return idb.changeRate(bId, nwPrice);
}

public ArrayList<Item> searchByCategory(String category){
	idb=new IitemDaoIMPL();
	return idb.getItemsByCategory(category);
}

public int getLastId() {
	// TODO Auto-generated method stub
	idb=new IitemDaoIMPL();
	return idb.getLastId();
	
}

public Item getItem(int id)
{
	idb=new IitemDaoIMPL();
	return idb.viewItem(id);
}

public ArrayList<Orders> getPlacedOrders() {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.getPlacedOrders();
}

public boolean approve(String[] alist) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.approve(alist);
}





}