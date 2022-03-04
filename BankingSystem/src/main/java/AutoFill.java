

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logiclayer.CustomException;

import level3.APILayer;
import level3.CustomerInfo;

/**
 * Servlet implementation class AutoFill
 */
@WebServlet("/AutoFill")
public class AutoFill extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String id=request.getParameter("userId");
	   int id2=Integer.valueOf(id);
	   APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
	   try {
		CustomerInfo c=logic.getCusInfoFromFile(id2);
		request.setAttribute("name", c.getName());
		request.setAttribute("address", c.getAddress());
		request.setAttribute("mobileno",c.getMobileNo());
		RequestDispatcher rd=request.getRequestDispatcher("addCustomer.jsp");
		rd.forward(request, response);
	} catch (CustomException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
