package dao;

import java.util.ArrayList;

import dto.User;

public interface ILogin
{
public User searchUser();
public boolean modifyUser();
public boolean removeUser();
public ArrayList<User> viewAllUsers();
public boolean addUser(User l);
public User validateUser(User l);
public boolean updatePass(User l);
User searchUser(String email);
}