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
            String mail =(String) request.getSession().getAttribute("user");
            String itemName=request.getParameter("itemName");
            int q=7;
            service.addItem(id, q,mail,itemName );
            target="home.jsp";
            break;
		case "removeItem":
            int id1 = Integer.parseInt(request.getParameter("id"));
            String mail1 =(String) request.getSession().getAttribute("user");
            System.out.println(mail1);
            System.out.println(id1);
            service.removeItem(id1, mail1);
            target="kart.jsp";
            System.out.println(id1);
            break;
		case "inc":
			int id2=Integer.parseInt(request.getParameter("id"));
			String mail2=(String) request.getSession().getAttribute("user");
			//int q2=(int)request.getAttribute("quantityy");
			System.out.println(id2+" "+mail2);
			service.incrQuantity(id2,mail2,7);
			target="kart.jsp";
			break;
			
		case "dec":
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
