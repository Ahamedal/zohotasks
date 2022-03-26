

import java.io.IOException;
import java.io.PrintWriter;
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
import level3.DBLayer;

/**
 * Servlet implementation class WithDraw
 */
@WebServlet("/WithDraw")
public class WithDraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   
		String accId=request.getParameter("uAccNo");
		String WithDrawAmmount=request.getParameter("uWit");
		try {
	
		Utility.stringCheck(accId);
		Utility.stringCheck(WithDrawAmmount);
		DBLayer o=new DBLayer();
		int aId=Integer.valueOf(accId);
		int cId=o.getCusId(aId);
		long withDraw=Long.valueOf(WithDrawAmmount);
		HttpSession session=request.getSession();
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		PrintWriter out=response.getWriter();
		if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}
		else {
	
			logic.withDrawMoney(cId, aId, withDraw);
	        accMap=logic.readAccInfo();
	        request.setAttribute("AccountServelets", accMap);
			RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp?msg=*WithDrawal Succesfully");
			rd.forward(request, response);
		}
		} catch (CustomException |ClassNotFoundException e) {
		    request.setAttribute("withdraw",e.getMessage());
		    RequestDispatcher rd=request.getRequestDispatcher("WithDraw.jsp");
			rd.forward(request, response);
		    
	
		}
		
	}

}
