package level3;
import java.io.*;
public class AccountInfo implements Serializable{
	
	private int customerID;
	private int accountID;
	private String accountType;
	private String branchName;
	private long balance=0l;
	private boolean status=true;
	

	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "[customerID=" + customerID + ", accountID=" + accountID + ", accountType=" + accountType
				+ ", branchName=" + branchName +",status="+status+ ", balance=" + balance + "]";
	}
	
	
	

}
