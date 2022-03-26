


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
		try {
			Utility.stringCheck(userId);
			Utility.stringCheck(accountType);
			Utility.stringCheck(branchName);
		HttpSession session=request.getSession();
		if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}
		else {
		
		String id=request.getParameter("userId1");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		if(!id.equals("null")) {
			
				int a=Integer.valueOf(userId);
			    int k=Integer.parseInt(id);
				DBLayer o=new DBLayer();
				
				o.updateAccountDatas(a,accountType,branchName,k);
					
				    accMap=logic.readAccInfo();
					request.setAttribute("AccountServelets", accMap);
					RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp?msg=*Your Response Updated Successfully");
					rd.forward(request, response);
			
				
		}
		else {
			int a=Integer.valueOf(userId);
		AccountInfo acc=new AccountInfo();
		acc.setCustomerID(a);
		acc.setAccountType(accountType);
		acc.setBranchName(branchName);
		
	
			logic.addMultipleAccount(acc);
	
			accMap=logic.readAccInfo();
			request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp?msg=*Your Response Added Successfully");
			rd.forward(request, response);
		} 
		}
		}
		catch (CustomException|ClassNotFoundException e) {
			request.setAttribute("addaccount","Enter Valid UserId");
			RequestDispatcher rd=request.getRequestDispatcher("AddAccount.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}
	}

