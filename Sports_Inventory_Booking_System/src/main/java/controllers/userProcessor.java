package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Item;
import dto.Kart;
import dto.Orders;
import dto.User;
import service.LoginService;
import service.userService;

@WebServlet("/UserProcessor")
public class userProcessor extends HttpServlet {
	int uId;
	int price;
	String name;
	String bookName;
	String email;
	String pass;
	String address;
	int age;
	String number;
	String dob;
	int bId;
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action=request.getParameter("action");
		ArrayList<Kart> kart_list = null;
		ArrayList<Kart> kart_list1 = null;
		ArrayList<Kart> orderkart_list1 = null;
		ArrayList<Orders> order_list = null;
		String target="";
		LoginService lservice= new LoginService();
		userService service=new userService();
		HttpSession sn=request.getSession();
		System.out.println(action);
		switch(action)
		{
		case "userLogin":
			email=request.getParameter("email");
			pass=request.getParameter("password");
			
			User user=lservice.validateUser(new User(email,null,pass));
			if(user!=null) {
				target="home.jsp";
				sn.setAttribute("user", email);
				//sn.setAttribute("user", user);
				
				order_list=service.viewOrders(user.getEmailId());
				System.out.println(order_list);
				 kart_list=service.viewKart(user.getEmailId());
				sn.setAttribute("kart_list", kart_list);
				sn.setAttribute("order_list", order_list);
				sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
				System.out.println(service.getTotalCartPrice(email));
			}else {
				target="login.jsp";
			}
			break;
			
		
		case "signup":
			//uId=Integer.parseInt(request.getParameter("uId"));
			email=request.getParameter("email");
			pass=request.getParameter("password");
			name=request.getParameter("name");
			address=request.getParameter("address");
			age=Integer.parseInt(request.getParameter("age"));
			number=request.getParameter("number");
			User user1=new User(email, name, pass, age, address,number);
			if(lservice.addUser(user1)) {
				target="login.jsp";
			}
			break;
		
		case "addCart":
            int id = Integer.parseInt(request.getParameter("id"));
            String itemName=service.getItemName(id);

            kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");
            String mail =(String) request.getSession().getAttribute("user");
            int flag=0;
            for (Kart c : kart_list) {
				if (c.getItemId() == id) {
					
					int quantity = c.getQuaKart();
					quantity++;
					c.setQuaKart(quantity);
					int price=service.getItemPrice(id);			
					c.setPriceKart(price*quantity);
					service.incrQuantity(id, mail, quantity);
					sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
					 flag=1;
					 target="home.jsp";
					 break;
				}
			}
           if(flag==1)
           {
        	   System.out.print(kart_list);
        	   target="home.jsp";
        	   break;
           }
           
            int price=service.getItemPrice(id);
            
            Kart gk=new Kart(-1,id,itemName,mail,1,price);
            
            kart_list.add(gk);
            service.addItem(gk);
            sn.setAttribute("kart_list", kart_list);
            sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
            target="home.jsp";
            break;
		case "removeItem":
            int id1 = Integer.parseInt(request.getParameter("id"));
            String mail1 =(String) request.getSession().getAttribute("user");
           // String itemName2=service.getItemName(id1);
			kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");
            System.out.println(mail1);
            System.out.println(id1);
            for (Kart c : kart_list) {
				if (c.getItemId() == id1) {
					kart_list.remove(kart_list.indexOf(c));
					break;
				}
			}
            service.removeItem(id1, mail1);
            sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
            target="kart.jsp";
            System.out.println(id1);
            break;
		case "checkout":
			kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");
			int oid=service.getLastOrderId();
			String mail4 =(String) request.getSession().getAttribute("user");
			if(kart_list!=null)
			{
				service.buyKart(mail4,oid,service.getTotalCartPrice(email));
				kart_list.clear();
				order_list=service.viewOrders(mail4);
				sn.setAttribute("kart_list", kart_list);
				sn.setAttribute("order_list", order_list);
				sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
			}
			target="kart.jsp";
			break;
		case "viewDetails":
			int oid2 = Integer.parseInt(request.getParameter("id"));
			//int oid2=service.getLastOrderId();
			 //int price2=service.getItemPrice(id5);
			// String itemName4=service.getItemName(id5);
			 mail=(String) request.getSession().getAttribute("user");
			 kart_list1=service.viewOrderDetails(oid2,mail);
			 sn.setAttribute("viewDetails", kart_list1);
			 System.out.println(kart_list1);
			// Kart gk1=new Kart(oid+1,id4,itemName3,mail,1,price1);
			// service.addItem(gk1);
			// Orders ord=new Orders(oid+1,mail,price1,"placed");
			 
			 target="orders.jsp";
			 break;
		case "buyItem":
			int id4 = Integer.parseInt(request.getParameter("id"));
			int oid3=service.getLastOrderId();
			 int price1=service.getItemPrice(id4);
			 String itemName3=service.getItemName(id4);
			 mail=(String) request.getSession().getAttribute("user");
			 Kart gk1=new Kart(oid3+1,id4,itemName3,mail,1,price1);
			 service.addItem(gk1);
			 Orders ord=new Orders(oid3+1,mail,price1,"placed");
			 order_list = (ArrayList<Orders>)sn.getAttribute("order_list");
			 order_list.add(ord);
			 service.buy(ord);
			 sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
			 target="home.jsp";
			 break;
		case "buyfromkart":
			kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");

			int id5 = Integer.parseInt(request.getParameter("id"));
			int oid4=service.getLastOrderId();
			 int price4=0;
			//String itemName4=service.getItemName(id5);
			 mail=(String) request.getSession().getAttribute("user");
			 for (Kart c : kart_list) {
					if (c.getItemId() == id5) {
						//String itemName4=c.getItemName()
						price4=c.getPriceKart();
						kart_list.remove(kart_list.indexOf(c));
						break;
					}
				}
			 //Kart gk1=new Kart(oid3+1,id4,itemName3,mail,1,price1);
			 //service.addItem(gk1);
			 Orders ord4=new Orders(oid4+1,mail,price4,"placed");
			 order_list = (ArrayList<Orders>)sn.getAttribute("order_list");
			 order_list.add(ord4);
			 service.buyfk(ord4,id5);
			 sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
			 target="home.jsp";
			 break;
		case "inc":
			int id2=Integer.parseInt(request.getParameter("id"));
			String mail2=(String) request.getSession().getAttribute("user");
			kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");
			//int q2=(int)request.getAttribute("quantityy");
			for (Kart c : kart_list) {
				if (c.getItemId() == id2) {
					int quantity = c.getQuaKart();
					quantity++;
					int price5=service.getItemPrice(id2);			
					c.setPriceKart(price5*quantity);
					c.setQuaKart(quantity);
					service.incrQuantity(id2, mail2, quantity);
				}
			}
			sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
			target="kart.jsp";
			break;
			
		case "dec":
			int id3=Integer.parseInt(request.getParameter("id"));
			String mail3=(String) request.getSession().getAttribute("user");
			kart_list = (ArrayList<Kart>)sn.getAttribute("kart_list");
			//int q2=(int)request.getAttribute("quantityy");
			for (Kart c : kart_list) {
				if (c.getItemId() == id3) {
					int quantity = c.getQuaKart();
					quantity--;
					int price3=service.getItemPrice(id3);			
					c.setPriceKart(price3*quantity);
					c.setQuaKart(quantity);
					service.incrQuantity(id3, mail3, quantity);
				}
			}
			sn.setAttribute("KartPrice", service.getTotalCartPrice(email));
			target="kart.jsp";
			break;
		case "logout":
			sn.removeAttribute("user");
			sn.invalidate();
			target="index.jsp";
			break;
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
