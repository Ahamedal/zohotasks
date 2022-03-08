

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import level3.APILayer;
import level3.AccountInfo;
import level3.DBLayer;

/**
 * Servlet implementation class Activate
 */
@WebServlet("/Activate")
public class Activate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accId=request.getParameter("aId");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		int aId=Integer.valueOf(accId);
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		DBLayer db=new DBLayer();
		try {
			db.setAccountStatus(aId, 1);
		
			accMap=logic.readAccInfo();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  
		request.setAttribute("AccountServelets", accMap);
		RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
		rd.forward(request, response);
	}

}
