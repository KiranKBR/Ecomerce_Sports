package dao;

import java.util.ArrayList;

import dto.Item;
import dto.Kart;

public interface IItem {

public boolean addItem(Item i);
public ArrayList<Item> getItems();
public boolean removeItem(int id);
public boolean changeDetails(int id,String name,int quantity,double rate);
public Item viewItem(int id);


}