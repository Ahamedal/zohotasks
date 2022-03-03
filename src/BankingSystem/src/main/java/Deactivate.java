

import java.io.IOException;


import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logiclayer.CustomException;

import level3.APILayer;
import level3.AccountInfo;
import level3.CustomerInfo;
import level3.DBLayer;

/**
 * Servlet implementation class Deactivate
 */
@WebServlet("/Deactivate")
public class Deactivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accId=request.getParameter("aId");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		if(accId!=null) {
			int aId=Integer.valueOf(accId);
			DBLayer db=new DBLayer();
			try {
				db.setAccountStatus(aId, 0);;
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		
			try {
				accMap=logic.readAccInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
			rd.forward(request, response);
		
			
		}
		else {
		String cusId=request.getParameter("userId");
		int cId=Integer.valueOf(cusId);
		
		try {
			logic.setCustomerStatus(cId, 0);;
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer,CustomerInfo> accMap=new HashMap<>();
	
		try {
			accMap=logic.readCusInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		request.setAttribute("AccountServelets", accMap);
		RequestDispatcher rd=request.getRequestDispatcher("CustomerDetails.jsp");
		rd.forward(request, response);
	
		
			
		}	
		
	}

}
