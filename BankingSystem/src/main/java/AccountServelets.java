

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String page=request.getParameter("page");
		
		
		Map<Integer,AccountInfo> acc=new HashMap<>();
		HttpSession session=request.getSession();
		
		if(page.equals("login")) {
			String id=request.getParameter("uname");
			String pass=request.getParameter("pass");
			try {
				Utility.stringCheck(id);
				Utility.stringCheck(pass);
			int id1=Integer.valueOf(id);
			String check=null;
			
			session.setAttribute("id", id);
			
			
				check=logic.getLogin(id1, pass);
			
		     if(check.equals("admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("adminloginpage.jsp");
			rd.forward(request, response);
		         }
		    
		     else if(check.equals("customer")) {
			
		      int id2=Integer.valueOf(id);
             Map<Integer,CustomerInfo> accMap=new HashMap<>();
			
			 
				CustomerInfo c=logic.getCusInfoFromCache(id2);
				accMap.put(id2, c);
				System.out.println(accMap);
				request.setAttribute("AccountServelets", accMap);
				acc=logic.getForAccId(id2);
				session.setAttribute("map", acc);
				System.out.println(acc);
				request.setAttribute("AccountServelet", acc);
				RequestDispatcher rd1=request.getRequestDispatcher("customerloginpage.jsp");
				rd1.forward(request, response);
			}
		     else {
					request.setAttribute("login", "*your user id and password is wrong");
					RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
					rd.forward(request, response);
					
					
				}
			}catch (CustomException |ClassNotFoundException e) {
				request.setAttribute("login", e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
				rd.forward(request, response);
			}
			
		}
		
//	
		
		if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}
		if(page.equals("accountdetails")) {
			Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
			
			
			try {
				accMap=logic.getAccountInfoCache();
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
				accMap=logic.getCustomerInfoCache();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerDetails.jsp");
			rd.forward(request, response);
			

		}
		
	   if(page.equals("logout")) {
		   
		   session.invalidate();
		   response.sendRedirect("banklogin.jsp");
		   //RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			//rd.forward(request, response);
	   }
	  
	
	if(page.equals("drop")) {
		session.setAttribute("map", acc);
		RequestDispatcher rd=request.getRequestDispatcher("TransferToAnotherAccountCustomer.jsp");
		rd.forward(request, response);
	}
	if(page.equals("deactivatedetails")) {
        Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
			
			
			try {
				accMap=logic.getAccountInfoCache();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("DeactivateAccountDetails.jsp");
			rd.forward(request, response);
			

		}
	if(page.equals("deactivatedetailscustomer")) {
        Map<Integer,CustomerInfo> accMap=new HashMap<>();
			
			
			try {
				accMap=logic.getCustomerInfoCache();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(accMap);
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("DeactivatedAccountDetails.jsp");
			rd.forward(request, response);
			

		}
	}

}
