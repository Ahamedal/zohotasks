

import java.io.IOException;


import java.util.*;
import com.logiclayer.*;
import level3.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountServelets
 */
@WebServlet("/AccountServelets")
public class AccountServelets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config)throws ServletException {
    	APILayer obj=null;
		try {
			obj = new APILayer(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	config.getServletContext().setAttribute("object", obj);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		String id=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String page=request.getParameter("page");
		try {
			Utility.stringCheck(page);
			Utility.stringCheck(id);

		} catch (CustomException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(page.equals("login")) {
			int id1=Integer.valueOf(id);
			String check=null;
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			
			try {
				check=logic.getLogin(id1, pass);
			
		     if(check.equals("admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("adminloginpage.jsp");
			rd.forward(request, response);
		         }
		    
		     else if(check.equals("customer")) {
			
		      int id2=Integer.valueOf(id);
             Map<Integer,CustomerInfo> accMap=new HashMap<>();
			
			try {
				CustomerInfo c=logic.getCusInfoFromFile(id2);
				accMap.put(id2, c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("customerloginpage.jsp");
			
			Map<Integer,AccountInfo> acc=new HashMap<>();
			
			try {
				acc=logic.getForAccId(id2);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(acc);
			request.setAttribute("AccountServelet", acc);
			RequestDispatcher rd1=request.getRequestDispatcher("customerloginpage.jsp");
			rd1.forward(request, response);
			
		}
		else {
			System.out.println("error oocured");
		}
			} catch (ClassNotFoundException | CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(page.equals("accountdetails")) {
			Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
			
			
			try {
				accMap=logic.readAccInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
			rd.forward(request, response);
			

		}
		if(page.equals("customerdetails")) {
			Map<Integer,CustomerInfo> accMap=new HashMap<>();
			
			try {
				accMap=logic.readCusInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerDetails.jsp");
			rd.forward(request, response);
			

		}
		
		
	}

}
