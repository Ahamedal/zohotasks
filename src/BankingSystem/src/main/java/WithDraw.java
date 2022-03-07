

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

import level3.APILayer;
import level3.AccountInfo;

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
		String cusId=request.getParameter("uId");
		String accId=request.getParameter("uAccNo");
		String WithDrawAmmount=request.getParameter("uWit");
		int cId=Integer.valueOf(cusId);
		int aId=Integer.valueOf(accId);
		long withDraw=Long.valueOf(WithDrawAmmount);
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		try {
			logic.withDrawMoney(cId, aId, withDraw);;
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

}