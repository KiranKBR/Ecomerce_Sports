package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ILoginDaoIMPL;
import dao.IitemDaoIMPL;
import dto.Item;
import dto.User;

public class adminService {
Scanner scan =new Scanner(System.in);
IitemDaoIMPL idb;
ILoginDaoIMPL udb;
public boolean addItem()
{
		System.out.println("Enter the item id: ");
		int id=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the itemname: ");
		String name=scan.nextLine();
		System.out.println("Enter the quantity ");
		int quan=scan.nextInt();
		System.out.println("Enter the rate");
		double rate=scan.nextDouble();
		idb=new IitemDaoIMPL();
return idb.addItem(new Item(name,id,quan,rate));
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







}