package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ILoginDaoIMPL;
import dao.IitemDaoIMPL;
import dao.InvoiceDaoIMPL;
import dto.Item;
import dto.User;

public class userService {

Scanner scan =new Scanner(System.in);
IitemDaoIMPL idb;
ILoginDaoIMPL udb;
InvoiceDaoIMPL vdb;

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
public boolean addItem(int id,int quantiy,User user)
{
vdb=new InvoiceDaoIMPL();
return vdb.addItem(id, quantiy,user);
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
public boolean removeItem(int id,User user)
{
vdb=new InvoiceDaoIMPL();
return vdb.removeItem(id,user);
}

public ArrayList<Item> viewKart(User user)
{
vdb=new InvoiceDaoIMPL();
return vdb.getItems(user);
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





}