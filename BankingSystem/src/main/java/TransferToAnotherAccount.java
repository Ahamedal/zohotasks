

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
import level3.DBLayer;

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
		String page=request.getParameter("page");
        String fAccId=request.getParameter("uAccNo");
		
		String tAccId=request.getParameter("uaccNo");
		String dep=request.getParameter("uDep");
		HttpSession session=request.getSession();
		APILayer logic=(APILayer) request.getServletContext().getAttribute("object");
		if(page.equals("admin")) {
			Map<Integer,Map<Integer,AccountInfo>> accMap=new HashMap<>();;
		int aId=Integer.valueOf(fAccId);
		
		int aId1=Integer.valueOf(tAccId);
		long deposit=Long.valueOf(dep);
		DBLayer o=new DBLayer();
		String query="select * from accountInfo where accountID="+aId+";";
		String query1="select * from accountInfo where accountID="+aId1+";";
		try {
			int cId=o.getCusId(query);
			int cId1=o.getCusId(query1);
			System.out.println(cId+" "+cId1);
			logic.depositMoney(cId1, aId1, deposit);
			logic.withDrawMoney(cId, aId, deposit);
		
			accMap=logic.readAccInfo();
		} catch (CustomException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		request.setAttribute("AccountServelets", accMap);
		RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
		rd.forward(request, response);
		}
		if(page.equals("customer")){
			Map<Integer,CustomerInfo> cusMap=new HashMap<>();
		
			int aId=Integer.valueOf(fAccId);
		
			int aId1=Integer.valueOf(tAccId);
			long deposit=Long.valueOf(dep);
			DBLayer o=new DBLayer();
		
			String query1="select * from accountInfo where accountID="+aId1+";";
			int cId=0;
			int cId1=0;
			try {
			    cId=Integer.valueOf((String) session.getAttribute("id"));
			    System.out.println(cId);
				cId1=o.getCusId(query1);
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
