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

import dto.*;
import service.*;

@WebServlet("/UserProcessor")
public class UserProcessor extends HttpServlet {
	int uId;
	int price;
	String buyerEmail;
	String bookName;
	String email;
	String pass;
	String uname;
	String ulocation;
	int age;
	String mNumber;
	String dob;
	int bId;
	private static final long serialVersionUID = 1L;
       
    public UserProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action=request.getParameter("action");
		String target="";
		LoginService service=new LoginService();
		userService userService=new userService();
		HttpSession sn=request.getSession();
		switch(action)
		{
		case "userLogin":
			String email=request.getParameter("uEmail");
			String pass=request.getParameter("psw");
			User usr=new User(email,null,pass);

			if(service.validateUser(usr)) {
				target="UserMenu.jsp";
				sn.setAttribute("buyerMail", email);
				sn.setAttribute("role", "user");
			}else {
				target="failed.jsp";
			}
			break;
		case "signup":
			//uId=Integer.parseInt(request.getParameter("uId"));
			email=request.getParameter("uEmail");
			pass=request.getParameter("uPwd");
			uname=request.getParameter("name");			//ulocation=request.getParameter("ulocation");
			//age=Integer.parseInt(request.getParameter("uAge"));
			//mNumber=request.getParameter("uMobileNumber");
			//dob=request.getParameter("dob");
			User usr1=new User(email,uname,pass);
			if(service.addUser(usr1)) {
				target="UserLogin.jsp";
			}
			break;
		case "viewBooks":
			ArrayList<Item> blist=userService.viewAllItems();
			request.setAttribute("blist", blist);
			target="book.jsp";
			break;
		/*
		 * case "addCart": bId=Integer.parseInt(request.getParameter("bookId"));
		 * bookName=request.getParameter("bookName");
		 * price=Integer.parseInt(request.getParameter("bookPrice"));
		 * buyerEmail=request.getParameter("buyerMail"); //int
		 * quantity=service.existInCart(bId,buyerEmail); if(quantity!=0){ quantity+=1;
		 * service.updateQuantity(bId,quantity,buyerEmail); }else { quantity=1;
		 * service.addCart(bId,bookName, price,quantity, buyerEmail); }
		 * target="Success.jsp"; break;
		 *///case "viewKart":
		//	buyerEmail=request.getParameter("buyer");
			//ArrayList<Cart> clist=userService.viewKart(usr);
			//request.setAttribute("clist", clist);
			//target="cartItems.jsp";
			//break;
		case "signOut":
			sn.invalidate();
			target="index.html";
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
