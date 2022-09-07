package presentation;

import java.util.Scanner;

import dto.Item;
import dto.User;
import service.LoginService;
import service.adminService;
import service.userService;

public class test {



public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner scan =new Scanner(System.in);
adminService as=new adminService();
LoginService ls=new LoginService();
userService us=new userService();
int i;
do
{
Menu.mainMenu();
i=Integer.parseInt(scan.nextLine());
switch(i)
{
case 1:
int j;
do
{
Menu.adminMenu();
j=Integer.parseInt(scan.nextLine());
switch(j)
{
case 1:
for(Item l:as.viewAllItems())
{
System.out.println(l);
}
break;
case 2:
if(as.addItem())
{
System.out.println("item added succussfully");
}
else {
System.out.println("Sorry item can't be added");
}
break;
case 3:
	int id=scan.nextInt();
if(as.removeItem(id))
{
System.out.println("item removed successfully");
}
else
{
System.out.println("item can't be removed");
}
break;
case 4:
if(as.changedetails())
{
System.out.println("Details changed successfully");
}
else
{
System.out.println("price can't be changed");
}
break;
case 5:
// for(Order o:adservice.viewAllOrders())
//{
//System.out.println(o);
//}
break;
case 6:
for(User u:as.viewAllUsers())
{
System.out.println(u);
}
break;
case 7:
	String emailid=scan.nextLine();
if(as.removeUser(emailid))
{
System.out.println("user deleted successfully");
}
else
{
System.out.println("user doesn't exist");
}
break;
case 8:
break;
default:
System.out.println("Invalid key");
}
}while(j!=8);
case 2:
int k=0;

System.out.println("enter the emailId and password");
String email=scan.nextLine();
String pass=scan.nextLine();
int id=0,q=0;
User usr=new User(email,null,pass);
if(ls.validateUser(usr)) {
do
{
Menu.userMenu();
k=Integer.parseInt(scan.nextLine());
switch(k)
{
case 1:
for(Item l:us.viewAllItems())
{
System.out.println(l);
}
break;
case 2:
System.out.println("Enter id to view the item");
id=Integer.parseInt(scan.nextLine());
System.out.println(us.viewItem(id));
break;
case 3:
System.out.println("Enter the itemid and quantity");
id=Integer.parseInt(scan.nextLine());
q=Integer.parseInt(scan.nextLine());
if(us.addItem(id, q,usr)) {
System.out.println("Added Succesfully");
}
else
{
System.out.println("this has not been added");
}
break;
case 4:
System.out.println("add some more quantity to add");
id=Integer.parseInt(scan.nextLine());
q=Integer.parseInt(scan.nextLine());
if(us.addQuantity(id, q,usr)) {
System.out.println("Added succesfully");
}
else
{
System.out.println("not added");
}
break;
case 5:
System.out.println("enter item id and quantity to remove the quantity only");
id=Integer.parseInt(scan.nextLine());
q=Integer.parseInt(scan.nextLine());
if(us.removeQuantity(id, q,usr))
{
System.out.println("removed succesfully");
}
else
{
System.out.println("not removed");
}
break;
case 6:
System.out.println("enter item id to remove");
id=Integer.parseInt(scan.nextLine());
q=Integer.parseInt(scan.nextLine());
if(us.removeItem(id,usr))
{
System.out.println("removed succesfully");
}
else
{
System.out.println("not removed");
}
break;

case 7:
for(Item l:us.viewKart(usr))
{
System.out.println(l);
}
break;
case 9:
if(us.updatePass(usr))
System.out.println("Updated successfully");
else
System.out.println("not updated");
break;
case 10:
break;
case 8:
break;
}

}while(k!=10);

}else{continue;}}
}while(i!=3);

}

}