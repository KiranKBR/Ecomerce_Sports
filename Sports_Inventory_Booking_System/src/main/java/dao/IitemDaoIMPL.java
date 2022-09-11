package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Item;
import dto.Kart;
import util.DbConnection;

public class IitemDaoIMPL implements IItem{
	
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

public boolean addItem(Item i)
{
			try
			{		
					Connection con=DbConnection.getConnection();
					String cmd="INSERT INTO item VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(cmd);
					ps.setInt(1, i.getItemId());
					ps.setString(2, i.getItemName());
					ps.setInt(3, i.getQuantity());
					ps.setInt(4,i.getRate());
					ps.setString(5, i.getCategory());
					ps.setString(6, i.getSubCategory());
					ps.setString(7, i.getBrand());
					ps.setString(8, i.getFile());
					ps.executeUpdate();
					con.close();
					return true;
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			return false;
}

public ArrayList<Item> getItems()
{
try
{
		ArrayList<Item> itemList=new ArrayList<Item>();
		Connection con=DbConnection.getConnection();
		String cmd="SELECT * FROM item";
		PreparedStatement ps=con.prepareStatement(cmd);
		ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			int id=res.getInt(1);
			String itemName=res.getString(2);
			int quantity=res.getInt(3);
			int price=res.getInt(4);
			String category1=res.getString(5);
			String subCategory=res.getString(6);
			String brand=res.getString(7);
			String file=res.getString(8);
			Item l=new Item(id,itemName,quantity,price,category1,subCategory,brand,file);
			itemList.add(l);
		  }

return itemList;
}
catch(Exception e)
{
e.printStackTrace();
}
return null;
}

public ArrayList<Kart> getKartItems(String emailId)
{
try
{
		ArrayList<Kart> itemList=new ArrayList<Kart>();
		Connection con=DbConnection.getConnection();
		String cmd="SELECT * FROM kart where emailId=?";
		PreparedStatement ps=con.prepareStatement(cmd);
		ps.setString(1, emailId);

		ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			int id=res.getInt(1);
			String itemName=res.getString(2);
			int karQuan=res.getInt(4);
			int price=res.getInt(5);
			
			Kart l=new Kart(id,itemName,karQuan,price);
			itemList.add(l);
		  }

return itemList;
}
catch(Exception e)
{
e.printStackTrace();
}
return null;
}
public int getItemPrice(int id)
{
    Connection con=DbConnection.getConnection();
	String cmd="select price from item where itemId=?";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(cmd);
	
	ps.setInt(1, id);
    rs = ps.executeQuery();
    while (rs.next()) {
       return rs.getInt(1);
    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return 0;
}

public int getTotalCartPrice(ArrayList<Kart> cartList) {
    int sum = 0;
    try {
        if (cartList.size() > 0) {
            for (Kart item : cartList) {
               
                Connection con=DbConnection.getConnection();
        		String cmd="select price from item where itemId=?";
        		PreparedStatement ps=con.prepareStatement(cmd);
        		ps.setInt(1, item.getItemId());
                rs = ps.executeQuery();
                while (rs.next()) {
                    sum+=rs.getDouble("price")*item.getQuantity();
                }

            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
    return sum;
}






public boolean removeItem(int id)
{
try
{
		Connection con=DbConnection.getConnection();
		String cmd="DELETE FROM item WHERE itemId=?";
		PreparedStatement ps=con.prepareStatement(cmd);
		ps.setInt(1, id);
		ps.executeUpdate();
		return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;
}
public boolean changeDetails(int id,String name,int quantity,int rate)
{
try
{
Connection con=DbConnection.getConnection();
String cmd="UPDATE item SET name=?, quantity=?, price=? WHERE itemId=?";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setString(1,name);
ps.setInt(2, quantity);
ps.setInt(3, rate);
ps.setInt(4, id);
ps.executeUpdate();
return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;
}
public boolean changeRate(int id,int rate)
{
	try
	{
			Connection con=DbConnection.getConnection();
			String cmd="UPDATE item SET price=? WHERE itemId=?";
			PreparedStatement ps=con.prepareStatement(cmd);
			ps.setInt(1,rate);
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
	}
	catch(Exception e)
	{
			e.printStackTrace();
	}
	return false;
}
public int changeQuantityBuy(int id,int quantity)
{
int price=0;
try
{
Connection con=DbConnection.getConnection();
String c="select quantity,price from item where itemId=?";
PreparedStatement ps2=con.prepareStatement(c);
ps2.setInt(1, id);
int q=0;

ResultSet res=ps2.executeQuery();
while(res.next()) {
q=res.getInt(1);
price=res.getInt(2)*quantity;
}

String cmd1="update item set quantity=? where itemId=?";
PreparedStatement ps1=con.prepareStatement(cmd1);
ps1.setInt(1,q-quantity );
ps1.setInt(2,id);
ps1.executeUpdate();
}catch(Exception e)
{
e.printStackTrace();
}
return price;
}



@Override
public Item viewItem(int id) {
// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
String cmd="SELECT * FROM item where itemId=?";
PreparedStatement ps;
try {
ps = con.prepareStatement(cmd);

ps.setInt(1, id);
ResultSet res=ps.executeQuery();
//int iid=res.getInt(1);
while(res.next()) {
	int iid=res.getInt(1);
String itemName=res.getString(2);
int quantity=res.getInt(3);
int price=res.getInt(4);
String cat=res.getString(5);
String subcat=res.getString(6);
String brand=res.getString(7);
String file=res.getString(8);
Item l=new Item(iid,itemName,quantity,price,cat,subcat,brand,file);
return l;}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return null;
}

@Override
public boolean changeDetails(int id, String name, int quantity, double rate) {
	// TODO Auto-generated method stub
	return false;
}

public ArrayList<Item> getItemsByCategory(String category)
{
	try 
	{
		ArrayList<Item> categoryList=new ArrayList<Item>();
		Connection con=DbConnection.getConnection();
		String cmd="SELECT * FROM item where category=?";
		PreparedStatement ps=con.prepareStatement(cmd);
		ps.setString(1,category);
		ResultSet res=ps.executeQuery();
	  while(res.next())
	  {
		int id=res.getInt(1);
		String itemName=res.getString(2);
		int quantity=res.getInt(3);
		int price=res.getInt(4);
		String category1=res.getString(5);
		String subCategory=res.getString(6);
		String brand=res.getString(7);
		String file=res.getString(8);
		Item l=new Item(id,itemName,quantity,price,category1,subCategory,brand,file);
		categoryList.add(l);
	  }
	return categoryList;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public String getItemName(int id) {
	// TODO Auto-generated method stub
    Connection con=DbConnection.getConnection();
	String cmd="select itemName from item where itemId=?";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(cmd);
	
	ps.setInt(1, id);
    rs = ps.executeQuery();
    while (rs.next()) {
       return rs.getString(1);
    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
	return null;
}

public int getLastId() {
	// TODO Auto-generated method stub
	Connection con=DbConnection.getConnection();
	query="select itemId from item order by itemId DESC LIMIT 1";
	try {
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
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




}