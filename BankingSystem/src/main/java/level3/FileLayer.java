package level3;

import java.io.File;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.logiclayer.CustomException;
import com.logiclayer.Utility;

public class FileLayer implements PersistantLayer{
	
	private static int customerID=0;
	private static int accountID=1000;
	private File accFile=new File("AccountInformation1.txt");
    private File cusFile=new File("CustomerInformation1.txt");
	
		
	public void mapToFile(Map<Integer,CustomerInfo> obj,int custId) throws CustomException{

	   
		try(FileOutputStream writer=new FileOutputStream(cusFile,false);ObjectOutputStream out=new ObjectOutputStream(writer);){
			out.writeObject(obj);
			out.writeObject(custId);
			
			out.flush();
		
		
		}
		catch(IOException e) {
			throw new CustomException(e);
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Map<Integer,CustomerInfo> fileToMap()throws CustomException{
		  Map<Integer,CustomerInfo> customerInfo=new HashMap<>();
		if(cusFile.exists()){
		
		try(FileInputStream reader=new FileInputStream(cusFile);ObjectInputStream in=new ObjectInputStream(reader);){
		    customerInfo=(Map<Integer, CustomerInfo>) in.readObject();
	        //System.out.println(customerInfo);
	        
	        return customerInfo;
			
		}
	
		catch(IOException|ClassNotFoundException e) {
			throw new CustomException(e);
		}
		}
		
			return customerInfo;
		
		
	}
	public int fileToMap11()throws CustomException{
		try(FileInputStream reader=new FileInputStream(cusFile);ObjectInputStream in=new ObjectInputStream(reader);){
			in.readObject();
	        customerID=(int) in.readObject();
	        return customerID;
			
			
		}
	
		catch(IOException|ClassNotFoundException e) {
			throw new CustomException(e);
		}
		
	}
	public void mapToFile1(Map<Integer,Map<Integer,AccountInfo>> obj,int accId) throws CustomException{
		
		try(FileOutputStream writer=new FileOutputStream(accFile,false);ObjectOutputStream out=new ObjectOutputStream(writer);){
			out.writeObject(obj);
			out.writeObject(accId);
			
			out.flush();
		}
		
		catch(IOException e) {
			throw new CustomException(e);
		}
			   
	}
	
	@SuppressWarnings("unchecked")
	public Map<Integer,Map<Integer,AccountInfo>> fileToMap1()throws CustomException{
	
		
		Map<Integer,Map<Integer,AccountInfo>> accountInfo=new HashMap<>();
		if(accFile.exists()) {
		try(FileInputStream reader=new FileInputStream(accFile);ObjectInputStream in=new ObjectInputStream(reader);){
	            accountInfo=(Map<Integer, Map<Integer, AccountInfo>>) in.readObject();
	           
		          return accountInfo;
		}
		
		catch(IOException|ClassNotFoundException e) {
			throw new CustomException(e);
		}
		}
		return accountInfo;
			}
	public int fileToMap2()throws CustomException{
		try(FileInputStream reader=new FileInputStream(accFile);ObjectInputStream in=new ObjectInputStream(reader);){
	             in.readObject();
	            accountID=(int) in.readObject();
		          return accountID;
		}
		
		catch(IOException|ClassNotFoundException e) {
			throw new CustomException(e);
		}
			}
//    public Map<Integer,Integer> accountIdMap()throws CustomException{
//    	try(FileInputStream b=new FileInputStream(path);ObjectInputStream in=new ObjectInputStream(b);){
//    		Map<Integer,Integer> acc1=(Map<Integer, Integer>) in.readObject();
//    	
//    			return acc1;
//    		}
//    		catch(FileNotFoundException e) {
//    			throw new CustomException("file not found exception is occured");
//    		}
//    		catch(IOException e) {
//    			throw new CustomException("IO exception occured");
//    		}
//    		catch(ClassNotFoundException e) {
//    			throw new CustomException("class not found exception is occured");
//    		}
   // }
	 public int addMap(CustomerInfo value)throws CustomException {
		   // Map<Integer,CustomerInfo> customerInfo=new HashMap<>();
			Utility.nullCheck(value,"customerInfo");
			customerID=generateCustomerID();
			value.setCustomerId(customerID);
			Map<Integer,CustomerInfo> customerInfo=fileToMap();
			customerInfo.put(customerID, value);
			mapToFile(customerInfo, customerID);
			return customerID;
			
		}
	 public CustomerInfo getMap(int key)throws CustomException{
		
			checkCusId(key);
			Map<Integer,CustomerInfo> customerInfo=fileToMap();
			return customerInfo.get(key);
			
		}
		
	public int generateCustomerID(){
	       
			return ++customerID;
		}
	public int generateAccountID() {
			
	       return ++accountID;
		}
	public int addMultipleAccount(AccountInfo value) throws CustomException{
			Utility.nullCheck(value+"AccountInfo");
			
			int key=value.getCustomerID();
			accountID=generateAccountID();
			 value.setAccountID(accountID);
			 Map<Integer,Map<Integer,AccountInfo>> accountInfo=fileToMap1();
			 Map<Integer,AccountInfo> tempMap=accountInfo.get(key);
		 if(tempMap==null) {
			 tempMap=new HashMap<>();
					accountInfo.put(key,tempMap);
			 }
		    
			 tempMap.put(accountID, value);
			 
			mapToFile1(accountInfo, accountID);
			return accountID;
			
		}
		
		

	 public AccountInfo getForAccountId(int customerId,int accountId)throws CustomException {
			checkCusId(customerId);
			Map<Integer,Map<Integer,AccountInfo>> accountInfo=fileToMap1();
			Map<Integer,AccountInfo> accDetails=accountInfo.get(customerId);
			Utility.nullCheck(accDetails, "account is not present and account ");
			return accDetails.get(accountId);
		}
	 public Map<Integer,AccountInfo> getForAccountId(int customerId) throws CustomException{
		 Map<Integer,AccountInfo> acc=new HashMap<>();
		 return acc;
	 }
		private AccountInfo getForAccountId(Map<Integer,Map<Integer,AccountInfo>> accountInfo,int cusId,int accId)throws CustomException {
			checkCusId(cusId);
			
			Map<Integer,AccountInfo> accDetails=accountInfo.get(cusId);
			Utility.nullCheck(accDetails, "account is not present and account ");
			return accDetails.get(accId);
		}
	   public void depositMoney(int cusID,int accID,long deposit)throws CustomException{
		Map<Integer,Map<Integer,AccountInfo>> accountInfo=fileToMap1();
	    AccountInfo account=getForAccountId(accountInfo,cusID,accID);
	    Utility.nullCheck(account,"AccountInfo");
	    activationCheck(account);
	    long balance=account.getBalance();
	    account.setBalance(balance+deposit);
	    
	    mapToFile1(accountInfo, accountID);
	    	
	    }
	  public void withDrawMoney(int cusID,int accID,long withDraw)throws CustomException{
		  Map<Integer,Map<Integer,AccountInfo>> accountInfo=fileToMap1();
	    	AccountInfo account=getForAccountId(accountInfo,cusID,accID);
	    	activationCheck(account);
	    	long balance=account.getBalance();
	    	if(balance>=withDraw) {
	    	account.setBalance(balance-withDraw);
	    	
	    	mapToFile1(accountInfo, accountID);
	    	}
	    	else {
	    		throw new CustomException("your withdrawal ammount is out of balance");
	    	}
	    }
	   public void setCustomerStatus(int cusId,int status)throws CustomException{
		   Map<Integer,CustomerInfo> customerInfo=fileToMap();
	    	CustomerInfo account=customerInfo.get(cusId);
	    	if(status==1) {
	    		account.setStatus(true);
	    		System.out.println("your account is succesfullay activated");
	    		mapToFile(customerInfo,customerID);
	    	}
	    	else{
	    		account.setStatus(false);
	    		System.out.println("your account is deacvited if you need activate enter 1 ");
	    		mapToFile(customerInfo,customerID);
	    	}
	    	
	    }
	   public void setAccountStatus(int cusId,int accId,int status)throws CustomException {
		   Map<Integer,Map<Integer,AccountInfo>> accountInfo=fileToMap1();
	    	AccountInfo account=getForAccountId(accountInfo,cusId,accId);
	    	if(status==1) {
	             account.setStatus(true);
	             System.out.println("this account is succesfully activated");
	            
	             mapToFile1(accountInfo, accountID);
	             
	    	}
	    	else {
	    		account.setStatus(false);
	    		System.out.println("account is succesfully deactivated if you need activate enter 1");
	    		
	    		mapToFile1(accountInfo,accountID);
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
		  Map<Integer,CustomerInfo> customerInfo=fileToMap();
		  if(customerInfo.get(cusId)==null) {
			  throw new CustomException("this customer id is does not exist");
		  }
	  }
	  
	  public String getLogin(int cusId,String pass)throws CustomException,ClassNotFoundException{
		  return "a";
	  }
	
}
