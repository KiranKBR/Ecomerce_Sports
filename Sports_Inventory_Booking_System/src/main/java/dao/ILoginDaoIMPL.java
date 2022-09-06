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
String uname=res.getString(1);
String pass=res.getString(2);
String email=res.getString(3);
User l=new User(uname,pass,email);
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
String cmd="INSERT INTO user VALUES(?,?,?)";
PreparedStatement ps=con.prepareStatement(cmd);
ps.setString(2, l.getUserName());
ps.setString(3, l.getPassword());
ps.setString(1, l.getEmailId());
ps.executeUpdate();
return true;
}catch(Exception e)
{
e.printStackTrace();
}
return false;

}
public boolean validateUser(User l)
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
return true;}
return false;

}

catch(Exception e)
{
e.printStackTrace();
}
return false;
}

@Override
public User searchUser()
{
try
{
Connection con=DbConnection.getConnection();
String cmd="SELECT * FROM user WHERE emailId=?";
PreparedStatement ps=con.prepareStatement(cmd);
System.out.println("enter the username to search: ");
String uname=sc.next();
ps.setString(1,uname);
ResultSet res=ps.executeQuery();
if(res.next())
{
String u=res.getString(1);
String p=res.getString(2);
User s=new User(u,p);
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

}