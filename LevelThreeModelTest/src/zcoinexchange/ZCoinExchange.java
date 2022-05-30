package zcoinexchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZCoinExchange {

	static Map<String,User> signUpCustomer=new HashMap<>();
	static Map<Integer,List<Transaction>> transactionHistory=new HashMap<>();
	static Map<Integer,Account> accountInfo=new HashMap<>();
	static Map<String,User> customerInfo=new HashMap<>();
	static public int ZID=1000;
	static int fixedRate=1;
	public void addUser(User userObj) {
		signUpCustomer.put(userObj.getEmailId(), userObj);
	}
	public boolean passwordCheck(String password,User userObj) {
		if(userObj.getName().equals(password)||String.valueOf(userObj.getMobileNumber()).equals(password)||(password.length()<8)){
			return false;
		}
		int count1=0;
		int count2=0;
		int count3=0;
	    for(int i=0;i<password.length();i++) {
	    	if(Character.isLetter(password.charAt(i))) {
	    		count1++;
	    	}
	    	else if(Character.isDigit(password.charAt(i))) {
	    		count2++;
	    	}
	    	else {
	    		count3++;
	    	}
	    }
	    if(count1<1||count2<1||count3<1) {
	    	return false;
	    }
	    return true;
	}
	public boolean agentLoginAccept(String emailId,String password) {
		if(emailId.equals("ze@z0oho.com")&&password.equals("admin@12")) {
			return true;
		}
		return false;
		
	}
	public boolean userLogin(String emailId,String password) {
		if(customerInfo.containsKey(emailId)) {
			if(customerInfo.get(emailId).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public void allowUser(String emailId) {
		Account acc=new Account();
		User user=signUpCustomer.get(emailId);
		user.setZID(generateZID());
		acc.setZID(user.getZID());
		acc.setUserId(emailId);
		acc.setRCWallet(user.getRealCurrencyWalletAmount());
		addAccount(acc);
		customerInfo.put(emailId, user);
		signUpCustomer.remove(emailId);
	}
	public void addAccount(Account acc) {
		accountInfo.put(acc.getZID(), acc);
	}
	public int getRCwallet(int ZID) {
		return accountInfo.get(ZID).getRCWallet();
	}
	public int getZCWallet(int ZID) {
		return accountInfo.get(ZID).getZCWallet();
	}
	public void rejectUser(String emailId) {
		signUpCustomer.remove(emailId);
	}
	public Map<String,User> getSignUpList(){
		return signUpCustomer;
	}
	public int generateZID() {
		return ++ZID;
	}
	public List<Transaction> getTransactionHistory(int userId){
		return transactionHistory.get(userId);
	}
	public User getProfile(String emailId) {
	
		User usr=customerInfo.get(emailId);
		return usr;
	}
	public int getZID(String emailId) {
		return customerInfo.get(emailId).getZID();
	}
	public void deposit(int zId,int amount) {
		Account acc=accountInfo.get(zId);
		acc.setRCWallet(acc.getRCWallet()+amount);
		}
	public boolean withdraw(int zId,int amount) {
		Account acc=accountInfo.get(zId);
		if(acc.getRCWallet()<amount) {
			return false;
		}
		acc.setRCWallet(acc.getRCWallet()-amount);
		return true;
	}
	public void setRate(int r) {
		fixedRate=r;
	}
	public boolean RCToZCTransaction(int zId,int amount) {
		Account acc=accountInfo.get(zId);
		if(acc.getRCWallet()<amount) {
			return false;
		}
		acc.setRCWallet(acc.getRCWallet()-amount);
		acc.setZCWallet(acc.getZCWallet()+(amount*fixedRate));
		return true;
	}
	public boolean ZCToZCTransaction(int fZid,int tZid,int amount) {
		Account acc=accountInfo.get(fZid);
		Account acc2=accountInfo.get(tZid);
		if(acc.getZCWallet()<amount) {
			return false;
		}
		acc.setZCWallet(acc.getZCWallet()-amount);
		acc2.setZCWallet(acc2.getZCWallet()+amount);
		return true;
	}
	public boolean ZCToRCTransaction(int zId,int amount) {
		Account acc=accountInfo.get(zId);
		
		if(acc.getZCWallet()<amount) {
			return false;
		}
		acc.setZCWallet(acc.getZCWallet()-amount);
		int amount2=(int) ((zId/fixedRate)-((zId/fixedRate)*(0.15)));
		acc.setRCWallet(acc.getRCWallet()+amount2);
		return true;
	}
	public void addTransaction2(Transaction transaction,int zId) {
		List<Transaction> lis=transactionHistory.get(zId);
		if(lis==null) {
			lis=new ArrayList<>();
			transactionHistory.put(zId, lis);
		}
		lis.add(transaction);
	}
	public void addTransaction(int dep,int zId,String tran) {
		Transaction transaction=new Transaction();
		transaction.setAmount(dep);
		transaction.setTransactionTime(System.currentTimeMillis());
		transaction.setTransactionType(tran);
		transaction.setRecentBalanceRC(accountInfo.get(zId).getRCWallet());
		transaction.setRecentBalenceZC(accountInfo.get(zId).getZCWallet());
		addTransaction2(transaction,zId);
	}
}
