package service;

import java.util.ArrayList;

import dao.ILoginDaoIMPL;
import dto.User;

public class LoginService
{
ILoginDaoIMPL dao;
public ArrayList<User> getAllLoginUsers()
{
dao=new ILoginDaoIMPL();
ArrayList<User> al=dao.viewAllUsers();
return al;
}
public boolean addUser(User l)
{
dao=new ILoginDaoIMPL();
boolean flag=dao.addUser(l);
System.out.println(l);
return flag;
}
public User validateUser(User l)
{
dao=new ILoginDaoIMPL();
User flag=dao.validateUser(l);
return flag;
}
public User searchUser()
{
dao=new ILoginDaoIMPL();
return dao.searchUser();
}
public boolean modifyUser()
{
dao=new ILoginDaoIMPL();
return dao.modifyUser();
}
public boolean removeUser()
{
dao=new ILoginDaoIMPL();
return dao.removeUser();
}

}
