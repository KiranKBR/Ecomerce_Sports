package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Item;
import dto.Kart;
import dto.Orders;
import dto.User;
import util.DbConnection;

public class InvoiceDaoIMPL implements Iinvoice{
static int iid=1;
IitemDaoIMPL itt=new IitemDaoIMPL();


public boolean buyItem(Kart k)
{
	
	
	
	return false;
}



@Override
public boolean addItem(Kart gk) {
// TODO Auto-generated method stub

try
{

Connection con=DbConnection.getConnection();

String cmd="INSERT INTO kart VALUES(?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1,gk.getInvoiceId());
ps.setInt(2,gk.getItemId());
ps.setString(4,gk.getMail());
ps.setInt(6,gk.getPriceKart());
ps.setInt(5, gk.getQuaKart());
ps.setString(3, gk.getItemName()); //ps.setString(2, i.getItemName());
//ps.setInt(3, i.getQuantity());
//ps.setDouble(4,i.getRate());
ps.executeUpdate();

return true;
}catch(Exception e)
{
e.printStackTrace();
}



return false;


}

@Override
public ArrayList<Kart> getItems(String mail) {
// TODO Auto-generated method stub
try
{
ArrayList<Kart> cartItemList=new ArrayList<Kart>();
Connection con=DbConnection.getConnection();
String cmd="SELECT  * from kart where invoiceId=? and emailId=?";

PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1, -1);
ps.setString(2, mail);
ResultSet res=ps.executeQuery();
while(res.next())
{

int id=res.getInt(1);
int itemId=res.getInt(2);
String itemName=res.getString(3);
String email=res.getString(4);
int q=res.getInt(5);
int price=res.getInt(6);
cartItemList.add(new Kart(itemId,itemName,email,q,price));
}


return cartItemList;
}
catch(Exception e)
{
e.printStackTrace();
}
return null;

}

