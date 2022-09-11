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
import dto.Orders;
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
		ArrayList<Orders> olist=null;
		
		int bId;
		
		switch(action) {
		case "adLogin":
			String email=request.getParameter("email");
				String psw=request.getParameter("password");
			olist=service.getPlacedOrders();
			sn.setAttribute("order_list", olist);
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
		case "approve":
			  
			String[] alist=request.getParameterValues("approval");
			System.out.println(alist);
			//olist=(ArrayList<Orders>) sn.getAttribute("order_list");
			service.approve(alist);
			olist=service.getPlacedOrders();
			sn.setAttribute("order_list", olist);
			target="adminorders.jsp";
			break;
		case "addItem":
			int id=service.getLastId();
			String itemName=request.getParameter("name");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			int price=Integer.parseInt(request.getParameter("price"));
			String category=request.getParameter("category");
			String subCategory=request.getParameter("subcat");
			String brand=request.getParameter("brand");
			String file=request.getParameter("image");
			service.addItem(id+1, itemName, quantity, price, category, subCategory, brand, file);
			target="adminhome.jsp";
			break;
		case "removeItem":
			bId=Integer.parseInt(request.getParameter("id"));
			service.removeItem(bId);
			sn.removeAttribute("idc");
				target="adminhome.jsp";

		
			break;
		case "changeDetails":
			int itid=Integer.parseInt(request.getParameter("id"));
			Item i=service.getItem(itid);
			sn.setAttribute("idc", i);
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
