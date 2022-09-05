package presentation;

public class Menu {

public static void mainMenu()
{
System.out.println("---Main Menu---");
System.out.println("1.Admin Portal");
System.out.println("2.User Portal");
//System.out.println("3.Seller Portal");
System.out.println("3.Guest Portal");
System.out.println("4. exit");
System.out.println("Enter your choice");
}

public static void adminMenu()
{
System.out.println("1.view all the items");
System.out.println("2.add new item");
System.out.println("3.remove item");
System.out.println("4.change the details of item ");
System.out.println("5.View all the orders");
System.out.println("6.View all the Users");
System.out.println("7.remove the User");
System.out.println("8.Go to main menu");
System.out.println("Enter your choice:");
}
public static void userMenu()
{
System.out.println("1.viewl all the items");
System.out.println("2.view the item");
System.out.println("3.add item and quantity to cart");
System.out.println("4.add some more quantity of item to cart");
System.out.println("5.remove quantity of item to cart");
System.out.println("6.remove the item from cart");
System.out.println("7.view the cart");
System.out.println("8.buy the cart");
System.out.println("9.update the password");
//System.out.println("10.View the cart");
System.out.println("10.Go to main menu");
System.out.println("Enter the Choice");
}
public static void GuestMenu()
{
System.out.println("1.viewl all the items");
System.out.println("2.view the item");
//System.out.println("3.add itm to cart");
//System.out.println("4.buy the cart");
//System.out.println("5.remove the item from cart");
//System.out.println("6.update the password");
System.out.println("3.Signup");
System.out.println("4.Login");
System.out.println("5.exit");
System.out.println("Enter the Choice");
}
}