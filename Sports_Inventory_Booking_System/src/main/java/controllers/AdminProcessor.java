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
import service.adminService;


@WebServlet("/AdminProcessor")
public class AdminProcessor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action=request.getParameter("action");
		String target="";
		adminService service=new adminService();
		HttpSession sn=request.getSession();
		
		int bId;
		
		switch(action) {
		case "adLogin":
			String email=request.getParameter("email");
			String psw=request.getParameter("psw");
			User usr=new User(email,null,psw);
			if(service.validateAdmin(usr)) {
				sn.setAttribute("role", "admin");
				target="AdminMenu.jsp";
			}
			else {
				target="failed.jsp";
			}
			break;
		case "viewBooks":
			ArrayList<Item> blist=service.viewAllItems();
			request.setAttribute("blist", blist);
			target="book.jsp";
			break;
		case "addItem":
			
			break;
		case "removeItem":
			bId=Integer.parseInt(request.getParameter("bId"));
			if(service.removeItem(bId)) {
				target="removeBook.jsp";
				request.setAttribute("flag",1);
			}
			else {
				request.setAttribute("flag",0);
				target="removeBook.jsp";
			}
			break;
		
		case "changeBookPrice":
			bId=(int) sn.getAttribute("eId");
			int nwPrice=Integer.parseInt(request.getParameter("nwPrice"));
			if(service.changePrice(bId, nwPrice)) {
				target="Success.jsp";
			}else {
				target="failed.jsp";
			}
			break;
		case "viewUsers":
			ArrayList<User> ulist=service.viewAllUsers();
			request.setAttribute("ulist",ulist);
			target="UserList.jsp";
			break;
		case "removeUser":
			String uuId=request.getParameter("uId");
			if(service.removeUser(uuId)) {
				target="removeUser.jsp";
				request.setAttribute("flag",1);
			}else {
				request.setAttribute("flag",0);
				target="removeUser.jsp";
			}
			break;
		case "signout":
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
