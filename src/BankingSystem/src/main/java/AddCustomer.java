

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
		long a=Long.valueOf(mobileNo);
		String id=request.getParameter("userId1");
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		if(id!=null) {
			
	      int k=Integer.parseInt(id);
			DBLayer o=new DBLayer();
			String query="update customerInfo set name='"+name+"',address='"+address+"',mobileNo='"+mobileNo+"' where customerID="+k+";";
			o.updateTable(query);Map<Integer,CustomerInfo> accMap=new HashMap<>();
			
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
		else {
		CustomerInfo cus=new CustomerInfo();
		cus.setName(name);
		cus.setAddress(address);
		cus.setMobileNo(a);
		
		try {
			logic.addMap(cus);
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
