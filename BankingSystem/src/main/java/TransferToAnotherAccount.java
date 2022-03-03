

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

import level3.APILayer;
import level3.AccountInfo;
import level3.CustomerInfo;

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
		String fCusId=request.getParameter("uId");
        String fAccId=request.getParameter("uAccNo");
		String tcusId=request.getParameter("uId1");
		String tAccId=request.getParameter("uaccNo");
		String dep=request.getParameter("uDep");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("id");
		if(fCusId!=null) {
		int cId=Integer.valueOf(fCusId);
		int aId=Integer.valueOf(fAccId);
		int cId1=Integer.valueOf(tcusId);
		int aId1=Integer.valueOf(tAccId);
		long deposit=Long.valueOf(dep);
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();
		try {
			logic.depositMoney(cId1, aId1, deposit);
			logic.withDrawMoney(cId, aId, deposit);
		
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
			Map<Integer,CustomerInfo> cusMap=new HashMap<>();
			int cId=Integer.valueOf(userId);
			int aId=Integer.valueOf(fAccId);
			int cId1=Integer.valueOf(tcusId);
			int aId1=Integer.valueOf(tAccId);
			long deposit=Long.valueOf(dep);
			APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
			try {
				logic.depositMoney(cId1, aId1, deposit);
				logic.withDrawMoney(cId, aId, deposit);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Map<Integer,CustomerInfo> accMap=new HashMap<>();
				
				try {
					CustomerInfo c=logic.getCusInfoFromFile(cId);
					accMap.put(cId, c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(accMap);
				request.setAttribute("AccountServelets", accMap);
				RequestDispatcher rd=request.getRequestDispatcher("customerloginpage.jsp");
				
				Map<Integer,AccountInfo> acc=new HashMap<>();
				
				try {
					acc=logic.getForAccId(cId);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(acc);
				request.setAttribute("AccountServelet", acc);
				RequestDispatcher rd1=request.getRequestDispatcher("customerloginpage.jsp");
				rd1.forward(request, response);
				
		}
	}

}
