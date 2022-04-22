package internetbankinglogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import exception.CustomsException;
import loan.LoanDetails;
import transactionhistory.TransactionHistory;

public class LogicOfInternetBanking {
	private static Map<Integer,CustomerInfo> cusInfo=new HashMap<>();
	private static Map<Integer,List<Integer>> accountID=new HashMap<>();
	private static Map<Integer,AccountInfo> accInfo=new HashMap<>();
	private static Map<Integer,List<TransactionHistory>> transaction=new HashMap<>();
	private static Map<Integer,Map<String,LoanDetails>> loan=new HashMap<>();
	
	//private Map<String,String> checker=new HashMap<>();
	static int cusId=0;
	static int acctId=1000;
public boolean validator(int uId,String pass)throws CustomsException {
	
	stringCheck(pass);
	if(uId==0) {
		if(pass.equals("admin")) {
			return true;
		}
		return false;
	}
	checkCusId(uId);
	 CustomerInfo cus=cusInfo.get(uId);
	 if(cus.getpWord().equals(pass)) {
		 return true;
	 }
	 return false;
 }
 public void addCustomer(CustomerInfo customerInfo)throws CustomsException {
	 nullCheck(customerInfo);
	 cusInfo.put(customerInfo.getCusId(), customerInfo);
 }
 public void  addAccount(AccountInfo accountInfo)throws CustomsException {
	 nullCheck(accountInfo);
	 accInfo.put(accountInfo.getAccountId(), accountInfo);
	 
 }
 public double getBalance(int accId)throws CustomsException {
	 checkAccId(accId);
	 AccountInfo acc=accInfo.get(accId);
	 return acc.getBalance();
 }
 public void depositMoney(int accID,double deposit)throws CustomsException{
	    checkAccId(accID);
	    AccountInfo account=accInfo.get(accID);
	    double balance=account.getBalance();
	    account.setBalance(balance+deposit);
	    
}
public void withDrawMoney(int accID,double withDraw)throws CustomsException{
	checkAccId(accID);
	AccountInfo account=accInfo.get(accID);
    double balance=account.getBalance();
    account.setBalance(balance-withDraw);
}
boolean flag=false;
private void storeTranObj(int fAccId,int tAccId,double amount)throws CustomsException{
	checkAccId(fAccId);
	checkAccId(tAccId);
	TransactionHistory tran=new TransactionHistory();
	if(!flag) {
	tran.setFromAccount(fAccId);
	tran.setToAccount(tAccId);
	flag=true;
	}
	else {
		tran.setFromAccount(tAccId);
		tran.setToAccount(fAccId);
		flag=false;
	}
	tran.setAmount(amount);
	AccountInfo accountInfo=accInfo.get(fAccId);
	double beforeBalance=accountInfo.getBalance();
	tran.setBeforeBalance(beforeBalance);
	storeTranDetails(fAccId,tran);
	
}
private void storeTranDetails(int fAccId,TransactionHistory tran)throws CustomsException {
	checkAccId(fAccId);
	List<TransactionHistory> lis=transaction.get(fAccId);
	if(lis==null) {
		lis=new ArrayList<>();
		transaction.put(fAccId, lis);
	}
	lis.add(tran);
}

public void transferMoney(int fAccId,int tAccId,double amount)throws CustomsException {
	checkAccId(fAccId);
	checkAccId(tAccId);
	storeTranObj(fAccId,tAccId,amount);
	storeTranObj(tAccId,fAccId,amount);
	depositMoney(tAccId,amount);
	withDrawMoney(fAccId,amount);
	
}
public List<TransactionHistory> getTransactionDetails(int accId)throws CustomsException {
	checkAccId(accId);
	List<TransactionHistory> tr=transaction.get(accId);
	List<TransactionHistory> trs=new ArrayList<>();
	for(int i=tr.size()-1;i>=0;i--) {
		trs.add(tr.get(i));
	}
	return trs;
}
 public void accountIds(int cusId,int accId)throws CustomsException{
	 checkCusId(cusId);

	 List<Integer> lis=accountID.get(cusId);
	 if(lis==null) {
		 lis=new ArrayList<>();
		 accountID.put(cusId, lis);
	 }
	 lis.add(accId);
 }
 public void addLoan(int accId,LoanDetails loanObj)throws CustomsException{
	 checkAccId(accId);
	 nullCheck(loanObj);
	 Map<String,LoanDetails> loanMap=loan.get(accId);
	 if(loanMap==null) {
		 loanMap=new HashMap<>();
		 loan.put(accId, loanMap);
	 }
	 loanMap.put(loanObj.getLoanType(), loanObj);
 }
 public boolean loanApproving(int accID,LoanDetails loanObj)throws CustomsException {
	 checkAccId(accID);
	 nullCheck(loanObj);
	 Map<String,LoanDetails> lone=loan.get(accID);
	 String loType=loanObj.getLoanType();
	 if(lone!=null) {
	 if(lone.get(loType)!=null) {
		 return false;
	 }
     }
	 return true;
 }
 public Map<String,LoanDetails> getLoanDetails(int accId)throws CustomsException{
	 checkAccId(accId);
	 Map<String,LoanDetails> loanDetails=loan.get(accId);
	 if(loanDetails==null) {
		 return new HashMap<>();
	 }
	 return loanDetails;
 }
 public Map<Integer,Map<String,LoanDetails>> showLoanDetails(){
	 return loan;
 }
 public void changeStatus(int accId,String loanT,String status) throws CustomsException{
	 checkAccId(accId);
	 Map<String,LoanDetails> lo=loan.get(accId);
	 if(lo!=null) {
		 LoanDetails lDetils= lo.get(loanT);
	 if(status.equals("Approved")) {
		
		lDetils.setStatus(status);
		lDetils.setApproved(true);
	 }
	 else {
		lDetils.setStatus(status);
			 
	 }
	 }
	 
 }
 public Map<Integer,CustomerInfo> showCustomerDetails(){
	 return cusInfo;
 }
 public Map<Integer,AccountInfo> showAccountDeatils(){
	 return accInfo;
 }
 public int generatorAccId() {
	 return ++acctId;
 }
 public int generatorCusId() {
	  return ++cusId;
 }
public void showMap() {
	System.out.println(cusInfo);
	System.out.println(accInfo);
	System.out.println(accountID);
	System.out.println(transaction);
	System.out.println(loan);
}
private void checkCusId(int cusId)throws CustomsException{
	  if(cusInfo.get(cusId)==null) {
		  throw new CustomsException("this customer id is does not exist");
	  }
}
private void checkAccId(int accId)throws CustomsException{
	  if(accInfo.get(accId)==null) {
		  throw new CustomsException("this Account id is does not exist");
	  }
}
private void stringCheck(String testString)throws CustomsException{
	if(testString==null||testString.isEmpty()){
	throw new CustomsException("String can not be null or empty");
	}
	}
private void nullCheck(Object fileObj)throws CustomsException{
	if(fileObj==null){
	throw new CustomsException(fileObj+"cannot be null");
	}
	}

}
