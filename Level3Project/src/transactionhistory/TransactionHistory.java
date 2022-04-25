package transactionhistory;



public class TransactionHistory {
	private int Account;
	private String transactionType;
	private double amount;
	private long dateAndTime;
	private double beforeBalance;
    
	
	public int getAccount() {
		return Account;
	}
	public void setAccount(int account) {
		Account = account;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(long dateAndTime) {
		this.dateAndTime = dateAndTime;
		
		
	}
	public double getBeforeBalance() {
		return beforeBalance;
	}
	public void setBeforeBalance(double beforeBalance) {
		this.beforeBalance = beforeBalance;
	}
	
	@Override
	public String toString() {
		return "Transation" + transactionType + " " + Account + ", amount=" + amount
				+ ", dateAndTime=" + dateAndTime+ ", beforeBalance=" + beforeBalance + "";
	}
	

}
