package level3;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.logiclayer.*;
public class APILayer {
	PersistantLayer objForFile1;
 
 private Properties property=new Properties();
 //private PersistantLayer objForFile1=new DBLayer();
 private Cache cache=new Cache();
public APILayer(boolean flag) throws ClassNotFoundException, CustomException
{
	
	loadProperty();
	String path="";
	if(flag) 
	{
		path=property.getProperty("DBPath");
		
	}
	else {
		path=property.getProperty("FilePath");
		}
	try {
	Class<?> myClass=Class.forName(path);
	Object obj=myClass.getDeclaredConstructor().newInstance();
	objForFile1=(PersistantLayer) obj;
	readCusInfo();
	readAccInfo();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
 }
 public void loadProperty(){
	 property.setProperty("FilePath", "level3.FileLayer");
	 property.setProperty("DBPath", "level3.DBLayer");
 }
public Map<Integer,CustomerInfo> readCusInfo() throws CustomException, ClassNotFoundException{
 	Map<Integer,CustomerInfo> customerInfo=objForFile1.fileToMap();
 	cache.setCustomerInfo(customerInfo);
 	return customerInfo;
 }
 
public Map<Integer,Map<Integer,AccountInfo>> readAccInfo()throws CustomException, ClassNotFoundException{
 	Map<Integer,Map<Integer,AccountInfo>> accountInfo=objForFile1.fileToMap1();
 	cache.setAccountInfo(accountInfo);
 	return accountInfo;
 }
 
public CustomerInfo getCusInfoFromFile(int cusId)throws CustomException, ClassNotFoundException{
	CustomerInfo cusInfo=objForFile1.getMap(cusId);
	return cusInfo;
}
public CustomerInfo getCusInfoFromCache(int cusId)throws CustomException{
	CustomerInfo cusInfo=cache.getMap(cusId);
	return cusInfo;
}


public AccountInfo getAccForAccIdFromFile(int cusId,int accId)throws CustomException, ClassNotFoundException{
	AccountInfo acc=objForFile1.getForAccountId(cusId, accId);
	return acc;
}
public AccountInfo getAccForAccIdFromCache(int cusId,int accId)throws CustomException{
	AccountInfo acc=cache.getForAccountId(cusId, accId);
	return acc;
}
 
 public Map<Integer,AccountInfo> getForAccId(int id)throws CustomException, ClassNotFoundException{
	 Map<Integer,AccountInfo> map=objForFile1.getForAccountId(id);
	 return map;
 }
  public Map<Integer,CustomerInfo> getCustomerInfoCache()throws CustomException {
	    
		Map<Integer,CustomerInfo> customerInfo=cache.getCustomerInfo();
		
		return customerInfo;
	
 }
 
  
   
  public Map<Integer,Map<Integer,AccountInfo>> getAccountInfoCache() throws CustomException{
	   
	   Map<Integer,Map<Integer,AccountInfo>> accountInfo=cache.getAccountInfo();
	   
	   
	  
	 return accountInfo;
  }

  
  public void addMap(CustomerInfo value)throws CustomException {
	 int cusId=objForFile1.addMap(value);
	 cache.addMap(value,cusId);

	
	}

	

public void addMultipleAccount(AccountInfo value) throws CustomException{
	int accId=objForFile1.addMultipleAccount(value);
	cache.addMultipleAccount(value,accId);

		
		
	}
	
	

 public void getForAccountId(int customerId,int accountId)throws CustomException, ClassNotFoundException {
	 objForFile1.getForAccountId(customerId, accountId);
	 cache.getForAccountId(customerId, accountId);

	}
	
   public void depositMoney(int cusID,int accID,long deposit)throws CustomException, ClassNotFoundException{
	   objForFile1.depositMoney(cusID, accID, deposit);
	   cache.depositMoney(cusID, accID, deposit);
    

    
    	
    }
  public void withDrawMoney(int cusID,int accID,long withDraw)throws CustomException, ClassNotFoundException{
	  objForFile1.withDrawMoney(cusID, accID, withDraw);
	  cache.withDrawMoney(cusID, accID, withDraw);
    

    }
   public void setCustomerStatus(int cusId,int status)throws CustomException{
	   objForFile1.setCustomerStatus(cusId, status);
	   cache.setCustomerStatus(cusId, status);

    	
    }
   public void setAccountStatus(int cusId,int accId,int status)throws CustomException {
	   objForFile1.setAccountStatus(cusId, accId, status);
	   cache.setAccountStatus(cusId, accId, status);
	
    }
	public String getLogin(int cusId,String pass1) throws CustomException,ClassNotFoundException {
		String s=objForFile1.getLogin(cusId,pass1);
		return s;
	}
}
