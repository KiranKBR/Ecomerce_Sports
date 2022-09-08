package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log-in")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		LoginService service=new LoginService();

		
		
		response.setContentType("text/html;charset=UTF-8");
		
			String email=request.getParameter("email");
			String pass=request.getParameter("password");
			User user=new User(email,null,pass);
			
			if(service.validateUser(user)!=null){
				//sn.setAttribute("email", email);
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");
			}
			
		

		
	}

	}
