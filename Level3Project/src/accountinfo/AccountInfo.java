package accountinfo;

public class AccountInfo {
  private int customerId;
  private int accountId;
  private String brachName;
  private double balance=1000;
  private boolean status=true;

public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public String getBrachName() {
	return brachName;
}
public void setBrachName(String brachName) {
	this.brachName = brachName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
 
@Override
public String toString() {
	return "AccountInfo [customerId=" + customerId + ", accountId=" + accountId + ", brachName=" + brachName
			+ ", balance=" + balance + ", status=" + status + "]";
}
}
