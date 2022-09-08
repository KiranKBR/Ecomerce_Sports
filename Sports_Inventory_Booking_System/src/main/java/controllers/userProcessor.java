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
				//sn.setAttribute("role", user);
			}else {
				target="login.jsp";
			}
			break;
		case "signup":
			//uId=Integer.parseInt(request.getParameter("uId"));
			email=request.getParameter("email");
			pass=request.getParameter("pass");
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
            
            int q=7;
            service.addItem(id, q,mail );
            target="home.jsp";
            break;
		case "viewCart":

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
