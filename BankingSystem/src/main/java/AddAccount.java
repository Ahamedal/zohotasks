

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logiclayer.*;


import level3.*;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String accountType=request.getParameter("uAT");
		String branchName=request.getParameter("uBr");
		
		int a=Integer.valueOf(userId);
		String id=request.getParameter("userId1");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		if(!id.equals("null")) {
			  int k=Integer.parseInt(id);
				DBLayer o=new DBLayer();
				String query="update accountInfo set customerID="+a+",accountType='"+accountType+"',branchName='"+branchName+"' where accountID="+k+";";
				o.updateTable(query);
				
				
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
		AccountInfo acc=new AccountInfo();
		acc.setCustomerID(a);
		acc.setAccountType(accountType);
		acc.setBranchName(branchName);
		
		try {
			logic.addMultipleAccount(acc);
	
			accMap=logic.readAccInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("AccountServelets", accMap);
		RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
		rd.forward(request, response);
		}
	}

}
