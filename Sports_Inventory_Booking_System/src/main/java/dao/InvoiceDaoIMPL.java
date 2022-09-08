package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Item;
import dto.User;
import util.DbConnection;

public class InvoiceDaoIMPL implements Iinvoice{
static int iid=1;
IitemDaoIMPL itt=new IitemDaoIMPL();
@Override
public boolean addItem(int i,int quantity,String mail) {
// TODO Auto-generated method stub

try
{
double price=itt.changeQuantityBuy(i, quantity);
Connection con=DbConnection.getConnection();

String cmd="INSERT INTO kart(invoiceId,itemId,emailId,quantiy,price) VALUES(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1,-1);
ps.setInt(2,i);
ps.setInt(4,quantity);

ps.setDouble(5, price);
ps.setString(3, mail); //ps.setString(2, i.getItemName());
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
public ArrayList<Item> getItems(User user) {
// TODO Auto-generated method stub
try
{
ArrayList<Integer> cartIntList=new ArrayList<Integer>();
Connection con=DbConnection.getConnection();
String cmd="SELECT itemId FROM Kart where invoiceId=?";

PreparedStatement ps=con.prepareStatement(cmd);
ps.setInt(1, iid);
ResultSet res=ps.executeQuery();
while(res.next())
{
int id=res.getInt(1);
//String itemName=res.getString(2);
//int quantity=res.getInt(3);
//double price=res.getDouble(4);
//Item l=new Item(itemName,id,quantity,price);
cartIntList.add(id);
}

System.out.println(cartIntList);
ArrayList<Item> cartItemList=new ArrayList<Item>();
//Connection con=DbConnection.getConnection();
for(int i:cartIntList) {
String cmd2="SELECT * FROM item where itemId=?";

PreparedStatement ps2=con.prepareStatement(cmd2);
ps2.setInt(1, i);
ResultSet res1=ps2.executeQuery();
while(res1.next())
{
int id=res1.getInt(1);
String itemName=res1.getString(2);
int quantity=res1.getInt(3);
int price=res1.getInt(4);
Item l=new Item(itemName,i,quantity,price);
System.out.println(i);
cartItemList.add(l);
}
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
public boolean removeItem(int id,User user) {
// TODO Auto-generated method stub


try {
Connection con=DbConnection.getConnection();
String cmd1="select quantity from kart where itemId=?";
int quantity=0;
PreparedStatement ps2=con.prepareStatement(cmd1);
ps2.setInt(1, id);
ResultSet res1=ps2.executeQuery();
///String itemName=res1.getString(2);
while(res1.next()) {
quantity=res1.getInt(1);
}
//double price=res1.getDouble(4);





String cmd="delete from kart where itemId=?";

PreparedStatement ps;

ps = con.prepareStatement(cmd);
ps.setInt(1, id);
ps.executeQuery();
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

}