

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logiclayer.CustomException;

import level3.*;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusId=request.getParameter("uId");
		String accId=request.getParameter("uAccNo");
		String depositAmmount=request.getParameter("uDep");
		int cId=Integer.valueOf(cusId);
		int aId=Integer.valueOf(accId);
		long deposit=Long.valueOf(depositAmmount);
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		try {
			logic.depositMoney(cId, aId, deposit);
		
			accMap=logic.readAccInfo();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.setAttribute("AccountServelets", accMap);
		RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
		rd.forward(request, response);
	}

}
