package level3;
import java.sql.*;
import java.util.*;

import com.logiclayer.*;
public class DBLayer implements PersistantLayer{
	
	
	String url="jdbc:mysql://localhost:3306/bank";
	String uName="root";
	String pass="K@r0!KuD!";
	public int insertTable(String query)throws CustomException{
		
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			st.executeUpdate(query,st.RETURN_GENERATED_KEYS);
			ResultSet rs=st.getGeneratedKeys();
			rs.next();
			 return rs.getInt(1);
		}
		catch(Exception e) {
			throw new CustomException(e);
		}
		
	}
	public CustomerInfo selectCustomerTable(String query)throws CustomException{
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				CustomerInfo cus=new CustomerInfo();
				cus.setCustomerId(rs.getInt("customerID"));
				cus.setName(rs.getString("name"));
				cus.setAddress(rs.getString("address"));
				cus.setMobileNo(rs.getLong("mobileNo"));
				cus.setStatus(rs.getBoolean("status"));
				return cus;
			}
		}
		catch(Exception e) {
			throw new CustomException(e);
		}
		return null;
		
	}
	public AccountInfo selectAccountTable(String query)throws CustomException{
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				AccountInfo acc=new AccountInfo();
				acc.setCustomerID(rs.getInt("customerID"));
				acc.setAccountID(rs.getInt("accountID"));
				acc.setAccountType(rs.getString("accountType"));
				acc.setBranchName(rs.getString("branchName"));
				acc.setBalance(rs.getLong("balance"));
				acc.setStatus(rs.getBoolean("status"));
				return acc;
			}
		}
		catch(SQLException e) {
			throw new CustomException(e);
		}
		return null;
	}
	private Map<Integer,AccountInfo> selectAccountTable1(String query)throws CustomException{
		Map<Integer,AccountInfo> map=new HashMap<>();
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int accId=rs.getInt(2);
				
				AccountInfo acc=new AccountInfo();
				acc.setCustomerID(rs.getInt("customerID"));
				acc.setAccountID(rs.getInt("accountID"));
				acc.setAccountType(rs.getString("accountType"));
				acc.setBranchName(rs.getString("branchName"));
				acc.setBalance(rs.getLong("balance"));
				acc.setStatus(rs.getBoolean("status"));
				map.put(accId,acc);
				
			}
		}
		catch(Exception e) {
			throw new CustomException(e);
		}
		return map;
	}
	public int getCusId(int aId) throws CustomException{
		
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			String query="select * from accountInfo where accountID="+aId+";";
			
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int cusId=rs.getInt(1);
			return cusId;
		}
		catch(Exception e) {
			throw new CustomException("AccountNumber is not found");
		}
		
	}
	public void updateTable(String query) throws CustomException{
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			int count=st.executeUpdate(query);
			 System.out.println(count+"rows affected");
		}
		catch(Exception e) {
			throw new CustomException(e);
		}
	}
	
	public void createTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
		Statement st=con.createStatement();){
			String query1="create table customerInfo(customerID int not null auto_increment,name varchar(25),address varchar(25),mobileNo bigint,status tinyint,primary key(customerID));";
		    String query2="create table accountInfo(customerID int not null,accountID int not null auto_increment,accountType varchar(25),branchName varchar(13),balance int,status tinyint,primary key(accountID),foreign key(customerID) references customerInfo(customerID));";
		    int count1=st.executeUpdate(query1);
		  
			  System.out.println(count1+"table Created");
			  int count2=st.executeUpdate(query2);
			  System.out.println(count2+"table created");
		  st.executeUpdate("alter table accountInfo auto_increment=1001");
		  
		
	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		}
	public void addLogin(int cusId,int password) throws CustomException{
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
		st.executeUpdate("insert into User(rollId,customerID,password) values("+0+","+cusId+","+password+");");
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	}
	@SuppressWarnings("unused")
    public int addMap(CustomerInfo value) throws CustomException{
    	
		Utility.nullCheck(value,"customerInfo");
					
    				String name=value.getName();
    				String address=value.getAddress();
    				long mobileNo=value.getMobileNo();
    				boolean status=value.isStatus();
    			  String query="insert into customerInfo (name,address,mobileNo,status) values('"+name+"','"+address+"',"+mobileNo+","+status+");";
    			  int a=insertTable(query);
    			  value.setCustomerId(a);
    			   return a;
    		
    			
    	
    }
	public void updateDatas(String name,String address,Long mobileNo,int k) throws CustomException,ClassNotFoundException{
		String query="update customerInfo set name='"+name+"',address='"+address+"',mobileNo='"+mobileNo+"' where customerID="+k+";";
		updateTable(query);
	}
	
	@Override
	public CustomerInfo getMap(int key) throws CustomException, ClassNotFoundException{
		checkCusId(key);
		return selectCustomerTable("select * from customerInfo where customerID="+key+";");
	}
	@Override
	public int addMultipleAccount(AccountInfo value) throws CustomException {
		Utility.nullCheck(value+"AccountInfo");
		int customerId=value.getCustomerID();
	
		String accountType=value.getAccountType();
		String branchName=value.getBranchName();
		long balance=value.getBalance();
		boolean status=value.isStatus();
		int a=insertTable("insert into accountInfo(customerID,accountType,branchName,balance,status) values("+customerId+",'"+accountType+"','"+branchName+"',"+balance+","+status+");");
		value.setAccountID(a);
		return value.getAccountID();
	}
	public void updateAccountDatas(int a,String accountType,String branchName,int k) throws CustomException {
		String query="update accountInfo set customerID="+a+",accountType='"+accountType+"',branchName='"+branchName+"' where accountID="+k+";";
		updateTable(query);
	}
	
	@Override
	public AccountInfo getForAccountId(int customerId, int accountId) throws CustomException, ClassNotFoundException {
		 checkCusId(customerId);
		return selectAccountTable("select * from accountInfo where accountID="+accountId+" and customerID="+customerId+";");
	}
     public Map<Integer,AccountInfo> getForAccountId(int customerId) throws CustomException, ClassNotFoundException {
    	 checkCusId(customerId);
		return selectAccountTable1("select * from accountInfo where customerID="+customerId+";");
	}
	@Override
	public void depositMoney(int cusID, int accID, long deposit) throws CustomException, ClassNotFoundException {
		AccountInfo accountInfo=getForAccountId(cusID,accID);
		
	    activationCheck(accountInfo);
		deposit=accountInfo.getBalance()+deposit;
		updateTable("update accountInfo set balance="+deposit+" where accountID="+accID+" and customerID="+cusID+";");
		
	}
	@Override
	public void withDrawMoney(int cusID, int accID, long withDraw) throws CustomException, ClassNotFoundException {
		AccountInfo accountInfo=getForAccountId(cusID,accID);
		activationCheck(accountInfo);
		if(accountInfo.getBalance()>=withDraw) {
        withDraw=accountInfo.getBalance()-withDraw;
        updateTable("update accountInfo set balance="+withDraw+" where accountID="+accID+" and customerID="+cusID+";");
		}
		else {
			throw new CustomException("Your Withdraw Amount is Out of range");
		}
	}
	@Override
	public void setCustomerStatus(int cusId, int status) throws CustomException {
	   updateTable("update customerInfo set status="+status+" where customerID="+cusId+";");
		
	}
	@Override
	public void setAccountStatus(int cusId, int accId, int status) throws CustomException {
		updateTable("update accountInfo set status="+status+" where accountID="+accId+" and customerID="+cusId+";");
		
	}
	public void setAccountStatus(int accId, int status) throws CustomException {
		updateTable("update accountInfo set status="+status+" where accountID="+accId+";");
		
	}
	@Override
	public Map<Integer, CustomerInfo> fileToMap() throws CustomException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
			 String sql="select * from customerInfo;";
			 ResultSet result=st.executeQuery(sql);
			 Map<Integer,CustomerInfo> customerData=new HashMap<>();
			 while(result.next())
			 {
				 CustomerInfo customerInfo=new CustomerInfo();
				 
				 customerInfo.setName(result.getString("name"));
				 customerInfo.setAddress(result.getString("address"));
				 customerInfo.setMobileNo(result.getLong("mobileNo"));
				 customerInfo.setStatus(result.getBoolean("status"));
				 customerInfo.setCustomerId(result.getInt("customerId"));
				 int customerId=customerInfo.getCustomerId();
				 customerData.put(customerId,customerInfo);
			 }
			 return customerData;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
		
	}
	@Override
	public Map<Integer, Map<Integer, AccountInfo>> fileToMap1() throws CustomException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
			 String sql="select * from accountInfo;";
			 ResultSet rs=st.executeQuery(sql);
			 
			 Map<Integer,Map<Integer,AccountInfo>> accountData=new HashMap<>();
			 while(rs.next())
			 {
				 
				 AccountInfo acc=new AccountInfo();
					acc.setCustomerID(rs.getInt("customerID"));
					acc.setAccountID(rs.getInt("accountID"));
					acc.setAccountType(rs.getString("accountType"));
					acc.setBranchName(rs.getString("branchName"));
					acc.setBalance(rs.getLong("balance"));
					acc.setStatus(rs.getBoolean("status")); 
					int customerId=acc.getCustomerID();
					int accountId=acc.getAccountID();
					Map<Integer,AccountInfo> tempMap=accountData.get(customerId);
			 if(tempMap==null) {
				 tempMap=new HashMap<>();
						accountData.put(customerId,tempMap);
				 }
			    
				 tempMap.put(accountId, acc);
				 
			 }
			 return accountData;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new CustomException(e);
		}
		
	}
	private void activationCheck(CustomerInfo customerInfo)throws CustomException {
		  if(!customerInfo.isStatus()) {
			  throw new CustomException("customer is deactivated");
		  }
	  }
	  private void activationCheck(AccountInfo accountInfo)throws CustomException {
		  if(accountInfo==null) {
			 throw new CustomException("Account is not found") ;
		  }
		  else {
		  if(!accountInfo.isStatus()) {
			  throw new CustomException("account is deactivated");
		  }
		  }
	  }
	  private void checkCusId(int cusId)throws CustomException, ClassNotFoundException {
		  Map<Integer,CustomerInfo> customerInfo=fileToMap();
		  if(cusId!=0) {
		  if(customerInfo.get(cusId)==null) {
			  throw new CustomException("this customer id is does not exist");
		  }
		  }
		  else {
			  throw new CustomException("Account is not found");
		  }
	  }
	public String getLogin(int cusId,String pass1) throws CustomException,ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		int check=0;
		
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
		String query="select * from User where customerID="+cusId+" and password="+pass1+";";
		
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			check=rs.getInt("rollid");
			if(check==1) {
				return "admin";
			}
			if(check==0) {
				return "customer";
			}
				
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
}