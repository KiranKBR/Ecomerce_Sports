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
import service.AdminService;


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
		AdminService service=new AdminService();
		HttpSession sn=request.getSession();
		ArrayList<Orders> olist=null;
		ArrayList<Orders> olist2=null;
		int bId;
		
		switch(action) {
		case "adLogin":
			String email=request.getParameter("email");
				String psw=request.getParameter("password");
			olist=service.getPlacedOrders();
			olist2=service.getApprovedOrders();
			sn.setAttribute("order_list", olist);
			sn.setAttribute("order_list_approved", olist2);
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
			bId=Integer.parseInt(request.getParameter("id3"));
			service.removeItem(bId);
			sn.removeAttribute("idc");
				target="adminhome.jsp";
				
		
			break;
			
		case  "viewOrder":
			target="adminorders.jsp";
			int itid2=Integer.parseInt(request.getParameter("Id"));
			ArrayList<Kart> kart_list=service.getKartByInvoice(itid2);
			sn.setAttribute("viewDetails", kart_list);
			olist=service.getPlacedOrders();
			sn.setAttribute("order_list", olist);
			break;
		case  "viewOrderApproved":
			
			int itid3=Integer.parseInt(request.getParameter("Id2"));
			ArrayList<Kart> kart_list2=service.getKartByInvoice(itid3);
			sn.setAttribute("viewDetailsapproved", kart_list2);
			olist2=service.getApprovedOrders();
			sn.setAttribute("order_list_approved", olist2);
			target="approvedOrd.jsp";
			break;
		case "selectToChange":
			int id5=Integer.parseInt(request.getParameter("id"));
			Item i=service.getItem(id5);
			sn.setAttribute("idc", i);
			target="adminhome.jsp";
			break;
		case "changeDetails":
			int id2=Integer.parseInt(request.getParameter("id2"));
			String itemName2=request.getParameter("name");

			
			int quantity2=Integer.parseInt(request.getParameter("quantity"));
			int price2=Integer.parseInt(request.getParameter("price"));
			String category2=request.getParameter("category");
			String subCategory2=request.getParameter("subcat");
			String brand2=request.getParameter("brand");
			String file2=request.getParameter("image");
			service.changeDetails(new Item(id2, itemName2, quantity2, price2, category2, subCategory2, brand2, file2));
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
