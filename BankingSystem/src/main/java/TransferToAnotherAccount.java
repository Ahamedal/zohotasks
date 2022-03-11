

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

import level3.APILayer;
import level3.AccountInfo;
import level3.CustomerInfo;
import level3.DBLayer;

/**
 * Servlet implementation class TransferToAnotherAccount
 */
@WebServlet("/TransferToAnotherAccount")
public class TransferToAnotherAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
        String fAccId=request.getParameter("uAccNo");
		
		String tAccId=request.getParameter("uaccNo");
		String dep=request.getParameter("uDep");
		
		HttpSession session=request.getSession();
		if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}
		
		else {
		
			
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		
		if(page.equals("admin")) {
			try {
			    Utility.stringCheck(fAccId);
			    Utility.stringCheck(tAccId);
			    Utility.stringCheck(dep);
			Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();;
		    int aId=Integer.valueOf(fAccId);
		
		   int aId1=Integer.valueOf(tAccId);
		   if(aId==aId1) {
			   request.setAttribute("same", "Not Able to Transation between Same Account");
			   RequestDispatcher rd=request.getRequestDispatcher("Transfer to Another Account.jsp");
				rd.forward(request, response);
		   }
		   long deposit=Long.valueOf(dep);
		    DBLayer o=new DBLayer();
		
		
			int cId=o.getCusId(aId);
			int cId1=o.getCusId(aId1);
			System.out.println(cId+" "+cId1);
			logic.depositMoney(cId1, aId1, deposit);
			logic.withDrawMoney(cId, aId, deposit);
		
			accMap=logic.readAccInfo();
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp?msg=Transaction Successfully");
			rd.forward(request, response);
			}
			catch (CustomException | ClassNotFoundException e) {
					request.setAttribute("transfers",e.getMessage());
				    RequestDispatcher rd=request.getRequestDispatcher("Transfer to Another Account.jsp");
					rd.forward(request, response);
				}
			
		}
	
		
		if(page.equals("customer")){
			
			try {
			    Utility.stringCheck(fAccId);
			    Utility.stringCheck(tAccId);
			    Utility.stringCheck(dep);
			
			int aId=Integer.valueOf(fAccId);
		    int aId1=Integer.valueOf(tAccId);
		    if(aId==aId1) {
				   request.setAttribute("same", "Not Able to Transation between Same Account");
				   RequestDispatcher rd=request.getRequestDispatcher("TransferToAnotherAccountCustomer.jsp");
					rd.forward(request, response);
			   }
			long deposit=Long.valueOf(dep);
			DBLayer o=new DBLayer();
	        Map<Integer,CustomerInfo> accMap=new HashMap<>();
			Map<Integer,AccountInfo> acc=new HashMap<>();
		
			    int cId=Integer.valueOf((String) session.getAttribute("id"));
			    System.out.println(cId);
				int cId1=o.getCusId(aId1);
				logic.depositMoney(cId1, aId1, deposit);
				logic.withDrawMoney(cId, aId, deposit);
				CustomerInfo c=logic.getCusInfoFromFile(cId);
				accMap.put(cId, c);
				System.out.println(accMap);
				request.setAttribute("AccountServelets", accMap);
				acc=logic.getForAccId(cId);
				System.out.println(acc);
				request.setAttribute("AccountServelet", acc);
				RequestDispatcher rd1=request.getRequestDispatcher("customerloginpage.jsp?msg=Transaction Successfully");
				rd1.forward(request, response);
				
			
		}
		
		catch (CustomException | ClassNotFoundException e) {
				request.setAttribute("transfers",e.getMessage());
			    RequestDispatcher rd=request.getRequestDispatcher("TransferToAnotherAccountCustomer.jsp");
				rd.forward(request, response);
			}
		}
		}
				
	
				
		}
	
	
}
