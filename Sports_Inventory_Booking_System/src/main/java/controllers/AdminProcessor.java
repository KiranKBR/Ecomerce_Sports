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
	public static int iId=7;
  
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
			String psw=request.getParameter("password");
			
			if(email.equals("kirankummari77@gmail.com") && psw.equals("NoPassword")) {
				sn.setAttribute("user", "admin");
				target="adminhome.jsp";
			}
			
			break;
		case "viewItems":
			ArrayList<Item> Ilist=service.viewAllItems();
			request.setAttribute("blist", Ilist);
			target="item.jsp";
			break;
		case "addItem":
			String itemName=request.getParameter("iName");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			int price=Integer.parseInt(request.getParameter("iPrice"));
			String category=request.getParameter("category");
			String subCategory=request.getParameter("subCategory");
			String brand=request.getParameter("brand");
			String file=request.getParameter("image");
			service.addItem(iId++, itemName, quantity, price, category, subCategory, brand, file);
			target="addItem.jsp";
			break;
		case "removeItem":
			bId=Integer.parseInt(request.getParameter("id"));
			service.removeItem(bId);
				target="adminhome.jsp";

		
			break;
		case "searchCategory":
			String bCategory=request.getParameter("category");
			ArrayList <Item> categoryList=service.searchByCategory(bCategory);
			request.setAttribute("categoryList", categoryList);
			target="serachCategory.jsp";
			break;
		case "changeItemPrice":
			int eId=Integer.parseInt(request.getParameter("eId"));
			int nwPrice=Integer.parseInt(request.getParameter("nwPrice"));
			if(service.changePrice(eId, nwPrice)) {
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
			String uuId=request.getParameter("emailId");
			if(service.removeUser(uuId)) {
				target="users.jsp";
				
			}
			break;
		case "logout":
			
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
