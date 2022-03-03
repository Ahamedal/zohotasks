package level3;

import java.util.*;

import com.logiclayer.CustomException;
import com.logiclayer.Utility;

public class Cache {
	
    private static Map<Integer,CustomerInfo> customerInfo=new HashMap<>();
	private static Map<Integer,Map<Integer,AccountInfo>> accountInfo=new HashMap<>();
	
    
	 public Map<Integer, CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(Map<Integer, CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}
	public Map<Integer, Map<Integer, AccountInfo>> getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(Map<Integer, Map<Integer, AccountInfo>> accountInfo) {
		this.accountInfo = accountInfo;
	}
	public void addMap(CustomerInfo value,int cusId)throws CustomException {
		 
			Utility.nullCheck(value,"customerInfo");
		
			
			customerInfo.put(cusId, value);
			
			
		}
	 public CustomerInfo getMap(int key)throws CustomException{
		
			checkCusId(key);
			
			return customerInfo.get(key);
			
		}
		
	
	public void addMultipleAccount(AccountInfo value,int keyAccId) throws CustomException{
			Utility.nullCheck(value+"AccountInfo");
			
			int key=value.getCustomerID();
			 
			 Map<Integer,AccountInfo> tempMap=accountInfo.get(key);
		 if(tempMap==null) {
			 tempMap=new HashMap<>();
					accountInfo.put(key,tempMap);
			 }
		    
			 tempMap.put(keyAccId, value);
			 
			
			
		}
		
		
	public Map<Integer,AccountInfo> getForCustomerId(int customerId)throws CustomException{
		     checkCusId(customerId);
			return accountInfo.get(customerId);
		}
	 public AccountInfo getForAccountId(int customerId,int accountId)throws CustomException {
			checkCusId(customerId);
			Map<Integer,AccountInfo> accDetails=accountInfo.get(customerId);
			Utility.nullCheck(accDetails, "account is not present and account ");
			return accDetails.get(accountId);
		}
		
	   public void depositMoney(int cusID,int accID,long deposit)throws CustomException{
	    
	    AccountInfo account=getForAccountId(cusID,accID);
	    Utility.nullCheck(account,"AccountInfo");
	    activationCheck(account);
	    long balance=account.getBalance();
	    account.setBalance(balance+deposit);
	    
	    	
	    }
	  public void withDrawMoney(int cusID,int accID,long withDraw)throws CustomException{
	    
	    	AccountInfo account=getForAccountId(cusID,accID);
	    	activationCheck(account);
	    	long balance=account.getBalance();
	    	if(balance>=withDraw) {
	    	account.setBalance(balance-withDraw);
	    	}
	    	else {
	    		throw new CustomException("your withdrawal ammount is out of balance");
	    	}
	    }
	   public void setCustomerStatus(int cusId,int status)throws CustomException{
	    	CustomerInfo account=customerInfo.get(cusId);
	    	if(status==1) {
	    		account.setStatus(true);
	    		System.out.println("your account is succesfullay activated");
	    	}
	    	else{
	    		account.setStatus(false);
	    		System.out.println("your account is deacvited if you need activate enter 1 ");
	    	}
	    	
	    }
	   public void setAccountStatus(int cusId,int accId,int status)throws CustomException {
	    	AccountInfo account=getForAccountId(cusId,accId);
	    	if(status==1) {
	             account.setStatus(true);
	             System.out.println("this account is succesfully activated");
	             
	    	}
	    	else {
	    		account.setStatus(false);
	    		System.out.println("account is succesfully deactivated if you need activate enter 1");
	    	}
	    	
	    }
	  @SuppressWarnings("unused")
	 private void activationCheck(CustomerInfo customerInfo)throws CustomException {
		  if(!customerInfo.isStatus()) {
			  throw new CustomException("customer is deactivated");
		  }
	  }
	  private void activationCheck(AccountInfo accountInfo)throws CustomException {
		  if(!accountInfo.isStatus()) {
			  throw new CustomException("account is deactivated");
		  }
	  }
	  private void checkCusId(int cusId)throws CustomException {
		  if(customerInfo.get(cusId)==null) {
			  throw new CustomException("this customer id is does not exist");
		  }
	  }
    
}
