

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logiclayer.CustomException;
import com.logiclayer.Utility;

import level3.*;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("uname");
		String address=request.getParameter("uadd");
		String mobileNo=request.getParameter("umob");
		try {
				Utility.stringCheck(name);
				Utility.stringCheck(address);
				Utility.stringCheck(mobileNo);
		HttpSession session=request.getSession();
		if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}
		else {
	  
		String id=request.getParameter("userId1");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,CustomerInfo> accMap=new HashMap<>();
		
		if(!id.equals("null")) {
		  
			long mobileN=Long.valueOf(mobileNo);
	        int k=Integer.parseInt(id);
			DBLayer o=new DBLayer();
			
			o.updateDatas(name,address,mobileN,k);
			
			
				accMap=logic.readCusInfo();
				request.setAttribute("AccountServelets", accMap);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerDetails.jsp");
				rd.forward(request, response);
			
			
		}
		else {
			
		CustomerInfo cus=new CustomerInfo();
		long mobileN=Long.valueOf(mobileNo);
		cus.setName(name);
		cus.setAddress(address);
		cus.setMobileNo(mobileN);
	    logic.addMap(cus);
	    accMap=logic.readCusInfo();
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerDetails.jsp");
			rd.forward(request, response);
		} 
		}
		}
		catch (CustomException|ClassNotFoundException  e) {
			 request.setAttribute("addcustomer",e.getMessage());
			    RequestDispatcher rd=request.getRequestDispatcher("addCustomer.jsp");
				rd.forward(request, response);
		}
		
		}
	
}
