package dao;

import java.util.ArrayList;

import dto.Item;
import dto.User;

public interface Iinvoice {
public boolean addItem(int i,int quantity,User user);
public ArrayList<Item> getItems(User user);
public boolean updateQuantity(int i,int q,User user);
public boolean removeItem(int id,User user);
public boolean removeQuantity(int id,int q,User user);
public boolean buy(User user);
boolean addItem(int i, int quantity, String mail);

}