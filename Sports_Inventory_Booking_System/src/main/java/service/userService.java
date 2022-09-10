package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ILoginDaoIMPL;
import dao.IitemDaoIMPL;
import dao.InvoiceDaoIMPL;
import dto.Item;
import dto.Kart;
import dto.Orders;
import dto.User;

public class userService {

Scanner scan =new Scanner(System.in);
IitemDaoIMPL idb;
ILoginDaoIMPL udb;
InvoiceDaoIMPL vdb;

public User getUserById(String email)
{
	udb=new ILoginDaoIMPL();
	return udb.searchUser(email);
}

public ArrayList<Item> viewAllItems()
{
idb=new IitemDaoIMPL();
return idb.getItems();
}

public Item viewItem(int id)
{
idb=new IitemDaoIMPL();
return idb.viewItem(id);
}
public int getItemPrice(int id)
{
	idb=new IitemDaoIMPL();
	return idb.getItemPrice(id);
}
public boolean addItem(Kart gk)
{
vdb=new InvoiceDaoIMPL();
return vdb.addItem(gk);
}
public boolean addQuantity(int id,int quantiy,User user)
{
vdb=new InvoiceDaoIMPL();
return vdb.updateQuantity(id, quantiy,user);
}
public boolean removeQuantity(int id,int quantiy,User user)
{
vdb=new InvoiceDaoIMPL();
return vdb.removeQuantity(id, quantiy,user);
}
public boolean removeItem(int id,String mail)
{
vdb=new InvoiceDaoIMPL();
return vdb.removeItem(id,mail);
}

public ArrayList<Kart> viewKart(String mail)
{
vdb=new InvoiceDaoIMPL();
return vdb.getItems(mail);
}

public boolean Buy(User user)
{
vdb=new InvoiceDaoIMPL();
return false;
}

public boolean updatePass(User l)
{
udb=new ILoginDaoIMPL();
return udb.updatePass(l);
}

public void incrQuantity(int id2, String mail2,int q) {
	vdb=new InvoiceDaoIMPL();
 vdb.incQuantity(id2,mail2,q);
	// TODO Auto-generated method stub
	
}

public String getItemName(int id) {
	// TODO Auto-generated method stub
	idb=new IitemDaoIMPL();
	return idb.getItemName(id);
	
}

public ArrayList<Orders> viewOrders(String mail) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.getOrders(mail);
}

public int getLastOrderId() {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.getLastOrderId();
}

public boolean buy(Orders ord) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.buy(ord);
}

public ArrayList<Kart> viewOrderDetails(int oid2, String mail) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.viewOrderDetails(oid2,mail);
}

public boolean buyKart(String mail,int oid) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.buyKart(mail,oid);
}

public boolean buyfk(Orders ord,int name) {
	// TODO Auto-generated method stub
	vdb=new InvoiceDaoIMPL();
	return vdb.buyfk(ord,name);
}





}