@Override
public boolean removeItem(int id,String mail) {
// TODO Auto-generated method stub


try {
Connection con=DbConnection.getConnection();





String cmd="delete from kart where invoiceId=? and itemId=? and emailId=?";

PreparedStatement ps;

ps = con.prepareStatement(cmd);
ps.setInt(1, -1);
ps.setInt(2, id);
ps.setString(3, mail);
ps.executeUpdate();
return true;
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return false;
}

@Override
public boolean buy(User user) {
// TODO Auto-generated method stub
return false;
}


@Override
public boolean updateQuantity(int i,int q,User user) {
// TODO Auto-generated method stub

Connection con=DbConnection.getConnection();
String cmd="update kart set quantity=?,tprice=? where itemId=? and email=?";

PreparedStatement ps;
try {
ps = con.prepareStatement(cmd);
ps.setInt(1, q);
ps.setInt(2, i);
ps.setString(3, user.getEmailId());
ps.executeUpdate();
return true;
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return false;
}

@Override
public boolean removeQuantity(int id, int q,User user) {
// TODO Auto-generated method stub
// TODO Auto-generated method stub


try {
Connection con=DbConnection.getConnection();
String cmd1="select quantity from kart where itemId=?";
PreparedStatement ps2=con.prepareStatement(cmd1);
ps2.setInt(1, id);
ResultSet res1=ps2.executeQuery();
///String itemName=res1.getString(2);
int quantity=res1.getInt(1);
//double price=res1.getDouble(4);





String cmd="update kart set quantity=? where itemId=?";

PreparedStatement ps;

ps = con.prepareStatement(cmd);
ps.setInt(1, quantity-q);
ps.setInt(2, id);
ps.executeQuery();
return true;
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return false;

}

@Override
public boolean addItem(int i, int quantity, User user) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<Item> getItems(User user) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean addItem(int i, int quantity, String mail) {
	// TODO Auto-generated method stub
	return false;
}

public boolean incQuantity(int id2, String mail2,int q) {
	// TODO Auto-generated method stub
	Connection con=DbConnection.getConnection();
	String cmd="UPDATE kart SET quantiy=?,price=? WHERE itemId=? and emailId=? and invoiceId=?";
	PreparedStatement ps;
	try {
		int price=itt.getItemPrice(id2);
		ps = con.prepareStatement(cmd);
		ps.setInt(1,q);
		ps.setInt(2, price*q);
		ps.setString(4, mail2);
		ps.setInt(3, id2);
		ps.setInt(5, -1);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return true;
	
}

@Override
public boolean addItem(int i, int quantity, String mail, String itemName) {
	// TODO Auto-generated method stub
	return false;
}



public ArrayList<Orders> getOrders(String mail) {
	// TODO Auto-generated method stub
	try
	{
		ArrayList<Orders> orderList=new ArrayList<Orders>();
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  * from orders where  email=?";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setString(1, mail);
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int id=res.getInt(1);
	String status=res.getString(4);
	int price=res.getInt(3);
	String email=res.getString(2);
	
	orderList.add(new Orders(id,email,price,status));
	}


	return orderList;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
}



public int getLastOrderId() {
	// TODO Auto-generated method stub
	Connection con=DbConnection.getConnection();
	String query="SELECT invoiceId FROM orders ORDER BY invoiceID DESC LIMIT 1;";
	try {
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			return rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
}



public boolean buy(Orders gk) {
	// TODO Auto-generated method stub

try
{

Connection con=DbConnection.getConnection();

String cmd="INSERT INTO orders VALUES(?,?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1,gk.getInvoiceId());
ps.setString(2,gk.getEmail());
ps.setInt(3,gk.getPrice());
ps.setString(4,gk.getStatus());
//ps.setString(3, gk.getItemName()); //ps.setString(2, i.getItemName());
//ps.setInt(3, i.getQuantity());
//ps.setDouble(4,i.getRate());
ps.executeUpdate();

return true;
}catch(Exception e)
{
e.printStackTrace();
}



return false;
}



public ArrayList<Kart> viewOrderDetails(int oid2, String mail) {
	// TODO Auto-generated method stub
	try
	{
	ArrayList<Kart> cartItemList=new ArrayList<Kart>();
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  * from kart where invoiceId=? and emailId=?";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setInt(1, oid2);
	ps.setString(2, mail);
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int id=res.getInt(1);
	int itemId=res.getInt(2);
	String itemName=res.getString(3);
	String email=res.getString(4);
	int q=res.getInt(5);
	int price=res.getInt(6);
	cartItemList.add(new Kart(itemId,itemName,email,q,price));
	}


	return cartItemList;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
}



public boolean buyKart(String mail,int oid,int price) {
	
	Connection con=DbConnection.getConnection();
	String cmd="UPDATE kart SET invoiceId=? WHERE invoiceId=-1 and emailId=?";
	PreparedStatement ps;
	try {
		
		ps = con.prepareStatement(cmd);
		ps.setInt(1,oid+1);
		//ps.setInt(2, id2);
		ps.setString(2, mail);
		ps.executeUpdate();
		
		Orders o=new Orders(oid+1,mail,price,"placed");
		buy(o);
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



	return false;
	
	
}



public boolean buyfk(Orders gk,int id) {
	// TODO Auto-generated method stub

try
{

Connection con=DbConnection.getConnection();

String cmd="UPDATE kart SET invoiceId=? WHERE invoiceId=-1 and emailId=? and itemId=?";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1,gk.getInvoiceId());
ps.setString(2,gk.getEmail());
ps.setInt(3, id);

//ps.setString(3, gk.getItemName()); //ps.setString(2, i.getItemName());
//ps.setInt(3, i.getQuantity());
//ps.setDouble(4,i.getRate());
ps.executeUpdate();
Orders o=new Orders(gk.getInvoiceId(),gk.getEmail(),gk.getPrice(),"placed");
buy(o);

return true;
}catch(Exception e)
{
e.printStackTrace();
}



return false;
}



public ArrayList<Orders> getPlacedOrders() {
	// TODO Auto-generated method stub
	try
	{
	ArrayList<Orders> cartItemList=new ArrayList<Orders>();
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  * from orders where status=?";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setString(1, "placed");
	
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int id=res.getInt(1);
	
	
	String email=res.getString(2);
	int q=res.getInt(3);
	String status=res.getString(4);
	cartItemList.add(new Orders(id,email,q,status));
	}


	return cartItemList;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
}



public boolean approve(String [] alist) {
	// TODO Auto-generated method stub
	try
	{

	Connection con=DbConnection.getConnection();
	for(String c:alist)
	{
	
	String cmd="UPDATE orders SET status=? WHERE invoiceId=? and status=?";
	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setString(1,"approved");
	ps.setInt(2,Integer.parseInt(c));
	ps.setString(3,"placed");

	//ps.setString(3, gk.getItemName()); //ps.setString(2, i.getItemName());
	//ps.setInt(3, i.getQuantity());
	//ps.setDouble(4,i.getRate());
	ps.executeUpdate();

	}
	return true;
	}catch(Exception e)
	{
	e.printStackTrace();
	}



	return false;
}



public ArrayList<Kart> getKartByInvoice(int itid2) {
	// TODO Auto-generated method stub
	try
	{
	ArrayList<Kart> cartItemList=new ArrayList<Kart>();
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  * from kart where invoiceId=? ";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setInt(1, itid2);
	
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int id=res.getInt(1);
	int itemId=res.getInt(2);
	String itemName=res.getString(3);
	String email=res.getString(4);
	int q=res.getInt(5);
	int price=res.getInt(6);
	cartItemList.add(new Kart(itemId,itemName,email,q,price));
	}


	return cartItemList;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;

}



public ArrayList<Orders> getApprovedOrders() {
	// TODO Auto-generated method stub
	try
	{
	ArrayList<Orders> cartItemList=new ArrayList<Orders>();
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  * from orders where status=?";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setString(1, "approved");
	
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int id=res.getInt(1);
	
	
	String email=res.getString(2);
	int q=res.getInt(3);
	String status=res.getString(4);
	cartItemList.add(new Orders(id,email,q,status));
	}


	return cartItemList;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
}


public int getTotalCartPrice(String mail) {
    int sum = 0;
    try
	{
	Connection con=DbConnection.getConnection();
	String cmd="SELECT  price from kart where invoiceId=-1 and emailId=? ";

	PreparedStatement ps=con.prepareStatement(cmd);
	ps.setString(1, mail);
	
	ResultSet res=ps.executeQuery();
	while(res.next())
	{

	int price=res.getInt(1);
	sum=sum+price;
	}


	
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
    return sum;
}

}

