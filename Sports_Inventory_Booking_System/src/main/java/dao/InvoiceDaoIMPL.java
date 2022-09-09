package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Item;
import dto.Kart;
import dto.User;
import util.DbConnection;

public class InvoiceDaoIMPL implements Iinvoice{
static int iid=1;
IitemDaoIMPL itt=new IitemDaoIMPL();
@Override
public boolean addItem(int i,int quantity,String mail,String itemName) {
// TODO Auto-generated method stub

try
{
int price=itt.changeQuantityBuy(i, quantity);
Connection con=DbConnection.getConnection();

String cmd="INSERT INTO kart VALUES(?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1,-1);
ps.setInt(2,i);
ps.setString(4,mail);
ps.setInt(6,price);
ps.setInt(5, quantity);
ps.setString(3, itemName); //ps.setString(2, i.getItemName());
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
cartItemList.add(new Kart(id,itemId,itemName,email,q,price));
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





String cmd="delete from kart where itemId=? and emailId=?";

PreparedStatement ps;

ps = con.prepareStatement(cmd);
ps.setInt(1, id);
ps.setString(2, mail);
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
double price=itt.changeQuantityBuy(i, q);
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
	String cmd="UPDATE kart SET quantiy=? WHERE itemId=? and emailId=?";
	PreparedStatement ps;
	try {
		int s=q+1;
		ps = con.prepareStatement(cmd);
		ps.setInt(1,s);
		ps.setInt(2, id2);
		ps.setString(3, mail2);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return true;
	
}

}