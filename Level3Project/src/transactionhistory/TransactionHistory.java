package transactionhistory;

public class TransactionHistory {
	private int fromAccount;
	private int toAccount;
	private double amount;
	private String dateAndTime;
	
	private double beforeBalance;
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
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
		return "fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
				+ ", dateAndTime=" + dateAndTime + ", beforeBalance=" + beforeBalance + "";
	}
	

}
