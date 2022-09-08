package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.User;
import util.DbConnection;

public class ILoginDaoIMPL implements ILogin
{
Scanner sc=new Scanner(System.in);
public ArrayList<User> viewAllUsers()
{
try {
ArrayList<User> loginlist=new ArrayList<User>();
Connection con=DbConnection.getConnection();
String cmd="SELECT * FROM user";
PreparedStatement ps=con.prepareStatement(cmd);
ResultSet res=ps.executeQuery();
while(res.next())
{
String email=res.getString(1);
String name=res.getString(2);
String pass=res.getString(3);
int age=res.getInt(4);
String address=res.getString(5);
String phoneNumber=res.getString(6);
User l=new User(email,name,pass,age,address,phoneNumber);
loginlist.add(l);
}
return loginlist;
}catch(Exception e)
{
e.printStackTrace();
}
return null;
}

public boolean addUser(User l)
{
try
{
Connection con=DbConnection.getConnection();
String cmd="INSERT INTO user VALUES(?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setString(2, l.getUserName());
ps.setString(3, l.getPassword());
ps.setString(1, l.getEmailId());
ps.setInt(4, l.getAge());
ps.setString(5, l.getAddress());
ps.setString(6, l.getPhoneNumber());
ps.executeUpdate();
return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;

}
public User validateUser(User l)
{
try
{
Connection con=DbConnection.getConnection();
String cmd="SELECT * FROM user WHERE emailId=? and password=?";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setString(1,l.getEmailId());
ps.setString(2, l.getPassword());
ResultSet res=ps.executeQuery();
if(res.next()) {
l.setUserName(res.getString(1));
l.setAge(res.getInt(4));
l.setAddress(res.getString(5));
l.setPhoneNumber(res.getString(6));
return l;}
return null;

}

catch(Exception e)
{
e.printStackTrace();
}
return null;

}

@Override
public User searchUser(String email)
{
try
{
Connection con=DbConnection.getConnection();
String cmd="SELECT * FROM user WHERE emailId=?";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setString(1,email);
ResultSet res=ps.executeQuery();
if(res.next())
{
String email1=res.getString(1);
String name=res.getString(2);
String pass=res.getString(3);
int age=res.getInt(4);
String address=res.getString(5);
String phone=res.getString(6);
User s=new User(email1,name,pass,age,address,phone);
return s;
}
}catch(Exception e)
{
e.printStackTrace();
}
return null;
}

@Override
public boolean modifyUser()
{
try
{
Connection con=DbConnection.getConnection();
String cmd="UPDATE login SET emailId=?,password=? WHERE emailId=?";
PreparedStatement ps=con.prepareStatement(cmd);
System.out.println("enter the username to Modify: ");
String uname=sc.next();
System.out.println("enter the NewUsername: ");
String nwName=sc.next();
System.out.println("enter the NewPassword: ");
String nwPaswd=sc.next();
ps.setString(1,nwName);
ps.setString(2, nwPaswd);
ps.setString(3, uname);
ps.executeUpdate();
return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;
}

public boolean removeUser(String id)
{
try
{
Connection con=DbConnection.getConnection();
String cmd="DELETE FROM user WHERE emailId=?";
PreparedStatement ps=con.prepareStatement(cmd);
//String uname=sc.next();
ps.setString(1, id);
ps.executeUpdate();
return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;
}

@Override
public boolean removeUser() {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean updatePass(User l) {
// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
String cmd="update user set password=? where emailId=?";

PreparedStatement ps;
try {
ps = con.prepareStatement(cmd);
ps.setString(1, l.getPassword());
ps.setString(2, l.getEmailId());
ps.executeQuery();
return true;
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return false;

}

@Override
public User searchUser() {
	// TODO Auto-generated method stub
	return null;
}

}