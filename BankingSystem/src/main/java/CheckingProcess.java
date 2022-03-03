

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckingProcess
 */
@WebServlet("/CheckingProcess")
public class CheckingProcess extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(id.equals("1") && pass.equals("12345")) {
			RequestDispatcher rd=request.getRequestDispatcher("adminloginpage.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("customerloginpage.jsp");
			rd.forward(request, response);
		}
		
	}

}
